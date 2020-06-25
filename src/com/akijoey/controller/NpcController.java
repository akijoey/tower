package com.akijoey.controller;

import static com.akijoey.util.ConfigUtil.map;
import static com.akijoey.view.ContentPane.dialogPane;

public class NpcController {

    public static boolean interaction(int id) {
        dialogPane.display(id);
        if (id == 1230) {   // 0层 仙子 第一次对话
            map[0][8][5] = 1000;
            map[0][8][4] = 1230;
        }
        return false;
    }

}
