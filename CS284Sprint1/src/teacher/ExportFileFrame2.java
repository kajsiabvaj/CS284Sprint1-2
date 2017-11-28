package teacher;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ExportFileFrame2 extends JFrame{
	public JButton exportBtn;
	public JTable table;
	public String[] head = {"เลขทะเบียน","เกรด"};
	
	public ExportFileFrame2() {
		
		JPanel nothPanel = new JPanel();
		nothPanel.setPreferredSize(new Dimension(this.getWidth(),50));
		this.add(nothPanel,BorderLayout.NORTH);
		
		
		String[][] student = {{"5909669955","A"},{"5909884510","A"},{"5909784596","A"},{"5909778899","A"},{"5909150024","A"},
				{"5909441122","A"},{"5909669955","A"},{"5909884510","A"},{"5909784596","A"},{"5909778899","A"},{"5909150024","A"},
				{"5909441122","A"},{"5909669955","A"},{"5909884510","A"},{"5909784596","A"},{"5909778899","A"},{"5909150024","A"},
				{"5909441122","A"},{"5909669955","A"},{"5909884510","A"},{"5909784596","A"},{"5909778899","A"},{"5909150024","A"},
				{"5909441122","A"},{"5909669955","A"},{"5909884510","A"},{"5909784596","A"},{"5909778899","A"},{"5909150024","A"},
				{"5909441122","A"},{"5909669955","A"},{"5909884510","A"},{"5909784596","A"},{"5909778899","A"},{"5909150024","A"},
				{"5909441122","A"},{"5909669955","A"},{"5909884510","A"},{"5909784596","A"},{"5909778899","A"},{"5909150024","A"},
				{"5909441122","A"},{"5909669955","A"},{"5909884510","A"},{"5909784596","A"},{"5909778899","A"},{"5909150024","A"},
				{"5909441122","A"},{"5909669955","A"},{"5909884510","A"},{"5909784596","A"},{"5909778899","A"},{"5909150024","A"},
				{"5909441122","A"}};
		
		
		
		table = new JTable(student,head);
		//-------------------------------------------------------------------------วิธีจัดตัวหนังสือให้อยู่ตรงกลาง colomn-----------//
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		
		JScrollPane jp = new JScrollPane(table);
		jp.setPreferredSize(new Dimension(400,500));
		
		JPanel panel = new JPanel();
		panel.setSize(300,300);
		panel.add(jp);
	
		this.add(panel);
		
		JButton cancelBtn = new JButton("Cancel");
		exportBtn = new JButton("Export File");
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(cancelBtn);
		buttonPanel.add(exportBtn);
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		this.add(buttonPanel,BorderLayout.SOUTH);
		
		
		this.setSize(700, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		ExportFileFrame2 tjs = new ExportFileFrame2();

	}

}
