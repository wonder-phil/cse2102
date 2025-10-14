public class MainAudioPlayer2VideoPlayer {

    public static void main(String[] args) {

        AudioPlayer audioPlayer = new AudioPlayer();
        AudioPlayer2VideoPlayer audioPlayer2VideoPlayer = new AudioPlayer2VideoPlayer(audioPlayer);

        audioPlayer2VideoPlayer.playScreen();
        audioPlayer2VideoPlayer.playAudio();


    }

}