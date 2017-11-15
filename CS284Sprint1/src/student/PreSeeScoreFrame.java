package student;
import java.awt.BorderLayout;
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

public class PreSeeScoreFrame extends JFrame{
	public JComboBox<String> subjectNameCombo;
	public JComboBox<String> quizeNameCombo;
	public JButton seeScoreBnt;
	
	public PreSeeScoreFrame() {

		JPanel subjectPanel = new JPanel();
		subjectPanel.setLayout(new BorderLayout());
		subjectPanel.setPreferredSize(new Dimension(700,200));
		
		JPanel smallPanel = new JPanel();
		smallPanel.setPreferredSize(new Dimension(700,100));
		
		JLabel subjectLabel = new JLabel("ª×èÍÇÔªÒ");
		subjectLabel.setFont(new Font("Angsana New", Font.BOLD, 30));
		subjectNameCombo = new JComboBox<String>();
		subjectNameCombo.setPreferredSize(new Dimension(150, 30));
		smallPanel.add(subjectLabel);
		smallPanel.add(subjectNameCombo);
		subjectPanel.add(smallPanel,BorderLayout.SOUTH);
		this.add(subjectPanel,BorderLayout.NORTH);

		JPanel quizePanel = new JPanel();
		JLabel quizeLabel = new JLabel("ª¹Ô´¤Ðá¹¹");
		quizeLabel.setFont(new Font("Angsana New", Font.BOLD, 30));
		quizeNameCombo = new JComboBox<String>();
		quizeNameCombo.setPreferredSize(new Dimension(150, 30));
		quizePanel.add(quizeLabel);
		quizePanel.add(quizeNameCombo);
		this.add(quizePanel,BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(700,200));
		seeScoreBnt = new JButton("´Ù¤Ðá¹¹");
		seeScoreBnt.setFont(new Font("Angsana New", Font.BOLD, 20));
		seeScoreBnt.setPreferredSize(new Dimension(140, 30));
		/*seeScoreBnt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ScoreStudentFrame sf = new ScoreStudentFrame();
			}
		});*/
		buttonPanel.add(seeScoreBnt);
		this.add(buttonPanel,BorderLayout.SOUTH);
	
		this.setSize(700,700);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		PreSeeScoreFrame pf = new PreSeeScoreFrame();

	}

}
