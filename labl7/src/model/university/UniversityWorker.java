package model.university;

public abstract class UniversityWorker extends Person {
    private String occupation;
    private int seniority;
    private int salary;

    public UniversityWorker(String name, String surname, String pesel, int age, boolean isMale, String occupation, int seniority, int salary) {
        super(name, surname, pesel, age, isMale);
        this.occupation = occupation;
        this.seniority = seniority;
        this.salary = salary;
    }



    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
