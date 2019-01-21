package model.tableDisplays;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.university.*;

@SuppressWarnings("Duplicates")
public class TableColumnFactory {
    public static TableView<Person> getFullTable() {
        TableColumn<Person, String> peselColumn = TableColumnFactory.getPeselColumn();
        TableColumn<Person, String> nameColumn = TableColumnFactory.getNameColumn();
        TableColumn<Person, String> surnameColumn = TableColumnFactory.getSurnameColumn();
        TableColumn<Person, String> ageColumn = TableColumnFactory.getAgeColumn();
        TableColumn<Person, String> genderColumn = TableColumnFactory.getGenderColumn();
        TableColumn<Person, String> occupationColumn = TableColumnFactory.getOccupationColumn();
        TableColumn<Person, Integer> seniorityColumn = TableColumnFactory.getSeniorityColumn();
        TableColumn<Person, Integer> salaryColumn = TableColumnFactory.getSalaryColumn();
        TableColumn<Person, Integer> overtimeHoursColumn = TableColumnFactory.getOvertimeHoursColumn();
        TableColumn<Person, Integer> scientificOutputPointsColumn = TableColumnFactory.getScientifiOutputPointsColumn();
        TableColumn<Person, String> indexColumn = TableColumnFactory.getIndexColumn();
        TableColumn<Person, String> erasmusParticipantColumn = TableColumnFactory.getErasmusParticipantColumn();
        TableColumn<Person, String> coursesColumn = TableColumnFactory.getCoursesColumn();

        TableView<Person> tableView = new TableView<>();
        tableView.getColumns().addAll(peselColumn, nameColumn, surnameColumn, ageColumn, genderColumn, occupationColumn, seniorityColumn, salaryColumn, overtimeHoursColumn, scientificOutputPointsColumn, indexColumn, erasmusParticipantColumn, coursesColumn);
        return tableView;
    }

    public static TableView<Person> getStudentsTable() {

        TableColumn<Person, String> peselColumn = TableColumnFactory.getPeselColumn();
        TableColumn<Person, String> nameColumn = TableColumnFactory.getNameColumn();
        TableColumn<Person, String> surnameColumn = TableColumnFactory.getSurnameColumn();
        TableColumn<Person, String> ageColumn = TableColumnFactory.getAgeColumn();
        TableColumn<Person, String> genderColumn = TableColumnFactory.getGenderColumn();
        TableColumn<Person, String> indexColumn = TableColumnFactory.getIndexColumn();
        TableColumn<Person, String> erasmusParticipantColumn = TableColumnFactory.getErasmusParticipantColumn();
        TableColumn<Person, String> coursesColumn = TableColumnFactory.getCoursesColumn();

        TableView<Person> table = new TableView<>();
        table.getColumns().addAll(peselColumn, nameColumn, surnameColumn, ageColumn, genderColumn, indexColumn, erasmusParticipantColumn, coursesColumn);
        return table;
    }

    public static TableView<Person> getScientificWorkersTable() {
        TableColumn<Person, String> peselColumn = TableColumnFactory.getPeselColumn();
        TableColumn<Person, String> nameColumn = TableColumnFactory.getNameColumn();
        TableColumn<Person, String> surnameColumn = TableColumnFactory.getSurnameColumn();
        TableColumn<Person, String> ageColumn = TableColumnFactory.getAgeColumn();
        TableColumn<Person, String> genderColumn = TableColumnFactory.getGenderColumn();
        TableColumn<Person, String> occupationColumn = TableColumnFactory.getOccupationColumn();
        TableColumn<Person, Integer> seniorityColumn = TableColumnFactory.getSeniorityColumn();
        TableColumn<Person, Integer> salaryColumn = TableColumnFactory.getSalaryColumn();
        TableColumn<Person, Integer> scientificOutputPointsColumn = TableColumnFactory.getScientifiOutputPointsColumn();
        TableView<Person> tableView = new TableView<>();
        tableView.getColumns().addAll(peselColumn, nameColumn, surnameColumn, ageColumn, genderColumn, occupationColumn, seniorityColumn, salaryColumn, scientificOutputPointsColumn);
        return tableView;
    }

    public static TableView<Person> getAdministrativeWorkersTable() {
        TableColumn<Person, String> peselColumn = TableColumnFactory.getPeselColumn();
        TableColumn<Person, String> nameColumn = TableColumnFactory.getNameColumn();
        TableColumn<Person, String> surnameColumn = TableColumnFactory.getSurnameColumn();
        TableColumn<Person, String> ageColumn = TableColumnFactory.getAgeColumn();
        TableColumn<Person, String> genderColumn = TableColumnFactory.getGenderColumn();
        TableColumn<Person, String> occupationColumn = TableColumnFactory.getOccupationColumn();
        TableColumn<Person, Integer> seniorityColumn = TableColumnFactory.getSeniorityColumn();
        TableColumn<Person, Integer> salaryColumn = TableColumnFactory.getSalaryColumn();
        TableColumn<Person, Integer> overtimeHoursColumn = TableColumnFactory.getOvertimeHoursColumn();
        TableView<Person> tableView = new TableView<>();
        tableView.getColumns().addAll(peselColumn, nameColumn, surnameColumn, ageColumn, genderColumn, occupationColumn, seniorityColumn, salaryColumn, overtimeHoursColumn);
        return tableView;
    }


