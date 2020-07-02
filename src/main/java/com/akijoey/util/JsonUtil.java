package com.akijoey.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class JsonUtil {

    public static String stringify(Map data) {
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    public static Map parse(String json) {
        Map data = null;
        try {
            data = new ObjectMapper().readValue(json, Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

}
