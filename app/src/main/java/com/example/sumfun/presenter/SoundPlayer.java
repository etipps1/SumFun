package com.example.sumfun.presenter;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

import com.example.sumfun.R;

/**
 * public SoundPlayer
 * purpose: play sounds
 * private AudioAttributes audioAttribute,
 * private static SoundPool soundPool
 * private static int, correctAns, wrongAns, yay
 * final int SOUND_POOL_MAX
 */

public class SoundPlayer {

    private AudioAttributes audioAttributes;
    final int SOUND_POOL_MAX = 2;

    private static SoundPool soundPool;
    private static int correctAns;
    private static int wrongAns;
    private static int yay;
//    private static int award;

    /**
     * public SoundPlayer constructor
     * @param context Context
     * purpose: build attribute so it sound has all it requires to play correctly, for a game.
     * also make sure credit is given to those that created the free sounds.
     */

    public SoundPlayer(Context context) {

        //SoundPool may be deprecated so adding attribute
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP) {

            audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(audioAttributes)
                    .setMaxStreams(SOUND_POOL_MAX)
                    .build();
        } else {
            //SoundPool (int maxStreams, int streamType, int scrQuality)
            soundPool = new SoundPool(SOUND_POOL_MAX, AudioManager.STREAM_MUSIC, 0);
        }

        correctAns = soundPool.load(context, R.raw.wine_glasses_cheers, 1);
        wrongAns = soundPool.load(context, R.raw.wronganswer, 1);
        yay = soundPool.load(context, R.raw.yay, 1);
//        award = soundPool.load(context, R.raw.award, 1);
        //The first sound was provided by Mega-X-stream on freesound.org the link to wine_glasses_cheers sound  license is below
        //https://creativecommons.org/licenses/by/3.0/ there were no changes made to this sound.
        //the second sound was provided by Gronkjaer on freesound.org the link to wrongaswer sound license is below
        //https://creativecommons.org/publicdomain/zero/1.0/ no changes were made to the sound.
        //yay was provided by Higgs01 on freesound.org. the link to the license is below
        //https://creativecommons.org/publicdomain/zero/1.0/ there were no changes made to this sound
        //award sound was provided by Suntemple on freesound.org the link to the license is below
        //https://creativecommons.org/publicdomain/zero/1.0/ there were no changes made to this sound.
    }

    /**
     * public method playCorrectSound
     * purpose: function that plays the sound when called
     */

    public void playCorrectSound() {
        //play(int soundID, float leftVolume, float rightVolume, int priority, int loop, float rate)
        soundPool.play(correctAns, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    /**
     * public method playWrongSound
     * purpose: function that plays the sound when called
     */

    public void playWrongSound() {
        soundPool.play(wrongAns, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    /**
     * public method playYaySound
     * purpose: function that plays the sound when called
     */
    public void playYaySound() {
        soundPool.play(yay, 1.0f, 1.0f, 1, 0, 1.0f);
    }
//    public void playAwardSound() {
//        soundPool.play(award, 1.0f, 1.0f, 1, 0, 1.0f);
//    } this may be added to the badge when awarded
}
