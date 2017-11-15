package teacher;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class TeacherFrame extends JFrame{
	public JPanel panel ;
	public JPanel p1,p10 ,p11,p12,p13,p14;
	public JPanel p2,p20,p21;
	public JButton btLogout , btCriteria,btFillScore ,btStudentList ;
	public JLabel name ,line,txt;
	
	public TeacherFrame() {
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		p10 = new JPanel() ;
		p10.setLayout(new GridLayout(0,1));
		p11 = new JPanel();
		p12 = new JPanel();
		p13 = new JPanel();
		p14 = new JPanel();
		
		btLogout = new JButton("ออกจากระบบ");
		btCriteria = new JButton("กรอกสัดส่วนคะแนน");
		btFillScore = new JButton("กรอกคะแนน");
		btStudentList = new JButton("รายชื่อนักษา");
		
		btLogout.setFont(new Font("Angsana New", Font.PLAIN, 20));
		btCriteria.setFont(new Font("Angsana New", Font.PLAIN, 20));
		btFillScore.setFont(new Font("Angsana New", Font.PLAIN, 20));
		btStudentList.setFont(new Font("Angsana New", Font.PLAIN, 20));
		
		btLogout.setPreferredSize(new Dimension(150, 30));
		btCriteria.setPreferredSize(new Dimension(150, 30));
		btFillScore.setPreferredSize(new Dimension(150, 30));
		btStudentList.setPreferredSize(new Dimension(150, 30));
		
		/*btCriteria.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CriteriaFrame c = new CriteriaFrame();
				
			}
		});*/
		
		
		
		btFillScore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FillFrame();
			}
		});
		
		p11.add(btLogout);
		p12.add(btCriteria);
		p13.add(btFillScore);
		p14.add(btStudentList);
		
		p10.add(p11);
		p10.add(p12);
		p10.add(p13);
		p10.add(p14);
		p1 = new JPanel();
		p1.setBorder(new EtchedBorder());
		p1.add(p10);

		p20 = new JPanel();
		p20.setLayout(new GridLayout(0, 1));
		name = new JLabel("ชื่ออาจารย์");
		name.setFont(new Font("Angsana New", Font.BOLD, 30));
		p20.add(name);
		line = new JLabel();
		line.setText("_________________________________________________________________");
		p20.add(line);
		txt = new JLabel("ยินดีตอนรับ  "+name.getText()+"เข้าสู่ระบบ");
		txt.setFont(new Font("Angsana New", Font.BOLD, 20));
		p20.add(txt);

		p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		p2.add(p20);

		panel.add(p2,BorderLayout.CENTER);
		panel.add(p1,BorderLayout.WEST);
		this.add(panel);
		this.setSize(700, 700);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main (String[] args) {
		new TeacherFrame();
	}


}
