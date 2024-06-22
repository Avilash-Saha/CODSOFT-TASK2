
import java.util.*;

class subject{

    private String subjectname = null;
    private int marks = -1;

    subject(String subjectname, int marks) {
        this.subjectname = subjectname;
        this.marks = marks;
    }

    int getmarks(){
        return this.marks;
    }
    String getsubject(){
        return this.subjectname;
    }


}


class student{
    private String studentname = null;
    student(String studentname){
        this.studentname = studentname;
    }
    private ArrayList<subject> subjectList = new ArrayList<subject>();
    void addSubject(subject sub){
        subjectList.add(sub);
    }

    String getStudentName(){
        return this.studentname;
    }
    int getAllSubjectMarks(){
        int sum = 0;
        for(int i = 0; i < subjectList.size(); i++){
            sum += subjectList.get(i).getmarks();
        }
        return sum;
    }
    int getTotalSubjects(){
        return subjectList.size();
    }
    int getMarksforASubject(String subject){
        for(int j = 0; j < subjectList.size(); j++){
            if(subject.equals(subjectList.get(j).getsubject())){
                return subjectList.get(j).getmarks();
            }
        }
        return 0;
    
    }

}



public class gradeCalculator{

    static int getTotalMarks(student studnt){
        return studnt.getAllSubjectMarks();
    }

    static float getAvg(student studnt){
        return (float)studnt.getAllSubjectMarks()/(float)studnt.getTotalSubjects();
    }

    static char getGrade(student studnt){
        float avgMarks = getAvg(studnt);
        if(avgMarks >= 90){
            return 'A';
        }
        else if(avgMarks >= 80 && avgMarks < 90){
            return 'B';
        }
        else if(avgMarks >= 70 && avgMarks < 80){
            return 'c';
        }
        else if(avgMarks >= 60 && avgMarks < 70){
            return 'D';
        }
        else if(avgMarks >= 50 && avgMarks < 60){
            return 'E';
        }
        return 'F';

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student name:");
        String studentname = sc.nextLine();
        student newStudent = new student(studentname);

        char choice;
        do { 
            String buffer = sc.nextLine();
            System.out.println("Enter Subject Name:");
            String subject = sc.nextLine();
            System.out.println("Enter Subject Marks:");
            int submarks = sc.nextInt();
            subject newSubject = new subject(subject,submarks);
            newStudent.addSubject(newSubject);
            System.out.println("Add more subjects ? Y/N: ");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');

        System.out.println("Student Name : " + newStudent.getStudentName());

        System.out.println("Total marks out of " + newStudent.getTotalSubjects() * 100 + " : " + getTotalMarks(newStudent));
        System.out.println("Average marks : " + getAvg(newStudent));
        System.out.println("Grade : " + getGrade(newStudent));
    }

    
}