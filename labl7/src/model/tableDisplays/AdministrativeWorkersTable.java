package model.tableDisplays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import model.university.AdministrativeWorker;
import model.university.Person;

import java.util.ArrayList;

public class AdministrativeWorkersTable implements DisplayingTableStrategy {
    public ObservableList<Person> getPeopleObservableList(ArrayList<Person> people) {
        ArrayList<AdministrativeWorker> administrativeWorkersArrayList = new ArrayList<>();
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i) instanceof AdministrativeWorker) {
                administrativeWorkersArrayList.add((AdministrativeWorker) people.get(i));
            }
        }
        ObservableList<Person> personObservableList = FXCollections.observableArrayList(administrativeWorkersArrayList);
        return personObservableList;
    }

    @Override
    public TableView getTableFromArrayList(ArrayList<Person> people) {
        TableView<Person> table = TableColumnFactory.getAdministrativeWorkersTable();
        table.setItems(getPeopleObservableList(people));
        return table;
    }
}
