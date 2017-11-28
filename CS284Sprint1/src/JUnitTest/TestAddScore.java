package JUnitTest;
import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Test;

import classModel.Student;

public class TestAddScore {

	@Test
	public void testSetScore() {
		JOptionPane.showMessageDialog(null, "Test add score");
		Student st = new Student("Nancy", "123");
		st.addSubject("cs284");
		assertTrue("can set score but miss test", st.addScore("cs284", "final",20, true, "miss test")==false); // miss test can't set score and return false 
		
		st.addSubject("cs211");
		
		assertTrue("can't set score", st.addScore("cs211", "mid",20, false, "not miss test"));
		assertTrue("can set score under zero", st.addScore("cs211", "final",-20, false, "not miss test") == false);
		assertTrue("can add score but not add Subject", st.addScore("xxx", "test",20, false, "") == false); //ยังไม่ได้ addSubject จะรีเทร์น false
		st = null;
	}
	
	@Test
	public void testGetScore(){
		JOptionPane.showMessageDialog(null, "Test get score from add score");
		Student st = new Student("Nancy", "123");
		st.addSubject("cs284");
		st.addScore("cs284", "final",50, true, "miss test");
		assertTrue("can get score > 0 but miss test", st.getScoreAt(0) == 0);//miss test return score = -1
		
		st.addSubject("cs211");
		st.addScore("cs211", "midterm",50, false, "not miss test");
		assertTrue("wrong get score", st.getScoreAt(1)==50);
		
		st = null;
	}
	

	@Test
	public void testSetScoreAgain() {
		JOptionPane.showMessageDialog(null, "Test add replace score");
		Student st = new Student("Nancy", "123");
		st.addSubject("cs284");
		st.addScore("cs284", "final",50, false, "not miss test");
		assertTrue("can't set score again", st.setScoreAt(0, 80));
		assertTrue("get score from set score again wrong", st.getScoreAt(0) == 80);
		
		st = null;
	}

}
