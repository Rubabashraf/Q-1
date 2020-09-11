package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Main extends Application {
    Label cpLabel ,dateLabel,marksLabel;
    DatePicker dateDP;
    TextField marksTextfield;
    Button saveBtn;
    VBox VBox1,VBox2;
    HBox LabelHBox,HBox1;
    FlowPane root;


    @Override
    public void start(Stage primaryStage) throws Exception{
        cpLabel=new Label("My CP Tracker");
        cpLabel.setFont(new Font(22));
        cpLabel.setPadding(new Insets(20,70,10,70));
        dateLabel=new Label("Date");
        marksLabel=new Label("Marks");
        dateDP=new DatePicker();
        saveBtn =new Button("Save data");
        marksTextfield=new TextField();
        marksTextfield.setPromptText("Enter Your Marks");
        VBox1 =new VBox(20,dateLabel,marksLabel);
        VBox1.setPadding(new Insets(0,10,10,60));
        VBox2 = new VBox(10,dateDP,marksTextfield,saveBtn);
        VBox2.setPadding(new Insets(0,60,10,10));
        HBox1=new HBox( 20,VBox1,VBox2);
        LabelHBox=new HBox(cpLabel);
        root=new FlowPane(LabelHBox,HBox1);


        primaryStage.setTitle("181380019- cp tracker");
        primaryStage.setScene(new Scene(root, 400, 275));
        primaryStage.show();
    }
    private void save(){
        try(PrintWriter writer=new PrintWriter(new FileWriter("CP.txt",true))){
            String str="------- CP Marks on "+dateDP.getValue().toString()+" --------\n";
            str+=" Marks: "+marksTextfield.getText();
            writer.println(str);
            alert(str);
        }catch(Exception invalid){
            System.out.println("Error: "+invalid.getMessage());
        }
    }

    private void alert(String value){
        Alert a=new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("CP Data Saved");
        a.setHeaderText("Your CP data is saved successfully");
        a.setContentText(value);
        a.showAndWait();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
