package musicbox;

import javax.sound.midi.*;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.io.File;


public class Machine extends JFrame implements Receiver {

    public static final String[] NOTES={"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    public static final int NOTE_ON = 0x90;
    public static final int NOTE_OFF = 0x80;

    String fileRute;
    Sequence sequence;
    Sequencer sequencer;
    Transmitter transmitter;
    
    NotePoint[][] points;
    
    int data1;
    int note;
    int channel;
    int octave;
    int colorhex;
    int numberOfChannels;

    public Machine(){}


    public Machine(String fileRute) throws MidiUnavailableException, InvalidMidiDataException {
        
        //Settings of Frame
        setTitle("Music Box");
        setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Try to read file, and create a sequence
        this.fileRute = fileRute;
        try {
            File archivo_midi = new File(this.fileRute);
            sequence = MidiSystem.getSequence(archivo_midi);
        } catch (Exception FileNotFound) {
            System.out.println("File" + fileRute + " not found or not a .mid");
        }

        //Initiate sequencer and transmitter.
        sequencer = MidiSystem.getSequencer();
        sequencer.open();
        sequencer.setSequence(sequence);
        transmitter = sequencer.getTransmitter();
        transmitter.setReceiver(this);

        //Set the number of channels and initiatePoints
        numberOfChannels= sequence.getTracks().length+1;
        initiatePoints();
    }

    public void initiatePoints() throws MidiUnavailableException, InvalidMidiDataException{
        //Divide X axis in 128 points and Y axis in numberOfChannels points
        points = new NotePoint[numberOfChannels][128];
        for(int i = 0; i < 128; i++){
            for(int j=0; j < numberOfChannels;j++){
                points[j][i] = new NotePoint(j,i,this);   
                this.add(points[j][i]);
            }  
        }  
    }
    
    public static int map128To1920(int n){
    return n*(1920/128);
    }
    public static int mapChannelsTo1024(int channels,int n){
    return n*(1024/channels);
    }

    
    @Override
    public void paint(Graphics g){
        super.paint(g); 
    }
    
    @Override
    synchronized public void send(MidiMessage message, long timeStamp) {

        if ((message instanceof ShortMessage)) {
            ShortMessage sm = (ShortMessage) message;
        
            if (sm.getCommand() == NOTE_ON) {
             data1 = sm.getData1();
             note = sm.getData1()%12;
             octave = sm.getData1()/12;
             colorhex = Color.getColor(note); 
             channel = sm.getChannel();
             points[channel][data1].active = true; 
             points[channel][data1].revalidate();
             points[channel][data1].repaint();
             this.add(points[channel][data1]);
             
            } else if (sm.getCommand() == NOTE_OFF) {
             data1 = sm.getData1();
             note = sm.getData1()%12;
             octave = sm.getData1()/12;
             colorhex = Color.getColor(note); 
             channel = sm.getChannel();
             points[channel][data1].active = false; 
             points[channel][data1].revalidate();
             points[channel][data1].repaint(); 
            }
        }
    }

    @Override
    public void close() {
        System.out.println("End of simulation");
    }

}
