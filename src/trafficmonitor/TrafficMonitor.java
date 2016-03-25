package trafficmonitor;

import java.awt.*;
import javax.swing.*;

/**
 * Main class for Assignment 02: Build a traffic monitor tool for “your commute”
 * using Google Maps.
 * @author Michelle Gybels & Anaïs Ools
 * Created on March 24, 2016
 */

public class TrafficMonitor {
    //Constants
    private static final int WINDOW_WIDTH = 1200;
    private static final int WINDOW_HEIGHT = 700;

    private final View mView;

    public TrafficMonitor() {
        int marginWidth = 40;
        int marginHeight = 100;
        int inputPanelWidth = WINDOW_WIDTH - marginWidth;
        int inputPanelHeight = 150;
        int outputPanelWidth = WINDOW_WIDTH - marginWidth;
        int outputPanelHeight = WINDOW_HEIGHT - inputPanelHeight - marginHeight;

        Dimension inputPanelSize = new Dimension(inputPanelWidth,inputPanelHeight);
        Dimension outputPanelSize = new Dimension(outputPanelWidth, outputPanelHeight);

        mView = new View(inputPanelSize, outputPanelSize);
    }


    /**
     * Create the GUI for the application.
     */
    public void createGUI() {
        JFrame frame = new JFrame("Traffic Monitor");
        Dimension size = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setPreferredSize(size);
        frame.setMinimumSize(size);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //center the window on the screen
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(screen.width / 2 - WINDOW_WIDTH / 2,
                screen.height / 2 - WINDOW_HEIGHT / 2);

        frame.add(mView);
        frame.pack();
        frame.setVisible(true);
    }

    private static void createAndShowGUI() {
        TrafficMonitor anothercoolapplication = new TrafficMonitor();
        anothercoolapplication.createGUI();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
