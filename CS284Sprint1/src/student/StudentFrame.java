package student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class StudentFrame extends JFrame {

	public JButton bntLogout;
	public JButton bntScore;
	public JButton bntTranscript;
	public JButton bntprofile;
	public JLabel lbId;
	public JLabel lbName;
	public JLabel lbtxt;
	public JLabel lbNotice;
	public JLabel lbDate;
	public String id = "5909450016";
	public String name = "นางสาวแนนซี่ อยากได้สามี";
//	private String subject = "CS284";
	public String date = "7/11/2560";
//	private String type = "Midterm";
	
	public StudentFrame() {
		bntLogout = new JButton("ออกจากระบบ");
		bntLogout.setFont(new Font("Angsana New", Font.BOLD, 18));
		bntLogout.setPreferredSize(new Dimension(150, 30));
		bntprofile = new JButton("ประวัติส่วนตัว");
		bntprofile.setFont(new Font("Angsana New", Font.BOLD, 18));
		bntprofile.setPreferredSize(new Dimension(150, 30));
		bntScore = new JButton("คะเเนน");
		/*bntScore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PreSeeScoreFrame preSee = new PreSeeScoreFrame();
				
			}
		});*/
		bntScore.setFont(new Font("Angsana New", Font.BOLD, 18));
		bntScore.setPreferredSize(new Dimension(150, 30));
		bntTranscript = new JButton("ผลการศึกษา");
		bntTranscript.setFont(new Font("Angsana New", Font.BOLD, 18));
		bntTranscript.setPreferredSize(new Dimension(150, 30));
		
		JPanel p1 = new JPanel();
		p1.add(bntLogout);
		JPanel p2 = new JPanel();
		p2.add(bntprofile);
		JPanel p3 = new JPanel();
		p3.add(bntScore);
		JPanel p4 = new JPanel();
		p4.add(bntTranscript);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(0, 1));
		panel1.add(p1);
		panel1.add(p2);
		panel1.add(p3);
		panel1.add(p4);
		
		JPanel panel2 = new JPanel();
		panel2.setBorder(new EtchedBorder());
		panel2.add(panel1);
		
		lbId = new JLabel(id + ": ");
		lbId.setFont(new Font("Angsana New", Font.BOLD, 20));
		lbName = new JLabel(name);
		lbName.setFont(new Font("Angsana New", Font.BOLD, 20));
		
		JPanel p5 = new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.LEFT));
//		p5.setBorder(new TitledBorder(""));
		p5.add(lbId);
		p5.add(lbName);
		
		lbtxt = new JLabel("_________________________________________________________.");
		
		lbNotice = new JLabel("คะเเนน Midterm รายวิชา CS284 ประกาศแล้ว!!!");
		lbNotice.setFont(new Font("Angsana New", Font.BOLD, 30));
		lbNotice.setForeground(Color.RED);
		lbDate = new JLabel("แจ้งเมื่อวันที่: " + date, JLabel.RIGHT);
		lbDate.setFont(new Font("Angsana New", Font.PLAIN, 18));
		
		JPanel p6 = new JPanel();
		p6.setLayout(new GridLayout(0, 1));
//		p6.setBorder(new TitledBorder("7/11/2016"));
		p6.add(lbNotice);
		p6.add(lbDate);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BorderLayout());
		panel3.add(p5, BorderLayout.NORTH);
		panel3.add(lbtxt);
		panel3.add(p6, BorderLayout.SOUTH);
		
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel4.add(panel3);
		
		this.add(panel2, BorderLayout.WEST);
		this.add(panel4);
		this.setSize(700,700);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new StudentFrame();
	}
	
}
