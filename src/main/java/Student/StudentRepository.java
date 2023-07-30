package Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private Connection con;
    private Statement st;
    private PreparedStatement prst;


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
     * Creates Table to Database
     */
    public void createTable() {
        getConnection();
        getStatement();
        try {
            st.execute("CREATE TABLE IF NOT EXISTS t_student(std_id serial, std_no int, std_name varchar(50), std_lastname varchar(50), std_address varchar(50), std_note1 int, std_note2 int, std_noteAverage float)");
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
     * Creates Student add to database
     * */

    public void createStudent(Student student) {
        getConnection();
        String sql = "insert into t_student(std_name,std_lastname,std_address values (?,?,?))";
        getPreparedStatement(sql);

        try {
            prst.setString(1, student.getStd_name());
            prst.setString(2, student.getStd_lastname());
            prst.setString(3, student.getStd_address());
            prst.executeUpdate();
            System.out.println("Kayıt işlemi başarılı.");
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
     * Lists entire student from database table

     * */
//(std_id serial, std_no int, std_name varchar(50), std_lastname varchar(50), std_address varchar(50), std_note1 int, std_note2 int, std_noteAverage float)");
    public void listAllStudent(){
        getConnection();
        getStatement();
        String sql ="select * from t_student";

        try{
            ResultSet resultset = st.executeQuery(sql);
            System.out.println("+"+"-".repeat(80)+"+");
            System.out.printf("|%-5s | %-20s |%-20s |%-40s |%-5s | %-5s |%-5s \n","Ögrenci no", "Öğrenci Adı","Öğrenci soyadı","Öğrenci adresi","1.sınav","2.sınav","sınav ortalaması");
            while (resultset.next()){
                System.out.printf("|%-5d | %-20s |%-20s |%-40s |%-5d | %-5d |%-5d \n" +
                        resultset.getInt("std_no"),
                        resultset.getString("std_name"),
                        resultset.getString("std_lastname"),
                        resultset.getString("std_address"),
                        resultset.getInt("std_note1"),
                        resultset.getInt("std_note2"),
                        resultset.getDouble("std_noteAverage")
                );
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally{
            try {
                st.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Deletes entered student from database
     * */

    public void deleteStudent(int id){
        getConnection();
        String sql = "delete from t_student where id=?";
        getPreparedStatement(sql);

        try{
            prst.setInt(1,id);
            int deleted = prst.executeUpdate();
            if(deleted>0){
                System.out.println("id : "+id+" kayıtlı öğrenci sistemden silinmiştir.");
            }else {
                System.err.println("id : "+id+" Olan kayıtlı bir öğrenci bulunamamıştır.");
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally{
            try {
                prst.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * changes the information of the entered student from the database
     * */

    public void updateStudent(Student student){
        getConnection();
        String sql = "update t_student set std_name =? ,set std_lastname = ?, set std_address = ?";
        getPreparedStatement(sql);

        try{
            prst.setString(1,student.std_name);
            prst.setString(2, student.std_lastname);
            prst.setString(3, student.std_address);
            int updated = prst.executeUpdate();
            if(updated >0){
                System.out.println("Kayıt başarı ile güncellenmiştir");
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally{
            try {
                prst.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * List entered student from database
     * */

    public List<Student> findStudentByNameOrLastName(String nameOrLastName){
        List<Student> list = new ArrayList<>();
        getConnection();

        String searched = "%"+nameOrLastName+"%";
        String sql = "select * from t_student where std_name ilike ? or std_lastname ilike ? ";
        getPreparedStatement(sql);

        try{
            prst.setString(1,searched);
            prst.setString(2,searched);
            ResultSet resultset = prst.executeQuery();
            while(resultset.next()){
                Student student = new Student();
                student.setStd_no(resultset.getInt("std_id"));
                student.setStd_name(resultset.getString("std_name"));
                student.setStd_lastname(resultset.getString("std_lastname"));
                student.setStd_address(resultset.getString("std_address"));

                list.add(student);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally{
            try {
                prst.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return list;
    }

    /**
     * find entered student by id from database
     * */
    public Student findStudentById(int id) {
        Student student = null;
        String sql = "SELECT * FROM t_student where id =?";
        getPreparedStatement(sql);
        try {
            prst.setInt(1, id);
            ResultSet resultSet = prst.executeQuery();
            if (resultSet.next()) {
                student = new Student();
                student.setStd_id(resultSet.getInt("id"));
                student.setStd_no(resultSet.getInt("std_no"));
                student.setStd_name(resultSet.getString("std_name"));
                student.setStd_lastname(resultSet.getString("std_lastname"));
                student.setStd_address(resultSet.getString("std_address"));
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
        return student;
    }





















































































































}
