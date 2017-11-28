package JUnitTest;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Test;

import classModel.ClassList;
import classModel.ExamCriteria;
import classModel.Student;
import classModel.Subject;

public class TestCalculateGrade {

	@Test
	public void testCheckDataForCalGrade() {
		JOptionPane.showMessageDialog(null, "Test check data for calculate grade");
		ExamCriteria ex = new ExamCriteria("CS284", 2);
		ex.addRate("midterm", 100, 50);
		ex.addRate("final", 100, 50);
		Subject sj = new Subject("CS284", "");
		sj.setList(new ClassList("CS284", 1));
		sj.getList().addStudent("Nancy", "123");
		sj.getList().getStudentAt(0).addSubject("CS284");
		sj.getList().getStudentAt(0).addScore("CS284", "midterm", 80, false, "");
		sj.getList().getStudentAt(0).addScore("CS284", "final", 75, false, "");
		sj.setExt(ex);
		
		assertTrue("ExamCriteria = null", sj.getExt() != null);
		assertTrue("ClassList = null", sj.getList() != null);
		assertTrue("Get score fail", sj.getList().getStudentAt(0).getScore("CS284", "midterm") != 0);
		assertTrue("Get score fail", sj.getList().getStudentAt(0).getScore("CS284", "final") != 0);
		
		ex = null;
		sj = null;
	}
	
	@Test
	public void testAllStudentHaveGrade() {
		JOptionPane.showMessageDialog(null, "Test all students have grade after calculate");
		Subject sj = new Subject("CS284","");
		ExamCriteria ex = new ExamCriteria("CS284", 3);
		ex.addRate("final", 100, 100);
		sj.setExt(ex);
		sj.setList(new ClassList("CS284", 3));
		sj.getList().addStudent("Nancy", "1");
		sj.getList().addStudent("John", "2");
		sj.getList().addStudent("Mark", "3");
		sj.getList().getStudentAt(0).addSubject("CS284");
		sj.getList().getStudentAt(1).addSubject("CS284");
		sj.getList().getStudentAt(2).addSubject("CS284");
		sj.getList().getStudentAt(0).addScore("CS284","final", 40,sj.calculateNetScore("40", 0) , false, "");
		sj.getList().getStudentAt(1).addScore("CS284","final", 80,sj.calculateNetScore("80", 0) , false, "");
		sj.getList().getStudentAt(2).addScore("CS284","final", 60,sj.calculateNetScore("60", 0) , false, "");
		String g = "";
		for(int i = 0 ; i < sj.getList().size() ; i++){
			g = sj.checkGrade(sj.sumScoreOfStudent(sj.getList().getStudentAt(i)));
			if(g.equals("A"));
			else if(g.equals("B+"));
			else if(g.equals("B"));
			else if(g.equals("C+"));
			else if(g.equals("C"));
			else if(g.equals("D+"));
			else if(g.equals("D"));
			else if(g.equals("F"));
			else fail("no have grade");
		}
		
		sj = null;
		ex = null;
	}
	
	@Test
	public void testFormatOfGrade() {
		JOptionPane.showMessageDialog(null, "Check format of grade");
		Subject sj = new Subject("CS284", "");
		String g = "";
		for(int i = 0 ; i <= 100 ; i+=5){
			g = sj.checkGrade((double) i);
			if(g.equals("A"));
			else if(g.equals("B+"));
			else if(g.equals("B"));
			else if(g.equals("C+"));
			else if(g.equals("C"));
			else if(g.equals("D+"));
			else if(g.equals("D"));
			else if(g.equals("F"));
			else fail("wrong format of grade");
		}
		sj = null;
	}
	
	@Test
	public void testCheckScoreForCalGrade() {
		JOptionPane.showMessageDialog(null, "Check all net score for calculate grade not over 100");
		Student st = new Student("Nancy", "1234");
		Student st2 = new Student("John", "5678");
		Subject sj = new Subject("CS284","");
		ExamCriteria ex = new ExamCriteria("CS284", 2);
		ex.addRate("midterm", 100, 40);
		ex.addRate("final", 100, 60);
		sj.setExt(ex);
		st.addSubject(sj.getName());
		st.addScore("CS284", "midterm", 100, sj.calculateNetScore("100",0), false, "");
		st.addScore("CS284", "final", 100, sj.calculateNetScore("100",1), false, "");
		assertTrue("net score over 100", sj.sumScoreOfStudent(st) <= 100);
		
		st2.addSubject(sj.getName());
		st2.addScore("CS284", "midterm", 140, sj.calculateNetScore("140",0), false, "");
		st2.addScore("CS284", "final", 130, sj.calculateNetScore("130",1), false, "");
		assertTrue("net score over 100", sj.checkGrade(sj.sumScoreOfStudent(st2)) == null);
		st = null;
		st2 = null;
		sj = null;
		ex = null;
	}

}
