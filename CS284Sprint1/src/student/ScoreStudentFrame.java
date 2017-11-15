package student;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import classModel.ClassList;
import classModel.Student;

public class ScoreStudentFrame extends JFrame{
	private Student student;
	private String subjectName;
	private String typeName;
	public JLabel subjectNameLabel;
	public JTable table;
	
	public ScoreStudentFrame(Student student, String subjectName, String typeName) {
		this.student = student;
		this.subjectName = subjectName;
		this.typeName = typeName;
	}

	public ScoreStudentFrame() {
		
		this.setTitle("คะแนนวิชา CS284");
		JPanel northPanel = new JPanel();
		northPanel.setPreferredSize(new Dimension(2000,50));
		subjectNameLabel = new JLabel("คะแนนวิชา CS284");
		subjectNameLabel.setFont(new Font("Angsana New", Font.BOLD, 30));
		northPanel.add(subjectNameLabel);
		this.add(northPanel,BorderLayout.NORTH);
		
		//row , column
		String data[][] = { {"5909520016" , "0","0" },{"Max","Min","Average"},{"10","10","10"}};//,{"Max","Min","Average","SD"},{"10","10","10","10"} 
//		String data[][] = new String[จำนวนนักเรียน/นักเรียนคนที่ login เข้ามา][4];
		
		
		String header[] = {"เลขทะเบียน", "คะแนนดิบ","คะแนนสุทธิ" };
		table = new JTable(data,header);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.getColumnModel().getColumn(1).setPreferredWidth(190);
		table.getColumnModel().getColumn(2).setPreferredWidth(190);
		
		
		JScrollPane scrollPane = new JScrollPane(table);

		this.add(scrollPane);
		
		
		JPanel buttonPanel = new JPanel();
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonPanel.add(cancelBtn);
		this.add(buttonPanel,BorderLayout.SOUTH);
		
		this.setSize(700,700);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	

	public void setTable(JTable table) {
		this.table = table;
	}

	public static void main(String[] args) {
		ScoreStudentFrame sf = new ScoreStudentFrame();

	}

}
