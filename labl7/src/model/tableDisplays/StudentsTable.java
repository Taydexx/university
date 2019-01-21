package model.tableDisplays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import model.university.*;

import java.util.ArrayList;

public class StudentsTable implements DisplayingTableStrategy {


    public ObservableList<Person> getPeopleObservableList(ArrayList<Person> people) {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i) instanceof Student) {
                studentArrayList.add((Student) people.get(i));
            }
        }
        ObservableList<Person> personObservableList = FXCollections.observableArrayList(studentArrayList);
        return personObservableList;
    }

    @Override
    public TableView getTableFromArrayList(ArrayList<Person> people) {
        TableView<Person> table = TableColumnFactory.getStudentsTable();
        table.setItems(getPeopleObservableList(people));
        return table;
    }
}
