package com.akijoey.util;

import javax.sound.sampled.*;
import java.net.URL;

public class AudioUtil {

    public static void playBackgroundMusic() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("audio/background.au");
        try {
            AudioInputStream stream = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
