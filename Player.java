import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * this class haddles playing songs
 */
public class Player {

    private MediaPlayer mediaPlayer;

    /**
     * empty constructor to call
     * without passing in anything
     */
    public Player(){ }

    /**
     * takes in a path and sets te mediaplayer
     *
     * @param path takes in a path and sets up the media player
     */
    public Player(String path){ setMediaPlayer(path); }

    /**
     * gets the mediaplayer
     *
     * @return returns the recent media player
     */
    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    /**
     * sets the media player
     *
     * @param path takes in a path and builds a media player
     */
    public void setMediaPlayer(String path){

        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer player = new MediaPlayer(media);

        try {
            TimeUnit.MILLISECONDS.sleep(250);
        } catch (InterruptedException e) {

        }

        this.mediaPlayer = player;

    }

    /**
     * gets the duration
     * @return returns duration of the current song in millis
     */
    public String getDuration(MediaPlayer mediaPlayer){
        return formatDuration(mediaPlayer.getMedia().getDuration().toMillis());
    }


    /**
     * formats durations to minutes : seconds
     *
     * @param duration takes in a duration in mullis and coverts it to minutes: seconds
     * @return returns the new duration
     */
    private String formatDuration(double duration){

        return String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes((long) duration) -  TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours((long) duration)),
                TimeUnit.MILLISECONDS.toSeconds((long) duration) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) duration)));
    }

    /**
     * play media
     */
    public void play(){

        this.mediaPlayer.play();
    }

    /**
     * stop media
     */
    public void stop() {

        if (this.mediaPlayer != null) {
            this.mediaPlayer.stop();
        }
    }
}