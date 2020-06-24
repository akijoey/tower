package com.akijoey.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ImageUtil {

    public static HashMap<Integer, BufferedImage> from = new HashMap<>();
    public static HashMap<Integer, BufferedImage> to = new HashMap<>();

    public static BufferedImage content = readBackground("content");
    public static BufferedImage battle = readBackground("battle");
    public static BufferedImage blank = readBackground("blank");

    static {
        for (int i = 0;i < 118;i++) {
            from.put(i, readImage("/keyframe/from/" + i));
            to.put(i, readImage("/keyframe/to/" + i));
        }
    }

    public static BufferedImage readImage(String relative) {
        String absolute = System.getProperty("user.dir") + "/res/image" + relative + ".png";
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(absolute));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public static BufferedImage readBackground(String name) {
        return readImage("/background/" + name);
    }

    public static BufferedImage readPlayer(String name) {
        return readImage("/player/" + name);
    }

}
