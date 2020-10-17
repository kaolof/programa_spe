
package preguntas_spe;
import javax.sound.sampled.AudioInputStream;
import marytts.LocalMaryInterface;
import marytts.MaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.util.data.audio.AudioPlayer;

public class Mary {
    private MaryInterface marytts;
    private AudioPlayer ap;
    
    public Mary(String voiceName)
    {
        try
        {
            marytts = new LocalMaryInterface();
            marytts.setVoice(voiceName);
            ap = new AudioPlayer();
        }
        catch (MaryConfigurationException ex)
        {
            ex.printStackTrace();
        }
    }

    public void say(String input)
    {
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
    
    
    public static void main(String[] args) {
       Mary voz= new Mary("cmu-rms-hsmm");
       voz.say("what name is given to the act of putting drillpipe into the wellbore when the blowout preventers are closed and pressure is contained in the well?");
       

