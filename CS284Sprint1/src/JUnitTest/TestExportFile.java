package JUnitTest;

import static org.junit.Assert.*;

import java.io.File;

import javax.swing.JOptionPane;

import org.junit.Test;

import classModel.ClassList;
import classModel.ExamCriteria;
import classModel.Subject;

public class TestExportFile {

//	@Test
//	public void testHaveIDandGrade() {
//		JOptionPane.showMessageDialog(null, "File must have ID & Grade");
//		fail("Not yet implemented"); // TODO
//	}
	
	@Test
	public void testExportToXLSX() {
		JOptionPane.showMessageDialog(null, "Test export file to XLSX");
		Subject sj = new Subject("CS284","");
		ExamCriteria ex = new ExamCriteria("CS284", 1);
		ex.addRate("final", 100, 100);
		sj.setExt(ex);
		sj.setList(new ClassList("CS284", 3));
		sj.getList().addStudent("Nancy", "123");
		sj.getList().addStudent("John", "456");
		sj.getList().addStudent("Mark", "789");
		sj.getList().getStudentAt(0).addSubject("CS284");
		sj.getList().getStudentAt(1).addSubject("CS284");
		sj.getList().getStudentAt(2).addSubject("CS284");
		sj.getList().getStudentAt(0).addScore("CS284","final", 40,sj.calculateNetScore("40", 0) , false, "");
		sj.getList().getStudentAt(1).addScore("CS284","final", 81,sj.calculateNetScore("81", 0) , false, "");
		sj.getList().getStudentAt(2).addScore("CS284","final", 60,sj.calculateNetScore("60", 0) , false, "");
		
		assertTrue("can not export file to XLSX", sj.exportFile(new File("GRADE.xlsx")));
		
		sj = null;
		ex = null;
	
	}
	
	@Test
	public void testCannotExportNoGrade() {
		JOptionPane.showMessageDialog(null, "Test can not export file if some student no grade");
		
		Subject sj = new Subject("CS284","");
		ExamCriteria ex = new ExamCriteria("CS284", 3);
		ex.addRate("final", 100, 100);
		sj.setExt(ex);
		sj.setList(new ClassList("CS284", 3));
		sj.getList().addStudent("Nancy", "123");
		sj.getList().addStudent("John", "456");
		sj.getList().addStudent("Mark", "789");
		
		assertTrue("can not export file to XLSX", sj.exportFile(new File("GRADE.xlsx")) == false);
	}

}
