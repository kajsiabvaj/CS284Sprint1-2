package teacher;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class export2 extends JFrame{
	public JPanel panel,pAll, p1,p2,p3,ptop ,pdown;
	public JPanel pdown1,pdown2;
	public JLabel lbNum,lbId,lbGrade;
	public JLabel[] arrNum, arrId;
	public JTextField[]  arrGrade;
	public JButton cancel,expoet ;
	public JScrollPane scroll;
	
	
	
	public export2() {
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
		lbGrade = new JLabel("เกรด");
		p3.add(lbGrade);
		arrGrade  = new JTextField[25] ;
		for (int i = 0; i < 25; i++) {
			arrGrade [i] = new JTextField("");
			arrGrade [i].setHorizontalAlignment ( SwingConstants.CENTER );
			p3.add(arrGrade [i]);
		}
		
		lbNum.setFont(new Font("Angsana New", Font.BOLD, 30));
		lbId.setFont(new Font("Angsana New", Font.BOLD, 30));
		lbGrade.setFont(new Font("Angsana New", Font.BOLD, 30));
		
		lbNum.setPreferredSize(new Dimension(125, 30));
		lbId.setPreferredSize(new Dimension(125, 30));
		lbGrade.setPreferredSize(new Dimension(125, 30));
		
		lbNum.setHorizontalAlignment ( SwingConstants.CENTER );
		lbId.setHorizontalAlignment ( SwingConstants.CENTER );
		lbGrade.setHorizontalAlignment ( SwingConstants.CENTER );
		
		ptop = new JPanel();
		ptop.add(p1);
		ptop.add(p2);
		ptop.add(p3);
		
		cancel = new JButton("Cancel"); 
		expoet = new JButton("Export"); 
		
		pdown = new JPanel();
		pdown.setLayout(new GridLayout(1,0));
		pdown1 = new JPanel();
		pdown1.setLayout(new FlowLayout(FlowLayout.LEFT));
		pdown1.add(cancel);
		pdown.add(pdown1);
		pdown2 = new JPanel();
		pdown2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pdown2.add(expoet);
		pdown.add(pdown2);
		
		
		pAll.add(ptop, BorderLayout.CENTER);
		pAll.add(pdown,BorderLayout.SOUTH);
		
		panel = new JPanel();
		panel.add(pAll);
		scroll = new JScrollPane(panel);
		this.setTitle("Preview");
		this.add(scroll,BorderLayout.CENTER);
		this.setSize(700, 700);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public export2(int nos) {
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
		lbGrade = new JLabel("เกรด");
		p3.add(lbGrade);
		arrGrade  = new JTextField[nos] ;
		for (int i = 0; i < nos; i++) {
			arrGrade [i] = new JTextField("");
			arrGrade [i].setHorizontalAlignment ( SwingConstants.CENTER );
			p3.add(arrGrade [i]);
		}
		
		lbNum.setFont(new Font("Angsana New", Font.BOLD, 30));
		lbId.setFont(new Font("Angsana New", Font.BOLD, 30));
		lbGrade.setFont(new Font("Angsana New", Font.BOLD, 30));
		
		lbNum.setPreferredSize(new Dimension(125, 30));
		lbId.setPreferredSize(new Dimension(125, 30));
		lbGrade.setPreferredSize(new Dimension(125, 30));
		
		lbNum.setHorizontalAlignment ( SwingConstants.CENTER );
		lbId.setHorizontalAlignment ( SwingConstants.CENTER );
		lbGrade.setHorizontalAlignment ( SwingConstants.CENTER );
		
		ptop = new JPanel();
		ptop.add(p1);
		ptop.add(p2);
		ptop.add(p3);
		
		cancel = new JButton("Cancel"); 
		expoet = new JButton("Export"); 
		
		pdown = new JPanel();
		pdown.setLayout(new GridLayout(1,0));
		pdown1 = new JPanel();
		pdown1.setLayout(new FlowLayout(FlowLayout.LEFT));
		pdown1.add(cancel);
		pdown.add(pdown1);
		pdown2 = new JPanel();
		pdown2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		//pdown2.add(expoet);
		pdown.add(pdown2);
		
		
		pAll.add(ptop, BorderLayout.CENTER);
		pAll.add(pdown,BorderLayout.SOUTH);
		
		panel = new JPanel();
		panel.add(pAll);
		scroll = new JScrollPane(panel);
		this.setTitle("Preview");
		this.add(scroll,BorderLayout.CENTER);
		this.setSize(700, 700);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main (String[] args) {
		new export2(5);
	}

}
