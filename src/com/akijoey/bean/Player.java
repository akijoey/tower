package com.akijoey.bean;

public class Player extends Block {

    private static Player player = new Player();

    private int level;
    private int gold;
    private int experience;

    private int health;
    private int attack;
    private int defend;

    private int floor;
    private String direction;

    private Item item;

    private Player() {
//        level = 1;
////        gold = 0;
////        experience = 0;
////        health = 1000;
////        attack = 10;
////        defend = 10;
////        floor = 0;
////        direction = "down";
////        item = Item.getInstance();
////        setX(5);
////        setY(10);

        // test
        level = 1;
        gold = 0;
        experience = 0;
        health = 100000;
        attack = 10000;
        defend = 10000;
        floor = 0;
        direction = "down";
        item = Item.getInstance();
        setX(5);
        setY(10);
    }

    public static Player getInstance() {
        return player;
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
