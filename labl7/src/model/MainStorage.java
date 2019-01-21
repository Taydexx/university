package model;

import model.university.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class MainStorage implements Serializable {
    private ArrayList<Person> peopleList;
    private HashSet<String> indexSet;
    private HashSet<String> peselSet;
    public MainStorage() {
        peopleList = new ArrayList<>();
        indexSet = new HashSet<>();
        peselSet = new HashSet<>();


    }

    public void sortByName() {
        Collections.sort(peopleList, new NameComparator());
    }


    public void sortBySurname() {
        Collections.sort(peopleList, new SurnameComparator());
    }


    public void sortBySurnameName() {
        Collections.sort(peopleList, new SurnameNameComparator());
    }


    public void sortBySurnameAge() {
        Collections.sort(peopleList, new SurnameAgeComparator());
    }

    public ArrayList<Person> getPeopleList() {
        return peopleList;
    }

    static class NameComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.getName().compareTo(p2.getName());
        }
    }

    static class SurnameComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.getSurname().compareTo(p2.getSurname());
        }
    }

    static class SurnameNameComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            if (p1.getSurname().equals(p2.getSurname())) {
                return p1.getName().compareTo(p2.getName());
            } else {
                return p1.getSurname().compareTo(p2.getSurname());
            }
        }
    }

    static class SurnameAgeComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            if (p1.getSurname().equals(p2.getSurname())) {
                return Integer.compare(p1.getAge(), p2.getAge());
            } else {
                return p1.getSurname().compareTo(p2.getSurname());
            }
        }
    }

    public HashSet<String> getIndexSet() {
        return indexSet;
    }

    public HashSet<String> getPeselSet() {
        return peselSet;
    }
}
