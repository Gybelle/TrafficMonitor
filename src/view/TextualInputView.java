package view;

import javax.swing.*;
import java.awt.*;

/**
 * A view to represent a label and textfield. (Ex. "From [....]")
 * @author Michelle Gybels and Anaïs Ools
 */
public class TextualInputView extends JPanel {
    private JLabel mLabel;
    private JTextField mField;

    public TextualInputView(String label){
        init(label, "");
        setPreferences();
        createUI();
    }

    public TextualInputView(String label, String field){
        init(label, field);
        setPreferences();
        createUI();
    }

    /**
     * Initialise the components.
     * @param label Text to show as label.
     * @param field Text to show in textfield. (Not empty if  locations are hard coded)
     */
    private void init(String label, String field){
        //create label
        mLabel = new JLabel(label);

        //create textfield
        mField = new JTextField(field);
        mField.setPreferredSize(new Dimension(300,30));
        mField.setMargin(new Insets(0,7,0,0));
        mField.setBackground(Color.white);
        mField.setEditable(false);
    }

    /**
     * Set the background or size.
     */
    private void setPreferences(){

    }

    /**
     * Create the layout and add components.
     */
    private void createUI(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc =new GridBagConstraints();

        //add label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 5, 10);  // top left bottom right
        this.add(mLabel, gbc);

        //add textfield
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 10, 15, 35);  // top left bottom right
        this.add(mField, gbc);
    }

    /**
     * Get the field.
     * @return the textfield within this panel.
     */
    public JTextField getTextField(){
        return mField;
    }

    /**
     * Set a new field as text field.
     * @param textfield the new text field.
     */
    public void setTextField(JTextField textfield){
        mField = textfield;
    }







}
