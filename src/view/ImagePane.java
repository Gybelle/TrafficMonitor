package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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


    public ImagePane(int dayID, String partOfDay,int start, int end){
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
        this.setBackground(Color.white);
        this.setPreferredSize(new Dimension(400,800));

    }

    /**
     * Create the layout and add components.
     */
    private void createUI(){
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(mLabel);
        this.add(Box.createRigidArea(new Dimension(0,5)));

        //testing:
        JLabel mImage = new JLabel(new ImageIcon("images/output.gif"));
        this.add(mImage);
    }

    /**
     * Update image for newly set hours.
     */
    public void setImagePane(String partOfDay,int start, int end){
        mPartOfDay = partOfDay;
        mHourStart = start;
        mHourEnd = end;
        String custom = "";
        String tab = "         ";
        if(partOfDay.equals("Custom")){
            custom = tab + tab + "(Select value from slider below)";
        }
        mLabel.setText(mPartOfDay + ": "
                + mHourStart + "h00" + " - "
                + mHourEnd + "h00" + custom);
    }


}
