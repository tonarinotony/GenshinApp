package UserMenu;

import java.net.URL;
import java.util.ResourceBundle;

import genshinApp.User;
import javafx.fxml.Initializable;

public class UserController implements Initializable{
	private User user;
	
	public void setUser(User u) {
		this.user = u;
		System.out.println(user.getId() + user.getName());
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}
	
	
}
