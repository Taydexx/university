package model.tableDisplays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import model.university.Person;

import java.util.ArrayList;

public class GenderIsMaleTable implements DisplayingTableStrategy{
    private boolean genderIsMale;

    public GenderIsMaleTable(boolean genderIsMale) {
        this.genderIsMale = genderIsMale;
    }

    public ObservableList<Person> getPeopleObservableList(ArrayList<Person> people) {
        ArrayList<Person> peopleList = new ArrayList<>();
        for (int i = 0; i < people.size(); i++) {
            if (genderIsMale == people.get(i).isMale()) {
                peopleList.add(people.get(i));
            }
        }
        ObservableList<Person> personObservableList = FXCollections.observableArrayList(peopleList);
        return personObservableList;
    }

    @Override
    public TableView getTableFromArrayList(ArrayList<Person> people) {
        TableView<Person> table = TableColumnFactory.getFullTable();
        table.setItems(getPeopleObservableList(people));
        return table;
    }
}
