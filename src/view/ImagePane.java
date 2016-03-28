package view;

import javax.swing.*;
import java.awt.*;

/**
 * A view to represent the image with traffic information.
 * @author Michelle Gybels and Anaïs Ools
 */
public class ImagePane extends JPanel{
    private JLabel mLabel;
    private int mDayOfWeek;
    private String mPartOfDay;
    private int mHourStart;
    private int mHourEnd;


    public ImagePane(int dayID,String partOfDay,int start, int end){
        mDayOfWeek = dayID;
        mPartOfDay = partOfDay;
        mHourStart = start;
        mHourEnd = end;

        init();
        setPreferences();
        createUI();
    }

    /**
     * Initialise the components.
     */
    private void init(){
        //create the label
        String labelText = mPartOfDay + ": "
                + mHourStart + "h00" + " - "
                + mHourEnd + "h00";
        mLabel = new JLabel(labelText);
    }

    /**
     * Set the background.
     */
    private void setPreferences(){
        this.setPreferredSize(new Dimension(300,300));

    }

    /**
     * Create the layout and add components.
     */
    private void createUI(){
        /*
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //label
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(mLabel);

        //image
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(new JButton("Placeholder Image"));
        */

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(mLabel);
        this.add(Box.createRigidArea(new Dimension(0,5)));
        this.add(new JButton("Placeholder Image"));
    }

}
