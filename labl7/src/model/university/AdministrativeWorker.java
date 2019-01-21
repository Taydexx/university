package model.university;

public class AdministrativeWorker extends UniversityWorker {
    private int overtimeHours;

    public AdministrativeWorker(String name, String surname, String pesel, int age, boolean isMale, String occupation, int seniority, int salary, int overtimeHours) {
        super(name, surname, pesel, age, isMale, occupation, seniority, salary);
        this.overtimeHours = overtimeHours;
    }



    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }
}
