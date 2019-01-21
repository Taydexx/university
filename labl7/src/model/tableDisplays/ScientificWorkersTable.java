package model.tableDisplays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import model.university.Person;
import model.university.ScientificWorker;

import java.util.ArrayList;

public class ScientificWorkersTable implements DisplayingTableStrategy{
    public ObservableList<Person> getPeopleObservableList(ArrayList<Person> people) {
        ArrayList<ScientificWorker> scientificWorkersArrayList = new ArrayList<>();
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i) instanceof ScientificWorker) {
                scientificWorkersArrayList.add((ScientificWorker) people.get(i));
            }
        }
        ObservableList<Person> personObservableList = FXCollections.observableArrayList(scientificWorkersArrayList);
        return personObservableList;
    }

    @Override
    public TableView getTableFromArrayList(ArrayList<Person> people) {
        TableView<Person> table = TableColumnFactory.getScientificWorkersTable();
        table.setItems(getPeopleObservableList(people));
        return table;
    }
}
