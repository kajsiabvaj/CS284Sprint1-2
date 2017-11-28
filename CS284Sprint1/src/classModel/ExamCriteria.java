package classModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ExamCriteria {
	public class Exam {
		private String type;
		private double max, rate;// rate is a % of score max is a max score

		public Exam(String type, double max, double rate) {
			this.type = type;// ชื่อควิซ
			this.max = max;// คะแนนเต็ม ในแต่ละควิซ
			this.rate = rate;// เปอร์เซ็นที่คิด
		}
	}

	private String subName;// ชื่อวิชา
	private int numOfScore = 0;// คะแนนที่ได้
	private ArrayList<Exam> scoreRate;// เก็บจำนวนสัดส่วนของวิชานั้นๆ เช่น
										// midterm final quize1

	public ExamCriteria() {
		scoreRate = new ArrayList<>();
	}

	public ExamCriteria(String sub, int nos) {
		this.subName = sub;
		numOfScore = nos;
		scoreRate = new ArrayList<>();
	}

	public boolean addRate(String name, double max, double rate) {
		if (max < 0 || rate < 0 || rate > 100) {
			return false;
		} else {
			try {
				scoreRate.add(new Exam(name, max, rate));
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		}
	}

	public boolean setRate(String name, double max, double rate, int index) {
		if (max < 0 || rate < 0 || rate > 100 || index >= scoreRate.size()) {
			return false;
		} else {
			try {
				scoreRate.set(index, new Exam(name, max, rate));
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		}
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public int getNumOfScore() {
		return numOfScore;
	}

	public void setNumOfScore(int numOfScore) {
		this.numOfScore = numOfScore;
	}

	public ArrayList<Exam> getScoreRate() {
		return scoreRate;
	}

	public void setScoreRate(ArrayList<Exam> scoreRate) {
		this.scoreRate = scoreRate;
	}

	public double getRateAt(int index) {
		return scoreRate.get(index).rate;
	}

	public double getMaxAt(int index) {
		return scoreRate.get(index).max;
	}

	public String getTypeAt(int index) {
		return scoreRate.get(index).type;
	}
	public int size(){
		return scoreRate.size();
	}

	public boolean CheckMidAndFinal() {
		if (scoreRate.get(0).rate + scoreRate.get(1).rate >= 50) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFullRate() {
		double full = 0.0;
		for (Exam ex : scoreRate) {
			full += ex.rate;
		}

		if (full == 100) {
			return true;
		} else {
			return false;
		}
	}

	public void writeFile(File f) {
		FileWriter fw;
		try {
			fw = new FileWriter(f, false);
			PrintWriter pw = new PrintWriter(fw, true);
			pw.println(subName + " " + numOfScore);
			for (int i = 0; i < scoreRate.size(); i++) {
				pw.println(scoreRate.get(i).type + " " + scoreRate.get(i).rate + " " + scoreRate.get(i).max);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readFile(File f) {
		try (Scanner sc = new Scanner(f)) {
			if (f.exists()) {
				subName = sc.next();
				numOfScore = sc.nextInt();
				for (int i = 0; i < scoreRate.size(); i++) {
					scoreRate.get(i).type = sc.next();
					scoreRate.get(i).rate = sc.nextDouble();
					scoreRate.get(i).max = sc.nextDouble();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
