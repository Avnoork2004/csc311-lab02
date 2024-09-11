package org.example.csc311_lab2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class HelloController {

    // the fx ids
    @FXML
    private Button btnCalculator;

    @FXML
    private TextField txtAnnualInterestRate;

    @FXML
    private TextField txtLoanAmount;

    @FXML
    private TextField txtMonthlyPayment;

    @FXML
    private TextField txtNumberOfYears;

    @FXML
    private TextField txtTotalPayment;

    // the action event for the button
    @FXML
    void onHelloButtonClick(ActionEvent event) {
        try {
            // Taking from the input fields get the values
            double loanAmount = Double.parseDouble(txtLoanAmount.getText()); //decimal values
            double annInterestRate = Double.parseDouble(txtAnnualInterestRate.getText()); //decimal values
            int numOfYears = Integer.parseInt(txtNumberOfYears.getText()); //number values

            // calculate the monthly interest rate
            double monthInterestRate = annInterestRate / 1200;

            // calculate the monthly payment
            double monthPayment = (loanAmount * monthInterestRate) /
                    (1 - (1 / Math.pow(1 + monthInterestRate, numOfYears * 12)));

            // calculate the total payment
            double totalPayment = monthPayment * numOfYears * 12;

            // show the total
            txtMonthlyPayment.setText(String.format("$%.2f", monthPayment));
            txtTotalPayment.setText(String.format("$%.2f", totalPayment));

        }

        catch (NumberFormatException e) {
            //  error will pop up if something other than numbers are entered
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Enter valid number values");
            alert.showAndWait();
        }
    }

}
