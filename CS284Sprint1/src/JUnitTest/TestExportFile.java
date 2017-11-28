package JUnitTest;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import javax.swing.JOptionPane;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import classModel.ClassList;
import classModel.ExamCriteria;
import classModel.Subject;

public class TestExportFile {

	@Test
	public void testHaveIDandGrade() {
		JOptionPane.showMessageDialog(null, "File must have ID & Grade");

		Subject sj = new Subject("CS284", "");
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
		sj.getList().getStudentAt(0).addScore("CS284", "final", 40, sj.calculateNetScore("40", 0), false, "");
		sj.getList().getStudentAt(1).addScore("CS284", "final", 81, sj.calculateNetScore("81", 0), false, "");
		sj.getList().getStudentAt(2).addScore("CS284", "final", 60, sj.calculateNetScore("60", 0), false, "");
		sj.exportFile(new File("FormatGrade"));
		
		try (XSSFWorkbook wk = new XSSFWorkbook(new FileInputStream(new File("FormatGrade.xlsx")))) {
			
			XSSFSheet sh = wk.getSheetAt(0);
			XSSFRow row = sh.getRow(0);
			String id = "";
			String grade = "";
			id =  row.getCell(0).getStringCellValue() + "\n";
			grade = row.getCell(1).getStringCellValue() + "\n";
	
			assertTrue("wrong format",sj.getList().getStudentAt(0).getId().equals(id.trim()));
			assertTrue("wrong format",sj.checkGrade(sj.sumScoreOfStudent(sj.getList().getStudentAt(0))).equals(grade.trim()));
		
		} catch (Exception e) {
			fail();
		}
		
		
	}

	@Test
	public void testExportToXLSX() {
		JOptionPane.showMessageDialog(null, "Test export file to XLSX");
		Subject sj = new Subject("CS284", "");
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
		sj.getList().getStudentAt(0).addScore("CS284", "final", 40, sj.calculateNetScore("40", 0), false, "");
		sj.getList().getStudentAt(1).addScore("CS284", "final", 81, sj.calculateNetScore("81", 0), false, "");
		sj.getList().getStudentAt(2).addScore("CS284", "final", 60, sj.calculateNetScore("60", 0), false, "");

		assertTrue("can not export file to XLSX", sj.exportFile(new File("GRADE")));

		sj = null;
		ex = null;

	}

	@Test
	public void testCannotExportNoGrade() {
		JOptionPane.showMessageDialog(null, "Test can not export file if some student no have grade");
//		for(int i = 0 ; i < list.size() ; i++){
//			if(list.getStudentAt(i).getMyScore().size() != ext.getNumOfScore()){
//				return false;
//			}
//		}
		Subject sj = new Subject("CS284", "");
		ExamCriteria ex = new ExamCriteria("CS284", 3);
		ex.addRate("final", 100, 100);
		sj.setExt(ex);
		sj.setList(new ClassList("CS284", 3));
		sj.getList().addStudent("Nancy", "123");
		sj.getList().addStudent("John", "456");
		sj.getList().addStudent("Mark", "789");

		assertTrue("can not export file to XLSX", sj.exportFile(new File("GRADE")) == false);
	}

}
