package com.akijoey.controller;

import com.akijoey.bean.Item;

import static com.akijoey.controller.PlayerController.player;
import static com.akijoey.view.ContentPane.messagePane;

public class ItemController {

    public static boolean interaction(int id) {
        if (id >= 1100 && id < 1110) {
            takeKey(id);
        } else if (id >= 1110 && id < 1120) {
            takeBottle(id);
        } else if (id >= 1120 && id < 1130) {
            takeGem(id);
        } else if (id >= 1130 && id < 1140) {
            takePack(id);
        } else if (id >= 1140 && id < 1160) {
            takeTool(id);
        } else if (id >= 1160 && id < 1180) {
            takeWeapon(id);
        } else if (id >= 1180 && id < 1200) {
            takeShield(id);
        }
        return true;
    }

    private static void takeTool(int id) {

    }

    private static void takePack(int id) {
        Item item = player.getItem();
        if (id == 1130) {
            item.setKeyPack(item.getKeyPack() + 1);
            item.setYellowKey(item.getYellowKey() + 1);
            item.setBlueBottle(item.getBlueKey() + 1);
            item.setRedKey(item.getRedKey() + 1);
        } else if (id == 1131) {
            item.setGoldPack(item.getGoldPack() + 1);
            player.setGold(player.getGold() + 300);
        } else if (id == 1132) {
            item.setExperiencePack(item.getExperiencePack() + 1);
            player.setExperience(player.getExperience() + 300);
        }
    }

    private static void takeKey(int id) {
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

    private static void takeGem(int id) {
        Item item = player.getItem();
        if (id == 1120) {
            item.setRedGem(item.getRedGem() + 1);
            player.setAttack(player.getAttack() + 3);
            messagePane.display("得到一个 红宝石 攻击力加 3 ！");
        } else if (id == 1121) {
            item.setBlueGem(item.getBlueGem() + 1);
            player.setDefend(player.getDefend() + 3);
            messagePane.display("得到一个 蓝宝石 防御力加 3 ！");
        } else if (id == 1122) {
            item.setOrangeGem(item.getOrangeGem() + 1);
            player.setAttack(player.getAttack() + 3);
            player.setDefend(player.getDefend() + 3);
            messagePane.display("得到一个 橙宝石 攻击力和防御力加 3 ！");
        }
    }

    private static void takeBottle(int id) {
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

    private static void takeWeapon(int id) {
        Item item = player.getItem();
        if (id == 1160) {
            player.setAttack(player.getAttack() + 10);
            messagePane.display("获得 铁剑 攻击加 10 ！");
        } else if (id == 1161) {
            player.setAttack(player.getAttack() + 50);
            messagePane.display("获得 钢剑 攻击加 50 ！");
        } else if (id == 1162) {
            player.setAttack(player.getAttack() + 120);
            messagePane.display("获得 旅人剑 攻击加 120 ！");
        } else if (id == 1163) {
            player.setAttack(player.getAttack() + 300);
            messagePane.display("获得 圣光剑 攻击加 300 ！");
        } else if (id == 1164) {
            player.setAttack(player.getAttack() + 500);
            messagePane.display("获得 王族剑 攻击加 500 ！");
        }
    }

    private static void takeShield(int id) {
        Item item = player.getItem();
        if (id == 1180) {
            player.setDefend(player.getDefend() + 10);
            messagePane.display("获得 铁盾 防御加 10 ！");
        } else if (id == 1181) {
            player.setDefend(player.getDefend() + 30);
            messagePane.display("获得 钢盾 防御加 10 ！");
        } else if (id == 1182) {
            player.setDefend(player.getDefend() + 120);
            messagePane.display("获得 旅人盾 防御加 10 ！");
        } else if (id == 1183) {
            player.setDefend(player.getDefend() + 300);
            messagePane.display("获得 星光盾 防御加 10 ！");
        } else if (id == 1184) {
            player.setDefend(player.getDefend() + 500);
            messagePane.display("获得 王族盾 防御加 10 ！");
        }
    }

}
