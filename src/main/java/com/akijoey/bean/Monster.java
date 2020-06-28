package com.akijoey.bean;

import java.util.HashMap;

public class Monster extends Block {

    private String name;

    private int health;
    private int attack;
    private int defend;
    private int gold;
    private int experience;

    public Monster(HashMap<String, Object> map) {
        name = (String)map.get("name");
        health = (Integer)map.get("health");
        attack = (Integer)map.get("attack");
        defend = (Integer)map.get("defend");
        gold = (Integer)map.get("gold");
        experience = (Integer)map.get("experience");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
