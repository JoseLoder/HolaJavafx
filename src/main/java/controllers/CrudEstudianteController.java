package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Escuela;
import model.Estudiante;

public class CrudEstudianteController {

    @FXML
    private TableView<Estudiante> tvListaEstudiantes;

    @FXML
    private TableColumn<Estudiante, String> tcApellido;

    @FXML
    private TableColumn<Estudiante, String> tcDni;

    @FXML
    private TableColumn<Estudiante, String> tcMatricula;

    @FXML
    private TableColumn<Estudiante, String> tcNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtDni;

    @FXML
    private TextField txtMatricula;

    @FXML
    private TextField txtNombre;

    @FXML
    void initialize() {

        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tcDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        tcMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));

        tvListaEstudiantes.getItems().addAll(Escuela.getInstance().getListaEstudiantes());

        tvListaEstudiantes.setOnMouseClicked(event -> {

            Estudiante estudiante = tvListaEstudiantes.getSelectionModel().getSelectedItem();

            if (estudiante == null) {
                return;
            }

            txtNombre.setText(estudiante.getNombre());
            txtApellido.setText(estudiante.getApellido());
            txtDni.setText(estudiante.getDni());
            txtMatricula.setText(estudiante.getMatricula());

            txtDni.setDisable(true);
            txtMatricula.setDisable(true);
        });
    }


    @FXML
    void agregarEstudiante(ActionEvent event) {

        Escuela escuela = Escuela.getInstance();
        Estudiante estudiante = new Estudiante(txtNombre.getText(), txtApellido.getText(), txtDni.getText(), txtMatricula.getText());

        escuela.aniadirEstudiante(estudiante);

        actualizarTabla();
        limpiarCampos();
    }

    @FXML
    void eliminarEstudiante(ActionEvent event) {

            Escuela escuela = Escuela.getInstance();
            Estudiante estudiante = tvListaEstudiantes.getSelectionModel().getSelectedItem();

            escuela.eliminarEstudiante(estudiante);

            actualizarTabla();
            limpiarCampos();
    }

    @FXML
    void actualizarEstudiante(ActionEvent event) {

            Escuela escuela = Escuela.getInstance();

            Estudiante estudiante = tvListaEstudiantes.getSelectionModel().getSelectedItem();

            if (estudiante == null) {
                return;
            }

            Estudiante nuevoEstudiante = new Estudiante(txtNombre.getText(), txtApellido.getText(), txtDni.getText(), txtMatricula.getText());
            escuela.modificarEstudiante(nuevoEstudiante);

            actualizarTabla();
            limpiarCampos();
    }

    @FXML
    void deshacerSeleccion(ActionEvent event) {

        limpiarCampos();
    }

    // FUNCIONES AUXILIARES PARA LA REUTILIZACIÓN DE CÓDIGO

    public void actualizarTabla() {

        Escuela escuela = Escuela.getInstance();

        tvListaEstudiantes.getItems().clear();
        tvListaEstudiantes.getItems().addAll(escuela.getListaEstudiantes());
        tvListaEstudiantes.refresh();

    }

    public void limpiarCampos() {
        txtNombre.clear();
        txtApellido.clear();
        txtDni.clear();
        txtMatricula.clear();

        txtDni.setDisable(false);
        txtMatricula.setDisable(false);
    }

}
