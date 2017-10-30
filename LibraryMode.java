import java.util.ArrayList;

/**
 * This defines my actions when the mp3Player is on libraryMode state.
 */
public class LibraryMode implements MP3PlayerState {

    //private Write xmlWrite = new Write();
    private MP3Player mp3Player;
    private String libraryPath = "./library.data";

    /**
     * Take in a mp3Player and set some variables to make
     * life easier.
     *
     * @param mp3Player Takes the MP3Player class.
     */
    public LibraryMode(MP3Player mp3Player) {
        this.mp3Player = mp3Player;
    }

    /**
     * Load list of playlist. Under construction.
     */
    @Override
    public void loadListOfPlaylist() {
        //TODO:check if file that contains list of playlist exist
    }

    /**
     * Load new song
     *
     * @param selectedSong Takes in the new song to be played.
     */
    @Override
    public void loadNewTrack(String selectedSong) {
        this.mp3Player.getPlayer().stop();
        this.mp3Player.getPlayer().setMediaPlayer(selectedSong);
    }

    /**
     * Play a song.
     */
    @Override
    public void playSong() {
        this.mp3Player.getPlayer().play();
        //this.mp3Player.setMP3PlayerState(this.mp3Player.getPlayingLibrary());
    }

    /**
     * Adds song to library.
     *
     * @param newSongs Takes in path of new song
     */
    @Override
    public void addSong(ArrayList<String> newSongs) {
        //add to library
        for (String readPath : newSongs) { new Write().storeData(libraryPath, readPath); }
        Updates updates = new Updates(this.mp3Player.getComponents(),this.mp3Player.getMusicList());
        updates.updateMusicList(newSongs);
    }

    /**
     * Coming soon...
     */
    @Override
    public void createPlaylist() {
        this.mp3Player.getComponents().getStage().showAndWait();
        this.mp3Player.getComponents().getComboBox().getSelectionModel().select("Library");
    }

    /**
     * Prints an alert message since we are already in library state.
     */
    @Override
    public void switchToLibrary() {
        //System.out.println("LibraryMode");
    }

    /**
     * Use to change the state to playlistMode state.
     */
    @Override
    public void switchToPlaylist() {
        this.mp3Player.setMP3PlayerState(this.mp3Player.getPlaylistMode());
    }
}
