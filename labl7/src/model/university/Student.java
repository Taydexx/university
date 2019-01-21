package model.university;

import java.util.ArrayList;

public class Student extends Person {
    private String index;
    private CourseRepository courseRepository;
    private boolean erasmusParticipant;

    public Student(String name, String surname, String pesel, int age, boolean isMale, String index, boolean erasmusParticipant) {
        super(name, surname, pesel, age, isMale);
        this.index = index;
        this.erasmusParticipant = erasmusParticipant;
        courseRepository = new CourseRepository();
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public boolean isErasmusParticipant() {
        return erasmusParticipant;
    }

    public void setErasmusParticipant(boolean erasmusParticipant) {
        this.erasmusParticipant = erasmusParticipant;
    }

    public CourseRepository getCourseRepository() {
        return courseRepository;
    }


}
