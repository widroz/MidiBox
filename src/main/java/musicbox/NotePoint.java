package musicbox;

import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

public class NotePoint extends Component {
    Machine m;
    boolean active;
    int data1;
    int note;
    int octave;
    int channel;

    int x;
    int y;

    public NotePoint(int channel, int data1, Machine m) throws MidiUnavailableException, InvalidMidiDataException {
        this.m = new Machine();
        this.m = m;

        active = false;
        this.data1 = data1;
        note = data1 % 12;
        octave = data1 / 12;
        this.channel = channel;
        x = Machine.map128To1920(data1);
        y = Machine.mapChannelsTo1024(m.numberOfChannels, channel);
    }

    public void modeStrokeRectangles(Graphics g) {
        if (active) {
            for (int j = 0; j < m.numberOfChannels; j++) {
                g.drawRect(x, y, Machine.map128To1920(data1 + 1) - x,(Machine.mapChannelsTo1024(m.numberOfChannels, channel + 1)) - y);
            }

        }
    }

    public void modeRectangulosFill(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));

        if (active) {
            for (int i = 0; i < 128; i++) {
                for (int j = 0; j < m.numberOfChannels; j++) {

                    if (m.points[j][i].active)
                        g.drawLine(x, y, (m.points[j][i].x), (m.points[j][i].y));
                }
            }

        }
    }

    public void circlesMode(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));

        if (active) {
            g.fillOval(x - 5, y - 5, 10, 10);
        }
    }

    public void circlesMode2(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));

        if (active) {
            // g.drawOval(x, y, 50,50);
            g.fillOval(x, y, 20, 20);
        }

    }


    public void NDimensionalmode(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        if (active) {
            for (int i = 0; i < 128; i++) {
                for (int j = 0; j < m.numberOfChannels; j++) {
                    if (m.points[j][i].active)
                        g.drawLine(x, y, (m.points[j][i].x), (m.points[j][i].y));
                }
            }
        }
    }

    public void centerMode(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        if (active) {
            g.drawLine(x, y, 1920 / 2, 1080 / 2);
        }
    }

    public void weirdMode(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));

        if (active) {

            switch (note) {
                case 7:
                    g.fillOval(x, y, 15, 15);
                case 1:
                    g.fillRect(x, y, 15, 15);
                case 2:
                    g.drawLine(x, y, 1920 / 2, 1080 / 2);
                case 6: {
                    g.drawOval(x, y, 15, 15);
                    g.drawOval(x + 20, y + 20, 5, 5);
                }
                case 4:
                    g.drawRect(x, y, 20, 10);
                case 5:
                    g.drawRect(x, y, 10, 20);
                case 3:
                    g.drawOval(x, y, 15, 15);
                case 0:
                    g.drawLine(x, y, 0, 0);
                case 8:
                    g.drawLine(x, y, 1920, 0);
                case 9:
                    g.drawLine(x, y, 1920, 1080);
                case 10:
                    g.drawLine(x, y, 0, 1080);
                case 11:
                    g.drawLine(x, y, x, y + 50);
            }

        }
    }



    public void setColor(Graphics g, String mode) {
        if (mode == "default") {
            g.setColor(new java.awt.Color(Color.getColor(data1)));
        }
        if (mode == "gray") {
            java.awt.Color c = new java.awt.Color(data1 * 2, data1 * 2, data1 * 2);
            g.setColor(c);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON));


        // You can choose between "default" to "gray"
        setColor(g, "default");

        // You can choose your favourite mode, just type here nameOfMode(g)
        NDimensionalmode(g);
    }
}
