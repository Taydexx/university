package model.university;

import java.io.Serializable;
import java.util.ArrayList;

public class CourseRepository implements Serializable {
    ArrayList<Course> courses;

    public CourseRepository() {
        courses = new ArrayList<>();
        courses.add(new Course("OSK", "Organizacja Systemów Komputerowych", 3));
        courses.add(new Course("PP", "Podstawy programowania", 6));
        courses.add(new Course("FIZ", "Fizyka", 5));
        courses.add(new Course("LOG", "Logika dla informatyków", 4));
        courses.add(new Course("ALG", "Algera i geometria analityczna", 4));
        courses.add(new Course("AM", "Analiza matematyczna", 8));
    }



    @Override
    public String toString() {
        StringBuilder tmpString = new StringBuilder();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).isSignedFor()) {
                tmpString.append(courses.get(i).getCourseShortName());
                tmpString.append(" ");
            }
        }
        return tmpString.toString();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
