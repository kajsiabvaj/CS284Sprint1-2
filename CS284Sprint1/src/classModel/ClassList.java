package classModel;

import java.util.ArrayList;

public class ClassList {
	private int numOfStudent;
	private ArrayList<Student> studentList;
	private String subName;
	
	public ClassList(){
		
	}
	public ClassList(String sub,int nos){
		subName=sub;
		numOfStudent=nos;
		studentList=new ArrayList<>();
	}
	public void addStudent(String name,String id){
		studentList.add(new Student(name,id));
	}
	public int getNumOfStudent() {
		return numOfStudent;
	}
	public void setNumOfStudent(int numOfStudent) {
		this.numOfStudent = numOfStudent;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	
}
