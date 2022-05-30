package musicbox;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

/**
 *
 * @author widroz
 */

public class MainClass {

    //Place here the file of the desired FILE'S RUTE
    public static String example = "C:\\Users\\ancap\\Desktop\\Mercurio.mid";

    public static void main(String[] args) throws MidiUnavailableException, InvalidMidiDataException {
        
        
        Machine midi_box = new Machine(MainClass.example);

        midi_box.sequencer.start();
        midi_box.close();
    }
}
