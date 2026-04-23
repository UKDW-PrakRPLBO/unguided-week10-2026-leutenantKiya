package org.rplbo.app.ug8.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.rplbo.app.ug8.UmbrellaApp;
import org.rplbo.app.ug8.UmbrellaDBManager;

//import java.io.IO;
import java.io.IOException;

public class LoginController {
    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblStatus;

    @FXML void btnLoginClick(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER) {
            handleLogin();
        }
    }
    @FXML
    private void handleLogin() throws IOException {
        // ==============================================================================
        // TODO 1: PROSES AUTENTIKASI (LOGIN)
        // ==============================================================================
        // 1. Ambil input teks dari txtUsername dan txtPassword.
        // 2. Buat instansiasi dari class UmbrellaDBManager.
        // 3. Panggil metode validateUser() dari db manager tersebut.
        // 4. Jika hasil validasi berhasil (tidak null):
        //    a. Simpan nama user ke variabel statis UmbrellaApp.loggedInUser.
        //    b. Pindah ke halaman "umbrella-view.fxml" menggunakan UmbrellaApp.switchScene().
        // 5. Jika gagal, tampilkan pesan error "" pada lblStatus.
        // ==============================================================================

        // --- TULIS KODE ANDA DI BAWAH INI ---AUTHENTICATION FAILED
        Alert a;
        UmbrellaDBManager db = new UmbrellaDBManager();
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        if (db.validateUser(username, password) != null){
            UmbrellaApp.loggedInUser = username;
            System.out.println(UmbrellaApp.loggedInUser);
            UmbrellaApp.switchScene("umbrella-view.fxml");
        }else{
            lblStatus.setText("AUTHENTICATION FAILED");
            a =  new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Error");
            a.setContentText("Login failed!! Please check again.");
            a.showAndWait();
            txtUsername.requestFocus();
        }
    }
}