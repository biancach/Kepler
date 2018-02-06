
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;

public class KeplerModel {

    Timer timer;
    double time;
    ArrayList<Planet> planets;
    double satelliteMass;
    double centerMass;

    public KeplerModel() {
        planets = new ArrayList<Planet>();
        timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSatellitePosition();
                time += 0.01;
            }
        });
    }

    public void start() {
        if (timer != null) {
            timer.start();
        }
    }

    public void addPlanet(Planet p) {
        planets.add(p);
    }

    private void updateSatellitePosition() {
        for (Planet p : planets) {
            p.updatePosition(time);
        }
    }

    public void enableLaw1() {
        if (planets.size() == 2) {
            planets.remove(1); 
        }
        for (Planet p : planets) {
            p.setLaw1(true);
            p.setLaw2(false);
            p.setLaw3(false);
        }
    }

    public void enableLaw2() {
        if (planets.size() == 2) {
            planets.remove(1); 
        }
        for (Planet p : planets) {
            p.setLaw2(true);
            p.setLaw1(false);
            p.setLaw3(false);
        }
    }

    public void enableLaw3() {
        if (planets.size() < 2) {
            planets.add(new Planet(Color.GREEN, 50, 15, 270, 250, 1/(Math.sqrt(1.35))));
        }
        for (Planet p : planets) {
            p.setLaw3(true);
            p.setLaw2(false);
            p.setLaw1(false);
        }
    }

}
