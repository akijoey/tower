package com.akijoey.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.net.URL;
import java.util.*;

import static com.akijoey.controller.PlayerController.player;

public class ConfigUtil {

    public static ArrayList<int[][]> maps;
    public static HashMap<String, Object> attributes;

    public static ArrayList<int[][]> positions;
    public static HashMap<Integer, HashMap<String, Object>> monsters;
    public static HashMap<Integer, ArrayList<String>> messages;

    static {
        maps = readMap();
        attributes = readPlayer();

        positions = readPosition();
        monsters = readMonster();
        messages = readMessage();

    }

    public static Map readConfig(String name) {
        URL url = Thread.currentThread().getContextClassLoader().getResource("config/");
        File config = new File(url.getPath() + name + ".json");
        Map data = null;
        try {
            data = new ObjectMapper().readValue(config, Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void writeConfig(String name, Object data) {
        URL url = Thread.currentThread().getContextClassLoader().getResource("config/");
        File config = new File(url.getPath() + name + ".json");
        try {
            if (!config.exists()) {
                config.createNewFile();
            }
            new ObjectMapper().writeValue(config, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<int[][]> readMap() {
        List<List<List<Integer>>> map = (List)readConfig("default").get("map");
        return parseList(map);
    }

    public static HashMap<String, Object> readPlayer() {
        return (HashMap<String, Object>)readConfig("default").get("player");
    }

    public static ArrayList<int[][]> readPosition() {
        List<List<List<Integer>>> position = (List)readConfig("constant").get("position");
        return parseList(position);
    }

    public static HashMap<Integer, HashMap<String, Object>> readMonster() {
        Map<String, Object> monster = (Map)readConfig("constant").get("monster");
        return new HashMap<>(){{
            monster.forEach((key, value) -> put(Integer.valueOf(key), (HashMap<String, Object>)value));
        }};
    }

    public static HashMap<Integer, ArrayList<String>> readMessage() {
        Map<String, Object> message = (Map)readConfig("constant").get("message");
        return new HashMap<>(){{
            message.forEach((key, value) -> put(Integer.valueOf(key), (ArrayList<String>)value));
        }};
    }

    public static ArrayList<int[][]> parseList(List<List<List<Integer>>> data) {
        return new ArrayList<>(){{
            data.forEach(list -> {
                int[][] arr = new int[list.size()][];
                for (int i = 0;i < list.size();i++) {
                    arr[i] = list.get(i).stream().mapToInt(Integer::valueOf).toArray();
                }
                add(arr);
            });
        }};
    }

    public static void archive() {
        writeConfig("archive", new HashMap<>(){{
            put("player", player);
            put("map", maps);
        }});
    }

}
