package HomePage;

import AssistantManager.AssistantManagerService;

import java.util.Scanner;

import Student.Student;
import Student.StudentService;
import Teacher.TeacherService;


public class AsistantManagementHomePage {
    StudentService student = new StudentService();
    TeacherService teacher = new TeacherService();
    AssistantManagerService manager = new AssistantManagerService();

    public void asistantManagementHomePage() {

        String ustPanel = "╔═══════════════╗";
        String altPanel = "╚═══════════════╝";
        String s = " ";
        System.out.println(s.repeat(25) + "      »»————-　      　————-««");
        System.out.println(s.repeat(24) + "  MÜDÜR YARDIMCISI BİLGİ SİSTEMİ");
        System.out.println(s.repeat(25) + "      »»————-　      　————-««");
        System.out.println();
        System.out.println(s.repeat(5) + ustPanel + s.repeat(12) + ustPanel + s.repeat(12) + ustPanel + s.repeat(12));
        System.out.println(s.repeat(6) + "1-DUYURULAR" + s.repeat(18) + "2-SINAV NOTLARI" + s.repeat(14) + "3-SINAV TAKVİMİ" + s.repeat(19));
        System.out.println(s.repeat(5) + altPanel + s.repeat(12) + altPanel + s.repeat(12) + altPanel + s.repeat(12));
        System.out.println();
        System.out.println();
        System.out.println(s.repeat(5) + ustPanel + s.repeat(12) + ustPanel + s.repeat(12) + ustPanel);
        System.out.println(s.repeat(3) + "4-ÖĞRENCİ GÜNCELLEME" + s.repeat(12) + "5-DERS PROGRAMİ" + s.repeat(17) + "6-ÇIKIŞ");
        System.out.println(s.repeat(5) + altPanel + s.repeat(12) + altPanel + s.repeat(12) + altPanel);
        int select;
        do {
            Scanner input = new Scanner(System.in);
            select = input.nextInt();
            switch (select) {
                case 1:
                    //duyuruları ekleme
                    manager.newAnnouncement();
                    break;
                case 2:
                    //sinav notlari görme
                    teacher.showGrade();
                    break;
                case 3:
                    //sinav takvimi gorme
                    teacher.showExamDate();
                    break;
                case 4:
                    //ogrenci guncelleme//silme
                    System.out.println("Guncellemek istediğiniz öğrencinin id sini giriniz.");
                    int id = input.nextInt();
                    Student uStudent = student.findStudentById(id);
                    student.updateEnteredStudent(uStudent);
                    break;
                case 5:
                    //ders programi
                    manager.addClassSchedule();
                    break;
                case 6:
                    //cikis
                HomePage hp = new HomePage();
                hp.start();
                break;
            }
        } while (select != 6);

    }
}
