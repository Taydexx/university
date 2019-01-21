package model.university;

import java.io.Serializable;

public class Course implements Serializable {
    private String courseShortName;
    private String courseFullName;
    private int ectsPoints;
    private boolean signedFor;

    public Course(String courseShortName, String courseFullName, int ectsPoints) {
        this.courseShortName = courseShortName;
        this.courseFullName = courseFullName;
        this.ectsPoints = ectsPoints;
        signedFor = false;
    }

    public String getCourseShortName() {
        return courseShortName;
    }

    public String getCourseFullName() {
        return courseFullName;
    }

    public int getEctsPoints() {
        return ectsPoints;
    }

    public boolean isSignedFor() {
        return signedFor;
    }

    public void setSignedFor(boolean signedFor) {
        this.signedFor = signedFor;
    }
}
