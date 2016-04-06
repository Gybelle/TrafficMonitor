package view;

import javax.swing.*;
import java.awt.*;

/**
 * A view to represent the days of the week within a tabbed pane.
 * @author Michelle Gybels and Anaïs Ools
 */

public class DayPane extends JPanel {
    private int mDayOfWeek; //[1 = Monday, ..., 5 = Friday]
    private Dimension mDimension;
    private ImagePane mMorning;
    private ImagePane mAfternoon;

    public DayPane(int dayID, Dimension paneSize){
        mDayOfWeek = dayID;
        mDimension = paneSize;
        init();
        setPreferences();
        createUI();
    }

    /**
     * Initialise the components.
     */
    private void init(){
        mMorning = new ImagePane(mDayOfWeek, "Morning", 6, 10);
        mAfternoon = new ImagePane(mDayOfWeek, "Evening", 15, 19);
    }

    /**
     * Set the background.
     */
    private void setPreferences(){
        this.setBackground(Color.white);
        this.setPreferredSize(mDimension);
    }

    /**
     * Create the layout and add components.
     */
    private void createUI(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //add "Morning"
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(mMorning);

        /*
        //add "Afternoon"
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(mAfternoon);
        */
    }

}
