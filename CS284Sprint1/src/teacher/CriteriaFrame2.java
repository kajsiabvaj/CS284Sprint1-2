package teacher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class CriteriaFrame2 extends JFrame {
	
	private ArrayList<JLabel> lbCount;
	public ArrayList<JTextField> type;
	public ArrayList<JTextField> CriteriaScore;
	public ArrayList<JTextField> percentage;
	public ArrayList<JTextField> note;
	public JButton bntSet;
	private JButton bntCancle;
	private int count = 10;
	private String subject = "CS284";
	
	public CriteriaFrame2() {
		type = new ArrayList<>();
		CriteriaScore = new ArrayList<>();
		percentage = new ArrayList<>();
		note = new ArrayList<>();
		lbCount = new ArrayList<>();
		
		
		JLabel titleType = new JLabel("หัวข้อในการเก็บคะเเนน");
		titleType.setFont(new Font("Angsana New", Font.BOLD, 18));
		for(int i = 0; i < count; i++) {
			type.add(new JTextField(10));
		}
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(0, 1));
		p1.add(titleType);
		for(JTextField t: type) {
			p1.add(t);
		}
		
		JLabel titleCriteria = new JLabel("คะเเนนเต็ม");
		titleCriteria.setFont(new Font("Angsana New", Font.BOLD, 18));
		for(int i = 0; i < count; i++) {
			CriteriaScore.add(new JTextField(5));
		}
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(0, 1));
		p2.add(titleCriteria);
		for(JTextField cs: CriteriaScore) {
			p2.add(cs);
		}
		
		JLabel titlePercen = new JLabel("คิดเป็นร้อยละ");
		titlePercen.setFont(new Font("Angsana New", Font.BOLD, 18));
		for(int i = 0; i < count; i++) {
			percentage.add(new JTextField(5));
		}
		
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(0, 1));
		p3.add(titlePercen);
		for(JTextField p: percentage) {
			p3.add(p);
		}
		
		JLabel titleNote = new JLabel("รายละเอียดการเก็บคะเเนน");
		titleNote.setFont(new Font("Angsana New", Font.BOLD, 18));
		for(int i = 0; i < count; i++) {
			note.add(new JTextField(10));
		}
		
		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(0, 1));
		p4.add(titleNote);
		for(JTextField t: note) {
			p4.add(t);
		}
		
		JLabel titleCount = new JLabel("ครั้งที่");
		titleCount.setFont(new Font("Angsana New", Font.BOLD, 18));
		for(int i = 1; i <= count; i++) {
			lbCount.add(new JLabel("" + i));
		}
		
		JPanel p5 = new JPanel();
		p5.setLayout(new GridLayout(0, 1));
		p5.add(titleCount);
		for(JLabel lb: lbCount) {
			p5.add(lb);
		}
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		panel1.setBorder(new TitledBorder(subject));
		panel1.add(p5);
		panel1.add(p1);
		panel1.add(p2);
		panel1.add(p3);
		panel1.add(p4);
		
		bntSet = new JButton("Set Criteria");
		bntCancle = new JButton("Cancle");
		
		bntCancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JPanel p6 = new JPanel();
		p6.add(bntSet);
		p6.add(bntCancle);
		
		JLabel titalSuggestion = new JLabel("การใช้งานโปรแกรมกรอกสัดส่วนของคะเเนน", JLabel.LEFT);
		titalSuggestion.setFont(new Font("Angsana New", Font.BOLD, 18));
		JLabel suggestion1 = new JLabel("1. อาจารย์ประจำรายวิชาระบุหัวข้อการเก็บคะเเนน คะเเนนเต็ม และสัดส่วนร้อยละ", JLabel.LEFT);
		suggestion1.setFont(new Font("Angsana New", Font.BOLD, 18));
		JLabel suggestion2 = new JLabel("2. กด  Set Criteria เพื่อจัดเก็บข้อมูล", JLabel.LEFT);
		suggestion2.setFont(new Font("Angsana New", Font.BOLD, 18));
		JLabel suggestion3 = new JLabel("3. ช่องรายละเอียดของการเก็บคะเเนนสามารถระบุหรือไม่ระบุก็ได้", JLabel.LEFT);
		suggestion3.setFont(new Font("Angsana New", Font.BOLD, 18));
		
		JPanel p7 = new JPanel();
		p7.setLayout(new GridLayout(0,1));
		p7.setBorder(new EtchedBorder());
		p7.add(titalSuggestion);
		p7.add(suggestion1);
		p7.add(suggestion2);
		p7.add(suggestion3);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.add(p6, BorderLayout.NORTH);
		panel2.add(p7);
		
		this.add(panel1);
		this.add(panel2, BorderLayout.SOUTH);
		this.setTitle("กรอกสัดส่วนของคะเเนน");
		this.setSize(700,700);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public CriteriaFrame2(int top,String subName){
		if(top<3) count=3;
		else count=top;
		subject=subName;
		type = new ArrayList<>();
		CriteriaScore = new ArrayList<>();
		percentage = new ArrayList<>();
		note = new ArrayList<>();
		lbCount = new ArrayList<>();
		
		
		JLabel titleType = new JLabel("หัวข้อในการเก็บคะเเนน");
		titleType.setFont(new Font("Angsana New", Font.BOLD, 18));
		for(int i = 0; i < count; i++) {
			type.add(new JTextField(10));
		}
		
		type.get(0).setText("Midterm");
		type.get(0).setEditable(false);
		type.get(1).setText("Final");
		type.get(1).setEditable(false);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(0, 1));
		p1.add(titleType);
		for(JTextField t: type) {
			p1.add(t);
		}
		
		JLabel titleCriteria = new JLabel("คะเเนนเต็ม");
		titleCriteria.setFont(new Font("Angsana New", Font.BOLD, 18));
		for(int i = 0; i < count; i++) {
			CriteriaScore.add(new JTextField(5));
		}
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(0, 1));
		p2.add(titleCriteria);
		for(JTextField cs: CriteriaScore) {
			p2.add(cs);
		}
		
		JLabel titlePercen = new JLabel("คิดเป็นร้อยละ");
		titlePercen.setFont(new Font("Angsana New", Font.BOLD, 18));
		for(int i = 0; i < count; i++) {
			percentage.add(new JTextField(5));
		}
		
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(0, 1));
		p3.add(titlePercen);
		for(JTextField p: percentage) {
			p3.add(p);
		}
		
		JLabel titleNote = new JLabel("รายละเอียดการเก็บคะเเนน");
		titleNote.setFont(new Font("Angsana New", Font.BOLD, 18));
		for(int i = 0; i < count; i++) {
			note.add(new JTextField(10));
		}
		
		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(0, 1));
		p4.add(titleNote);
		for(JTextField t: note) {
			p4.add(t);
		}
		
		JLabel titleCount = new JLabel("ครั้งที่");
		titleCount.setFont(new Font("Angsana New", Font.BOLD, 18));
		for(int i = 1; i <= count; i++) {
			lbCount.add(new JLabel("" + i));
		}
		
		JPanel p5 = new JPanel();
		p5.setLayout(new GridLayout(0, 1));
		p5.add(titleCount);
		for(JLabel lb: lbCount) {
			p5.add(lb);
		}
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		panel1.setBorder(new TitledBorder(subject));
		panel1.add(p5);
		panel1.add(p1);
		panel1.add(p2);
		panel1.add(p3);
		panel1.add(p4);
		
		bntSet = new JButton("Set Criteria");
		bntCancle = new JButton("Cancle");
		
		bntCancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JPanel p6 = new JPanel();
		p6.add(bntSet);
		p6.add(bntCancle);
		
		JLabel titalSuggestion = new JLabel("การใช้งานโปรแกรมกรอกสัดส่วนของคะเเนน", JLabel.LEFT);
		titalSuggestion.setFont(new Font("Angsana New", Font.BOLD, 18));
		JLabel suggestion1 = new JLabel("1. อาจารย์ประจำรายวิชาระบุหัวข้อการเก็บคะเเนน คะเเนนเต็ม และสัดส่วนร้อยละ", JLabel.LEFT);
		suggestion1.setFont(new Font("Angsana New", Font.BOLD, 18));
		JLabel suggestion2 = new JLabel("2. กด  Set Criteria เพื่อจัดเก็บข้อมูล", JLabel.LEFT);
		suggestion2.setFont(new Font("Angsana New", Font.BOLD, 18));
		JLabel suggestion3 = new JLabel("3. ช่องรายละเอียดของการเก็บคะเเนนสามารถระบุหรือไม่ระบุก็ได้", JLabel.LEFT);
		suggestion3.setFont(new Font("Angsana New", Font.BOLD, 18));
		JLabel suggestion4=new JLabel("4.คะแนน Midterm รวมกับคะแนน Final ต้องมีอัตราส่วนมากกว่าหรือเท่ากับ 50%");
		suggestion4.setFont(new Font("Angsana New", Font.BOLD, 25));
		suggestion4.setForeground(Color.RED);
		
		JPanel p7 = new JPanel();
		p7.setLayout(new GridLayout(0,1));
		p7.setBorder(new EtchedBorder());
		p7.add(titalSuggestion);
		p7.add(suggestion1);
		p7.add(suggestion2);
		p7.add(suggestion3);
		p7.add(suggestion4);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.add(p6, BorderLayout.NORTH);
		panel2.add(p7);
		
		this.add(panel1);
		this.add(panel2, BorderLayout.SOUTH);
		this.setTitle("กรอกสัดส่วนของคะเเนน");
		this.setSize(700,700);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public static void main(String[] args) {
		new CriteriaFrame2();
	}
}
