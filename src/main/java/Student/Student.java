package Student;

public class Student {
    int std_id;
    int std_no;
    String std_name;
    String std_lastname;
    String std_address;
    double std_note1;
    double std_note2;
    double std_noteAverage;

    /**
     * const
     */
    public Student() {
    }

    /**
     * param const
     */
    public Student(int std_id, int std_no, String std_name, String std_lastname, String std_address, int std_note1, int std_note2, double std_noteAverage) {
        this.std_id = std_id;
        this.std_no = std_no;
        this.std_name = std_name;
        this.std_lastname = std_lastname;
        this.std_address = std_address;
        this.std_note1 = std_note1;
        this.std_note2 = std_note2;
        this.std_noteAverage = std_noteAverage;
    }

    /**
     * Student Home Page param const
     */
    public Student(int std_no, String std_name, String std_lastname, int std_note1, int std_note2, double std_noteAverage) {
        this.std_no = std_no;
        this.std_name = std_name;
        this.std_lastname = std_lastname;
        this.std_note1 = std_note1;
        this.std_note2 = std_note2;
        this.std_noteAverage = std_noteAverage;
    }

    /**
     * Student Register Param Const
     */
    public Student(String std_name, String std_lastname, String std_address) {
        this.std_name = std_name;
        this.std_lastname = std_lastname;
        this.std_address = std_address;
    }

    /**
     * Getter - Setter
     */
    public int getStd_id() {
        return std_id;
    }

    public void setStd_id(int std_id) {
        this.std_id = std_id;
    }

    public int getStd_no() {
        return std_no;
    }

    public void setStd_no(int std_no) {
        this.std_no = std_no;
    }

    public String getStd_name() {
        return std_name;
    }

    public void setStd_name(String std_name) {
        this.std_name = std_name;
    }

    public String getStd_lastname() {
        return std_lastname;
    }

    public void setStd_lastname(String std_lastname) {
        this.std_lastname = std_lastname;
    }

    public String getStd_address() {
        return std_address;
    }

    public void setStd_address(String std_address) {
        this.std_address = std_address;
    }

    public double getStd_note1() {
        return std_note1;
    }

    public void setStd_note1(double std_note1) {
        this.std_note1 = std_note1;
    }

    public double getStd_note2() {
        return std_note2;
    }

    public void setStd_note2(double std_note2) {
        this.std_note2 = std_note2;
    }

    public double getStd_noteAverage() {
        return std_noteAverage;
    }

    public void setStd_noteAverage(double std_noteAverage) {
        this.std_noteAverage = std_noteAverage;
    }

    /**
     * To-String
     */
    @Override
    public String toString() {
        return "Student{" + "std_id=" + std_id + ", std_no=" + std_no + ", std_name='" + std_name + '\'' + ", std_lastname='" + std_lastname + '\'' + ", std_address='" + std_address + '\'' + ", std_note1=" + std_note1 + ", std_note2=" + std_note2 + ", std_noteAverage=" + std_noteAverage + '}';
    }
}
