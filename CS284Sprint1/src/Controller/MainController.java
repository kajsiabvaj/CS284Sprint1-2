package Controller;

import java.awt.Color;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import classModel.ExamCriteria;
import classModel.Score;
import classModel.Student;
import classModel.Subject;
import classModel.Teacher;
import login.LoginFrame;
import student.PreSeeScoreFrame;
import student.ScoreStudentFrame;
import student.StudentFrame;
import teacher.CriteriaFrame;
import teacher.CriteriaFrame2;
import teacher.TeacherFrame;

public class MainController {
	private LoginFrame login;
	private Subject subject;
	private int cnt=0;
	private ArrayList<Score>tscore;

	public MainController() {
		login = new LoginFrame();
		login.teacher.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Teacher user = new Teacher("Teach", "5678");
				login.dispose();
				TeacherFrame teacher = new TeacherFrame();
				teacher.name.setText(user.getName());
				teacher.txt.setText("ยินดีต้อนรับ  อาจารย์  " + user.getName() + "  เข้าสู่ระบบ");
				teacher.btLogout.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController m = new MainController();
						teacher.dispose();
					}
				});
				teacher.btStudentList.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

					}
				});
				teacher.btCriteria.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						CriteriaFrame c = new CriteriaFrame();
						c.nextBtn.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								try {
									int topic = Integer.parseInt(c.cbTopic.getText());
									if (c.cbSubject.getText().equals(""))
										throw new Exception();
									else if (topic <= 0)
										throw new NumberFormatException();
									else {
										subject = new Subject(c.cbSubject.getText(), "");
										CriteriaFrame2 c2 = new CriteriaFrame2(topic, c.cbSubject.getText());
										c2.bntSet.addActionListener(new ActionListener() {
											@Override
											public void actionPerformed(ActionEvent e) {
												int show = JOptionPane.showConfirmDialog(null,
														"คุณต้องการที่จะบันทึกใช่หรือไม่");
												if (show == JOptionPane.CANCEL_OPTION)
													return;
												else if (show == JOptionPane.NO_OPTION) {
													c.dispose();
													c2.dispose();
												} else if (show == JOptionPane.OK_OPTION) {
													cnt++;
													ExamCriteria exam = new ExamCriteria();
													exam.setNumOfScore(topic);
													exam.setSubName(c2.getSubject());
													int t = 0;
													double max, rate;
													String name;
													try {
														for (int i = 0; i < exam.getNumOfScore(); i++) {
															t = i;
															name = c2.type.get(i).getText();
															max = Double.parseDouble(c2.CriteriaScore.get(i).getText());
															rate = Double.parseDouble(c2.percentage.get(i).getText());
															exam.addRate(name, max, rate);
														}
														if (!exam.CheckMidAndFinal())
															throw new Exception();
														if (!exam.isFullRate())
															throw new Exception();
														File f = new File("Criteria_" + exam.getSubName() + ".txt");
														f.createNewFile();
														exam.writeFile(f);
														subject.setExt(exam);
														c.dispose();
														c2.dispose();
													} catch (Exception e2) {
														e2.printStackTrace();
														c2.CriteriaScore.get(t).setBackground(Color.RED);
														c2.percentage.get(t).setBackground(Color.RED);
														c2.CriteriaScore.get(t).setForeground(Color.WHITE);
														c2.percentage.get(t).setForeground(Color.WHITE);
													}
													max = 0;
													rate = 0;
												}
											}
										});
									}

								} catch (NumberFormatException ee) {
									c.cbTopic.setBackground(Color.RED);
									c.cbTopic.setForeground(Color.WHITE);
								} catch (Exception eee) {
									c.cbSubject.setBackground(Color.RED);
									c.cbSubject.setForeground(Color.WHITE);
								}
							}
						});
					}
				});
				//********************************กรอกคะแนน/upload file
			}
		});
		login.student.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				subject=new Subject("CS284","");
				subject.setAvgScore(5.0);
				subject.setMaxScore(20.0);
				subject.setMinScore(2.0);
				tscore=new ArrayList<>();
				tscore.add(new Score("CS284","Quiz1",0,false,"-"));
				cnt++;
				Student user=new Student("Stu","xxxxxxxx");
				user.addSubject("CS284");
				user.addScore("CS284","Quiz",15,false,"-");
				user.setNetScoreAt(0,10,20);
				login.dispose();
				StudentFrame student = new StudentFrame();
				student.lbId.setText(user.getId());
				student.lbName.setText(user.getName());
				if(cnt<=0);
				else{
					for(int i=0;i<cnt;i++){
						student.lbNotice.setText("คะแนน "+tscore.get(i).getType()+" รายวิชา "+tscore.get(i).getSubName()+"ประกาศแล้ว");
					}
				}
				student.bntLogout.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainController m = new MainController();
						student.dispose();
					}
				});
				student.bntScore.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						PreSeeScoreFrame preSee = new PreSeeScoreFrame();
						for(String sub:user.getSubName()){
							preSee.subjectNameCombo.addItem(sub);	
						}
						preSee.quizeNameCombo.setEnabled(false);
						preSee.subjectNameCombo.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								for (Score quiz : user.getMyScore()) {
									if(quiz.getSubName().equals(preSee.subjectNameCombo.getSelectedItem()))
										preSee.quizeNameCombo.addItem(quiz.getType());
								}
								preSee.quizeNameCombo.setEnabled(true);
							}
						});
						preSee.seeScoreBnt.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								preSee.dispose();
								ScoreStudentFrame sf = new ScoreStudentFrame();
								sf.setTitle("คะแนนวิชา"+preSee.subjectNameCombo.getSelectedItem());
								sf.subjectNameLabel.setText("คะแนนวิชา++++"+preSee.subjectNameCombo.getSelectedItem());
								sf.table.setEnabled(false);
								sf.table.getModel().setValueAt(user.getId(),0,0);
								sf.table.getModel().setValueAt(user.getScore((String)preSee.subjectNameCombo.getSelectedItem(),(String)preSee.quizeNameCombo.getSelectedItem())+"",0,1);
								sf.table.getModel().setValueAt(user.getNetScore((String)preSee.subjectNameCombo.getSelectedItem(),(String)preSee.quizeNameCombo.getSelectedItem())+"",0,2);
								sf.table.getModel().setValueAt(subject.getMaxScore()+"",2,0);
								sf.table.getModel().setValueAt(subject.getMinScore()+"",2,1);
								sf.table.getModel().setValueAt(subject.getAvgScore()+"",2,2);
							}
						});
					}
				});
			}
		});
	}

	public static void main(String a[]) {
		MainController m = new MainController();
	}
}