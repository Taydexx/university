package model.tableDisplays;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.university.*;
import java.util.ArrayList;

public class FullTable implements DisplayingTableStrategy {


    public ObservableList<Person> getPeopleObservableList(ArrayList<Person> people) {
        ObservableList<Person> personObservableList = FXCollections.observableArrayList(people);
        return personObservableList;
    }

    @Override
    public TableView getTableFromArrayList(ArrayList<Person> people) {
        TableView<Person> table = TableColumnFactory.getFullTable();
        table.setItems(getPeopleObservableList(people));
        return table;
    }
}
