package AssistantManager;

import java.util.Scanner;


public class AssistantManagerService {
    Scanner sc = new Scanner(System.in);
    AssistantManagerRepository amr = new AssistantManagerRepository();

    public void createClassScheduleTable(){
        amr.createTable();
    }
    public void createAnnouncementTable(){
        System.out.println("Geçmek istediğiniz duyuruyu yazınız");
        amr.createAnnouncementTable(sc.nextLine());
    }
    public void newAnnouncement(){
        System.out.println("Geçmek istediğiniz duyuruyu yazınız");
        amr.newAnnouncement(sc.nextLine());

    }

    public void addClassSchedule(){
        System.out.println("1. ders:");
        String pzt1 = sc.nextLine();
        System.out.println("2. ders:");
        String pzt2 = sc.nextLine();
        System.out.println("3. ders:");
        String pzt3 = sc.nextLine();
        System.out.println("4. ders:");
        String pzt4 = sc.nextLine();
        System.out.println("5. ders:");
        String pzt5 = sc.nextLine();
        System.out.println("6. ders:");
        String pzt6 = sc.nextLine();
        System.out.println("7. ders:");
        String pzt7 = sc.nextLine();

        amr.createClassSchedule(pzt1, pzt2, pzt3, pzt4, pzt5, pzt6, pzt7);
    }
     public void showAnnouncement(){
        amr.showAnnouncement();
     }

}
