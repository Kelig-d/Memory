import javax.swing.*;
import java.awt.*;

public class ConfigurationFrame extends JFrame {
    private JLabel firstPlayerLabel,secondPlayerLabel, themeLabel, sizeLabel;
    private JTextField firstPlayerField, secondPlayerField;
    String[] themes = {"Cartes à jouer" , "Spiderman" , "owo" ,"Dial"};
    String[] sizes = {"4x4","3x3","5x5","6x6"};
    private JComboBox <String> themeCombo, sizeCombo;
    private JButton playButton;

    public ConfigurationFrame(){
        this.setTitle("Paramètres");
        this.setMinimumSize(new Dimension(250,240));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.Construct();
        this.setVisible(true);
    }

    private void Construct(){
        this.firstPlayerLabel = new JLabel("Joueur 1 :");
        this.firstPlayerLabel.setLocation(10,10);
        this.firstPlayerLabel.setSize(60,20);
        this.add(this.firstPlayerLabel);

        this.secondPlayerLabel = new JLabel("Joueur 2 :");
        this.secondPlayerLabel.setLocation(10,50);
        this.secondPlayerLabel.setSize(60,20);
        this.add(this.secondPlayerLabel);

        this.firstPlayerField = new JTextField();
        this.firstPlayerField.setLocation(80, 10);
        this.firstPlayerField.setSize(60,20);
        this.add(this.firstPlayerField);

        this.secondPlayerField = new JTextField();
        this.secondPlayerField.setLocation(80, 50);
        this.secondPlayerField.setSize(60,20);
        this.add(this.secondPlayerField);

        this.themeLabel = new JLabel("Thème :");
        this.themeLabel.setLocation(10,90);
        this.themeLabel.setSize(60,20);
        this.add(this.themeLabel);

        this.themeCombo = new JComboBox<String>(themes);
        this.themeCombo.setLocation(70, 90);
        this.themeCombo.setSize(150,20);
        this.add(this.themeCombo);

        this.sizeLabel = new JLabel("Taille :");
        this.sizeLabel.setLocation(10,130);
        this.sizeLabel.setSize(60,20);
        this.add(this.sizeLabel);

        this.sizeCombo = new JComboBox<String>(sizes);
        this.sizeCombo.setLocation(70, 130);
        this.sizeCombo.setSize(80,20);
        this.add(this.sizeCombo);

        this.playButton = new JButton("Jouer");
        this.playButton.setSize(110,20);
        this.playButton.setLocation(60,170);
        this.add(this.playButton);
    }

}
