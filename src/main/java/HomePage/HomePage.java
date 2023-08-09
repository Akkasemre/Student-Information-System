package HomePage;

import java.util.Scanner;

public class HomePage {

    public void start() {

        AsistantManagementHomePage asistantManagementHomePage = new AsistantManagementHomePage();
        TeacherHomePage teacherHomePage = new TeacherHomePage();
        StudentHomePage studentHomePage = new StudentHomePage();


        String ustPanel = "╔═══════════════╗";
        String altPanel = "╚═══════════════╝";
        String s = " ";
        System.out.println(s.repeat(47) + "»»————-　      　————-««");
        System.out.println(s.repeat(48) + "  OKUL BİLGİ SİSTEMİ");
        System.out.println(s.repeat(47) + "»»————-　      　————-««");
        System.out.println();


        System.out.println(s.repeat(5) + ustPanel + s.repeat(12) + ustPanel + s.repeat(12) + ustPanel + s.repeat(12) + ustPanel);
        System.out.println(s.repeat(6) + "1-M. YARDIMCISI" + s.repeat(16) + "2-ÖĞRETMEN" + s.repeat(19) + "3-ÖĞRENCİ" + s.repeat(22) + "4-ÇIKIŞ");
        System.out.println(s.repeat(5) + altPanel + s.repeat(12) + altPanel + s.repeat(12) + altPanel + s.repeat(12) + altPanel);

        int select;
        do {
            Scanner input = new Scanner(System.in);
            select = input.nextInt();
            switch (select) {
                case 1:
                    asistantManagementHomePage.asistantManagementHomePage();
                    break;
                case 2:
                    teacherHomePage.teacherHomePage();
                    System.out.println("2");

                    break;
                case 3:
                    studentHomePage.studentHomePage();
                    System.out.println("3");

                    break;
                case 4:
                    System.out.println("İYİ GÜNLER");
                    break;
                default:
                    System.out.println("Farklı bir değer girdiniz. yeniden deneyiniz.");

            }
        } while (select != 4);


    }


}
