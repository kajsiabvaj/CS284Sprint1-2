package classModel;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Subject {
	private String name;
	private String information;
	private ArrayList<Teacher> teacher;
	private ExamCriteria ext;
	private ClassList list;
	private double maxScore, minScore, avgScore, SD;
	private boolean upList;
	private int numOfAddScore;

	public Subject() {
		list = new ClassList();
		numOfAddScore = 0;
	}

	public Subject(String n, String in) {
		name = n;
		information = in;
		teacher = new ArrayList<>();
		list = new ClassList();
		numOfAddScore = 0;
	}

	public int getNumOfAddScore() {
		return numOfAddScore;
	}

	public void plusNumOfAddScore() {
		numOfAddScore++;
	}

	public boolean isUpList() {
		return upList;
	}

	public void setUpList(boolean ubList) {
		this.upList = ubList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public double getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(double maxScore) {
		this.maxScore = maxScore;
	}

	public double getMinScore() {
		return minScore;
	}

	public void setMinScore(double minScore) {
		this.minScore = minScore;
	}

	public double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}

	public ExamCriteria getExt() {
		return ext;
	}

	public void setExt(ExamCriteria ext) {
		this.ext = ext;
	}

	public double getSD() {
		return SD;
	}

	public void setSD(double sD) {
		SD = sD;
	}

	public ArrayList<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(ArrayList<Teacher> teacher) {
		this.teacher = teacher;
	}

	public ClassList getList() {
		return list;
	}

	public void setList(ClassList list) {
		this.list = list;
	}

	public double calculateNetScore(String input, int index) {
		try {
			double ratio = ext.getMaxAt(index) / ext.getRateAt(index);
			double temp = (Double.parseDouble(input) / ratio);
			return temp;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public double sumScoreOfStudent(Student s) {
		double sum = 0;
		for (int i = 0; i < s.getMyScore().size(); i++) {
			if (s.getMyScore().get(i).getSubName().equals(name)) {
				sum = sum + s.getNetScoreAt(i);
			}
		}
		System.out.println(sum);
		return sum;
	}

	public String checkGrade(double score) {
		String grade = "";
		if (score > 100) {
			return null;
		} else if (score >= 81.0) {
			grade = "A";
		} else if (score >= 74.0 && score < 81.0) {
			grade = "B+";
		} else if (score >= 67.0 && score < 74.0) {
			grade = "B";
		} else if (score >= 60.0 && score < 67.0) {
			grade = "C+";
		} else if (score >= 53.0 && score < 60.0) {
			grade = "C";
		} else if (score >= 47.0 && score < 53.0) {
			grade = "D+";
		} else if (score >= 41.0 && score < 47.0) {
			grade = "D";
		} else if (score < 41.0) {
			grade = "F";
		}

		return grade;
	}

	public boolean importFile(File f) {// --------------------------------------------------------------------
		// *******************************

		if (!f.exists())
			return false;

		if (fileType(f.getName()).equals(".xls")) {
			try (HSSFWorkbook wk = new HSSFWorkbook(new FileInputStream(f))) {
				HSSFSheet sh = wk.getSheetAt(0);
				HSSFRow row = sh.getRow(1);
				String temp = "";
				temp = temp + row.getCell(6).getStringCellValue() + "\n";
				row = sh.getRow(2);
				temp = temp + row.getCell(6).getStringCellValue() + "\n";
				row = sh.getRow(3);
				temp = temp + row.getCell(0).getStringCellValue() + "\n" + row.getCell(6).getStringCellValue() + "\n";
				information = temp;
				int c = 0;
				Iterator rows = sh.rowIterator();
				while (rows.hasNext()) {
					row = (HSSFRow) rows.next();
					c++;
					if (c >= 8) {
						list.addStudent(row.getCell(2).getStringCellValue(),
								NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));
					}
				}
				list.remove(list.size() - 1);
				list.setNumOfStudent(c - 7);
				return true;

			} catch (IllegalStateException e) {
				// e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Wrong Format", "FormatError", JOptionPane.ERROR_MESSAGE);
				return false;
			} catch (Exception e) {
				// e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Please input file .xlsx", "FileInputError",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}

		} else if (fileType(f.getName()).equals(".xlsx")) {
			try (XSSFWorkbook wk = new XSSFWorkbook(new FileInputStream(f))) {
				XSSFSheet sh = wk.getSheetAt(0);
				XSSFRow row = sh.getRow(1);
				String temp = "";
				temp = temp + row.getCell(6).getStringCellValue() + "\n";
				row = sh.getRow(2);
				temp = temp + row.getCell(6).getStringCellValue() + "\n";
				row = sh.getRow(3);
				temp = temp + row.getCell(0).getStringCellValue() + "\n" + row.getCell(6).getStringCellValue() + "\n";
				information = temp;
				int c = 0;
				Iterator rows = sh.rowIterator();
				while (rows.hasNext()) {
					row = (XSSFRow) rows.next();
					c++;
					if (c >= 8) {
						list.addStudent(row.getCell(2).getStringCellValue(),
								NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));
					}
				}
				list.remove(list.size() - 1);
				list.setNumOfStudent(c - 7);
				return true;

			} catch (IllegalStateException e) {
				// e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Wrong Format", "FormatError", JOptionPane.ERROR_MESSAGE);
				return false;
			} catch (Exception e) {
				// e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Please input file .xlsx", "FileInputError",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return false;// ถ้าไม่ใช่ .xls , .xlsx ให้ return false;
	}

	public boolean unNullFile(File f) { // ----------------------------------------------------------------------------------

		if (fileType(f.getName()).equals(".xls")) {
			String temp = "";
			try (HSSFWorkbook wk = new HSSFWorkbook(new FileInputStream(f))) {
				HSSFSheet sh = wk.getSheetAt(0);
				HSSFRow row = sh.getRow(0);
				temp = row.getCell(0).getStringCellValue();
				return true;
			} catch (EOFException e) {
				if (temp.equals(null))
					return false;
				else
					return true;
			} catch (FileNotFoundException e) {
				return false;
			} catch (IOException e) {
				return false;
			} catch (Exception e) {
				return false;
			}

		} else if (fileType(f.getName()).equals(".xlsx")) {
			String temp = "";
			try (XSSFWorkbook wk = new XSSFWorkbook(new FileInputStream(f))) {
				XSSFSheet sh = wk.getSheetAt(0);
				XSSFRow row = sh.getRow(0);
				temp = row.getCell(0).getStringCellValue();
				return true;
			} catch (EOFException e) {
				if (temp.equals(null))
					return false;
				else
					return true;
			} catch (FileNotFoundException e) {
				return false;
			} catch (IOException e) {
				return false;
			} catch (Exception e) {
				return false;
			}
		}
		return false;// ถ้าไม่ใช่ .xls , .xlsx ให้ return false;
	}

	public boolean importFile(File f, String sub) {// -----------------------------------------------------
		// *******************************
		if (!f.exists())
			return false;
		if (unNullFile(f))
			;
		else
			return false;

		if (fileType(f.getName()).equals(".xls")) {
			try (HSSFWorkbook wk = new HSSFWorkbook(new FileInputStream(f))) {
				HSSFSheet sh = wk.getSheetAt(0);
				HSSFRow row = sh.getRow(1);
				String temp = "";
				temp = temp + row.getCell(6).getStringCellValue() + "\n";
				row = sh.getRow(2);
				temp = temp + row.getCell(6).getStringCellValue() + "\n";
				row = sh.getRow(3);
				temp = temp + row.getCell(0).getStringCellValue() + "\n" + row.getCell(6).getStringCellValue() + "\n";
				information = temp;
				list.setSubName(sub);

				int c = 0;
				Iterator rows = sh.rowIterator();
				while (rows.hasNext()) {
					row = (HSSFRow) rows.next();
					c++;
					if (c >= 8) {
						list.addStudent(row.getCell(2).getStringCellValue(),
								NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));
					}
				}
				list.remove(list.size() - 1);
				list.setNumOfStudent(c - 7);
				for (int i = 0; i < list.size(); i++) {
					list.getStudentAt(i).addSubject(name);
				}
				return true;

			} catch (IllegalStateException e) {
				// e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Wrong Format", "FormatError", JOptionPane.ERROR_MESSAGE);
				return false;
			} catch (Exception e) {
				// e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Please input file .xlsx", "FileInputError",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else if (fileType(f.getName()).equals(".xlsx")) {
			try (XSSFWorkbook wk = new XSSFWorkbook(new FileInputStream(f))) {
				XSSFSheet sh = wk.getSheetAt(0);
				XSSFRow row = sh.getRow(1);
				String temp = "";
				temp = temp + row.getCell(6).getStringCellValue() + "\n";
				row = sh.getRow(2);
				temp = temp + row.getCell(6).getStringCellValue() + "\n";
				row = sh.getRow(3);
				temp = temp + row.getCell(0).getStringCellValue() + "\n" + row.getCell(6).getStringCellValue() + "\n";
				information = temp;
				list.setSubName(sub);

				int c = 0;
				Iterator rows = sh.rowIterator();
				while (rows.hasNext()) {
					row = (XSSFRow) rows.next();
					c++;
					if (c >= 8) {
						list.addStudent(row.getCell(2).getStringCellValue(),
								NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));
					}
				}
				list.remove(list.size() - 1);
				list.setNumOfStudent(c - 7);
				for (int i = 0; i < list.size(); i++) {
					list.getStudentAt(i).addSubject(name);
				}
				return true;

			} catch (IllegalStateException e) {
				// e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Wrong Format", "FormatError", JOptionPane.ERROR_MESSAGE);
				return false;
			} catch (Exception e) {
				// e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Please input file .xlsx", "FileInputError",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}

		return false;// ถ้าไม่ใช่ .xls , .xlsx ให้ return false;
	}

	public boolean writeFile(boolean bb) {
		// *******************************
		if (bb) {
			File f = new File("Subject" + name + ".txt");
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			FileWriter fw;
			try {
				fw = new FileWriter(f, false);
				PrintWriter pw = new PrintWriter(fw, true);
				pw.println(name);
				pw.println(information);
				pw.print("\t\t\t\t");
				for (int a = 0; a < ext.size(); a++) {
					pw.print(ext.getTypeAt(a) + "\t");
				}
				pw.println();
				for (int i = 0; i < list.size(); i++) {
					pw.print(list.getStudentAt(i).getId() + list.getStudentAt(i).getName() + " ");
					pw.println();
				}
				return true;

			} catch (Exception e) {
				// e.printStackTrace();
				return false;
			}
		} else {
			File f = new File("Subject" + name + "2.txt");
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			FileWriter fw;
			try {
				fw = new FileWriter(f, false);
				PrintWriter pw = new PrintWriter(fw, true);
				pw.println(name);
				pw.println(information);
				pw.print("\t\t\t");
				for (int a = 0; a < ext.size(); a++) {
					pw.print(ext.getTypeAt(a) + "\t");
				}
				pw.println();
				for (int i = 0; i < list.size(); i++) {
					pw.println(list.getStudentAt(i).getId() + list.getStudentAt(i).getName());
					for (int b = 0; b < list.getStudentAt(i).getMyScore().size(); b++) {
						if (list.getStudentAt(i).getMyScore().get(b).getSubName().equalsIgnoreCase(name))
							pw.println(list.getStudentAt(i).getMyScore().get(b).getType() + ": "
									+ list.getStudentAt(i).getMyScore().get(b).getScore() + " "
									+ list.getStudentAt(i).getMyScore().get(b).getNetScore());
					}
				}
				return true;

			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}

	}

	public boolean exportFile(File f) {
		for (int i = 0; i < list.size(); i++) {
			if (list.getStudentAt(i).getMyScore().size() != ext.getNumOfScore()) {
				return false;
			}
		}
		try {
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet(name);
			for (int i = 0; i < list.size(); i++) {
				XSSFRow row = sheet.createRow(i);
				XSSFCell cell = row.createCell(0);
				cell.setCellValue(list.getStudentAt(i).getId());
				XSSFCell cell2 = row.createCell(1);
				cell2.setCellValue(checkGrade(sumScoreOfStudent(list.getStudentAt(i))));
			}
			sheet.setColumnWidth(0, 4000);
			sheet.setColumnWidth(1, 4000);
			FileOutputStream out = new FileOutputStream(f.getAbsolutePath() + ".xlsx");
			wb.write(out);
			wb.close();
			out.close();
			System.out.println("Excel created successfully");

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------------------------------

	public String fileType(String fileName) {
		String s = "";
		Pattern pat = Pattern.compile("\\.\\w{3,4}");
		Matcher mat = pat.matcher(fileName);
		if (mat.find()) {
			s = fileName.substring(mat.start(), mat.end());
		}
		return s;
	}

	public boolean checkFile() {
		File f = new File("Subject" + name + "2.txt");
		if (!f.exists())
			return false;
		else {
			try {
				Scanner sc = new Scanner(f);
				int cnt = 0;
				while (sc.hasNextLine()) {
					cnt++;
				}
				if (cnt >= (3 + (list.size() * (ext.size() + 1))))
					return true;
				else
					return false;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return false;
			}

		}
	}
}
