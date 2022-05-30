/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.musicbox;

/**
 *
 * @author ancap
 */
public class Color {

    public static int obtenerColor(int Nota) {
        String NombreNota = Maquina.NOTAS[Nota % 12];
        int Octava = Nota / 12;

        if (Octava > 7) {
            return 0xFFFFFF;
        }
        if (Octava < 1) {
            return 0;
        }

        if (NombreNota == "C") { //ROJO

            switch (Octava) {

                case 1:
                    return 0x003300;
                case 2:
                    return 0x1b5e20;
                case 3:
                    return 0x2e7d32;
                case 4:
                    return 0x43a047;
                case 5:
                    return 0x66bb6a;
                case 6:
                    return 0xa5d6a7;
                case 7:
                    return 0xc8e6c9;

            }

        }

        if (NombreNota == "C#" || NombreNota == "Db") { //INDIGO

            switch (Octava) {

                case 1:
                    return 0x000051;
                case 2:
                    return 0x1a237e;
                case 3:
                    return 0x283593;
                case 4:
                    return 0x3949ab;
                case 5:
                    return 0x5c6bc0;
                case 6:
                    return 0x9fa8da;
                case 7:
                    return 0xc5cae9;

            }

        }

        if (NombreNota == "D") {

            switch (Octava) {

                case 1:
                    return 0x760000;
                case 2:
                    return 0xac1900;
                case 3:
                    return 0xe65100;
                case 4:
                    return 0xef6c00;
                case 5:
                    return 0xfb8c00;
                case 6:
                    return 0xffa726;
                case 7:
                    return 0xffcc80;

            }

        }

        if (NombreNota == "Eb") { //MARRÓN

            switch (Octava) {

                case 1:
                    return 0xbcaaa4;
                case 2:
                    return 0xa1887f;
                case 3:
                    return 0x795548;
                case 4:
                    return 0x5d4037;
                case 5:
                    return 0x4e342e;
                case 6:
                    return 0x3e2723;
                case 7:
                    return 0x1b0000;

            }

        }

        if (NombreNota == "E") {

            switch (Octava) {

                case 1:
                    return 0x000a12;
                case 2:
                    return 0x263238;
                case 3:
                    return 0x37474f;
                case 4:
                    return 0x546e7a;
                case 5:
                    return 0x78909c;
                case 6:
                    return 0xb0bec5;
                case 7:
                    return 0xcfd8dc;

            }

        }

        if (NombreNota == "F") { //CYAN

            switch (Octava) {

                case 1:
                    return 0x00363a;
                case 2:
                    return 0x006064;
                case 3:
                    return 0x00838f;
                case 4:
                    return 0x00acc1;
                case 5:
                    return 0x26c6da;
                case 6:
                    return 0x80deea;
                case 7:
                    return 0xb2ebf2;

            }

        }

        if (NombreNota == "F#") { //ROSA

            switch (Octava) {

                case 1:
                    return 0x560027;
                case 2:
                    return 0x880e4f;
                case 3:
                    return 0xad1457;
                case 4:
                    return 0xd81b60;
                case 5:
                    return 0xec407a;
                case 6:
                    return 0xf48fb1;
                case 7:
                    return 0xf8bbd0;

            }

        }

        if (NombreNota == "G") { //ROJO

            switch (Octava) {

                case 1:
                    return 0x7f0000;
                case 2:
                    return 0xb71c1c;
                case 3:
                    return 0xc62828;
                case 4:
                    return 0xe53935;
                case 5:
                    return 0xef5350;
                case 6:
                    return 0xef9a9a;
                case 7:
                    return 0xffcdd2;

            }

        }

        if (NombreNota == "Ab") { //AZUL

            switch (Octava) {

                case 1:
                    return 0x002171;
                case 2:
                    return 0x0d47a1;
                case 3:
                    return 0x1565c0;
                case 4:
                    return 0x1e88e5;
                case 5:
                    return 0x42a5f5;
                case 6:
                    return 0x90caf9;
                case 7:
                    return 0xbbdefb;

            }

        }

        if (NombreNota == "A") { //GRIS

            switch (Octava) {

                case 1:
                    return 0x212121;
                case 2:
                    return 0x424242;
                case 3:
                    return 0x616161;
                case 4:
                    return 0x757575;
                case 5:
                    return 0x9e9e9e;
                case 6:
                    return 0xbdbdbd;
                case 7:
                    return 0xe0e0e0;

            }

        }

        if (NombreNota == "Bb") { //LIMA

            switch (Octava) {

                case 1:
                    return 0x524c00;
                case 2:
                    return 0x827717;
                case 3:
                    return 0x9e9d24;
                case 4:
                    return 0xc0ca33;
                case 5:
                    return 0xd4e157;
                case 6:
                    return 0xe6ee9c;
                case 7:
                    return 0xf0f4c3;

            }

        }

        if (NombreNota == "B") {

            switch (Octava) {

                case 1:
                    return 0xbc5100;
                case 2:
                    return 0xf57f17;
                case 3:
                    return 0xf9a825;
                case 4:
                    return 0xfdd835;
                case 5:
                    return 0xffee58;
                case 6:
                    return 0xfff59d;
                case 7:
                    return 0xfff9c4;

            }

        }
        return 0;

    }

    public static int R(int Hex) {
        return (Hex & 0xff0000) / 0xffff;
    }

    public static int G(int Hex) {
        return (Hex & 0x00ff00) / 0xff;
    }

    public static int B(int Hex) {
        return Hex & 0x0000ff;
    }

}
