package JUnitTest;
import static org.junit.Assert.*;

import org.junit.Test;

import classModel.ExamCriteria;
import classModel.Student;

public class TestAddScore {

	@Test
	public void testSetScore() {
		Student st = new Student("Nancy", "123");
		st.addSubject("cs284");
		st.addScore("cs284", "final", true, "miss test");
		assertTrue("can set score but miss test", st.setScoreAt(0, 20 ,30)==false); // miss test can't set score and return false 
		
		st.addSubject("cs211");
		st.addScore("cs211", "mid", false, "not miss test");
		assertTrue("can't set score", st.setScoreAt(1, 20 ,30));
		
		st.addScore("cs211", "final", false, "not miss test");
		assertTrue("can set score under zero", st.setScoreAt(2, -10 ,30) == false);
		
		
		assertTrue("can add score but not add Subject", st.addScore("xxx", "test", false, "") == false); //ยังไม่ได้ addSubject จะรีเทร์น false
		st = null;
	}
	
	@Test
	public void testGetScore(){
		Student st = new Student("Nancy", "123");
		st.addSubject("cs284");
		st.addScore("cs284", "final", true, "miss test");
		st.setScoreAt(0, 50 , 60);
		assertTrue("can get score > 0 but miss test", st.getScoreAt(0)==0);//miss test return score = 0
		
		st.addSubject("cs211");
		st.addScore("cs211", "midterm", false, "not miss test");
		st.setScoreAt(1, 50 , 60);
		assertTrue("wrong get score", st.getScoreAt(1)==50);
		
		st = null;
	}
	

	@Test
	public void testSetScoreAgain() {
		Student st = new Student("Nancy", "123");
		st.addSubject("cs284");
		st.addScore("cs284", "final", false, "not miss test");
		st.setScoreAt(0, 50 , 60);
		assertTrue("can't set score again", st.setScoreAt(0, 80 , 100));
		assertTrue("get score from set score again wrong", st.getScoreAt(0) == 80);
		
		st = null;
	}
	
	@Test
	public void testCheckNotOverMax() {
		ExamCriteria ex = new ExamCriteria("cs284",1);
		Student st = new Student("Nancy", "123");
		st.addSubject("cs284");
		ex.addRate("MidTerm",100,50);
		st.addScore("cs284", "Final", false, "");
		assertTrue("can set score over max", st.setScoreAt(0, 120 ,ex.getMaxAt(0))==false);
		assertTrue("can't set score over max", st.setScoreAt(0, 90 ,ex.getMaxAt(0)));
		
		ex = null;
		st = null;
	}

}
