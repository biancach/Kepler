
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class KeplerController implements ActionListener {

    private KeplerView view;
    private KeplerModel model;
    private Timer timer = new Timer(30, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.updatePlanets(model.planets);
        }
    });

    public KeplerController(KeplerView view, KeplerModel model) {
        this.view = view;
        this.model = model;
        model.addPlanet(new Planet(Color.RED, 50, 10, 200, 190, 1));
//		model.addPlanet(new Planet(Color.ORANGE, 50, 10, 95, 93));

    }

    public void start() {
        timer.start();
        model.start();
        view.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String command = evt.getActionCommand();
        if (command.equals("Law 1")) {
            model.enableLaw1();
        } else if (command.equals("Law 2")) {
            model.enableLaw2();
        } else if (command.equals("Law 3")) {
            model.enableLaw3();
        } 
        view.requestFocus();
    }

}
