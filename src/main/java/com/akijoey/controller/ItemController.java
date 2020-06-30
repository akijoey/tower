package com.akijoey.controller;

import com.akijoey.bean.Item;

import static com.akijoey.util.ConfigUtil.player;
import static com.akijoey.view.ContentPane.messagePane;

public class ItemController {

    public static boolean interaction(int id) {
        if (id >= 1100 && id < 1110) {
            getKey(id);
        } else if (id >= 1110 && id < 1120) {
            getBottle(id);
        } else if (id >= 1120 && id < 1130) {
            getGem(id);
        } else if (id >= 1130 && id < 1140) {
            getPack(id);
        } else if (id >= 1140 && id < 1160) {
            getTool(id);
        } else if (id >= 1160 && id < 1180) {
            getWeapon(id);
        } else if (id >= 1180 && id < 1200) {
            getShield(id);
        }
        return true;
    }

    private static void getTool(int id) {
        Item item = player.getItem();
        if (id == 1140) {
            item.setCompass(true);
            messagePane.display("得到 神圣的罗盘: 按 J 可跳跃楼层");
        } else if (id == 1141) {
            item.setPickaxe(true);
            messagePane.display("得到 神圣的镐子: 按 P 可破坏隐藏墙壁");
        } else if (id == 1142) {
            item.setKettle(true);
            player.setHealth(player.getHealth() * 2);
            messagePane.display("得到 神圣的水壶: 生命值翻倍");
        } else if (id == 1143) {
            item.setCross(true);
            messagePane.display("得到 仙女的十字架");
        } else if (id == 1144) {
            item.setBadge(true);
            messagePane.display("得到 神圣的徽章: 按 L 可查看怪物信息");
        } else if (id == 1148) {
            item.setFlameWand(true);
            messagePane.display("得到 火焰杖");
        } else if (id == 1149) {
            item.setFrozenWand(true);
            messagePane.display("得到 冰冻杖");
        } else if (id == 1150) {
            item.setThunderWand(true);
            messagePane.display("得到 雷电杖");
        }
    }

    private static void getPack(int id) {
        Item item = player.getItem();
        if (id == 1130) {
            item.setKeyPack(item.getKeyPack() + 1);
            item.setYellowKey(item.getYellowKey() + 1);
            item.setBlueBottle(item.getBlueKey() + 1);
            item.setBlueBottle(item.getRedKey() + 1);
            messagePane.display("得到一个 钥匙袋 各钥匙加 1 ！");
        } else if (id == 1131) {
            item.setGoldPack(item.getGoldPack() + 1);
            player.setGold(player.getGold() + 300);
            messagePane.display("得到一个 金币袋 金币加 300 ！");
        } else if (id == 1132) {
            item.setExperiencePack(item.getExperiencePack() + 1);
            player.setExperience(player.getExperience() + 300);
            messagePane.display("得到一个 经验袋 经验加 300 ！");
        }
    }

    private static void getKey(int id) {
        Item item = player.getItem();
        if (id == 1100) {
            item.setYellowKey(item.getYellowKey() + 1);
            messagePane.display("得到一把 黄钥匙 ！");
        } else if (id == 1101) {
            item.setBlueKey(item.getBlueKey() + 1);
            messagePane.display("得到一把 蓝钥匙 ！");
        } else if (id == 1102) {
            item.setRedKey(item.getRedKey() + 1);
            messagePane.display("得到一把 红钥匙 ！");
        } else if (id == 1103) {
            item.setGreenKey(item.getGreenKey() + 1);
            messagePane.display("得到一把 绿钥匙 ！");
        }
    }

    private static void getGem(int id) {
        Item item = player.getItem();
        if (id == 1120) {
            item.setRedGem(item.getRedGem() + 1);
            player.setAttack(player.getAttack() + 3);
            messagePane.display("得到一个 红宝石 攻击加 3 ！");
        } else if (id == 1121) {
            item.setBlueGem(item.getBlueGem() + 1);
            player.setDefend(player.getDefend() + 3);
            messagePane.display("得到一个 蓝宝石 防御加 3 ！");
        } else if (id == 1122) {
            item.setOrangeGem(item.getOrangeGem() + 1);
            player.setAttack(player.getAttack() + 3);
            player.setDefend(player.getDefend() + 3);
            messagePane.display("得到一个 橙宝石 攻击和防御加 3 ！");
        }
    }

    private static void getBottle(int id) {
        Item item = player.getItem();
        if (id == 1110) {
            item.setRedBottle(item.getRedBottle() + 1);
            player.setHealth(player.getHealth() + 200);
            messagePane.display("得到一个 初级血瓶 生命加 200 ！");
        } else if (id == 1111) {
            item.setBlueBottle(item.getBlueBottle() + 1);
            player.setHealth(player.getHealth() + 500);
            messagePane.display("得到一个 中级血瓶 生命加 500 ！");
        } else if (id == 1112) {
            item.setOrangeBottle(item.getOrangeBottle() + 1);
            player.setHealth(player.getHealth() + 1000);
            messagePane.display("得到一个 高级血瓶 生命加 1000 ！");
        }
    }

    private static void getWeapon(int id) {
        Item item = player.getItem();
        if (id == 1160) {
            item.setIronSword(true);
            player.setAttack(player.getAttack() + 15);
            messagePane.display("获得 铁剑 攻击加 15 ！");
        } else if (id == 1161) {
            item.setSilverSword(true);
            player.setAttack(player.getAttack() + 50);
            messagePane.display("获得 白银剑 攻击加 50 ！");
        } else if (id == 1162) {
            item.setGoldSword(true);
            player.setAttack(player.getAttack() + 120);
            messagePane.display("获得 黄金剑 攻击加 120 ！");
        } else if (id == 1163) {
            item.setDiamondSword(true);
            player.setAttack(player.getAttack() + 300);
            messagePane.display("获得 钻石剑 攻击加 300 ！");
        } else if (id == 1164) {
            item.setHolySword(true);
            player.setAttack(player.getAttack() + 500);
            messagePane.display("获得 神圣剑 攻击加 500 ！");
        }
    }

    private static void getShield(int id) {
        Item item = player.getItem();
        if (id == 1180) {
            item.setIronShield(true);
            player.setDefend(player.getDefend() + 15);
            messagePane.display("获得 铁盾 防御加 15 ！");
        } else if (id == 1181) {
            item.setSilverShield(true);
            player.setDefend(player.getDefend() + 50);
            messagePane.display("获得 白银盾 防御加 50 ！");
        } else if (id == 1182) {
            item.setGoldShield(true);
            player.setDefend(player.getDefend() + 120);
            messagePane.display("获得 黄金盾 防御加 120 ！");
        } else if (id == 1183) {
            item.setDiamondShield(true);
            player.setDefend(player.getDefend() + 300);
            messagePane.display("获得 钻石盾 防御加 300 ！");
        } else if (id == 1184) {
            item.setHolyShield(true);
            player.setDefend(player.getDefend() + 500);
            messagePane.display("获得 神圣盾 防御加 500 ！");
        }
    }

}
