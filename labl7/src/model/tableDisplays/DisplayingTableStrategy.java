package model.tableDisplays;

import javafx.scene.control.TableView;
import model.university.Person;
import java.util.ArrayList;

public interface DisplayingTableStrategy {
    TableView getTableFromArrayList (ArrayList<Person> people);

}
