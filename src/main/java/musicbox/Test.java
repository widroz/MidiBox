package musicbox;

import java.util.Scanner;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

/**
 *
 * @author widroz
 */

public class Test {

    /**
     * @param args the command line arguments
     */
    public static String ejemplo = "C:\\Users\\ancap\\Desktop\\Mercurio.mid";

    public static void main(String[] args) throws MidiUnavailableException, InvalidMidiDataException {
        
        //Scanner sc = new Scanner(System.in);
        //ejemplo = sc.nextLine();
        
        Maquina m = new Maquina(Test.ejemplo);
        Scanner sc = new Scanner(System.in);
        String pausa = sc.nextLine();
        m.secuenciador.start();

    }

}
