import HomePage.HomePage;
import HomePage.StudentHomePage;

import java.util.Scanner;

public class TestRunner {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       HomePage.start();

        System.out.println("3");
       int next = sc.nextInt();

       switch (next){
           case 1:
               System.out.println("1");
               break;
           case 2:
               System.out.println("2");

               break;
           case 3:
               StudentHomePage.homePage();
               break;
           default:
               break;
       }



    }
}
