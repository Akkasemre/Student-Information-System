package Teacher;

import Student.Student;

import java.sql.*;
import java.util.Scanner;

public class TeacherRepository {

    private Connection con;
    private Statement st;
    private PreparedStatement prst;

    Scanner sc = new Scanner(System.in);


    /**
     * Database Connection Method
     */
    private void getConnection() {
        try {
            this.con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/std_dtbs", "dev_user", "password");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Statement Method
     */
    private void getStatement() {
        try {
            this.st = con.createStatement();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * PreparedStatement Method
     */
    private void getPreparedStatement(String sql) {
        try {
            this.prst = con.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Created Table
     */

    public void createExamDateTable() {
        getConnection();
        getStatement();
        try {
            st.execute("CREATE TABLE IF NOT EXISTS t_examdate (exam_id serial,exam_date DATE, lesson_name VARCHAR(20))");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                st.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    /**
     * Adding the entered grade to the database table
     * It's prepared for only use with student object
     */

    public void addGrade(int student_id, double note1, double note2) {
        getConnection();
        Student std = new Student();

        String sql = "update t_student set std_note1=?,std_note2=?,std_noteAverage=? where std_id = ?";
        getPreparedStatement(sql);

        double getAverage = (note1 + note2) / 2;

        try {
            prst.setDouble(1, note1);
            prst.setDouble(2, note2);
            prst.setDouble(3, getAverage);
            prst.setDouble(4, student_id);
            int updated = prst.executeUpdate();
            if (updated > 0) {
                System.out.println("İşlem başarı ile gerçekleşti");
            } else {
                System.err.println("Öğrenci bulunamadı");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                prst.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void showGrade() {
        getConnection();
        String sql = "select std_note1, std_note2, std_noteAverage from t_student where id = ?";
        getPreparedStatement(sql);
        System.out.println("Öğrenci id. ");

        try {
            prst.setInt(1, sc.nextInt());
            prst.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                prst.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Creates ExamDate table  for t_examdate table from database
     **/

    public void createExamDate(Examdate examdate) {
        Scanner sc = new Scanner(System.in);
        getConnection();
        String sql = "INSERT INTO t_examdate(exam_date, lesson_name) VALUES (?, ?)";
        getPreparedStatement(sql);

        try {
            prst.setString(1, examdate.getExam_date());
            prst.setString(2, examdate.getLesson_name());
            prst.executeUpdate();
            System.out.println("İşlem başarı ile gerçekleştirildi.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                prst.close();
                con.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * Updates ExamDates and lesson names from database
     */
    public void updateExamDateLessonName(Examdate examdate) {
        getConnection();
        String sql = "update t_examdate set exam_date =?, lesson_name =?";
        getPreparedStatement(sql);

        try {
            prst.setString(1, examdate.exam_date);
            prst.setString(2, examdate.lesson_name);
            int updated = prst.executeUpdate();
            if (updated > 0) {
                System.out.println("Sınav tarihi başarı ile güncellenmiştir.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                prst.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void showExamdate() {
        getConnection();
        String sql = "select * from t_examdate";
        try {
            prst.execute(sql);
        } catch (SQLException e) {
            // SQLException'ı doğrudan işleyin, gerektiğinde loglayın veya hata mesajını kullanıcıya iletebilirsiniz
            System.err.println("Veritabanı hatası: " + e.getMessage());
        } finally {
            try {
                prst.close();
                con.close();
            } catch (SQLException e) {
                System.err.println("Kapatma hatası: " + e.getMessage());
            }
        }
    }


    public Examdate findExamDateLessonName(int id) {
        Examdate examdate = null;
        String sql = "SELECT * FROM t_examdate where id = ?";
        getPreparedStatement(sql);

        try {
            prst.setInt(1, id);
            ResultSet resultSet = prst.executeQuery();
            if (resultSet.next()) {
                examdate = new Examdate();
                examdate.setExam_date(resultSet.getString("exam_date"));
                examdate.setLesson_name(resultSet.getString("lesson_name"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                prst.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return examdate;
    }

    public void listExamDate() {
        getConnection();
        String sql = "Select * from t_examdate";
        getPreparedStatement(sql);
    }

}
