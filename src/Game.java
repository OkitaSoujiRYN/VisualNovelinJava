import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game extends JFrame {

    private static final long serialVersionUID = 1L;
    private Image backgroundImage = Toolkit.getDefaultToolkit().getImage("SAKURA FIELD.pngg");
    private Image character1Image = Toolkit.getDefaultToolkit().getImage("Bronya PNG.png");
    private Image character2Image = Toolkit.getDefaultToolkit().getImage("character2.png");
    private JPanel characterPanel = new JPanel();
    private JTextArea textArea = new JTextArea();
    private int currentScene = 1;

    public Game() {
        super("Visual Novel");

        setPreferredSize(new Dimension(800, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Ajouter un panneau pour les personnages
        characterPanel.setPreferredSize(new Dimension(800, 500));
        characterPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Ajouter un panneau pour le texte
        textArea.setPreferredSize(new Dimension(600, 200));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));

        // Ajouter un MouseListener pour détecter les clics de souris sur la fenêtre
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                nextScene();
            }
        });

        // Ajouter les composants à la fenêtre
        add(characterPanel, BorderLayout.WEST);
        add(textArea, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    private void nextScene() {
        // Code pour passer à la scène suivante
        currentScene++;

        // Mise à jour de l'interface en fonction de la scène actuelle
        switch (currentScene) {
            case 2:
                textArea.setText("J'ai toujours rêvé de voler de mes propres ailes");
                break;
            case 3:
                textArea.setText("BRONYA IKIMASU !");
                break;
            // Ajouter d'autres cas pour chaque scène suivante
            default:
                // Si toutes les scènes sont terminées, fermer la fenêtre
                dispose();
                break;
        }

        // Redessiner les images des personnages
        characterPanel.repaint();
    }

    public void paint(Graphics g) {
        // Dessiner le fond d'écran
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        // Dessiner les images des personnages en fonction de la scène actuelle
        switch (currentScene) {
            case 1:
                g.drawImage(character1Image, 50, 200, 100, 150, this);
                break;
            case 2:
                g.drawImage(character1Image, 50, 100, 500, 200, this);
                g.drawImage(character2Image, 650, 350, 100, 150, this);
                break;
        }
    }
    public static void main(String[] args) {
        Game visualNovel = new Game();
        visualNovel.nextScene();
    }
}