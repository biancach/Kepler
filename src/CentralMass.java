import java.awt.Color;
import java.awt.Graphics;


public class CentralMass {
	
	Color color = Color.YELLOW;
	double mass;
	double xPosition;
	double yPosition;
	static final int SUN_RADIUS = 30, WINDOW_HEIGHT = 702, WINDOW_WIDTH = 936;
	
	public CentralMass(double mass) {
		this.mass = mass;
		xPosition = WINDOW_WIDTH/2;
		yPosition = WINDOW_HEIGHT/2;
                
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval((int) (xPosition - SUN_RADIUS), (int) (yPosition - SUN_RADIUS), 
				2*SUN_RADIUS, 2*SUN_RADIUS);
	}
	
}