package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.*;
import model.tableDisplays.*;
import model.university.*;

import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class MainViewController {
    @FXML
    private Button sortByNameButton;

    @FXML
    private Button sortBySurnameButton;

    @FXML
    private Button sortBySurnameNameButton;

    @FXML
    private Button sortBySurnameAgeButton;

    @FXML
    private Button showAllButton;

    @FXML
    private Button showStudentsButton;

    @FXML
    private Button showScientificWorkersButton;

    @FXML
    private Button showAdministrativeWorkersButton;

    @FXML
    private Button showMenButton;

    @FXML
    private Button showWomenButton;

    @FXML
    private TextField indexOrPeselTextField;

    @FXML
    private Button searchByIndexButton;

    @FXML
    private Button searchByPeselButton;

    @FXML
    private Button deleteByPeselButton;

    @FXML
    private AnchorPane fullListAnchorPane;

    @FXML
    private TextField indexSearchForCourse;

    @FXML
    private Button searchIndexForCoursesButton;

    @FXML
    private Label studentNameLabel;

    @FXML
    private Label studentSurnameLabel;

    @FXML
    private Label studentPeselLabel;

    @FXML
    private Label studentAgeLabel;

    @FXML
    private Label studentGenderLabel;

    @FXML
    private Label studentIndexLabel;

    @FXML
    private Label studentErasmusParticipantLabel;

    @FXML
    private AnchorPane courseManagementCoursesAnchorPane;

    @FXML
    private CheckBox oskChecbkox;

    @FXML
    private CheckBox ppChecbkox;

    @FXML
    private CheckBox fizChecbkox;

    @FXML
    private CheckBox logChecbkox;

    @FXML
    private CheckBox algChecbkox;

    @FXML
    private CheckBox amChecbkox;

    @FXML
    private Label indexToSaveLabel;

    @FXML
    private Button courseManagementIndexButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button loadButton;

    @FXML
    private TextField addPersonNameTextField;

    @FXML
    private TextField addPersonSurnameTextField;

    @FXML
    private TextField addPersonPeselTextField;

    @FXML
    private TextField addPersonAgeTextField;

    @FXML
    private Slider addPersonGenderSlider;

    @FXML
    private Label addPersonResultStateLabel;

    @FXML
    private TextField addPersonIndexTextField;

    @FXML
    private Slider addPersonErasmusParticipantSlider;

    @FXML
    private Button addPersonStudentButton;

    @FXML
    private TextField addPersonOccupationTextField;

    @FXML
    private TextField addPersonSeniorityTextField;

    @FXML
    private TextField addPersonSalaryTextField;

    @FXML
    private TextField addPersonOvertimeHoursTextField;

    @FXML
    private Button addPersonAdministrativeWorkerButton;

    @FXML
    private TextField addPersonScientificOutputPointsTextField;

    @FXML
    private Button addPersonScientificWorkerButton;


    private MainStorage mainStorage;
    private ArrayList<Person> people;
    private TableView<Person> table;
    private DisplayingTableStrategy displayingTableStrategy;
    ArrayList<CheckBox> checkBoxArrayList;

    public MainViewController() {
        mainStorage = new MainStorage();
        checkBoxArrayList = new ArrayList<>();
        checkBoxArrayList.add(oskChecbkox);
        checkBoxArrayList.add(ppChecbkox);
        checkBoxArrayList.add(fizChecbkox);
        checkBoxArrayList.add(logChecbkox);
        checkBoxArrayList.add(algChecbkox);
        checkBoxArrayList.add(amChecbkox);
    }

    public void initialize() {
        //full list
        showAllButton.setOnAction((event -> {
            showTable(new FullTable());
        }));

        showStudentsButton.setOnAction((event -> {
            showTable(new StudentsTable());
        }));

        showAdministrativeWorkersButton.setOnAction((event -> {
            showTable(new AdministrativeWorkersTable());
        }));

        showScientificWorkersButton.setOnAction((event -> {
            showTable(new ScientificWorkersTable());
        }));

        showMenButton.setOnAction((event -> {
            showTable(new GenderIsMaleTable(true));
        }));

        showWomenButton.setOnAction((event -> {
            showTable(new GenderIsMaleTable(false));
        }));

        sortByNameButton.setOnAction(event -> {
            mainStorage.sortByName();
        });

        sortBySurnameButton.setOnAction(event -> {
            mainStorage.sortBySurname();
        });

        sortBySurnameNameButton.setOnAction(event -> {
            mainStorage.sortBySurnameName();
        });

        sortBySurnameAgeButton.setOnAction(event -> {
            mainStorage.sortBySurnameAge();
        });

        searchByIndexButton.setOnAction(event -> {
            searchByIndex(indexOrPeselTextField.getText());
        });

        searchByPeselButton.setOnAction(event -> {
            searchByPesel(indexOrPeselTextField.getText());
        });


        //courses management
        searchIndexForCoursesButton.setOnAction((event -> {
            searchForStudentWithCourses(indexSearchForCourse.getText());
        }));

        courseManagementIndexButton.setOnAction(event -> {
            updateStudentCourses(indexToSaveLabel.getText());
        });

        //save & load
        saveButton.setOnAction(event -> {
            save();
        });

        loadButton.setOnAction(event -> {
            load();
        });

        //add person
        addPersonAdministrativeWorkerButton.setOnAction(event -> {
            addAdministrativeWorker();
        });

        addPersonScientificWorkerButton.setOnAction(event -> {
            addScientificWorker();
        });

        addPersonStudentButton.setOnAction(event -> {
            addStudent();
        });

        deleteByPeselButton.setOnAction(event -> {
            deleteByPesel(indexOrPeselTextField.getText());
        });


    }


    // full list
    public void showTable(DisplayingTableStrategy displayingTableStrategy) {
        TableView table = displayingTableStrategy.getTableFromArrayList(mainStorage.getPeopleList());
        fullListAnchorPane.getChildren().clear();
        fullListAnchorPane.getChildren().add(table);
        AnchorPane.setTopAnchor(table, 0d);
        AnchorPane.setLeftAnchor(table, 0d);
        AnchorPane.setRightAnchor(table, 0d);
        AnchorPane.setBottomAnchor(table, 0d);
    }

    public void showOnePersonTable(DisplayingTableStrategy displayingTableStrategy, ArrayList<Person> onePersonList) {
        TableView table = displayingTableStrategy.getTableFromArrayList(onePersonList);
        fullListAnchorPane.getChildren().clear();
        fullListAnchorPane.getChildren().add(table);
        AnchorPane.setTopAnchor(table, 0d);
        AnchorPane.setLeftAnchor(table, 0d);
        AnchorPane.setRightAnchor(table, 0d);
        AnchorPane.setBottomAnchor(table, 0d);
    }

    private void searchByIndex(String index) {
        if (mainStorage.getIndexSet().contains(index)) {
            ArrayList<Person> oneStudentList = new ArrayList<>();
            oneStudentList.add(getStudentByIndex(index, mainStorage.getPeopleList()));
            showOnePersonTable(new StudentsTable(), oneStudentList);
        } else {
            fullListAnchorPane.getChildren().clear();
            fullListAnchorPane.getChildren().add(new Label("Index not found"));
        }
    }

    private void searchByPesel(String pesel) {
        if (mainStorage.getPeselSet().contains(pesel)) {
            ArrayList<Person> onePersonList = new ArrayList<>();
            Person person = getPersonByPesel(pesel, mainStorage.getPeopleList());
            onePersonList.add(person);
            if (person instanceof Student)
                showOnePersonTable(new StudentsTable(), onePersonList);
            if (person instanceof AdministrativeWorker)
                showOnePersonTable(new AdministrativeWorkersTable(), onePersonList);
            if (person instanceof ScientificWorker)
                showOnePersonTable(new ScientificWorkersTable(), onePersonList);
        } else {
            fullListAnchorPane.getChildren().clear();
            fullListAnchorPane.getChildren().add(new Label("Pesel not found"));
        }
    }

    private void deleteByPesel(String pesel) {
        if (mainStorage.getPeselSet().contains(pesel)) {
            int placeInArrayList = getPersonByPeselPlaceInArrayList(pesel, mainStorage.getPeopleList());
            if (mainStorage.getPeopleList().get(placeInArrayList) instanceof Student) {
                String index = ((Student) mainStorage.getPeopleList().get(placeInArrayList)).getIndex();
                mainStorage.getIndexSet().remove(index);
            }
            mainStorage.getPeopleList().remove(placeInArrayList);
            mainStorage.getPeselSet().remove(pesel);
        }
    }

    // coursesManagement
    private void searchForStudentWithCourses(String text) {
        if (text.length() == 6) {
            int placeInArrayList = getStudentByIndexPlaceInArrayList(text, mainStorage.getPeopleList());
            if (placeInArrayList != -1) {
                Student student = (Student) mainStorage.getPeopleList().get(placeInArrayList);
                studentNameLabel.setText(student.getName());
                studentSurnameLabel.setText(student.getSurname());
                studentPeselLabel.setText(student.getPesel());
                studentAgeLabel.setText(String.valueOf(student.getAge()));
                if (student.isMale()) studentGenderLabel.setText("M");
                else studentGenderLabel.setText("F");
                studentIndexLabel.setText(student.getIndex());
                if (student.isErasmusParticipant()) studentErasmusParticipantLabel.setText("Yes");
                else studentErasmusParticipantLabel.setText("No");

                indexToSaveLabel.setText(text);
                indexToSaveLabel.setTooltip(new Tooltip("Operate on index with grid on left"));

                updateCheckBoxes(placeInArrayList);
            } else indexSearchForCourse.setText("NOT_FOUND");
        } else indexSearchForCourse.setText("NOT_FOUND");
    }

    private void updateCheckBoxes(int placeInArrayList) {
        ArrayList<Course> courseArrayList = ((Student) mainStorage.getPeopleList().get(placeInArrayList)).getCourseRepository().getCourses();
        oskChecbkox.setSelected(courseArrayList.get(0).isSignedFor());
        ppChecbkox.setSelected(courseArrayList.get(1).isSignedFor());
        fizChecbkox.setSelected(courseArrayList.get(2).isSignedFor());
        logChecbkox.setSelected(courseArrayList.get(3).isSignedFor());
        algChecbkox.setSelected(courseArrayList.get(4).isSignedFor());
        amChecbkox.setSelected(courseArrayList.get(5).isSignedFor());
    }

    private void updateStudentCourses(String index) {
        if (mainStorage.getIndexSet().contains(index))
        {
            ArrayList<Boolean> checkoxesValues = new ArrayList<>();
            checkoxesValues.add(oskChecbkox.isSelected());
            checkoxesValues.add(ppChecbkox.isSelected());
            checkoxesValues.add(fizChecbkox.isSelected());
            checkoxesValues.add(logChecbkox.isSelected());
            checkoxesValues.add(algChecbkox.isSelected());
            checkoxesValues.add(amChecbkox.isSelected());
            int placeInArrayList = getStudentByIndexPlaceInArrayList(index, mainStorage.getPeopleList());
            for (int i = 0; i < checkoxesValues.size(); i++) {
                ((Student) mainStorage.getPeopleList().get(placeInArrayList)).getCourseRepository().getCourses().get(i).setSignedFor(checkoxesValues.get(i));
            }

        }

    }

    //save&load
    private void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("mainStorage"))) {
            oos.writeObject(mainStorage);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mainStorage"))) {
            mainStorage = (MainStorage) ois.readObject();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //add Person
    private void addStudent() {
        if (basicDataIsProper()) {
            if (addPersonIndexTextField.getText().length() != 6 || !addPersonIndexTextField.getText().chars().allMatch(Character::isDigit) || mainStorage.getIndexSet().contains(addPersonIndexTextField.getText())) {
                addPersonResultStateLabel.setText("WRONG_DATA");
            } else {
                String name = addPersonNameTextField.getText();
                String surname = addPersonSurnameTextField.getText();
                String pesel = addPersonPeselTextField.getText();
                int age = Integer.parseInt(addPersonAgeTextField.getText());
                boolean isMale;
                if (addPersonGenderSlider.getValue() == 0) isMale = false;
                else isMale = true;
                String index = addPersonIndexTextField.getText();
                boolean erasmusParticipant;
                if (addPersonErasmusParticipantSlider.getValue() == 0) erasmusParticipant = true;
                else erasmusParticipant = false;
                mainStorage.getIndexSet().add(index);
                mainStorage.getPeselSet().add(pesel);
                mainStorage.getPeopleList().add(new Student(name, surname, pesel, age, isMale, index, erasmusParticipant));
                addPersonResultStateLabel.setText("Student created");
            }
        } else {
            addPersonResultStateLabel.setText("WRONG_DATA");
        }

    }

    private void addAdministrativeWorker() {
        if (basicDataIsProper() && universityWorkerDataIsProper()) {
            if (addPersonOvertimeHoursTextField.getText().length() == 0 || !addPersonOvertimeHoursTextField.getText().chars().allMatch(Character::isDigit)) {
                addPersonResultStateLabel.setText("WRONG_DATA");
            } else {
                String name = addPersonNameTextField.getText();
                String surname = addPersonSurnameTextField.getText();
                String pesel = addPersonPeselTextField.getText();
                int age = Integer.parseInt(addPersonAgeTextField.getText());
                boolean isMale;
                if (addPersonGenderSlider.getValue() == 0) isMale = false;
                else isMale = true;
                String occupation = addPersonOccupationTextField.getText();
                int seniority = Integer.parseInt(addPersonSeniorityTextField.getText());
                int salary = Integer.parseInt(addPersonSalaryTextField.getText());
                int overtimeHours = Integer.parseInt(addPersonOvertimeHoursTextField.getText());
                mainStorage.getPeselSet().add(pesel);
                mainStorage.getPeopleList().add(new AdministrativeWorker(name, surname, pesel, age, isMale, occupation, seniority, salary, overtimeHours));
                addPersonResultStateLabel.setText("Administrative worker created");
            }
        } else addPersonResultStateLabel.setText("WRONG_DATA");
    }

    private void addScientificWorker() {
        if (basicDataIsProper() && universityWorkerDataIsProper()) {
            if (addPersonScientificOutputPointsTextField.getText().length() == 0 || !addPersonScientificOutputPointsTextField.getText().chars().allMatch(Character::isDigit)) {
                addPersonResultStateLabel.setText("WRONG_DATA");
            } else {
                String name = addPersonNameTextField.getText();
                String surname = addPersonSurnameTextField.getText();
                String pesel = addPersonPeselTextField.getText();
                int age = Integer.parseInt(addPersonAgeTextField.getText());
                boolean isMale;
                if (addPersonGenderSlider.getValue() == 0) isMale = false;
                else isMale = true;
                String occupation = addPersonOccupationTextField.getText();
                int seniority = Integer.parseInt(addPersonSeniorityTextField.getText());
                int salary = Integer.parseInt(addPersonSalaryTextField.getText());
                int scientificOutputPoints = Integer.parseInt(addPersonScientificOutputPointsTextField.getText());
                mainStorage.getPeselSet().add(pesel);
                mainStorage.getPeopleList().add(new ScientificWorker(name, surname, pesel, age, isMale, occupation, seniority, salary, scientificOutputPoints));
                addPersonResultStateLabel.setText("Administrative worker created");
            }
        } else addPersonResultStateLabel.setText("WRONG_DATA");
    }

    private boolean basicDataIsProper() {
        if (addPersonNameTextField.getText().length() == 0 || !addPersonNameTextField.getText().chars().allMatch(Character::isLetter))
            return false;
        if (addPersonSurnameTextField.getText().length() == 0 || !addPersonSurnameTextField.getText().chars().allMatch(Character::isLetter))
            return false;
        if (addPersonPeselTextField.getText().length() != 11 || !addPersonPeselTextField.getText().chars().allMatch(Character::isDigit) || mainStorage.getPeselSet().contains(addPersonPeselTextField.getText()))
            return false;
        if (addPersonAgeTextField.getText().length() == 0 || addPersonAgeTextField.getText().length() > 3 || !addPersonAgeTextField.getText().chars().allMatch(Character::isDigit))
            return false;
        return true;
    }

    private boolean universityWorkerDataIsProper() {
        if (addPersonOccupationTextField.getText().length() == 0 || !addPersonNameTextField.getText().chars().allMatch(Character::isLetter))
            return false;
        if (addPersonSeniorityTextField.getText().length() == 0 || addPersonSeniorityTextField.getText().length() > 2 || !addPersonSeniorityTextField.getText().chars().allMatch(Character::isDigit))
            return false;
        if (addPersonSalaryTextField.getText().length() < 4 || addPersonSalaryTextField.getText().length() > 7 || !addPersonSalaryTextField.getText().chars().allMatch(Character::isDigit))
            return false;

        return true;
    }

    private Person getPersonByPesel(String pesel, ArrayList<Person> peopleToSearchList) {
        for (int i = 0; i < peopleToSearchList.size(); i++) {
            if (peopleToSearchList.get(i).getPesel().equals(pesel)) return peopleToSearchList.get(i);
        }
        return null;
    }

    private Person getStudentByIndex(String index, ArrayList<Person> peopleToSearchList) {
        for (int i = 0; i < peopleToSearchList.size(); i++) {
            if (peopleToSearchList.get(i) instanceof Student) {
                if (((Student) peopleToSearchList.get(i)).getIndex().equals(index)) return peopleToSearchList.get(i);
            }
        }
        return null;
    }

    private int getPersonByPeselPlaceInArrayList(String pesel, ArrayList<Person> peopleToSearchList) {
        for (int i = 0; i < peopleToSearchList.size(); i++) {
            if (peopleToSearchList.get(i).getPesel().equals(pesel)) return i;
        }
        return -1;
    }

    private int getStudentByIndexPlaceInArrayList(String index, ArrayList<Person> peopleToSearchList) {
        for (int i = 0; i < peopleToSearchList.size(); i++) {
            if (peopleToSearchList.get(i) instanceof Student) {
                if (((Student) peopleToSearchList.get(i)).getIndex().equals(index)) return i;
            }
        }
        return -1;
    }


}
