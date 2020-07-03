package com.akijoey.util;

import javax.sound.sampled.*;
import java.io.InputStream;

public class AudioUtil {

    public static void playBackgroundMusic() {
        String path = "audio/background.au";
        InputStream audio = AudioUtil.class.getClassLoader().getResourceAsStream(path);
        try {
            AudioInputStream stream = AudioSystem.getAudioInputStream(audio);
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
