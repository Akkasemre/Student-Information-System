package HomePage;

import java.util.Scanner;

public class HomePage {
  public static void start(){
      String ustPanel="╔═══════════════╗";
      String altPanel="╚═══════════════╝";
      String s=" ";
      System.out.println(s.repeat(47)+ "»»————-　      　————-««");
      System.out.println(s.repeat(48)+"  OKUL BİLGİ SİSTEMİ");
      System.out.println(s.repeat(47)+"»»————-　      　————-««");
      System.out.println();


      System.out.println(s.repeat(5)+ ustPanel+ s.repeat(12) + ustPanel + s.repeat(12)+ ustPanel+s.repeat(12)+ ustPanel);
      System.out.println(s.repeat(6)+"1-M. YARDIMCISI"+ s.repeat(16)+ "2-ÖĞRETMEN"+ s.repeat(19)+"3-ÖĞRENCİ"+s.repeat(22)+"4-ÇIKIŞ");
      System.out.println(s.repeat(5)+ altPanel+ s.repeat(12) + altPanel + s.repeat(12)+ altPanel+ s.repeat(12)+ altPanel);

      int select;
      do {
          Scanner input= new Scanner(System.in);
          select= input.nextInt();
          switch (select){
              case 1:
                  //mudur yardimcisi sayfasi
                  break;
              case 2:
                  //ogretmen sayfasi
                  break;
              case 3:
            StudentHomePage.homePage();
                break;
              case 4:
                  System.out.println("İYİ GÜNLER");
              default:

          }
      }while (select!=4);



  }



}
