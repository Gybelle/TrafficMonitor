package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A view to represent the input fields for the application.
 * @author Michelle Gybels and Anaïs Ools
 */

public class InputView extends JPanel {
    private Dimension mDimension;
    private TextualInputView mInputFrom;
    private TextualInputView mInputTo;
    private JButton mSwapButton;


    public InputView(Dimension inputSize){
        mDimension = inputSize;
        init();
        setPreferences();
        setActions();
        createUI();
    }

    /**
     * Initialise the components.
     */
    private void init(){
        mInputFrom = new TextualInputView("From: ", "Hasselt");
        mInputTo = new TextualInputView("To: ", "Brussel");
        mSwapButton = new JButton("Swap");
    }

    /**
     * Set the background.
     */
    private void setPreferences(){
        //this.setBackground(Color.blue);
        this.setPreferredSize(mDimension);
        this.setOpaque(false);
        //this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    /**
     * Create actions for buttons in this view.
     */
    private void setActions(){
        mSwapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String from = mInputFrom.getTextField().getText();
                String to = mInputTo.getTextField().getText();
                mInputFrom.getTextField().setText(to);
                mInputTo.getTextField().setText(from);
            }
        });
    }

    /**
     * Create the layout and add components.
     */
    private void createUI(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //add "from" field
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(mInputFrom);

        //add "to" field
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(mInputTo);
    }
}
