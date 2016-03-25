package trafficmonitor;

import javax.swing.*;
import java.awt.*;

/**
 * A view to represent the output part of the application.
 * @author Michelle Gybels and Anaïs Ools
 */

public class OutputView extends JPanel {
    private Dimension mDimension;

    public  OutputView(Dimension outputSize) {
        mDimension = outputSize;
        init();
        setPreferences();
        createUI();
    }

    /**
     * Initialise the components.
     */
    private void init(){
      //TODO: write some code...
    }

    /**
     * Set the background.
     */
    private void setPreferences(){
        this.setBackground(Color.red);
        this.setPreferredSize(mDimension);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    /**
     * Create the layout and add components.
     */
    private void createUI(){
        //TODO: writhe some code.
    }

}
