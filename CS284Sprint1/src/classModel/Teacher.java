package classModel;

import java.util.ArrayList;

public class Teacher {
	private String name;
	private String id;
	private ArrayList<String> subName;
	public Teacher(){
		
	}
	public Teacher(String name,String id){
		subName=new ArrayList<>();
		this.name=name;
		this.id=id;
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
	public ArrayList<String> getSubName() {
		return subName;
	}
	public void setSubName(ArrayList<String> subName) {
		this.subName = subName;
	}
	public void addSubject(String name){
		subName.add(name);
	}
}
