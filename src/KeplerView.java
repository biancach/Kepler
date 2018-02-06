
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeplerView extends JFrame {

    private JPanel mainPanel;
    private JButton law1, law2, law3;
    private AnimationPanel spacePanel;
    private ArrayList<Planet> planets = new ArrayList<Planet>();
    private CentralMass centralMass;

    public KeplerView() {
        super("Kepler's Planetary Laws Simulation");
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        this.setContentPane(mainPanel);
        this.setBackground(Color.BLACK);

        spacePanel = new AnimationPanel();
        mainPanel.add(spacePanel, BorderLayout.CENTER);
        updateCentralMass(new CentralMass(1.98 * Math.pow(10, 30)));
        
        JPanel buttonPanel = new JPanel(new GridLayout());
        buttonPanel.setBackground(Color.BLACK);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        law1 = new JButton("Law 1");
        law2 = new JButton("Law 2");
        law3 = new JButton("Law 3");
        
        buttonPanel.add(law1);
        buttonPanel.add(law2);
        buttonPanel.add(law3);

    }

    public void addActionListener(ActionListener listener) {
        law1.addActionListener(listener);
        law2.addActionListener(listener);
        law3.addActionListener(listener);
    }
    
    public void updatePlanets(ArrayList<Planet> planets) {
        this.planets = planets;
        spacePanel.repaint();
    }
   

    public void updateCentralMass(CentralMass centralMass) {
        this.centralMass = centralMass;
    }

    public class AnimationPanel extends JPanel {

        public AnimationPanel() {
            super();
            setBackground(Color.BLACK);
        }

        @Override
        public void paintComponent(Graphics g) {
            centralMass.draw(g);
            for (Planet p : planets) {
                p.draw(g);
            }
        }

    }

}
