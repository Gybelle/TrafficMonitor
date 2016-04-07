package view;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

/**
 * A view to represent the days of the week within a tabbed pane.
 * @author Michelle Gybels and Anaïs Ools
 */

public class DayPane extends JPanel {
    private int mDayOfWeek; //[1 = Monday, ..., 5 = Friday]
    private Dimension mDimension;
    private ImagePane mActiveImage;
    private JButton mMorningButton;
    private JButton mAfternoonButton;
    private JButton mCustomButton;
    private JSlider mSlider;
    private int mSliderValue;

    public DayPane(int dayID, Dimension paneSize){
        mDayOfWeek = dayID;
        mDimension = paneSize;
        init();
        setPreferences();
        setActions();
        createUI();
    }

    /**
     * Initialise the components.
     */
    private void init(){
        mMorningButton = new JButton("Morning");
        mAfternoonButton = new JButton("Afternoon");
        mCustomButton = new JButton("Custom");
        mActiveImage = new ImagePane(mDayOfWeek, "Morning rush-hour", 6, 10);
        mSlider = new JSlider(JSlider.HORIZONTAL, 0, 23, 12);
    }

    /**
     * Set the background.
     */
    private void setPreferences(){
        this.setBackground(Color.white);
        this.setPreferredSize(mDimension);

        mMorningButton.setEnabled(false);
        mAfternoonButton.setEnabled(true);
        mCustomButton.setEnabled(true);

    }

    /**
     * Create actions for buttons and slider.
     */
    private void setActions(){
        mSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                mSliderValue = ((JSlider)changeEvent.getSource()).getValue();
                mActiveImage.setImagePane("Custom", mSliderValue, mSliderValue + 1);
            }
        });

        mMorningButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mMorningButton.setEnabled(false);
                mAfternoonButton.setEnabled(true);
                mCustomButton.setEnabled(true);
                mSlider.setVisible(false);
                mActiveImage.setImagePane("Morning rush-hour", 6, 10);
            }
        });

        mAfternoonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mMorningButton.setEnabled(true);
                mAfternoonButton.setEnabled(false);
                mCustomButton.setEnabled(true);
                mSlider.setVisible(false);
                mActiveImage.setImagePane("Evening rush-hour", 17, 20);
            }
        });

        mCustomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mMorningButton.setEnabled(true);
                mAfternoonButton.setEnabled(true);
                mCustomButton.setEnabled(false);
                mSlider.setVisible(true);
                mActiveImage.setImagePane("Custom", mSliderValue, mSliderValue+1);
            }
        });


    }

    /**
     * Create the layout and add components.
     */
    private void createUI(){
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));

        this.add(createButtonPanel());

        this.add(mActiveImage);
        mActiveImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(Box.createRigidArea(new Dimension(0,5)));

        mSlider.setAlignmentX(Component.CENTER_ALIGNMENT);
        setSliderLayout();
        this.add(mSlider);
    }

    /**
     * Add buttons to a panel and layout them.
     * @return the resulting panel.
     */
    private JPanel createButtonPanel(){
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        buttonPanel.add(mMorningButton);
        buttonPanel.add(mAfternoonButton);
        buttonPanel.add(mCustomButton);

        buttonPanel.setBackground(Color.white);

        return buttonPanel;
    }

    /**
     * Create layout for slider.
     */
    private void setSliderLayout(){
        Hashtable sliderLabels= new Hashtable();
        for(int i = 0; i < 24; i++){
            String label = "" + i + "h";
            sliderLabels.put(i, new JLabel(label));
        }

        mSlider.setLabelTable(sliderLabels);
        mSlider.setPaintLabels(true);

        mSlider.setVisible(false);
    }

}
