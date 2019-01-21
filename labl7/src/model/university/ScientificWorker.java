package model.university;

public class ScientificWorker extends UniversityWorker {
    private int scientificOutputPoints;

    public ScientificWorker(String name, String surname, String pesel, int age, boolean isMale, String occupation, int seniority, int salary, int scientificOutputPoints) {
        super(name, surname, pesel, age, isMale, occupation, seniority, salary);
        this.scientificOutputPoints = scientificOutputPoints;
    }



    public int getScientificOutputPoints() {
        return scientificOutputPoints;
    }

    public void setScientificOutputPoints(int scientificOutputPoints) {
        this.scientificOutputPoints = scientificOutputPoints;
    }
}
