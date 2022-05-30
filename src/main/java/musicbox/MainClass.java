/**
 *
 * @author widroz
 */

package musicbox;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;


public class MainClass {

    //Place HERE the rute of the desired file:
    public static String example = "src/main/java/musicbox/JupiterVoices.mid";

    public static void main(String[] args) throws MidiUnavailableException, InvalidMidiDataException {
        
        
        Machine midi_box = new Machine(MainClass.example);

        midi_box.sequencer.start();
        midi_box.close();
    }
}
