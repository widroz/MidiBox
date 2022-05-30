/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.musicbox;

import static com.mycompany.musicbox.Color.obtenerColor;
import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

/**
 *
 * @author ancap
 */
public class Casilla extends Component{
    
    Maquina m;
    boolean activada;
    int x;
    int y;
    int data1;
    int nota;
    int octava;
    int canal;
    int x2;
    int y2;
    
    public Casilla(int canal, int data1, Maquina m) throws MidiUnavailableException, InvalidMidiDataException{
    this.m = new Maquina();
    this.m = m;
    activada = false;
    this.data1=data1;
    nota=data1%12;
    octava=data1/12;
    this.canal = canal;
    x = Maquina.map128To1920(data1);
    y = Maquina.mapChannelsTo1024(m.numerocanales,canal);    
    }
    public Casilla(int canal, int data1, Maquina m, boolean b) throws MidiUnavailableException, InvalidMidiDataException{
    
    if(b){this.m = new Maquina();
    this.m = m;
    activada = false;
    this.data1=data1;
    nota=data1%12;
    octava=data1/12;
    this.canal = canal;
    x= Maquina.map128To1920(data1);
    y = Maquina.mapChannelsTo1024(m.numerocanales,canal);
    x2 = Maquina.map128To1920(nota*(128/12));
    y2 = Maquina.mapChannelsTo1024(m.numerocanales,canal);
        }
        else{
            this.m = new Maquina();
            this.m = m;
            activada = false;
            this.data1 = data1;
            nota=data1%12;
            octava=data1/12;
            this.canal = canal;
            if(nota == 3){
                
                x = 100+octava;
                y = 500+octava;
                x2 = 200-octava;
                y2 = 800-octava;
                
            }
            
            if(nota == 7){
                
                x = 300+octava;
                y = 500+octava;
                x2 = 500-octava;
                y2 = 800-octava;
                
            }
            
            if(nota == 5){
                
                x = 650+octava;
                y = 400+octava;
                x2 = 750-octava;
                y2 = 600-octava;
                
            }
             if(nota == 10){
                
                x = 650+octava;
                y = 700+octava;
                x2 = 750-octava;
                y2 = 900-octava;
                
            }
             //todo here
             
              if((nota != 3)&&(nota != 5)&&(nota != 10)&&(nota != 7)){
                
                x = 0+octava;
                y = 0+octava;
                x2 = 0+octava;
                y2 = 0+octava;
         
            }
            
            
        }
    
    }
    
    
    
        public void modoCentro(Graphics g){
        //Funciona
             Graphics2D g2 = (Graphics2D) g;
             
             g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND,
          BasicStroke.JOIN_ROUND));
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON));
        boolean b = false;
        
        if(activada){
    g.drawLine(x, y, 1920/2, 1080/2);
     
            }  
     
        }
    
    
    public void modoNDimensional(Graphics g){
        //Funciona
             Graphics2D g2 = (Graphics2D) g;
             
             g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND,
          BasicStroke.JOIN_ROUND));
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON));
        boolean b = false;
        
        if(activada){
        for(int i = 0; i < 128; i++){
            for(int j=0; j < m.numerocanales;j++){
           
            if(m.casillas[j][i].activada)g.drawLine(x, y, (m.casillas[j][i].x),(m.casillas[j][i].y));
     
            }  
        }  
    
        }    
        }
    
    
        public void modoNDimensionalDesplazado(Graphics g){
        //Funciona
             Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON));
        boolean b = false;
        
        if(activada){
        for(int i = 0; i < 128; i++){
            for(int j=0; j < m.numerocanales;j++){
           
            if(m.casillas[j][i].activada)g.drawLine(x, y+(1080/2), (m.casillas[j][i].x),(m.casillas[j][i].y)+(1080/2));
     
            }  
        }  
    
        }    
        }
    
    public void modoCPU(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON));
        
        if(activada){
        for(int i = 0; i < 128; i++){
            for(int j=0; j < m.numerocanales;j++){
           
            if(m.casillas[j][i].activada)g.drawLine(x,y, (m.casillas[j][i].x2),(m.casillas[j][i].y2));
     
            }  
        }      
    }
    }
    
    
    public void modoNDimensional2(Graphics g){
        //Funciona
             Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON));
        boolean b = false;
        if(activada){
        for(int i = 0; i < 128; i++){
            for(int j=0; j < m.numerocanales;j++){
            
            if(m.casillas[j][i].activada)g.drawLine(x2, y2, (m.casillas[j][i].x2),(m.casillas[j][i].y2));
     
            }  
        }  
    
        }    
        }
    
    public void modoRectangulosFill(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON));

        if(activada){
        for(int i = 0; i < 128; i++){
            for(int j=0; j < m.numerocanales;j++){
            
            if(m.casillas[j][i].activada)g.drawLine(x, y, (m.casillas[j][i].x),(m.casillas[j][i].y));
     
            }  
        }  
    
        }
        
    }
        public void modoCirculosFill(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON));

        if(activada){
        g.fillOval(x-5, y-5, 10,10);
        //g.fillOval(x2, y2, 20,20);

            } 
        
    
        }
        
            public void modoCirculosFill2(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON));

        if(activada){
        //g.drawOval(x, y, 50,50);
        g.fillOval(x, y, 20,20);

            } 
        
    
        }
        
    
    
        public void modo3(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON));

        if(activada){
   
                switch(nota){
                    case 7: g.fillOval(x, y, 15, 15);
                    case 1: g.fillRect(x, y, 15, 15);
                    case 2: g.drawLine(x,y,1920/2,1080/2);
                    case 6: {
                        g.drawOval(x,y,15,15);
                        g.drawOval(x+20,y+20,5,5);
                }
                    case 4: g.drawRect(x, y, 20,10);
                    case 5: g.drawRect(x, y, 10,20);
                    case 3: g.drawOval(x, y, 15, 15);
                    case 0: g.drawLine(x,y,0,0);
                    case 8: g.drawLine(x,y,1920,0);
                    case 9: g.drawLine(x,y,1920,1080);
                    case 10: g.drawLine(x,y,0,1080);
                    case 11: g.drawLine(x,y,x,y+50);
            }
     
            }  
          


        }

        
   
    
    public void modoString(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON));
            if(activada){

            //g.drawString(Maquina.NOTAS[nota]+""+octava, (int)(1920*Math.random()), (int)(Math.random()*1024));
            g.fillOval((int)(1920*Math.random()), (int)(Math.random()*1024),50,50);
            
            
        }
        
        
    }
    
    public void modoRectangulosStroke(Graphics g){
                    if(activada){
            for(int j=0; j < m.numerocanales;j++){
        
        g.drawRect(x, y,Maquina.map128To1920(data1+1)-x,(Maquina.mapChannelsTo1024(m.numerocanales,canal+1))-y);
            }
            
        }
        
    }
    
    public void establecerColor(Graphics g, String modo){
        
        if(modo == "default"){
            g.setColor(new java.awt.Color(Color.obtenerColor(data1)));
        }
        if(modo == "grisR" ){
            java.awt.Color c =new java.awt.Color(data1*2,data1*2,data1*2);
            g.setColor(c);
        }
        
    }
    
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON));
        establecerColor(g,"default");
        //modo2(g);
       
    //modoCirculosFill(g);
    
    //modoCPU(g);
    
    modoCentro(g);

    modoNDimensional(g);
    //modoCirculosFill(g);
    
//modoNDimensionalDesplazado(g);
    }
    
}
      
    
    
    

