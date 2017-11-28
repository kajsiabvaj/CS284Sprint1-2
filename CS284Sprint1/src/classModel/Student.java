package classModel;

import java.util.ArrayList;

public class Student {
	private String name;
	private String id;
	private boolean status;
	private ArrayList<String> subName;
	private ArrayList<Score> myScore;

	public Student() {

	}

	public Student(String n, String iD) {
		name = n;
		id = iD;
		subName = new ArrayList<>();
		myScore = new ArrayList<>();
	}

	public void addSubject(String sub) {
		subName.add(sub);
	}

	public boolean addScore(String sub, String typ, double sco, boolean mt, String n) {
		boolean isSubject = false;
		for (String s : subName) {
			if (s.equals(sub)) {
				if (mt == true || sco < 0) {
					myScore.add(new Score(sub, typ, 0, mt, n));
					return false;
				}
				myScore.add(new Score(sub, typ, sco, mt, n));
				isSubject = true;
				return true;
			} else {
				isSubject = false;
			}
		}
		return isSubject;
	}

	public boolean addScore(String sub, String typ, double sco, double netSco, boolean mt, String n) {
		boolean isSubject = false;
		for (String s : subName) {
			if (s.equals(sub)) {
				if (mt == true || sco < 0 || netSco < 0) {
					myScore.add(new Score(sub, typ, 0, 0, mt, n));
					return false;
				}
				myScore.add(new Score(sub, typ, sco, netSco, mt, n));
				isSubject = true;
				return true;
			} else {
				isSubject = false;
			}
		}
		return isSubject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ArrayList<String> getSubName() {
		return subName;
	}

	public double getScoreAt(int index) {
		return myScore.get(index).getScore();
	}

	public double getNetScoreAt(int index) {
		return myScore.get(index).getNetScore();
	}

	public boolean setScoreAt(int index, double score) {

		if (myScore.get(index).isMissTest() == false && score > 0) {
			myScore.get(index).setScore(score);
			return true;
		} else {
			return false;
		}
	}

	public boolean setNetScoreAt(int index, double netScore) {
		if (myScore.get(index).isMissTest() == false && netScore > 0) {
			myScore.get(index).setNetScore(netScore);
			return true;
		} else {
			return false;
		}

	}

	public ArrayList<Score> getMyScore() {
		return myScore;
	}

	public void setMyScore(ArrayList<Score> myScore) {
		this.myScore = myScore;
	}

	public double getScore(String subname, String type) {
		for (Score sc : myScore) {
			if (sc.getSubName().equals(subname) && sc.getType().equals(type)) {
				return sc.getScore();
			}
		}
		return 0;
	}

	public double getNetScore(String subname, String type) {
		for (Score sc : myScore) {
			if (sc.getSubName().equals(subname) && sc.getType().equals(type)) {
				return sc.getNetScore();
			} else
				return 0;
		}
		return 0;
	}
}
