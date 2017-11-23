package JUnitTest;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Test;

public class TestCalculateGrade {

	@Test
	public void testCheckDataForCalGrade() {
		JOptionPane.showMessageDialog(null, "Test check data for calculate grade");
		
	}
	
	@Test
	public void testAllStudentHaveGrade() {
		JOptionPane.showMessageDialog(null, "Test all students have grade after calculate");
		
	}
	
	@Test
	public void testFormatOfGrade() {
		JOptionPane.showMessageDialog(null, "Check format of grade");
		
	}
	
	@Test
	public void testCheckScoreForCalGrade() {
		JOptionPane.showMessageDialog(null, "Check net score for calculate grade not over 100");
		
	}

}
