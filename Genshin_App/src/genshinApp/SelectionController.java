package genshinApp;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import UserMenu.UserController;
import dbUtil.DBConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class SelectionController implements Initializable {

	@FXML
	private ComboBox<User> combobox;
	
	@FXML
	private Button selectButton;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		try {
			Connection conn = DBConnector.getConnection();
			ResultSet rs = conn.createStatement().executeQuery("SELECT id, name FROM users");
			ObservableList<User> data = FXCollections.observableArrayList();
			while(rs.next()) {
				data.add(new User(rs.getInt("id"),rs.getString("name")));
			}
			combobox.setItems(data);
			convertCombo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	public void selectUser(ActionEvent event) {
		try {
			if(combobox.getValue() != null) {
				Stage stage = (Stage) this.selectButton.getScene().getWindow();
				stage.close();
				openUser(this.combobox.getValue());
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public void openUser(User u) {
		try {
			Stage userStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = (Pane) loader.load(getClass().getResource("/UserMenu/UserMenu.fxml").openStream());
			UserController userC = (UserController) loader.getController();
			userC.setUser(u);
			Scene scene = new Scene(root);
			userStage.setScene(scene);
			userStage.setTitle("User Menu");
			userStage.setResizable(false);
			userStage.show();
		} catch (IOException e) {
			e.getStackTrace();
		}
	}
	
	public void convertCombo() {
		combobox.setConverter(new StringConverter<User>(){

			@Override
			public User fromString(String s) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String toString(User u) {
				// TODO Auto-generated method stub
				return u.getName();
			}
			
		});
	}

}
