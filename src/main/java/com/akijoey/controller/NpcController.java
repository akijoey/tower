package com.akijoey.controller;

import com.akijoey.bean.Item;

import static com.akijoey.util.ConfigUtil.maps;
import static com.akijoey.view.ContentPane.dialogPane;
import static com.akijoey.util.ConfigUtil.player;
import static com.akijoey.view.ContentPane.messagePane;

public class NpcController {

    public static boolean interaction(int id) {
        if (id >= 1200 && id < 1203) {
            dialogPane.shop(1201);
        } else if (id >= 1203 && id < 1206) {
            dialogPane.shop(1204);
        } else if (id == 1211 || id == 1212 || id == 1221 || id == 1222) {
            dialogPane.shop(id);
        } else {
            dialogPane.talk(id);
        }
        return false;
    }

    public static void talk(int id) {
        Item item = player.getItem();
        if (id == 1213) {   // 16层 老人
            maps.get(16)[4][4] = 1210;
            item.setPlume(true);
            messagePane.display("得到 飞羽");
            maps.get(0)[8][4] = 1233;
        } else if (id == 1231) {   // 0层 仙子 第一次对话
            maps.get(0)[8][5] = 1000;
            maps.get(0)[8][4] = 1230;
            item.setYellowKey(item.getYellowKey() + 1);
            item.setBlueKey(item.getBlueKey() + 1);
            item.setRedKey(item.getRedKey() + 1);
        } else if (id == 1232) {    // 0层 仙子 获得十字架后
            maps.get(0)[8][4] = 1230;
            player.setLevel(player.getLevel() + 20);
            player.setHealth(player.getHealth() + 20000);
            player.setAttack(player.getAttack() + 140);
            player.setDefend(player.getDefend() + 140);
        } else if (id == 1233) {    // 0层 仙子 获得飞羽后
            maps.get(0)[8][4] = 1230;
        } else if (id == 1234) {    // 22层 仙子
            maps.get(22)[2][6] = 1230;
        } else if (id == 1241) {    // 4层 小偷
            maps.get(4)[0][5] = 1240;
            maps.get(2)[6][1] = 1000;
        } else if (id == 1251) {    // 18层 公主
            maps.get(18)[4][5] = 1250;
        }
    }

    public static void shop(int id, int select) {
        int gold = player.getGold();
        int experience = player.getExperience();
        if (id == 1201) {   // 3层 商店
            if (gold < 25) {
                messagePane.display("金币不足");
                return;
            }
            player.setGold(gold - 25);
            if (select == 0) {
                player.setHealth(player.getHealth() + 800);
            } else if (select == 1) {
                player.setAttack(player.getAttack() + 4);
            } else {
                player.setDefend(player.getDefend() + 4);
            }
        } else if (id == 1204) {    // 11层 商店
            if (gold < 100) {
                messagePane.display("金币不足");
                return;
            }
            player.setGold(gold - 100);
            if (select == 0) {
                player.setHealth(player.getHealth() + 4000);
            } else if (select == 1) {
                player.setAttack(player.getAttack() + 20);
            } else {
                player.setDefend(player.getDefend() + 20);
            }
        } else if (id == 1211) {    // 5层 老人
            if (select == 0) {
                if (experience < 100) {
                    messagePane.display("经验不足");
                    return;
                }
                player.setExperience(experience - 100);
                player.setLevel(player.getLevel() + 1);
                player.setHealth(player.getHealth() + 1000);
                player.setAttack(player.getAttack() + 7);
                player.setDefend(player.getDefend() + 7);
            } else if (select == 1) {
                if (experience < 30) {
                    messagePane.display("经验不足");
                    return;
                }
                player.setExperience(experience - 30);
                player.setAttack(player.getAttack() + 5);
            } else if (select == 2) {
                if (experience < 30) {
                    messagePane.display("经验不足");
                    return;
                }
                player.setExperience(experience - 30);
                player.setDefend(player.getDefend() + 5);
            }
        } else if (id == 1212) {    // 13层 老人
            if (select == 0) {
                if (experience < 270) {
                    messagePane.display("经验不足");
                    return;
                }
                player.setExperience(experience - 270);
                player.setLevel(player.getLevel() + 3);
                player.setHealth(player.getHealth() + 3000);
                player.setAttack(player.getAttack() + 21);
                player.setDefend(player.getDefend() + 21);
            } else if (select == 1) {
                if (experience < 95) {
                    messagePane.display("经验不足");
                    return;
                }
                player.setExperience(experience - 95);
                player.setAttack(player.getAttack() + 17);
            } else if (select == 2) {
                if (experience < 95) {
                    messagePane.display("经验不足");
                    return;
                }
                player.setExperience(experience - 95);
                player.setDefend(player.getDefend() + 17);
            }
        } else if (id == 1221) {    // 5层 商人
            Item item = player.getItem();
            if (select == 0) {
                if (gold < 10) {
                    messagePane.display("金币不足");
                    return;
                }
                player.setGold(gold - 10);
                item.setYellowKey(item.getYellowKey() + 1);
            } else if (select == 1) {
                if (gold < 50) {
                    messagePane.display("金币不足");
                    return;
                }
                player.setGold(gold - 50);
                item.setBlueKey(item.getBlueKey() + 1);
            } else if (select == 2) {
                if (gold < 100) {
                    messagePane.display("金币不足");
                    return;
                }
                player.setGold(gold - 100);
                item.setRedKey(item.getRedKey() + 1);
            }
        } else if (id == 1222) {    // 12层 商人
            Item item = player.getItem();
            if (select == 0) {
                if (item.getYellowKey() == 0) {
                    messagePane.display("黄钥匙不足");
                    return;
                }
                item.setYellowKey(item.getYellowKey() - 1);
                player.setGold(gold + 7);
            } else if (select == 1) {
                if (item.getBlueKey() == 0) {
                    messagePane.display("蓝钥匙不足");
                    return;
                }
                item.setBlueKey(item.getBlueKey() - 1);
                player.setGold(gold + 35);
            } else if (select == 2) {
                if (item.getRedKey() == 0) {
                    messagePane.display("红钥匙不足");
                    return;
                }
                item.setRedKey(item.getRedKey() - 1);
                player.setGold(gold + 70);
            }
        }
    }


}
