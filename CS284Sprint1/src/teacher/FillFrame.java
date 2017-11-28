package teacher;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FillFrame extends JFrame {
	
	public JPanel panel,p1,p2,p3,p4 ;
	public JLabel name , lbSubject ,lbTopic ;
	public JComboBox<String> cbSubject ,cbTopic ;
	public JButton cancel , fillScore ,uplodefile;
	
	public FillFrame(){
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		panel = new JPanel();
		panel.setLayout(new GridLayout(0,1));
		p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		name = new JLabel("ชื่ออาจารย์");
		name.setFont(new Font("Angsana New", Font.BOLD, 40));
		p1.add(name);
		panel.add(p1);
		
		p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		lbSubject = new JLabel("ชื่อวิชา  ");
		lbSubject.setFont(new Font("Angsana New", Font.PLAIN, 30));
		cbSubject = new JComboBox<String>();
		cbSubject.setPreferredSize(new Dimension(150, 30));
		uplodefile = new JButton("Uplode File");
		uplodefile.setPreferredSize(new Dimension(140, 30));
		p2.add(lbSubject);
		p2.add(cbSubject);
		p2.add(uplodefile);
		panel.add(p2);
		
		p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		lbTopic = new JLabel("หัวข้อที่เก็บคะแนน  ");
		lbTopic.setFont(new Font("Angsana New", Font.PLAIN, 30));
		cbTopic = new JComboBox<String>();
		cbTopic.setPreferredSize(new Dimension(200, 30));
		p3.add(lbTopic);
		p3.add(cbTopic);
		panel.add(p3);
		
		p4 = new JPanel();
		cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		fillScore = new JButton("Fill score");
		/*fillScore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ScoreFrame();
			}
		});*/
		
		
		
		p4.add(cancel);
		p4.add(fillScore);
		panel.add(p4);
	
		this.add(panel);
		this.setTitle("กรอกคะแนน");
		this.setSize(700, 700);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	public static void main (String[] args) {
		new FillFrame();
	}

}