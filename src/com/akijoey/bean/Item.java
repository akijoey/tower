package com.akijoey.bean;

public class Item {

    private static Item item = new Item();

    private int redGem = 0;
    private int blueGem = 0;
    private int orangeGem = 0;

    private int redBottle = 0;
    private int blueBottle = 0;
    private int orangeBottle = 0;

    private int yellowKey = 100;
    private int blueKey = 100;
    private int redKey = 100;
    private int greenKey = 100;

    private int keyPack = 0;
    private int goldPack = 0;
    private int experiencePack = 0;

    private Item() {}

    public static Item getInstance() {
        return item;
    }

    public int getRedGem() {
        return redGem;
    }

    public void setRedGem(int redGem) {
        this.redGem = redGem;
    }

    public int getBlueGem() {
        return blueGem;
    }

    public void setBlueGem(int blueGem) {
        this.blueGem = blueGem;
    }

    public int getOrangeGem() {
        return orangeGem;
    }

    public void setOrangeGem(int orangeGem) {
        this.orangeGem = orangeGem;
    }

    public int getRedBottle() {
        return redBottle;
    }

    public void setRedBottle(int redBottle) {
        this.redBottle = redBottle;
    }

    public int getBlueBottle() {
        return blueBottle;
    }

    public void setBlueBottle(int blueBottle) {
        this.blueBottle = blueBottle;
    }

    public int getOrangeBottle() {
        return orangeBottle;
    }

    public void setOrangeBottle(int orangeBottle) {
        this.orangeBottle = orangeBottle;
    }

    public int getYellowKey() {
        return yellowKey;
    }

    public void setYellowKey(int yellowKey) {
        this.yellowKey = yellowKey;
    }

    public int getBlueKey() {
        return blueKey;
    }

    public void setBlueKey(int blueKey) {
        this.blueKey = blueKey;
    }

    public int getRedKey() {
        return redKey;
    }

    public void setRedKey(int redKey) {
        this.redKey = redKey;
    }

    public int getGreenKey() {
        return greenKey;
    }

    public void setGreenKey(int greenKey) {
        this.greenKey = greenKey;
    }

    public int getKeyPack() {
        return keyPack;
    }

    public void setKeyPack(int keyPack) {
        this.keyPack = keyPack;
    }

    public int getGoldPack() {
        return goldPack;
    }

    public void setGoldPack(int goldPack) {
        this.goldPack = goldPack;
    }

    public int getExperiencePack() {
        return experiencePack;
    }

    public void setExperiencePack(int experiencePack) {
        this.experiencePack = experiencePack;
    }
}
