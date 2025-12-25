package controller;

import dao.EmployeDAO;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

import java.util.List;

public class EmployeController {

    
    @FXML private TextField txtName;
    @FXML private TextField txtAge;
    @FXML private TextField txtDate;
    @FXML private TextField txtValue;
    @FXML private ComboBox<String> comboType;

    
    @FXML private TableView<Employe> table;
    @FXML private TableColumn<Employe, Integer> colId;
    @FXML private TableColumn<Employe, String> colName;
    @FXML private TableColumn<Employe, String> colDate;
    @FXML private TableColumn<Employe, String> colType;
    @FXML private TableColumn<Employe, Double> colSalary;

    private final ObservableList<Employe> employeeList =
            FXCollections.observableArrayList();

    private final EmployeDAO dao = new EmployeDAO();

    
    @FXML
    public void initialize() {

        comboType.getItems().addAll(
                "VENDEUR",
                "REPRESENTANT",
                "PRODUCTEUR",
                "MANUTENTIONNAIRE"
        );

        colId.setCellValueFactory(data ->
                new javafx.beans.property.SimpleIntegerProperty(
                        data.getValue().getId()).asObject());

        colName.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getNom()));

        colDate.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getDateEntree()));

        colType.setCellValueFactory(data ->
                new SimpleStringProperty(
                        data.getValue().getClass().getSimpleName()));

        colSalary.setCellValueFactory(data ->
                new SimpleDoubleProperty(
                        data.getValue().calculerSalaire()).asObject());

        table.setItems(employeeList);
        afficherAction();
    }

   
    @FXML
    private void ajouterAction() {
        try {
            Employe emp = createEmployeFromFields();
            dao.addEmploye(emp);
            afficherAction();
            clearFields();
        } catch (Exception e) {
            showAlert("Erreur", e.getMessage());
        }
    }

    
    @FXML
    private void modifierAction() {
        Employe selected = table.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Erreur", "Veuillez sélectionner un employé");
            return;
        }

        try {
            selected.setNom(txtName.getText());
            selected.setAge(Integer.parseInt(txtAge.getText()));
            selected.setDateEntree(txtDate.getText());

            dao.updateEmploye(selected);
            afficherAction();
            clearFields();
        } catch (Exception e) {
            showAlert("Erreur", e.getMessage());
        }
    }

    
    @FXML
    private void supprimerAction() {
        Employe selected = table.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Erreur", "Veuillez sélectionner un employé");
            return;
        }

        dao.deleteEmploye(selected.getId());
        afficherAction();
    }


    @FXML
    private void afficherAction() {
        List<Employe> list = dao.getAllEmployes();
        employeeList.setAll(list);
    }

    
    private Employe createEmployeFromFields() {

        String nom = txtName.getText();
        int age = Integer.parseInt(txtAge.getText());
        String date = txtDate.getText();
        double value = Double.parseDouble(txtValue.getText());
        String type = comboType.getValue();

        if (type == null)
            throw new IllegalArgumentException("Choisissez un type d'employé");

        switch (type) {
            case "VENDEUR":
                return new Vendeur(nom, age, date, value);

            case "REPRESENTANT":
                return new Representant(nom, age, date, value);

            case "PRODUCTEUR":
                return new Producteur(nom, age, date, (int) value);

            case "MANUTENTIONNAIRE":
                return new Manutentionnaire(nom, age, date, (int) value);

            default:
                throw new IllegalArgumentException("Type invalide");
        }
    }

    private void clearFields() {
        txtName.clear();
        txtAge.clear();
        txtDate.clear();
        txtValue.clear();
        comboType.setValue(null);
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
