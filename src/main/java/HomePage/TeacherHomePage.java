package HomePage;

import java.util.Scanner;
import AssistantManager.AssistantManagerService;
import Student.StudentService;
import Teacher.TeacherService;

public class TeacherHomePage {
TeacherService teacherService = new TeacherService();
StudentService studentService = new StudentService();
AssistantManagerService assistantManagerService = new AssistantManagerService();


    public void teacherHomePage(){

        String ustPanel="╔═══════════════╗";
        String altPanel="╚═══════════════╝";
        String s=" ";
        System.out.println(s.repeat(25) + "      »»————-　      　————-««");
        System.out.println(s.repeat(24) + "       ÖĞRETMEN BİLGİ SİSTEMİ");
        System.out.println(s.repeat(25) + "      »»————-　      　————-««");
        System.out.println();
        System.out.println(s.repeat(5) + ustPanel + s.repeat(12) + ustPanel + s.repeat(12) + ustPanel + s.repeat(12) );
        System.out.println(s.repeat(6) + "1-DUYURULAR" + s.repeat(19) + "2-NOT GİRME" + s.repeat(17) + "3-SINAV TAKVİMİ" + s.repeat(19));
        System.out.println(s.repeat(5) + altPanel + s.repeat(12) + altPanel + s.repeat(12) + altPanel + s.repeat(12) );
        System.out.println();
        System.out.println();
        System.out.println(s.repeat(20)+ ustPanel+s.repeat(12)+ustPanel+ s.repeat(12));
        System.out.println(s.repeat(21)+"4-ÖĞRENCİ ARAMA"+s.repeat(18)+"5-ÇIKIŞ");
        System.out.println(s.repeat(20)+ altPanel+s.repeat(12)+altPanel+ s.repeat(12));
        int select;
        do {
            Scanner input = new Scanner(System.in);
            select = input.nextInt();
            switch (select) {
                case 1:
                    //duyuru gorme
                    assistantManagerService.showAnnouncement();
                    break;
                case 2:
                    //not girme
                    System.out.println("1.sınav notu");
                    int grade1 = input.nextInt();
                    input.nextLine();
                    System.out.println("2.sınav notu");
                    int grade2 = input.nextInt();
                    input.nextLine();
                    double avg =(grade1 + grade2) /2;
                    teacherService.addGrade(grade1,grade2,avg);
                    break;
                case 3:
                    //sinav tarihi girme
                    teacherService.createExamDateTable();
                    break;
                case 4:
                    //ogrenci arama
                    System.out.println("Aramak istediğiniz öğrencinin id'sini giriniz.");
                    int id = input.nextInt();
                    studentService.findStudentById(id);
                    break;
                case 5:
                   //cikis
                    HomePage hp = new HomePage();
                    hp.start();
                    break;
            }
        } while (select != 5);
    }
}
