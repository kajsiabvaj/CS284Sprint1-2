package classModel;


public class Score {
	private String subName;
	private String type;
	private double score,netScore;
	private boolean missTest;
	private String note;
	public Score(){
		
	}
	public Score(String sub,String typ,double sco,boolean mt,String n){
		subName=sub;
		type=typ;
		missTest=mt;
		note=n;
		score=sco;
	}
	public Score(String sub,String typ,boolean mt,String n){
		subName=sub;
		type=typ;
		missTest=mt;
		note=n;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public double getNetScore() {
		return netScore;
	}
	public void setNetScore(double netScore) {
		this.netScore = netScore;
	}
	public boolean isMissTest() {
		return missTest;
	}
	public void setMissTest(boolean missTest) {
		this.missTest = missTest;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
