package com.akijoey.util;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class AudioUtil {

    public static void playBackgroundMusic() {
        String path = "audio/background.au";
        InputStream stream = AudioUtil.class.getClassLoader().getResourceAsStream(path);
        BufferedInputStream buffer = new BufferedInputStream(stream);
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(buffer);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
