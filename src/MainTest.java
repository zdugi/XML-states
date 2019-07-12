import gui.mainWindows.ComponentsWindow;
import model.Data;

public class MainTest {
	public static Data data = new Data();
	
	public static void main(String[] args) {
		
		
		ComponentsWindow cw = new ComponentsWindow(data);
		cw.setVisible(true);
	}

}
