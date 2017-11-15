package JUnitTest;
import static org.junit.Assert.*;

import org.junit.Test;

import classModel.Student;

public class TestShowScoreFromStudent {

	@Test
	public void ShowScore() {
		Student st = new Student("Nancy Eiei" , "123");
		st.addSubject("cs284");
		st.addScore("cs284", "MidTerm", true, "Miss test!!");
		st.addScore("cs284", "Final", false, "");
		st.setScoreAt(0,50,100);
		st.setNetScoreAt(0,50/2,100/2); //other user story without sprint 1
		st.setScoreAt(1,100,100);
		st.setNetScoreAt(1,100/2,100/2); //other user story without sprint 1
		assertTrue("can set score but miss test", st.getScoreAt(0)==0);
		assertTrue("can set net score but miss test", st.getNetScoreAt(0)==0);
		assertTrue("can't get score", st.getScoreAt(1)==100);
		assertTrue("can't get net score", st.getNetScoreAt(1)==100/2);
	}

}
