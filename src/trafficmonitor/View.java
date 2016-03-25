package trafficmonitor;

import javax.swing.*;
import java.awt.*;

/**
 * A view to represent the content of the application.
 * @author Michelle Gybels and Anaïs Ools
 */

public class View extends JPanel {
    private InputView mInputView;
    private OutputView mOutputView;

    public View(){
        init();
        setPreferences();
        createUI();
    }

    /**
     * Initialise the components.
     */
    private void init(){
        mInputView = new InputView();
        mOutputView = new OutputView();
    }

    /**
     * Set the background.
     */
    private void setPreferences(){
        this.setBackground(Color.white);
    }

    /**
     * Assign the needed panels within this main panel.
     */
    private void createUI(){
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(mInputView);
        this.add(mOutputView);
    }



}
