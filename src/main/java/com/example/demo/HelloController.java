package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private static final NumberFormat moneda = NumberFormat.getCurrencyInstance();
    private static final NumberFormat descuento = NumberFormat.getPercentInstance();
    private BigDecimal descuentoCliente = new BigDecimal(0.10);
    private BigDecimal porcentajeIVA = new BigDecimal(0.21);
    @FXML
    private Label etiquetaCantidad;
    @FXML
    private Label etiquetaPrecio;
    @FXML
    private Label etiquetaIVA;
    @FXML
    private Label etiquetaDto;
    @FXML
    private Label etiquetaTotal;
    @FXML
    private TextField campoCantidad;
    @FXML
    private TextField campoPrecio;
    @FXML
    private TextField campoIVA;
    @FXML
    private TextField campoTotal;
    @FXML
    private Slider sliderDto;
    @FXML
    private Button botonCalcular;

    @FXML
    private void calcularTotal(ActionEvent event){
        try{
            BigDecimal cantidad = new BigDecimal(campoCantidad.getText());
            BigDecimal precio = new BigDecimal(campoPrecio.getText());
            BigDecimal importe = cantidad.multiply(precio);
            BigDecimal descuento = precio.multiply(descuentoCliente);
            BigDecimal IVA = precio.multiply(porcentajeIVA);
            BigDecimal total = (precio.subtract(descuento)).add(IVA);

            campoTotal.setText(moneda.format(total));
        }catch(NumberFormatException e){
            campoCantidad.setText("Introduzca una cantidad correcta.");
            campoCantidad.selectAll();
            campoCantidad.requestFocus();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

