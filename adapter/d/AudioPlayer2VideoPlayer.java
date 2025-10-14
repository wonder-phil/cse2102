public class AudioPlayer2VideoPlayer {

    private AudioPlayer audioPlayer;

    public AudioPlayer2VideoPlayer(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    public void playScreen() {
        audioPlayer.randomColorScreen();
    }

    public void playAudio() {
        audioPlayer.playAudio();
    }

}