package Teacher;

public class Examdate {
    String exam_date;
    String lesson_name;
    /**
     * const
     * */
    public Examdate() {
    }
/**
     * Param const
     * */

    public Examdate(String exam_date, String lesson_name) {
        this.exam_date = exam_date;
        this.lesson_name = lesson_name;
    }

    /**
     * getter- setter
     * */

    public String getExam_date() {
        return exam_date;
    }

    public void setExam_date(String exam_date) {
        this.exam_date = exam_date;
    }

    public String getLesson_name() {
        return lesson_name;
    }

    public void setLesson_name(String lesson_name) {
        this.lesson_name = lesson_name;
    }

    /**
     * to-String
     * */
    @Override
    public String toString() {
        return "Examdate{" +
                "exam_date='" + exam_date + '\'' +
                ", lesson_name='" + lesson_name + '\'' +
                '}';
    }
}
