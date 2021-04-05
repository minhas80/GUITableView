package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class WindowController implements Initializable {
 
   
    

    
    @FXML
    private TextField name;

    @FXML
    private RadioButton male;

    @FXML
    private ToggleGroup Gender;

    @FXML
    private RadioButton female;

    @FXML
    private ChoiceBox<String> qualification;

    @FXML
    private DatePicker date;

    @FXML
    private Button submit;
    @FXML
    private Button close;
    ObjectOutputStream ob;
    FileOutputStream fp;
    @FXML
    void OnSubmit(ActionEvent event) {
    	
    	 String nameN=name.getText();
    	 String qualificationN=qualification.getSelectionModel().getSelectedItem();
    	 String genderN;
    	 if(female.isSelected())
    		 genderN="Female";
    	 else
    		 genderN="Male";
    	 System.out.print("Heymmmmmmmmmmm"+genderN);
    	 LocalDate dobN=date.getValue();
    	 Person P=new Person(nameN, qualificationN, genderN, dobN);
    	 
    	 
		try {
			
			ob.writeObject(P);
			name.clear();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
    	 

    }
    private ObservableList<String> dbTypeList = FXCollections.observableArrayList("BA","BTech","Pdgca");
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	qualification.setItems(dbTypeList);
    	qualification.setValue("PhD");
    	 FileOutputStream fp;
		try {
			fp = new FileOutputStream("person.bin");
			 ob = new ObjectOutputStream(fp);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         
         
    }
    @FXML
    private TextField name1;
    @FXML
    private Label qualification1;

    @FXML
    private Label gender1;

    @FXML
    private Label dob1;
    @FXML
    private Button get;
    @FXML
    void OnGet(ActionEvent event) {

    
    	FileInputStream fp;
    	Person p;
		try {
			fp = new FileInputStream("person.bin");
			try (ObjectInputStream ois = new ObjectInputStream(fp)) {
				p=null;
				while(fp.available()>0)
				{
					p=(Person)ois.readObject();
					if(p.getName().equals(name1.getText()))
					{
						dob1.setText(p.getDob().toString());
						qualification1.setText(p.getQualification());
						gender1.setText(p.getGender());
					}
				}
			}
			//System.out.print(p.getDob().toString());
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void OnClose(ActionEvent event) {
    	try {
			ob.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Platform.exit();
    }

}







