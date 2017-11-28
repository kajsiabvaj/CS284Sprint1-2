package teacher;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class export1 extends JFrame {
	public JPanel panel, pp, p1, p2, p3;
	public JPanel p, p21, p22;
	public JLabel lb2, lb1;
	public JComboBox<String> pick_subject;
	public JButton review, export, cancle;

	public export1() {
		setLayout(new BorderLayout());
		panel = new JPanel();
		pp = new JPanel();
		pp.setLayout(new GridLayout(0, 1));

		p3 = new JPanel();
		lb1 = new JLabel("ขอใบส่งเกรด");
		lb1.setFont(new Font("Angsana New", Font.BOLD, 40));

		p3.add(lb1);
		p1 = new JPanel();
		lb2 = new JLabel("เลือกวิชา ");
		lb2.setFont(new Font("Angsana New", Font.PLAIN, 30));

		pick_subject = new JComboBox<>();
		pick_subject.setPreferredSize(new Dimension(150, 30));
		p1.add(lb2);
		p1.add(pick_subject);

		p2 = new JPanel();

		review = new JButton("Review");
		export = new JButton("Export");
		cancle = new JButton("Cancle");
		p2.add(cancle);
		p2.add(review);
		p2.add(export);

		pp.add(p3);
		pp.add(p1);
		pp.add(p2);

		panel.add(pp);
		p = new JPanel();
		p.setPreferredSize(new Dimension(0, 100));

		this.add(p, BorderLayout.NORTH);
		this.setTitle("ขอใบส่งเกรด");
		this.add(panel, BorderLayout.CENTER);
		this.setSize(700, 700);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new export1();
	}

}
