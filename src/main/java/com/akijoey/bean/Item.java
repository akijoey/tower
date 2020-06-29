package com.akijoey.bean;

import java.util.HashMap;

public class Item {

    private int redGem;
    private int blueGem;
    private int orangeGem;

    private int redBottle;
    private int blueBottle;
    private int orangeBottle;

    private int yellowKey;
    private int blueKey;
    private int redKey;
    private int greenKey;

    private int keyPack;
    private int goldPack;
    private int experiencePack;

    private boolean cross;      // 仙女的十字架
    private boolean badge;      // 神圣的徽章: 获取该层怪物信息
    private boolean kettle;     // 神圣的水壶: 可增加一倍生命值
    private boolean compass;    // 神圣的罗盘: 随意传送至各楼层
    private boolean pickaxe;    // 神圣的镐子: 可以破坏隐藏墙壁

    private boolean plume;      // 飞羽
    private boolean firePlume;  // 火飞羽
    private boolean icePlume;   // 冰飞羽

    private boolean flameWand;      // 火焰杖
    private boolean frozenWand;     // 冰冻杖
    private boolean thunderWand;    // 雷电杖

    private boolean ironSword;      // 铁剑
    private boolean silverSword;    // 白银剑
    private boolean goldSword;      // 黄金剑
    private boolean diamondSword;   // 钻石剑
    private boolean holySword;      // 神圣剑

    private boolean ironShield;     // 铁盾
    private boolean silverShield;   // 白银盾
    private boolean goldShield;     // 黄金盾
    private boolean diamondShield;  // 钻石盾
    private boolean holyShield;     // 神圣盾

    public Item(HashMap<String, Object> map) {
        redGem = (Integer)map.get("redGem");
        blueGem = (Integer)map.get("blueGem");
        orangeGem = (Integer)map.get("orangeGem");

        redBottle = (Integer)map.get("redBottle");
        blueBottle = (Integer)map.get("blueBottle");
        orangeBottle = (Integer)map.get("orangeBottle");

        yellowKey = (Integer)map.get("yellowKey");
        blueKey = (Integer)map.get("blueKey");
        redKey = (Integer)map.get("redKey");
        greenKey = (Integer)map.get("greenKey");

        keyPack = (Integer)map.get("keyPack");
        goldPack = (Integer)map.get("goldPack");
        experiencePack = (Integer)map.get("experiencePack");

        cross = (Boolean)map.get("cross");
        badge = (Boolean)map.get("badge");
        kettle = (Boolean)map.get("kettle");
        compass = (Boolean)map.get("compass");
        pickaxe = (Boolean)map.get("pickaxe");

        plume = (Boolean)map.get("plume");
        firePlume = (Boolean)map.get("firePlume");
        icePlume = (Boolean)map.get("icePlume");

        flameWand = (Boolean)map.get("flameWand");
        frozenWand = (Boolean)map.get("frozenWand");
        thunderWand = (Boolean)map.get("thunderWand");

        ironSword = (Boolean)map.get("ironSword");
        silverSword = (Boolean)map.get("silverSword");
        goldSword = (Boolean)map.get("goldSword");
        diamondSword = (Boolean)map.get("diamondSword");
        holySword = (Boolean)map.get("holySword");

        ironShield = (Boolean)map.get("ironShield");
        silverShield = (Boolean)map.get("silverShield");
        goldShield = (Boolean)map.get("goldShield");
        diamondShield = (Boolean)map.get("diamondShield");
        holyShield = (Boolean)map.get("holyShield");
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

    public boolean isCross() {
        return cross;
    }

    public void setCross(boolean cross) {
        this.cross = cross;
    }

    public boolean isBadge() {
        return badge;
    }

    public void setBadge(boolean badge) {
        this.badge = badge;
    }

    public boolean isKettle() {
        return kettle;
    }

    public void setKettle(boolean kettle) {
        this.kettle = kettle;
    }

    public boolean isCompass() {
        return compass;
    }

    public void setCompass(boolean compass) {
        this.compass = compass;
    }

    public boolean isPickaxe() {
        return pickaxe;
    }

    public void setPickaxe(boolean pickaxe) {
        this.pickaxe = pickaxe;
    }

    public boolean isPlume() {
        return plume;
    }

    public void setPlume(boolean plume) {
        this.plume = plume;
    }

    public boolean isFirePlume() {
        return firePlume;
    }

    public void setFirePlume(boolean firePlume) {
        this.firePlume = firePlume;
    }

    public boolean isIcePlume() {
        return icePlume;
    }

    public void setIcePlume(boolean icePlume) {
        this.icePlume = icePlume;
    }

    public boolean isFlameWand() {
        return flameWand;
    }

    public void setFlameWand(boolean flameWand) {
        this.flameWand = flameWand;
    }

    public boolean isFrozenWand() {
        return frozenWand;
    }

    public void setFrozenWand(boolean frozenWand) {
        this.frozenWand = frozenWand;
    }

    public boolean isThunderWand() {
        return thunderWand;
    }

    public void setThunderWand(boolean thunderWand) {
        this.thunderWand = thunderWand;
    }

    public boolean isIronSword() {
        return ironSword;
    }

    public void setIronSword(boolean ironSword) {
        this.ironSword = ironSword;
    }

    public boolean isSilverSword() {
        return silverSword;
    }

    public void setSilverSword(boolean silverSword) {
        this.silverSword = silverSword;
    }

    public boolean isGoldSword() {
        return goldSword;
    }

    public void setGoldSword(boolean goldSword) {
        this.goldSword = goldSword;
    }

    public boolean isDiamondSword() {
        return diamondSword;
    }

    public void setDiamondSword(boolean diamondSword) {
        this.diamondSword = diamondSword;
    }

    public boolean isHolySword() {
        return holySword;
    }

    public void setHolySword(boolean holySword) {
        this.holySword = holySword;
    }

    public boolean isIronShield() {
        return ironShield;
    }

    public void setIronShield(boolean ironShield) {
        this.ironShield = ironShield;
    }

    public boolean isSilverShield() {
        return silverShield;
    }

    public void setSilverShield(boolean silverShield) {
        this.silverShield = silverShield;
    }

    public boolean isGoldShield() {
        return goldShield;
    }

    public void setGoldShield(boolean goldShield) {
        this.goldShield = goldShield;
    }

    public boolean isDiamondShield() {
        return diamondShield;
    }

    public void setDiamondShield(boolean diamondShield) {
        this.diamondShield = diamondShield;
    }

    public boolean isHolyShield() {
        return holyShield;
    }

    public void setHolyShield(boolean holyShield) {
        this.holyShield = holyShield;
    }
}
