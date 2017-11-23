package JUnitTest;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Test;

import classModel.ClassList;
import classModel.ExamCriteria;
import classModel.Subject;

public class TeatCalculateNetScore {

	@Test
	public void testCheckHaveScore() {
		JOptionPane.showMessageDialog(null, "Test have score in system");
		Subject st = new Subject("CS284", "-");
		st.setList(new ClassList("CS284", 1));
		st.getList().addStudent("Nancy", "1234");
		st.getList().getStudentAt(0).addSubject("CS284");
		st.getList().getStudentAt(0).addScore("CS284", "final", 20, false, "-");

		assertTrue("", st.getList().getStudentAt(0).getScoreAt(0) == 20);
	}

	@Test
	public void testCalNetScore() {
		JOptionPane.showMessageDialog(null, "Test calculate netscore >= 0 & correct");
		Subject st = new Subject("CS284", "-");
		ExamCriteria ex = new ExamCriteria("CS284", 1);
		ex.addRate("final", 50, 20);
		st.setList(new ClassList("CS284", 1));
		st.getList().addStudent("Nancy", "1234");
		st.getList().getStudentAt(0).addSubject("CS284");
		st.getList().getStudentAt(0).addScore("CS284", "final", 50, false, "-");
		st.setExt(ex);
		assertTrue("", st.calculateNetScore("" + st.getList().getStudentAt(0).getScoreAt(0), 0) > 0);
		assertTrue("", st.calculateNetScore("" + st.getList().getStudentAt(0).getScoreAt(0), 0) == 20);
		st = null;
		ex = null;
	}

	@Test
	public void testCheckNetscoreOverRate() {
		JOptionPane.showMessageDialog(null, "Test check netscore not over rate");
		Subject st = new Subject("CS284", "-");
		ExamCriteria ex = new ExamCriteria("CS284", 1);
		ex.addRate("final", 50, 20);
		st.setList(new ClassList("CS284", 1));
		st.getList().addStudent("Nancy", "1234");
		st.getList().getStudentAt(0).addSubject("CS284");
		st.getList().getStudentAt(0).addScore("CS284", "final", 50, false, "-");
		st.setExt(ex);
		System.out.println("net score = " + st.calculateNetScore("" + st.getList().getStudentAt(0).getScoreAt(0), 0));
		assertTrue("", st.calculateNetScore("" + st.getList().getStudentAt(0).getScoreAt(0), 0) <= ex.getRateAt(0));
		ex = null;
		st = null;
	}

	@Test
	public void testCheckHaveRate() {
		JOptionPane.showMessageDialog(null, "Test have ratio before calculagte");
		ExamCriteria ex = new ExamCriteria("CS284", 2);
		ex.addRate("midterm", 100, 40);
		ex.addRate("final", 100, 60);

		assertTrue("", ex.getRateAt(0) != 0);
		assertTrue("", ex.getRateAt(1) != 0);
		ex = null;
	}

	@Test
	public void testStudentMisstest() {
		JOptionPane.showMessageDialog(null, "Test make sure student miss test");
		ClassList cl = new ClassList("CS284", 1);
		cl.addStudent("Nancy", "1234");
		cl.getStudentAt(0).addSubject("CS284");
		cl.getStudentAt(0).addScore("CS284", "final", 0, true, "miss test");
		assertTrue("", cl.getStudentAt(0).getMyScore().get(0).isMissTest() == true);
	}

}
