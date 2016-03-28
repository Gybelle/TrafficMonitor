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

    }

}
