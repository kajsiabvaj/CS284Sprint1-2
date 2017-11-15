package login;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import student.StudentFrame;
import teacher.TeacherFrame;

public class LoginFrame extends JFrame{
	
	public JButton teacher , student ;

	public LoginFrame() {
		
		setLayout(new GridLayout(0,2));
		
		teacher = new JButton("Teacher");
		/*teacher.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TeacherFrame teacher = new TeacherFrame();
				
			}
		});*/
		
		student = new JButton("Student");
		/*student.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentFrame studen = new StudentFrame();
				
			}
		});*/
		
		teacher.setFont(new Font("Angsana New", Font.BOLD, 100));
		student.setFont(new Font("Angsana New", Font.BOLD, 100));
		
		add(teacher);
		add(student);
		
		this.setTitle("Login");
		this.setSize(700, 700);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
	}
	public static void main (String[] args) {
		new LoginFrame();
	}

}
