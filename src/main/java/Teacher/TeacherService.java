package Teacher;

import java.util.Scanner;

public class TeacherService {
    Scanner sc = new Scanner(System.in);
    TeacherRepository teacher = new TeacherRepository();

    public void createExamDateTable(){
        teacher.createExamDateTable();
    }
    public void createExamDateLessonName(){

        System.out.println("Ders tarihi (yyyy,aa,dd) girin");
        String exam_date = sc.nextLine();
        System.out.println("Ders adi girin");
        String lesson_name = sc.nextLine();

        Examdate examdate = new Examdate();
        teacher.createExamDate(examdate);
    }

    public void updateExamDateLessonName(int id){
        Examdate examdate = teacher.findExamDateLessonName(id);
        if(examdate==null){
            System.out.println("Öğrenci bulunamadı");
        }else {
            System.out.println("Sınav tarihi yyyy,aa,gg");
            String examDate = sc.nextLine();
            System.out.println("Ders adı");
            String lessonName=sc.nextLine();

            examdate.setExam_date(examDate);
            examdate.setLesson_name(lessonName);
            teacher.updateExamDateLessonName(examdate);
        }
    }








}
