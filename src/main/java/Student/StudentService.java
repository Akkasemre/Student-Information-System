package Student;

import java.util.Scanner;

public class StudentService {
    StudentRepository repository = new StudentRepository();
    Scanner sc = new Scanner(System.in);

    /**
     * Calls Create Table method from repository
     */
    public void createTable() {
        repository.createTable();
    }

    /**
     *Creates  new student
     * */
    public void createStudent(){

        System.out.println("Ad : ");
        String std_name=sc.nextLine().trim();

        System.out.println("Soyad : ");
        String std_lastname=sc.nextLine().trim();

        System.out.println("Adres : ");
        String std_address=sc.nextLine().trim();

        Student newStudent = new Student(std_name,std_lastname,std_address);
        repository.createStudent(newStudent);
    }

    /**
     * Lists entire student
     * */

    public void listAllStudent(){
        repository.listAllStudent();
    }

    /**
     *Deletes entered id student from database
     * */
    public void deleteEnteredStudent(int id){
        repository.deleteStudent(id);
    }




    /***/
    /***/

}
