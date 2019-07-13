import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import enums.TipStanja;
import gui.mainWindows.StateTransitonWindow;
import main.MainTest;
import model.State;

public class TestSelekcijeiBrisanja {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testStateTransitonWindow() {
		//fail("Not yet implemented");
		StateTransitonWindow stw = new StateTransitonWindow();
		stw.SelectState();
		assertTrue(stw.btnDelete.isEnabled());
		assertTrue(stw.btnEdit.isEnabled());
		
		stw.Delete();
		assertTrue(stw.states.getSelectedRow() == -1);
		
		stw.SelectTransiton();
		assertTrue(!stw.btnPostaviInit.isEnabled());
		
		stw.SelectState();
		assertTrue(stw.btnPostaviInit.isEnabled());
		
		stw.AddState();
		assertTrue(stw.states.getSelectedRow() != -1);
		
		
	}

}
