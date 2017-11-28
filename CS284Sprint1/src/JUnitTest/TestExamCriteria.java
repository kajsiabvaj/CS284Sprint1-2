package JUnitTest;
import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Test;

import classModel.ExamCriteria;


public class TestExamCriteria {

	@Test
	public void testAddRate() {
		JOptionPane.showMessageDialog(null, "Test add ratio");
		ExamCriteria ex = new ExamCriteria("cs284",2);
		assertTrue("can't add rate", ex.addRate("MidTerm",100,50)); 
		assertTrue("can set ratio under zero", ex.addRate("Final",-50,50) == false);
		ex = null;
	}
	
	@Test
	public void testSetDataByChar(){
		JOptionPane.showMessageDialog(null, "Test add score by specail char");
		ExamCriteria ex = new ExamCriteria("cs284",3);
		String str1 = "20%";
		try{
			double rate1 = Double.parseDouble(str1);

			assertTrue("can add rate by char", ex.addRate("MidTerm",100,rate1)==false);
		}catch (NumberFormatException e) {
			assertTrue(true);
		}
		ex = null;
	}
	
	@Test
	public void testGetData() {
		JOptionPane.showMessageDialog(null, "Test get data");
		ExamCriteria ex = new ExamCriteria("cs284",2);
		ex.addRate("Mid", 100,50);
		ex.addRate("Final",200, 50);
		assertTrue("get Type wrong", ex.getTypeAt(0).equals("Mid")); 
		assertTrue("get Type wrong", ex.getTypeAt(1).equals("Final"));
		assertTrue("get Rate wrong", ex.getRateAt(0) == 50);
		assertTrue("get Rate wrong", ex.getRateAt(1) == 50);
		assertTrue("get Max wrong", ex.getMaxAt(0) == 100);
		assertTrue("get Max wrong", ex.getMaxAt(1) == 200);
		ex = null;
	}
	
	@Test
	public void testSetDataAgain() {
		JOptionPane.showMessageDialog(null, "Test add replace ratio");
		ExamCriteria ex = new ExamCriteria("cs284",1);
		ex.addRate("MidTerm", 50, 50);
		assertTrue("can't edit old rate", ex.setRate("Final", 100, 100,0));
		assertTrue("get Type wrong", ex.getTypeAt(0).equals("Final"));
		assertTrue("get Rate wrong", ex.getRateAt(0) == 100);
		assertTrue("get Max wrong", ex.getMaxAt(0) == 100);
		ex = null;
	}
	
	@Test
	public void testCheckMidAndFinal() {
		JOptionPane.showMessageDialog(null, "Test check mid , final > 50%");
		ExamCriteria ex = new ExamCriteria("cs284",2);
		ex.addRate("MidTerm", 100, 10);
		ex.addRate("Final", 100, 10);
		
		assertTrue("can add Midterm + Final must < 50", ex.CheckMidAndFinal() == false);

		ExamCriteria ex2 = new ExamCriteria("cs284",3);
		ex2.addRate("Test", 100, 20);
		ex2.addRate("MidTerm", 100, 40);
		ex2.addRate("Final", 100, 40);

		assertTrue("Midterm + Final > 50 but false", ex2.CheckMidAndFinal());

		ex = null;
		ex2 = null;
	}
	
	@Test
	public void testFullRatio() {
		JOptionPane.showMessageDialog(null, "Test check sum of all ratio = 100%");
		ExamCriteria ex = new ExamCriteria("cs284",2);
		ex.addRate("MidTerm", 100, 10);
		ex.addRate("Final", 100, 10);
		assertTrue("Rate is not Full but can add", ex.isFullRate()==false);
		ExamCriteria ex2 = new ExamCriteria("cs284",3);
		ex2.addRate("Test", 100, 20);
		ex2.addRate("MidTerm", 100, 40);
		ex2.addRate("Final", 100, 40);
		assertTrue("Ratio be full but cant add", ex2.isFullRate());

		ex = null;
		ex2 = null;
	}

}
