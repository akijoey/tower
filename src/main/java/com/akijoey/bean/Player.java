package com.akijoey.bean;

import java.util.Map;

public class Player extends Block {

    private int level;
    private int experience;
    private int gold;

    private int health;
    private int attack;
    private int defend;

    private String direction;
    private int floor;
    private int limit;

    private Item item;

    public Player(Map map) {
        level = (Integer)map.get("level");
        health = (Integer)map.get("health");
        attack = (Integer)map.get("attack");
        defend = (Integer)map.get("defend");
        gold = (Integer)map.get("gold");
        experience = (Integer)map.get("experience");
        item = new Item((Map)map.get("item"));
        setX((Integer)map.get("x"));
        setY((Integer)map.get("y"));
        direction = (String)map.get("direction");
        floor = (Integer)map.get("floor");
        limit = (Integer)map.get("limit");
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefend() {
        return defend;
    }

    public void setDefend(int defend) {
        this.defend = defend;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
