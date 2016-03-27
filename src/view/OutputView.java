package view;

import javax.swing.*;
import java.awt.*;

/**
 * A view to represent the output part of the application.
 *
 * @author Michelle Gybels and Anaïs Ools
 */

public class OutputView extends JPanel {
    private Dimension mDimension;
    private JTabbedPane mTabbedPane;
    private DayPane mMonday;
    private DayPane mTuesday;
    private DayPane mWednesday;
    private DayPane mThursday;
    private DayPane mFriday;

    public OutputView(Dimension outputSize) {
        mDimension = outputSize;
        init();
        setPreferences();
        setActions();
        createUI();
    }

    /**
     * Initialise the components.
     */
    private void init() {
        mTabbedPane = new JTabbedPane();
        mMonday = new DayPane(1);
        mTuesday = new DayPane(2);
        mWednesday = new DayPane(3);
        mThursday = new DayPane(4);
        mFriday = new DayPane(5);
    }

    /**
     * Set the background.
     */
    private void setPreferences() {
        this.setBackground(Color.red);
        this.setPreferredSize(mDimension);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    /**
     * Create actions for the tabbed pane in this part of the view.
     */
    private void setActions() {

    }

    /**
     * Create the layout and add components.
     */
    private void createUI() {
        //TODO: writhe some code.
    }

}
