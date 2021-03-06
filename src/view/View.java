package view;

import javax.swing.*;
import java.awt.*;

/**
 * A view to represent the content of the application.
 * @author Michelle Gybels and Anaïs Ools
 */

public class View extends JPanel {
    private InputView mInputView;
    private OutputView mOutputView;
    private Image mBackground;

    public View(Dimension sizeInputPanel, Dimension sizeOutputPanel){
        init(sizeInputPanel, sizeOutputPanel);
        setPreferences();
        createUI();
    }

    /**
     * Initialise the components.
     */
    private void init(Dimension sizeInputPanel, Dimension sizeOutputPanel){
        mInputView = new InputView(sizeInputPanel);
        mOutputView = new OutputView(sizeOutputPanel);
    }

    /**
     * Set the background.
     */
    private void setPreferences(){
        this.setBackground(Color.white);
        java.net.URL url = ClassLoader.getSystemResource("Background4.png");
        ImageIcon image = new ImageIcon(url);
        mBackground = image.getImage();

        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    /**
     * Assign the needed panels within this main panel.
     */
    private void createUI(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // input panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        this.add(mInputView, gbc);

        // output panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        this.add(mOutputView, gbc);
    }


    /**
     * Paint the background.
     *
     * @param g the graphics used to paint.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(mBackground, 0, 0, getWidth(), getHeight(), null);
    }

}
