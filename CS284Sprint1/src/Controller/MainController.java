package Controller;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

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
import teacher.ExportFileFrame2;
import teacher.FillFrame;
import teacher.ScoreFrame;
import teacher.TeacherFrame;
import teacher.export1;
import teacher.export2;

public class MainController {
	private LoginFrame login;
	private ArrayList<Subject> subject;
	private ArrayList<Score> tscore;
	private int cnt = 0;

	public MainController() {
		//subject = new ArrayList<>();
		login = new LoginFrame();
		login.teacher.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				subject = new ArrayList<>();
				Teacher user = new Teacher("Teach", "5678");// User********************
				login.dispose();
				// subject.add(new Subject("CS284", "-"));//
				// *************************
				TeacherFrame teacher = new TeacherFrame();
				teacher.btExportFile.setEnabled(false);
				teacher.name.setText(user.getName());
				teacher.txt.setText("ยินดีตอนรับ  อาจารย์  " + user.getName() + "  เข้าสู่ระบบ");
				teacher.btExportFile.setEnabled(false);
				teacher.btFillScore.setEnabled(false);
				teacher.btStudentList.setEnabled(false);
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
									cnt++;
									teacher.btFillScore.setEnabled(true);
									if (c.cbSubject.getText().equals(""))
										throw new Exception();
									int topic = Integer.parseInt(c.cbTopic.getText());
									if (topic <= 0)
										throw new NumberFormatException();
									else {
										subject.add(new Subject(c.cbSubject.getText(), ""));
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
															throw new IllegalArgumentException();
														if (!exam.isFullRate())
															throw new ArrayIndexOutOfBoundsException();
														File f = new File("Criteria_" + exam.getSubName() + ".txt");
														f.createNewFile();
														exam.writeFile(f);
														subject.get(cnt - 1).setExt(exam);
														c.dispose();
														c2.dispose();
													} catch (ArrayIndexOutOfBoundsException e3) {
														for (int n = 0; n < c2.percentage.size(); n++) {
															c2.percentage.get(n).setBackground(Color.RED);
															c2.percentage.get(n).setForeground(Color.WHITE);
														}
													} catch (IllegalArgumentException ee) {
														c2.percentage.get(0).setBackground(Color.RED);
														c2.percentage.get(0).setForeground(Color.WHITE);
														c2.percentage.get(1).setBackground(Color.RED);
														c2.percentage.get(1).setForeground(Color.WHITE);
													} catch (Exception e2) {
														// e2.printStackTrace();
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
									c.cbTopic.setBackground(Color.RED);
									c.cbTopic.setForeground(Color.WHITE);
									c.cbSubject.setBackground(Color.RED);
									c.cbSubject.setForeground(Color.WHITE);
								}
							}
						});
					}
				});
				teacher.btFillScore.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// *************************
						// ExamCriteria ext = new ExamCriteria("CS284", 3);
						// ext.addRate("Q1", 100, 50);
						// ext.addRate("Q2", 100, 50);
						// ext.addRate("Q3", 100, 10);
						// subject.get(0).setExt(ext);
						// *************************
						FillFrame fill = new FillFrame();
						fill.name.setText(user.getName());
						fill.cbTopic.setEnabled(false);
						fill.fillScore.setEnabled(false);
						fill.uplodefile.setEnabled(false);
						for (int i = 0; i < subject.size(); i++) {
							fill.cbSubject.addItem(subject.get(i).getName());
						}
						fill.cbSubject.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								fill.cbTopic.removeAllItems();
								for (int t = 0; t < subject.get(fill.cbSubject.getSelectedIndex()).getExt()
										.size(); t++) {
									fill.cbTopic.addItem(
											subject.get(fill.cbSubject.getSelectedIndex()).getExt().getTypeAt(t));
								}
								if (subject.get(fill.cbSubject.getSelectedIndex()).isUpList()) {
									fill.uplodefile.setEnabled(false);
									fill.cbTopic.setEnabled(true);
								} else
									fill.uplodefile.setEnabled(true);
								fill.fillScore.setEnabled(false);
							}
						});
						fill.uplodefile.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								JFileChooser ch = new JFileChooser();
								int temp = ch.showOpenDialog(null);
								if (temp == ch.CANCEL_OPTION)
									;
								else if (temp == ch.ERROR_OPTION)
									;
								else {
									subject.get(fill.cbSubject.getSelectedIndex()).importFile(ch.getSelectedFile(),
											subject.get(fill.cbSubject.getSelectedIndex()).getName());
									subject.get(fill.cbSubject.getSelectedIndex()).writeFile(true);
									subject.get(fill.cbSubject.getSelectedIndex()).setUpList(true);
									for (int i = 0; i < subject.get(fill.cbSubject.getSelectedIndex()).getList()
											.size(); i++) {
										subject.get(fill.cbSubject.getSelectedIndex()).getList().getStudentAt(i)
												.addSubject(subject.get(fill.cbSubject.getSelectedIndex()).getName());
									}
									fill.cbTopic.setEnabled(true);
								}
							}
						});
						fill.cbTopic.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								fill.fillScore.setEnabled(true);
							}
						});
						fill.fillScore.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								Subject ss = subject.get(fill.cbSubject.getSelectedIndex());
								ScoreFrame sf = new ScoreFrame(ss.getList().size());
								sf.pScore.setBorder(new TitledBorder((String) fill.cbTopic.getSelectedItem()));
								for (int i = 0; i < ss.getList().size(); i++) {
									sf.arrId[i].setText(ss.getList().getStudentAt(i).getId());
									sf.arrScoreNet[i].setEditable(false);
								}
								sf.calculator.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										for (int i = 0; i < ss.getList().size(); i++) {
											try {
												if (sf.arrScoreRaw[i].getText().equals("ขส")) {
													sf.arrScoreNet[i].setText("ขส");
												} else {
													if (Double.parseDouble(sf.arrScoreRaw[i].getText()) > ss.getExt()
															.getMaxAt(fill.cbTopic.getSelectedIndex()))
														throw new Exception();
													double temp = ss.calculateNetScore(sf.arrScoreRaw[i].getText(),
															fill.cbTopic.getSelectedIndex());
													sf.arrScoreRaw[i].setForeground(null);
													sf.arrScoreRaw[i].setBackground(Color.WHITE);
													sf.arrScoreNet[i].setText(temp + "");
												}
											} catch (Exception ko) {
												// sf.arrScoreRaw[i].setBackground(Color.RED);
												// sf.arrScoreRaw[i].setForeground(Color.WHITE);
											}
										}
									}
								});
								sf.submit.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										double sco = 0, netSco = 0;
										int cnt = 0;
										for (int i = 0; i < ss.getList().size(); i++) {
											try {
												cnt++;
												if (sf.arrScoreRaw[i].getText().equals("ขส")) {
													ss.getList().getStudentAt(i).addScore(ss.getName(),
															(String) fill.cbTopic.getSelectedItem(), 0, 0, true,
															"misstest");
													sf.arrScoreNet[i].setText("ขส");
												} else {
													sco = Double.parseDouble(sf.arrScoreRaw[i].getText());
													if (sco > ss.getExt().getMaxAt(fill.cbTopic.getSelectedIndex()))
														throw new Exception();
													netSco = ss.calculateNetScore(sf.arrScoreRaw[i].getText(),
															fill.cbTopic.getSelectedIndex());
													if (sco < 0 || sco > ss.getExt()
															.getMaxAt(fill.cbTopic.getSelectedIndex()))
														throw new Exception();
													ss.getList().getStudentAt(i).addScore(ss.getName(),
															(String) fill.cbTopic.getSelectedItem(), sco, netSco, false,
															"-");
												}
											} catch (Exception kpo) {
												sf.arrScoreRaw[i].setBackground(Color.RED);
												sf.arrScoreRaw[i].setForeground(Color.WHITE);
												cnt--;
											}
										}
										if (cnt >= ss.getList().size()) {
											ss.plusNumOfAddScore();
											if (ss.getNumOfAddScore() >= ss.getExt().size())
												teacher.btExportFile.setEnabled(true);
											ss.writeFile(false);
											sf.dispose();
											fill.dispose();
										}
									}
								});
								sf.save.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										double sco, netSco;
										int cnt = 0;
										for (int i = 0; i < ss.getList().size(); i++) {
											try {
												cnt++;
												if (sf.arrScoreRaw[i].getText().equals("ขส")) {
													ss.getList().getStudentAt(i).addScore(ss.getName(),
															(String) fill.cbTopic.getSelectedItem(), 0, 0, true,
															"misstest");
													sf.arrScoreNet[i].setText("ขส");
												} else {
													sco = Double.parseDouble(sf.arrScoreRaw[i].getText());
													if (sco > ss.getExt().getMaxAt(fill.cbTopic.getSelectedIndex()))
														throw new Exception();
													netSco = ss.calculateNetScore(sf.arrScoreRaw[i].getText(),
															fill.cbTopic.getSelectedIndex());
													if (sco < 0 || sco > ss.getExt()
															.getMaxAt(fill.cbTopic.getSelectedIndex()))
														throw new Exception();
													ss.getList().getStudentAt(i).addScore(ss.getName(),
															(String) fill.cbTopic.getSelectedItem(), sco, netSco, false,
															"-");
												}
											} catch (Exception kpo) {
												sf.arrScoreRaw[i].setBackground(Color.RED);
												sf.arrScoreRaw[i].setForeground(Color.WHITE);
												cnt--;
											}
										}
										if (cnt >= ss.getList().size()) {
											ss.plusNumOfAddScore();
											if (ss.getNumOfAddScore() >= ss.getExt().size())
												teacher.btExportFile.setEnabled(true);
											ss.writeFile(false);
										} else if (true) {
											ss.writeFile(false);
											if (ss.checkFile())
												teacher.btExportFile.setEnabled(true);
										}
									}
								});
							}
						});
					}
				});
				teacher.btExportFile.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						export1 e1 = new export1();
						e1.export.setEnabled(false);
						e1.review.setEnabled(false);
						for (int i = 0; i < subject.size(); i++) {
							e1.pick_subject.addItem(subject.get(i).getName());
						}
						e1.cancle.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								e1.dispose();
							}
						});
						e1.pick_subject.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								e1.export.setEnabled(true);
								e1.review.setEnabled(true);
							}
						});
						e1.review.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								Subject ss = subject.get(e1.pick_subject.getSelectedIndex());
								export2 e2 = new export2(ss.getList().size());
								for (int i = 0; i < ss.getList().size(); i++) {
									e2.arrId[i].setText(ss.getList().getStudentAt(i).getId());
									e2.arrGrade[i].setEditable(false);
									e2.arrGrade[i]
											.setText(ss.checkGrade(ss.sumScoreOfStudent(ss.getList().getStudentAt(i))));
								}
								e2.cancel.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										e2.dispose();
									}
								});
							}
						});
						e1.export.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								Subject ss = subject.get(e1.pick_subject.getSelectedIndex());
								ExportFileFrame2 ef = new ExportFileFrame2();
								ef.table.setEnabled(false);
								DefaultTableModel model = new DefaultTableModel(ef.head, ss.getList().size());
								ef.table.setModel(model);
								DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
								centerRenderer.setHorizontalAlignment(JLabel.CENTER);
								ef.table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
								ef.table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
								for (int i = 0; i < ss.getList().size(); i++) {
									ef.table.getModel().setValueAt(ss.getList().getStudentAt(i).getId(), i, 0);
								}
								for (int j = 0; j < ss.getList().size(); j++) {
									ef.table.getModel().setValueAt(
											ss.checkGrade(ss.sumScoreOfStudent(ss.getList().getStudentAt(j))), j, 1);
								}

								ef.exportBtn.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										int show = JOptionPane.showConfirmDialog(null,
												"คุณต้องการที่จะขอใบส่งเกรดใช่หรือไม่");
										if (show == JOptionPane.CANCEL_OPTION)
											return;
										else if (show == JOptionPane.NO_OPTION) {
											e1.dispose();
											ef.dispose();
										} else if (show == JOptionPane.OK_OPTION) {
											// *******************
											JFileChooser chooser = new JFileChooser();
											int temp = chooser.showSaveDialog(null);
											if (temp == chooser.CANCEL_OPTION)
												;
											else if (temp == chooser.ERROR_OPTION)
												;
											else {
												ss.exportFile(chooser.getSelectedFile());
											}
											e1.dispose();
											ef.dispose();
										}
									}
								});
							}
						});
					}
				});
			}
		});
		login.student.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// **********************************
				subject.add(new Subject("CS284", "-"));
				subject.get(0).setAvgScore(5.0);
				subject.get(0).setMaxScore(20.0);
				subject.get(0).setMinScore(2.0);
				tscore = new ArrayList<>();
				tscore.add(new Score("CS284", "Quiz1", 0, false, "-"));
				// **********************************
				Student user = new Student("Stu", "xxxxxxxx");// User********************
				user.addSubject("CS284");
				user.addScore("CS284", "Quiz", 15, 10, false, "-");
				user.addScore("CS284", "Final", 50, 40, false, "-");
				user.setNetScoreAt(0, 10);
				// **********************************
				login.dispose();
				StudentFrame student = new StudentFrame();
				student.lbId.setText(user.getId());
				student.lbName.setText(user.getName());
				student.lbNotice.setText("คะแนน " + tscore.get(tscore.size() - 1).getType() + " รายวิชา "
						+ tscore.get(tscore.size() - 1).getSubName() + "ประกาศแล้ว");
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
						preSee.seeScoreBnt.setEnabled(false);
						for (String sub : user.getSubName()) {
							preSee.subjectNameCombo.addItem(sub);
						}
						preSee.quizeNameCombo.setEnabled(false);
						preSee.subjectNameCombo.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								preSee.quizeNameCombo.removeAllItems();
								for (Score quiz : user.getMyScore()) {
									if (quiz.getSubName().equals(preSee.subjectNameCombo.getSelectedItem()))
										preSee.quizeNameCombo.addItem(quiz.getType());
								}
								preSee.quizeNameCombo.addItem("คะแนนทั้งหมด");
								preSee.quizeNameCombo.setEnabled(true);
								preSee.seeScoreBnt.setEnabled(false);
							}
						});
						preSee.quizeNameCombo.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								preSee.seeScoreBnt.setEnabled(true);
							}
						});
						preSee.seeScoreBnt.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								preSee.dispose();
								if (preSee.quizeNameCombo.getSelectedItem().equals("คะแนนทั้งหมด")) {
									// **************************
									ScoreStudentFrame sf = new ScoreStudentFrame();
									sf.setTitle("คะแนนวิชา" + preSee.subjectNameCombo.getSelectedItem());
									sf.subjectNameLabel
											.setText("คะแนนวิชา" + preSee.subjectNameCombo.getSelectedItem());
									sf.table.setEnabled(false);
									int cn = 0;
									ArrayList<Score> s = new ArrayList<>();
									for (int i = 0; i < user.getMyScore().size(); i++) {
										if (user.getMyScore().get(i).getSubName().equals(
												subject.get(preSee.subjectNameCombo.getSelectedIndex()).getName())) {
											cn++;
											s.add(user.getMyScore().get(i));
										}
									}
									String header[] = { "หัวข้อ", "คะแนนดิบ", "คะแนนสุทธิ" };
									DefaultTableModel model = new DefaultTableModel(header, cn);
									sf.table.setModel(model);
									sf.table.getColumnModel().getColumn(0).setPreferredWidth(300);
									sf.table.getColumnModel().getColumn(1).setPreferredWidth(190);
									sf.table.getColumnModel().getColumn(2).setPreferredWidth(190);
									DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
									centerRenderer.setHorizontalAlignment(JLabel.CENTER);
									for (int i = 0; i < cn; i++) {
										sf.table.getModel().setValueAt(preSee.quizeNameCombo.getItemAt(i), i, 0);
									}
									for (int i = 0; i < cn; i++) {
										sf.table.getModel().setValueAt(s.get(i).getScore(), i, 1);
										sf.table.getModel().setValueAt(s.get(i).getNetScore(), i, 2);
									}
									// ***************************
								} else {
									ScoreStudentFrame sf = new ScoreStudentFrame();
									sf.setTitle("คะแนนวิชา" + preSee.subjectNameCombo.getSelectedItem());
									sf.subjectNameLabel
											.setText("คะแนนวิชา" + preSee.subjectNameCombo.getSelectedItem());
									sf.table.setEnabled(false);
									sf.table.getModel().setValueAt(user.getId(), 0, 0);
									sf.table.getModel()
											.setValueAt(
													user.getScore((String) preSee.subjectNameCombo.getSelectedItem(),
															(String) preSee.quizeNameCombo.getSelectedItem()) + "",
													0, 1);
									sf.table.getModel()
											.setValueAt(
													user.getNetScore((String) preSee.subjectNameCombo.getSelectedItem(),
															(String) preSee.quizeNameCombo.getSelectedItem()) + "",
													0, 2);
									sf.table.getModel().setValueAt(subject.get(0).getMaxScore() + "", 2, 0);
									sf.table.getModel().setValueAt(subject.get(0).getMinScore() + "", 2, 1);
									sf.table.getModel().setValueAt(subject.get(0).getAvgScore() + "", 2, 2);
								}
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