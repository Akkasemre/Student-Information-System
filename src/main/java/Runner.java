import Student.StudentService;
import Teacher.TeacherService;

public class Runner {
    public static void main(String[] args) {

        StudentService service = new StudentService();
        TeacherService tService = new TeacherService();
        service.createTable();
        tService.createExamDateTable();
    }
}
