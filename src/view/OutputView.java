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
        Dimension dayPaneSize = new Dimension(mDimension.width-20,
                mDimension.height-37);
        mMonday = new DayPane(1, dayPaneSize);
        mTuesday = new DayPane(2, dayPaneSize);
        mWednesday = new DayPane(3, dayPaneSize);
        mThursday = new DayPane(4, dayPaneSize);
        mFriday = new DayPane(5, dayPaneSize);
    }

    /**
     * Set the background.
     */
    private void setPreferences() {
        //this.setBackground(Color.red);
        this.setOpaque(false);
        this.setPreferredSize(mDimension);
        //this.setBorder(BorderFactory.createLineBorder(Color.black));
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
        //Add the panels as tabs
        mTabbedPane.addTab("Monday", mMonday);
        mTabbedPane.addTab("Tuesday", mTuesday);
        mTabbedPane.addTab("Wednesday", mWednesday);
        mTabbedPane.addTab("Thursday", mThursday);
        mTabbedPane.addTab("Friday", mFriday);
        this.add(mTabbedPane);
    }

}
