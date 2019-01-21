package model.university;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private String name;
    private String surname;
    private String pesel;
    private int age;
    private boolean isMale;

    public Person(String name, String surname, String pesel, int age, boolean isMale) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.age = age;
        this.isMale = isMale;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }
}
