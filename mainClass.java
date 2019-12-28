import java.io.*;
import java.util.*;

class Student
{
  int studentID,semester;
  String studentName;
  String departmentName;
  Student(int studentID, String studentName, String departmentName, int semester) //constructor to intialize the variables
  {
   this.studentID = studentID;
   this.studentName = studentName;
   this.departmentName = departmentName;
   this.semester = semester;
  }
  void display()
  {
    System.out.println("StudentID is : "+studentID);
    System.out.println("Name od the Student is : "+studentName);
    System.out.println("Department Name is : "+departmentName);
    System.out.println("Semester Number is : "+semester);
  }
}
class StudentReportCard extends Student  //extending the student class using Inheritance concept
{
  int total_subjects,points_earned;
  float gpa,cgpa;
  StudentReportCard(int studentID,String studentName,String departmentName,int semester, int total_subjects, int points_earned)
  {
    super(studentID,studentName,departmentName,semester); //reusing the parent class variables in the child class 
   this.total_subjects = total_subjects;
    this.points_earned = points_earned;
  }
  public float gpaCalculator()
  {
    gpa = (total_subjects*points_earned)/7;
    return 0;
    
  }
  public float cgpaCalculator()
  {
    cgpa = gpa/semester;
    return 0;
  }
  void display()
  {
   super.display();  // reusing the parent method in child class
   System.out.println("GPA of the current sem : "+gpa);
   System.out.println("Total CGPA as of now : "+cgpa);
  }
}
 class mainClass
 {
  public static void main(String args[])
  {
  Scanner sc = new Scanner(System.in);
  int studentID,semester;
  String studentName,departmentName;
  int total_subjects,points_earned;
  System.out.println("Please enter the student name : ");
  studentName = sc.nextLine();
  System.out.println("Please enter the studentID : ");
  studentID = sc.nextInt();
  sc.nextLine();  // to avoid the String escape. if we dont use this in wont allow us to take the departmentName at runtime
  System.out.println("Please enter the student Department name : ");
  departmentName = sc.nextLine();
  System.out.println("Please enter the student current semester number : ");
  semester = sc.nextInt();
  System.out.println("Please enter total_subjects number : ");
  total_subjects = sc.nextInt();
  System.out.println("Please enter the student earned points : ");
  points_earned = sc.nextInt();
  boolean result = validateInputs(studentID,semester,total_subjects,points_earned);
 
  if(result)
  {
    StudentReportCard reportObject = new StudentReportCard(studentID,studentName,departmentName,semester,total_subjects,points_earned);
    reportObject.gpaCalculator();
    reportObject.cgpaCalculator();
    reportObject.display();
  }
  else
  System.out.println("Invalid Request");
  }

  // Below function is used to validate the inputs

  public static boolean validateInputs(int studentID,int semester,int total_subjects,int points_earned)
  {
    int temp = Integer.toString(studentID).length();
    if((semester>=1 || semester<=7) && (total_subjects>=1 || total_subjects<=7) && (points_earned>=1 || points_earned<=7) && (temp == 4))
    {
     
      return true;
    }
    else
    return false;
  }

}

   