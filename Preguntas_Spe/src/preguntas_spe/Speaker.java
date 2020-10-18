
package preguntas_spe;
import javax.sound.sampled.AudioInputStream;
import marytts.LocalMaryInterface;
import marytts.MaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.util.data.audio.AudioPlayer;

public class Speaker {
    private MaryInterface marytts;
    private AudioPlayer ap;
    private String nombre_voz;
    
    public Speaker(){
        
        nombre_voz="cmu-rms-hsmm";
        
        try{
            marytts = new LocalMaryInterface();
            marytts.setVoice(nombre_voz);
            ap = new AudioPlayer();
            
        }
        catch (MaryConfigurationException ex){
            ex.printStackTrace();
        }
    }

    public void say(String input){
        try
        {
            AudioInputStream audio = marytts.generateAudio(input);

            ap.setAudio(audio);
            ap.start();
        }
        catch (SynthesisException ex)
        {
            System.err.println("Error saying phrase.");
        }
        
    }
    
}   

