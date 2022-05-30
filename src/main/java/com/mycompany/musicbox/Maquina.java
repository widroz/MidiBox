/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.musicbox;

import java.awt.Graphics;

import java.awt.Toolkit;
import java.io.File;
import javax.sound.midi.*;
import javax.swing.JFrame;


/**
 *
 * @author ancap
 */
public class Maquina extends JFrame implements Receiver {

    public static final String[] NOTAS = {"C", "C#", "D", "Eb", "E", "F", "F#", "G", "Ab", "A", "Bb", "B"};
    public static final int NOTE_ON = 0x90;
    public static final int NOTE_OFF = 0x80;

    String RutaArchivo;
    String Modo;
    Sequence secuencia;
    Sequencer secuenciador;
    Transmitter Transmisor;
    
    Casilla[][] casillas;
    
    int data1;
    int nota;
    int canal;
    int octava;
    int colorhex;
    int numerocanales;
    public Maquina(){}
    public Maquina(String RutaArchivo) throws MidiUnavailableException, InvalidMidiDataException {
        Modo = "3";
        this.RutaArchivo = RutaArchivo;
        setTitle("Music Box");
        setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        setVisible(true);
        //setBackground(new java.awt.Color(0,0,0));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        try {
            File archivo_midi = new File(this.RutaArchivo);
            secuencia = MidiSystem.getSequence(archivo_midi);
        } catch (Exception FileNotFound) {
            System.out.println("Archivo " + RutaArchivo + " no encontrado.");
        }

        secuenciador = MidiSystem.getSequencer();
        secuenciador.open();
        secuenciador.setSequence(secuencia);
        Transmisor = secuenciador.getTransmitter();
        Transmisor.setReceiver(this);
        numerocanales= secuencia.getTracks().length+1;
        //iniciarCasillasModoCPU();
        iniciarCasillas();

    }

    public void iniciarCasillas() throws MidiUnavailableException, InvalidMidiDataException{
        casillas = new Casilla[numerocanales][128];
        for(int i = 0; i < 128; i++){
            for(int j=0; j < numerocanales;j++){
                casillas[j][i] = new Casilla(j,i,this,true);   
                this.add(casillas[j][i]);
                
            }  
        }  
    }
    
    public void iniciarCasillasModoCPU() throws MidiUnavailableException, InvalidMidiDataException{
        casillas = new Casilla[12][numerocanales];
        for(int i = 0; i < 11; i++){
            for(int j=0; j < numerocanales;j++){
            casillas[i][j] = new Casilla(j,i,this,false);
            this.add(casillas[i][j]);
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
             nota = sm.getData1()%12;
             octava = sm.getData1()/12;
             colorhex = Color.obtenerColor(nota); 
             canal = sm.getChannel();
             casillas[canal][data1].activada = true; 
             casillas[canal][data1].revalidate();
             casillas[canal][data1].repaint();
             this.add(casillas[canal][data1]);
             
                
            } else if (sm.getCommand() == NOTE_OFF) {
             data1 = sm.getData1();
             nota = sm.getData1()%12;
             octava = sm.getData1()/12;
             colorhex = Color.obtenerColor(nota); 
             canal = sm.getChannel();
             casillas[canal][data1].activada = false; 
             
             casillas[canal][data1].revalidate();
             casillas[canal][data1].repaint();
                
                
            }
        }






    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