    public static TableColumn<Person, String> getPeselColumn() {
        TableColumn<Person, String> peselColumn = new TableColumn<>("Pesel");
        peselColumn.setMinWidth(70);
        peselColumn.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        return peselColumn;
    }

    public static TableColumn<Person, String> getNameColumn() {
        TableColumn<Person, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(120);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        return nameColumn;
    }

    public static TableColumn<Person, String> getSurnameColumn() {
        TableColumn<Person, String> surnameColumn = new TableColumn<>("Surname");
        surnameColumn.setMinWidth(120);
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        return surnameColumn;
    }

    public static TableColumn<Person, String> getAgeColumn() {
        TableColumn<Person, String> ageColumn = new TableColumn<>("Age");
        ageColumn.setMinWidth(25);
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        return ageColumn;
    }

    public static TableColumn<Person, String> getGenderColumn() {
        TableColumn<Person, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setMinWidth(30);
        genderColumn.setCellValueFactory(
                param -> {
                    if (param.getValue().isMale())
                        return new SimpleObjectProperty<>("M");
                    else
                        return new SimpleObjectProperty<>("F");
                }
        );
        return genderColumn;
    }

    public static TableColumn<Person, String> getOccupationColumn() {
        TableColumn<Person, String> occupationColumn = new TableColumn<>("Occupation");
        occupationColumn.setMinWidth(40);
        occupationColumn.setCellValueFactory(
                param -> {
                    if (param.getValue() instanceof UniversityWorker)
                        return new SimpleObjectProperty<>(((UniversityWorker) param.getValue()).getOccupation());
                    else
                        return new SimpleObjectProperty<>();
                }
        );
        return occupationColumn;
    }

    public static TableColumn<Person, Integer> getSeniorityColumn() {
        TableColumn<Person, Integer> seniorityColumn = new TableColumn<>("Seniority");
        seniorityColumn.setMinWidth(40);
        seniorityColumn.setCellValueFactory(
                param -> {
                    if (param.getValue() instanceof UniversityWorker)
                        return new SimpleObjectProperty<>(((UniversityWorker) param.getValue()).getSeniority());
                    else
                        return new SimpleObjectProperty<>();
                }
        );
        return seniorityColumn;
    }

    public static TableColumn<Person, Integer> getSalaryColumn() {
        TableColumn<Person, Integer> salaryColumn = new TableColumn<>("Salary");
        salaryColumn.setMinWidth(35);
        salaryColumn.setCellValueFactory(
                param -> {
                    if (param.getValue() instanceof UniversityWorker)
                        return new SimpleObjectProperty<>(((UniversityWorker) param.getValue()).getSalary());
                    else return new SimpleObjectProperty<>();
                }
        );
        return salaryColumn;
    }

    public static TableColumn<Person, Integer> getOvertimeHoursColumn() {
        TableColumn<Person, Integer> overtimeHoursColumn = new TableColumn<>("Over. h");
        overtimeHoursColumn.setMinWidth(30);
        overtimeHoursColumn.setCellValueFactory(
                param -> {
                    if (param.getValue() instanceof AdministrativeWorker)
                        return new SimpleObjectProperty<>(((AdministrativeWorker) param.getValue()).getOvertimeHours());
                    else
                        return new SimpleObjectProperty<>();
                });
        return overtimeHoursColumn;
    }

    public static TableColumn<Person, Integer> getScientifiOutputPointsColumn() {
        TableColumn<Person, Integer> scientificOutputPointsColumn = new TableColumn<>("Science p.");
        scientificOutputPointsColumn.setMinWidth(40);
        scientificOutputPointsColumn.setCellValueFactory(
                param -> {
                    if (param.getValue() instanceof ScientificWorker)
                        return new SimpleObjectProperty<>(((ScientificWorker) param.getValue()).getScientificOutputPoints());
                    else
                        return new SimpleObjectProperty<>();
                });
        return scientificOutputPointsColumn;
    }

    public static TableColumn<Person, String> getIndexColumn() {
        TableColumn<Person, String> indexColumn = new TableColumn<>("Index");
        indexColumn.setMinWidth(40);
        indexColumn.setCellValueFactory(
                param -> {
                    if (param.getValue() instanceof Student)
                        return new SimpleObjectProperty<>(((Student) param.getValue()).getIndex());
                    else
                        return new SimpleObjectProperty<>();
                });
        return indexColumn;
    }

    public static TableColumn<Person, String> getErasmusParticipantColumn() {
        TableColumn<Person, String> erasmusParticipantColumn = new TableColumn<>("Erasmus part.");
        erasmusParticipantColumn.setMinWidth(30);
        erasmusParticipantColumn.setCellValueFactory(
                param -> {
                    if (param.getValue() instanceof Student) {
                        if (((Student) param.getValue()).isErasmusParticipant())
                            return new SimpleObjectProperty<>("Yes");
                        else
                            return new SimpleObjectProperty<>("No");
                    } else
                        return new SimpleObjectProperty<>();
                });
        return erasmusParticipantColumn;
    }

    public static TableColumn<Person, String> getCoursesColumn() {
        TableColumn<Person, String> coursesColumn = new TableColumn<>("Courses");
        coursesColumn.setMinWidth(100);
        coursesColumn.setCellValueFactory(
                param -> {
                    if (param.getValue() instanceof Student)
                        return new SimpleObjectProperty<>(((Student) param.getValue()).getCourseRepository().toString());
                    else
                        return new SimpleObjectProperty<>();
                });
        return coursesColumn;
    }
}
