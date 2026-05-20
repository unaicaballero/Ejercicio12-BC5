package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Ejercicio 12 - Seleccionar País");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(20));

        // ComboBox con lista de paises
        Label lblPais = new Label("País:");
        ComboBox<String> comboPaises = new ComboBox<>();
        comboPaises.getItems().addAll(
                "Argentina", "Bolivia", "Chile", "Colombia",
                "Costa Rica", "Cuba", "Ecuador", "El Salvador",
                "España", "Guatemala", "Honduras", "México",
                "Nicaragua", "Panamá", "Paraguay", "Perú",
                "República Dominicana", "Uruguay", "Venezuela"
        );
        comboPaises.setPromptText("-- Selecciona un país --");

        Button btnSeleccionar = new Button("Ver país seleccionado");
        Label  lblMensaje     = new Label();

        grid.add(lblPais,          0, 0);
        grid.add(comboPaises,      1, 0);
        grid.add(btnSeleccionar,   1, 1);
        grid.add(lblMensaje,       1, 2);

        //leer el valor del ComboBox con getValue()
        btnSeleccionar.setOnAction(event -> {
            String seleccionado = comboPaises.getValue();
            if (seleccionado == null) {
                lblMensaje.setTextFill(Color.ORANGE);
                lblMensaje.setText("⚠ Por favor selecciona un país.");
            } else {
                lblMensaje.setTextFill(Color.STEELBLUE);
                lblMensaje.setText("🌎 País seleccionado: " + seleccionado);
            }
        });

        Scene scene = new Scene(grid, 360, 160);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}