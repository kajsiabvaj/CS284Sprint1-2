package teacher;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CriteriaFrame extends JFrame {
	
	public JPanel panel,p1,p2,p3,p4 ;
	public JLabel name , lbSubject ,lbTopic ;
	public JTextField cbSubject ,cbTopic ;
	public JButton cancel , nextBtn;
	
	public CriteriaFrame(){
		
		JPanel testPanel = new JPanel();
		testPanel.setPreferredSize(new Dimension(2000,100));
		this.add(testPanel,BorderLayout.NORTH);

		setLayout(new FlowLayout(FlowLayout.CENTER));
		panel = new JPanel();
		panel.setLayout(new GridLayout(0,1));
		p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.CENTER));
		lbSubject = new JLabel("ชื่อวิชา  ");
		lbSubject.setFont(new Font("Angsana New", Font.PLAIN, 30));
		cbSubject = new JTextField();
		cbSubject.setPreferredSize(new Dimension(150, 30));
		p2.add(lbSubject);
		p2.add(cbSubject);
		panel.add(p2);
		
		p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		lbTopic = new JLabel("จำนวนครั้งที่ท่านต้องการเก็บคะเเนน ");
		lbTopic.setFont(new Font("Angsana New", Font.PLAIN, 30));
		
		cbTopic = new JTextField(5);
		cbTopic.setPreferredSize(new Dimension(200, 30));
		
		
		p3.add(lbTopic);
		p3.add(cbTopic);
		panel.add(p3);
		
		
		p4 = new JPanel();
		cancel = new JButton("cancel");
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		nextBtn = new JButton("Next");
		/*nextBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CriteriaFrame2 c2 = new CriteriaFrame2();
			}
		});*/
		
		
		
		p4.add(cancel);
		p4.add(nextBtn);
		panel.add(p4);

		this.add(panel);
		
		this.setTitle("กรอกสัดส่วนของคะเเนน");
		this.setSize(700,700);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new CriteriaFrame();
	}

}
