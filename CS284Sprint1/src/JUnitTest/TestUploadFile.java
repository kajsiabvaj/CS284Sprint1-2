package JUnitTest;

import static org.junit.Assert.*;

import java.io.File;

import javax.swing.JOptionPane;

import org.junit.Test;

import classModel.ClassList;
import classModel.ExamCriteria;
import classModel.Subject;

public class TestUploadFile {

	@Test
	public void testUploadFile() {
		JOptionPane.showMessageDialog(null, "Test upload file and add student to classlist");
		Subject sj = new Subject("CS284", "");
		sj.importFile(new File("classlist-cs284-160.xlsx"));
		ClassList cl = sj.getList();
		String name1 = "†π“¬∞‘µ‘°√ °¡≈æ√√≥æ√";
		String name2 = "†π“¬≥—∞æß…Ï  «— ¥‘Ï√—°…“";
		assertTrue("can not get data from read file", cl.getStudentAt(0).getId().trim().equals("5909610031"));
		assertTrue("can not get data from read file", cl.getStudentAt(0).getName().trim().equals(name1.trim()));
		assertTrue("can not get data from read file", cl.getStudentAt(36).getId().trim().equals("5909680125"));
		assertTrue("can not get data from read file", cl.getStudentAt(36).getName().trim().equals(name2.trim()));
		cl = null;
		sj = null;
	}
	
	@Test
	public void testFileExists() {
		JOptionPane.showMessageDialog(null, "Test upload file to system");
		Subject sj = new Subject("CS284", "");
		assertTrue("can not upload file", sj.importFile(new File("classlist-cs284-160.xlsx")));
		assertTrue("can upload file from not exists file", sj.importFile(new File("xxxxx.xlsx")) == false);
		sj = null;
	}
	
	@Test
	public void testWriteTextFile() {
		JOptionPane.showMessageDialog(null, "Test write text file");
		Subject sj = new Subject("CS284", "");
		ExamCriteria ext = new ExamCriteria("CS284",3);
		ext.addRate("Q1", 10, 10);
		ext.addRate("Q2", 10, 10);
		ext.addRate("Q3", 10, 10);
		sj.setExt(ext);
		sj.importFile(new File("classlist-cs284-160.xlsx"));
		assertTrue("can not write text file", sj.writeFile(true));
		sj = null;
		ext = null;
	}
	
	@Test
	public void testNullFile() {
		JOptionPane.showMessageDialog(null, "Test null file");
		Subject sj = new Subject("CS284", "");
		assertTrue("can import null file", sj.unNullFile(new File("null.xlsx")) == false);
		sj = null;
	}
	
	@Test
	public void testFormat() {
		JOptionPane.showMessageDialog(null, "Test wrong format");
		Subject sj = new Subject("CS284", "");
		assertTrue("can import null file", sj.importFile(new File("wrongformat.xlsx")) == false);
		sj = null;
	}
	
	@Test
	public void testNotXlsx() {
		JOptionPane.showMessageDialog(null, "Test not .xlsx file");
		Subject sj = new Subject("CS284", "");
		assertTrue("can import null file", sj.importFile(new File("noxlsx.docx")) == false);
		sj = null;
	}
}
