/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.musicbox;

import java.util.Scanner;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

/**
 *
 * @author ancap
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
