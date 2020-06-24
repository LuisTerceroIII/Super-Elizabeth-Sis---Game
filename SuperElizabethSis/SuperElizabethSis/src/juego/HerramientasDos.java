package juego;



import javax.sound.sampled.*;
import java.io.IOException;


public class HerramientasDos {

    public static Mixer mixer;
    public static Clip clip;
    public static void main(String[] args) {}

    public static void play(String file) {
        Mixer.Info[] mixInfos = AudioSystem.getMixerInfo();
        mixer = AudioSystem.getMixer(mixInfos[2]);
        DataLine.Info dataInfo = new DataLine.Info(Clip.class,new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,44100,16,2,4,44100,false));
        try {
            clip = (Clip) mixer.getLine(dataInfo);
        } catch (LineUnavailableException lue) {
            lue.printStackTrace();
        }
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource(file));
            clip.open(audioInputStream);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException lue) {
            lue.printStackTrace();
        }
        clip.start();

        do {
            try {
                Thread.sleep(0);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        } while (clip.isActive());
    }


}




