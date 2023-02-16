package model;

public class Student {
	static int count = 0;
	private int id;
	private String name;
	private String surname;
	private int[] grades;
	private char gender;
	
	public Student(String name, String surname, int[] grades) {
		setName(name);
		setSurname(surname);
		setGrades(grades);
		calculateGender();
		id = count++;
	}
	
	public Student() {
		setName("");
		setSurname("");
		setGrades(new int[] {2,2,2});
		calculateGender();
		id = count++;
	}

	public void setName(String name) {
		this.name = name.matches("[A-Z][a-z]+[sae]") ?  name: "Default";
	}

	public void setSurname(String surname) {
		this.surname = surname.matches("[A-Z][a-z]+[sae]") ? surname: "Default";
	}

	public void setGrades(int[] grades) {
		if (grades != null) {
			this.grades = grades.length==3 ? grades: new int[] {0,0,0};
		}
	}
	private void calculateGender() {
		char lastLetterOfName = name.charAt(name.length()-1);
		if (lastLetterOfName == 'a' || lastLetterOfName == 'e') {this.gender = 'f';}
		else if (lastLetterOfName == 's') {this.gender = 'm';}
		else {this.gender = 'x';}
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public int[] getGrades() {
		return grades;
	}

	public char getGender() {
		return gender;
	}
	public float getAverageGrade() {
		float avg = 0.0f;
		for (int i: grades) {avg+=i;}
		avg /= grades.length;
		return avg;
	}
}
