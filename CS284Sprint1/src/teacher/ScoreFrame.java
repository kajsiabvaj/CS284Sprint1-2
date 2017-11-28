package teacher;

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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ScoreFrame extends JFrame{
	
	public JLabel lbNum , lbId , lbScoreRaw ,lbScoreNet,note;
	public JPanel  p1,p2,p3,p4,p5,p6,p36,pScore,pNote,pAll,panel;
	public JPanel p41,p42;
	public JLabel[] arrNum ,arrId;
	public JTextField[] arrScoreRaw ,arrScoreNet ;
	public JButton cancel , save , submit ,calculator;
	public JScrollPane scroll;
	
	public ScoreFrame(int nos) {
		setLayout(new BorderLayout());
		pAll = new JPanel() ;	
		pAll.setLayout(new BorderLayout());
		
		p1 = new JPanel() ;
		p1.setLayout(new GridLayout(0,1));
		lbNum = new JLabel("ลำดับ");
		p1.add(lbNum);
		arrNum = new JLabel[nos] ;
		for (int i = 0; i < nos; i++) {
			int y = i+1 ;
			arrNum[i] = new JLabel(""+y);
			arrNum[i].setHorizontalAlignment ( SwingConstants.CENTER );
			p1.add(arrNum[i]);
		}
		
		p2 = new JPanel();
		p2.setLayout(new GridLayout(0, 1));
		lbId = new JLabel("รหัสนักศึกษา");
		p2.add(lbId);
		arrId = new JLabel[nos] ;
		for (int i = 0; i < nos; i++) {
			arrId[i] = new JLabel("590961000"+i);
			arrId[i].setHorizontalAlignment ( SwingConstants.CENTER );
			p2.add(arrId[i]);
		}
		
		p3 = new JPanel();
		p3.setLayout(new GridLayout(0, 1));
		lbScoreRaw = new JLabel("คะแนนดิบ");
		p3.add(lbScoreRaw);
		arrScoreRaw  = new JTextField[nos] ;
		for (int i = 0; i < nos; i++) {
			arrScoreRaw [i] = new JTextField("");
			arrScoreRaw [i].setHorizontalAlignment ( SwingConstants.CENTER );
			p3.add(arrScoreRaw [i]);
		}
		
		p6 = new JPanel();
		p6.setLayout(new GridLayout(0, 1));
		lbScoreNet = new JLabel("คะแนนสุทธิ");
		p6.add(lbScoreNet);
		arrScoreNet  = new JTextField[nos] ;
		for (int i = 0; i < nos; i++) {
			arrScoreNet  [i] = new JTextField("");
			arrScoreNet  [i].setHorizontalAlignment ( SwingConstants.CENTER );
			p6.add(arrScoreNet  [i]);
		}
		
		
		lbNum.setFont(new Font("Angsana New", Font.BOLD, 30));
		lbId.setFont(new Font("Angsana New", Font.BOLD, 30));
		lbScoreRaw.setFont(new Font("Angsana New", Font.BOLD, 30));
		lbScoreNet.setFont(new Font("Angsana New", Font.BOLD, 30));
		
		lbNum.setPreferredSize(new Dimension(125, 30));
		lbId.setPreferredSize(new Dimension(170, 30));
		lbScoreRaw.setPreferredSize(new Dimension(125, 30));
		lbScoreNet.setPreferredSize(new Dimension(125, 30));
		
		lbNum.setHorizontalAlignment ( SwingConstants.CENTER );
		lbId.setHorizontalAlignment ( SwingConstants.CENTER );
		lbScoreRaw.setHorizontalAlignment ( SwingConstants.CENTER );
		lbScoreNet.setHorizontalAlignment ( SwingConstants.CENTER );
		
		//p36 = new JPanel();
	///	p36.add(p3);
		//p36.add(p6);
		
		
		pScore = new JPanel();
		//pScore.setLayout(new GridLayout(0,3));
		pScore.add(p1);
		pScore.add(p2);
		pScore.add(p3);
		pScore.add(p6);
		
		//pScore.add(p36);
		
		
		cancel = new JButton("Cancel"); 
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		save = new JButton("Save");
		submit = new JButton("Submit");
		calculator = new JButton("Preview");
		pNote = new JPanel();
		pNote.setLayout(new GridLayout(0, 1));
		p4 = new JPanel() ;	
		p4.setLayout(new GridLayout(0, 2));
		p41 = new JPanel() ;	
		p41.setLayout(new FlowLayout(FlowLayout.LEFT));
		p42 = new JPanel() ;	
		p42.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p41.add(cancel);
		p41.add(save);
		p42.add(calculator);
		p42.add(submit);
		p4.add(p41);
		p4.add(p42);
		p5 = new JPanel();
		note = new JLabel("หมายเหตุ Save คือการบันทึกข้อมูล Preview คือการแสดงตัวอย่างของคะแนนสุทธิ Submit คือแจ้งคะแนนให้นักศึกษาทราบ");
		note.setFont(new Font("Angsana New", Font.BOLD, 25));
		note.setForeground(Color.RED );
		p5.add(note);
		pNote.add(p4);
		pNote.add(p5);

		pAll.add(pScore, BorderLayout.CENTER);
		pAll.add(pNote,BorderLayout.SOUTH);
		
		panel = new JPanel();
		panel.add(pAll);
		scroll = new JScrollPane(panel);
		pScore.setBorder(new TitledBorder(lbScoreNet.getText()));
		this.add(scroll,BorderLayout.CENTER);
		this.setTitle("กรอกคะแนน");
		this.setSize(700, 700);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public ScoreFrame() {
		setLayout(new BorderLayout());
		pAll = new JPanel() ;	
		pAll.setLayout(new BorderLayout());
		
		p1 = new JPanel() ;
		p1.setLayout(new GridLayout(0,1));
		lbNum = new JLabel("ลำดับ");
		p1.add(lbNum);
		arrNum = new JLabel[25] ;
		for (int i = 0; i < 25; i++) {
			int y = i+1 ;
			arrNum[i] = new JLabel(""+y);
			arrNum[i].setHorizontalAlignment ( SwingConstants.CENTER );
			p1.add(arrNum[i]);
		}
		
		p2 = new JPanel();
		p2.setLayout(new GridLayout(0, 1));
		lbId = new JLabel("รหัสนักศึกษา");
		p2.add(lbId);
		arrId = new JLabel[25] ;
		for (int i = 0; i < 25; i++) {
			arrId[i] = new JLabel("590961000"+i);
			arrId[i].setHorizontalAlignment ( SwingConstants.CENTER );
			p2.add(arrId[i]);
		}
		
		p3 = new JPanel();
		p3.setLayout(new GridLayout(0, 1));
		lbScoreRaw = new JLabel("คะแนนดิบ");
		p3.add(lbScoreRaw);
		arrScoreRaw  = new JTextField[25] ;
		for (int i = 0; i < 25; i++) {
			arrScoreRaw [i] = new JTextField("");
			arrScoreRaw [i].setHorizontalAlignment ( SwingConstants.CENTER );
			p3.add(arrScoreRaw [i]);
		}
		
		p6 = new JPanel();
		p6.setLayout(new GridLayout(0, 1));
		lbScoreNet = new JLabel("คะแนนสุทธิ");
		p6.add(lbScoreNet);
		arrScoreNet  = new JTextField[25] ;
		for (int i = 0; i < 25; i++) {
			arrScoreNet  [i] = new JTextField("");
			arrScoreNet  [i].setHorizontalAlignment ( SwingConstants.CENTER );
			p6.add(arrScoreNet  [i]);
		}
		
		
		lbNum.setFont(new Font("Angsana New", Font.BOLD, 30));
		lbId.setFont(new Font("Angsana New", Font.BOLD, 30));
		lbScoreRaw.setFont(new Font("Angsana New", Font.BOLD, 30));
		lbScoreNet.setFont(new Font("Angsana New", Font.BOLD, 30));
		
		lbNum.setPreferredSize(new Dimension(125, 30));
		lbId.setPreferredSize(new Dimension(170, 30));
		lbScoreRaw.setPreferredSize(new Dimension(125, 30));
		lbScoreNet.setPreferredSize(new Dimension(125, 30));
		
		lbNum.setHorizontalAlignment ( SwingConstants.CENTER );
		lbId.setHorizontalAlignment ( SwingConstants.CENTER );
		lbScoreRaw.setHorizontalAlignment ( SwingConstants.CENTER );
		lbScoreNet.setHorizontalAlignment ( SwingConstants.CENTER );
		
		p36 = new JPanel();
		p36.add(p3);
		p36.add(p6);
		
		
		pScore = new JPanel();
		pScore.setLayout(new GridLayout(0,3));
		pScore.add(p1);
		pScore.add(p2);
		pScore.add(p36);
		
		
		cancel = new JButton("cancel"); 
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		save = new JButton("save");
		submit = new JButton("submit");
		calculator = new JButton("calculator");
		pNote = new JPanel();
		pNote.setLayout(new GridLayout(0, 1));
		p4 = new JPanel() ;	
		p4.setLayout(new GridLayout(0, 2));
		p41 = new JPanel() ;	
		p41.setLayout(new FlowLayout(FlowLayout.LEFT));
		p42 = new JPanel() ;	
		p42.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p41.add(cancel);
		p41.add(save);
		p42.add(calculator);
		p42.add(submit);
		p4.add(p41);
		p4.add(p42);
		p5 = new JPanel();
		note = new JLabel("หมายเหตุ save คือการบันทึกข้อมูล  calculator คือการคำนวณคะแนนสุทธิ submit คือแจ้งคะแนนให้นักศึกษาทราบ");
		note.setFont(new Font("Angsana New", Font.BOLD, 25));
		note.setForeground(Color.RED );
		p5.add(note);
		pNote.add(p4);
		pNote.add(p5);

		pAll.add(pScore, BorderLayout.CENTER);
		pAll.add(pNote,BorderLayout.SOUTH);
		
		panel = new JPanel();
		panel.add(pAll);
		//panel.setBorder(new TitledBorder(lbScoreNet.getText()));
		scroll = new JScrollPane(panel);
		scroll.setBorder(new TitledBorder(new LineBorder(Color.BLACK,5),lbScoreNet.getText()));
		this.add(scroll,BorderLayout.CENTER);
		this.setTitle("กรอกคะแนน");
		this.setSize(700, 700);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main (String[] args) {
		new ScoreFrame(5);
	}
}