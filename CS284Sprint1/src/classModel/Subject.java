package classModel;

import java.util.ArrayList;

public class Subject {
	private String name;
	private String information;
	private ArrayList<Teacher> teacher;
	private ExamCriteria ext;
	private ClassList list;
	private double maxScore,minScore,avgScore;
	
	public Subject(){
		
	}
	
	public Subject(String n,String in){
		name=n;
		information=in;
		teacher=new ArrayList<>();
	}

//	public void calMaxScore();  help me plsssssssssssssss
//	public void calMinScore();
//	public void calAvgScore();
//	public void createScoreForm(); ****create score form to send grade
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public double getMaxScore() {
		return maxScore;
	}
	public void setMaxScore(double maxScore) {
		this.maxScore = maxScore;
	}
	public double getMinScore() {
		return minScore;
	}
	public void setMinScore(double minScore) {
		this.minScore = minScore;
	}
	public double getAvgScore() {
		return avgScore;
	}
	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}

	public ExamCriteria getExt() {
		return ext;
	}

	public void setExt(ExamCriteria ext) {
		this.ext = ext;
	}

}
