package com.akijoey.bean;

public class Monster extends Block {

    private int id;
    private String name;

    private int health;
    private int attack;
    private int defend;
    private int gold;
    private int experience;

    public Monster() {}

    public Monster(int id, String name, int health, int attack, int defend, int gold, int experience) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defend = defend;
        this.gold = gold;
        this.experience = experience;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
