import java.awt.Dimension;
import java.awt.Toolkit;


public class KeplerMain {
	
	public static void main(String[] args) {
		
		KeplerView view = new KeplerView();
		view.setSize(936, 702);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		view.setLocation( (screensize.width - view.getWidth())/2,
		    		  				(screensize.height - view.getHeight())/2 );
		view.setVisible(true);
		KeplerModel model = new KeplerModel();
		KeplerController controller = new KeplerController(view, model);
		controller.start();
		
	}
	
}
