package HomePage;

import java.util.Scanner;

import AssistantManager.AssistantManagerService;
import Student.StudentService;
import Teacher.TeacherService;


public class StudentHomePage {
    TeacherService teacherService = new TeacherService();
    StudentService studentService = new StudentService();
    AssistantManagerService assistantManagerService = new AssistantManagerService();

    Scanner sc = new Scanner(System.in);

    public void studentHomePage() {
        String ustPanel = "╔═══════════════╗";
        String altPanel = "╚═══════════════╝";
        String s = " ";
        System.out.println(s.repeat(47) + "»»————-　      　————-««");
        System.out.println(s.repeat(46) + "  ÖĞRENCİ BİLGİ SİSTEMİ");
        System.out.println(s.repeat(47) + "»»————-　      　————-««");
        System.out.println();
        System.out.println(s.repeat(5) + ustPanel + s.repeat(12) + ustPanel + s.repeat(12) + ustPanel + s.repeat(12) + ustPanel);
        System.out.println(s.repeat(6) + "1-DERS PROGRAMI" + s.repeat(14) + "2-SINAV NOTLARI" + s.repeat(16) + "3-DUYURULAR" + s.repeat(19) + "4-ÇIKIŞ");
        System.out.println(s.repeat(5) + altPanel + s.repeat(12) + altPanel + s.repeat(12) + altPanel + s.repeat(12) + altPanel);

        int choice = sc.nextInt();

        if(choice == 4 ){

        }
        switch (choice) {
            case 1:
                //ders programı görme
                teacherService.showExamDate();
                break;
            case 2:
                //sınav notları görme
                teacherService.showGrade();
            case 3:
                //duyuruları görme
                assistantManagerService.showAnnouncement();
            case 4:
                //çıkış

            default:
                System.out.println("Yanlış deger girdiniz yeniden deneyin.");
                break;
        }


    }

}
