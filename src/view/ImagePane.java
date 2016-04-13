package view;

import javax.swing.*;
import java.awt.*;

/**
 * A view to represent the image with traffic information.
 * @author Michelle Gybels and Anaïs Ools
 */
public class ImagePane extends JPanel{
    private JLabel mLabel;
    private JLabel mImage;
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
        mImage = new JLabel();
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

        this.add(mImage);
        setImage();
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

        setImage();
    }

    /**
     * Set the corresponding gif within the image pane.
     */
    private void setImage(){
        String file = getFolder();
        switch(mPartOfDay){
            case "Morning rush-hour":
                file += "morning.gif";
                break;
            case "Evening rush-hour":
                file += "afternoon.gif";
                break;
            case "Custom":
                file += (mHourStart < 10 ? "0" + mHourStart : mHourStart ) + ".gif";
        }

        try{
            mImage.setText("");
            mImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource(file)));
        } catch (Exception e){
            mImage.setText("Image " + file + " not found.");
        }
    }


    /**
     * Get the location of the file based on day of week.
     * @return path to folder.
     */
    private String getFolder(){
        String folder = "";
        switch(mDayOfWeek){
            case 1:
                folder = "1_Mon/";
                break;
            case 2:
                folder = "2_Tue/";
                break;
            case 3:
                folder = "3_Wed/";
                break;
            case 4:
                folder = "4_Thu/";
                break;
            case 5:
                folder = "5_Fri/";
                break;
        }

        return folder;
    }

}
