
import java.awt.Color;
import java.awt.Graphics;

public class Planet {

    final private Color color;
    final private double mass;
    final private int planetRadius;
    private double xPosition;
    private double yPosition;
    final private double xCentralMass;
    final private double yCentralMass;
    private double distanceFromCenterToPlanet1;
    private double distanceFromFocalPointToPlanet1;
    private double xDistanceFromFocalPointToPlanet1;
    private double yDistanceFromFocalPointToPlanet1;
    private double distanceFromFocalPointToPlanet2;
    private double xDistanceFromFocalPointToPlanet2;
    private double yDistanceFromFocalPointToPlanet2;
    final private double distanceFromCenterToFocalPoint;
    private double angleFromFocalPoint;
    final private double semiMajorAxis;
    final private double semiMinorAxis;
    final private double timeModifier;
    private boolean law1 = true;
    private boolean law2;
    private boolean law3;
    static final int WINDOW_HEIGHT = 702, WINDOW_WIDTH = 936;

    public Planet(Color color, double mass, int planetRadius,
            double semiMajorAxis, double semiMinorAxis, double timeModifier) {
        this.color = color;
        this.mass = mass;
        this.planetRadius = planetRadius;
        this.semiMajorAxis = semiMajorAxis;
        this.semiMinorAxis = semiMinorAxis;
        this.timeModifier = timeModifier;

        xCentralMass = WINDOW_WIDTH / 2;
        yCentralMass = WINDOW_HEIGHT / 2;
        xPosition = (WINDOW_WIDTH / 2) + semiMajorAxis;
        yPosition = (WINDOW_HEIGHT / 2);
        distanceFromCenterToFocalPoint = Math.sqrt(semiMajorAxis * semiMajorAxis
                - semiMinorAxis * semiMinorAxis);

    }

    public void draw(Graphics g) {
        //draw orbit
        g.setColor(Color.WHITE);
        g.drawOval((int) (xCentralMass + distanceFromCenterToFocalPoint - semiMajorAxis),
                (int) (yCentralMass - semiMinorAxis), (int) (semiMajorAxis * 2), (int) (semiMinorAxis * 2));

        if (law2) {
            g.setColor(new Color(190, 194, 247, 200));
            int[] xPoints = {(int) xCentralMass, (int) (xCentralMass + xDistanceFromFocalPointToPlanet1), 
                (int) (xCentralMass + xDistanceFromFocalPointToPlanet2)};
            int[] yPoints = {(int) yCentralMass, (int) (yCentralMass - yDistanceFromFocalPointToPlanet1),
                (int) (yCentralMass - yDistanceFromFocalPointToPlanet2)};
            g.fillPolygon(xPoints, yPoints, xPoints.length);
           

        } else if (law3) {
            
        }

        //draw planet
        g.setColor(color);
        g.fillOval((int) (xPosition - planetRadius), (int) (yPosition - planetRadius),
                2 * planetRadius, 2 * planetRadius);
    }

    public void updatePosition(double time) {
        
        distanceFromCenterToPlanet1 = Math.sqrt(Math.pow(semiMajorAxis * 
        		Math.cos(timeModifier * time + Math.sin(timeModifier * time)), 2)
                + Math.pow(semiMinorAxis * (Math.sin(timeModifier * time)), 2));
        
        xDistanceFromFocalPointToPlanet1 = distanceFromCenterToFocalPoint
                + semiMajorAxis * Math.cos(timeModifier * time);
        yDistanceFromFocalPointToPlanet1 = semiMinorAxis * (Math.sin(timeModifier * time));
        distanceFromFocalPointToPlanet1 = Math.sqrt(Math.pow(xDistanceFromFocalPointToPlanet1, 2) 
                + Math.pow(yDistanceFromFocalPointToPlanet1, 2));
        
        xDistanceFromFocalPointToPlanet2 = distanceFromCenterToFocalPoint
                + semiMajorAxis * Math.cos((timeModifier * time) + 
                		100*(1/(distanceFromFocalPointToPlanet1)) - 0.05);
        yDistanceFromFocalPointToPlanet2 = semiMinorAxis * (Math.sin((timeModifier * time) + 
        		100*(1/(distanceFromFocalPointToPlanet1)) - 0.05));
        distanceFromFocalPointToPlanet2 = Math.sqrt(Math.pow(xDistanceFromFocalPointToPlanet1, 2) //josh pirl
                + Math.pow(yDistanceFromFocalPointToPlanet1, 2));
        
        xPosition = (WINDOW_WIDTH / 2) + (semiMajorAxis * 
        		Math.cos((timeModifier * time) + 100*(1/(distanceFromFocalPointToPlanet1)))
                + Math.sqrt(Math.pow(semiMajorAxis, 2) - Math.pow(semiMinorAxis, 2)));
        yPosition = (WINDOW_HEIGHT / 2) - semiMinorAxis * 
        		(Math.sin((timeModifier * time) + 100*(1/distanceFromFocalPointToPlanet1)));
        
    }

    public void setLaw1(boolean law1) {
        this.law1 = law1;
    }
    
    public void setLaw2(boolean law2) {
        this.law2 = law2;
    }
    
    public void setLaw3(boolean law3) {
        this.law3 = law3;
    }
}
