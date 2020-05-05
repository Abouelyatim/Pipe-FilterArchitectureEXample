import com.sun.javafx.application.PlatformImpl;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.concurrent.CountDownLatch;

public class StartUpTest extends Application {
    public static final CountDownLatch latch = new CountDownLatch(1);
    public static StartUpTest startUpTest = null;

    public static StartUpTest waitForStartUpTest() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return startUpTest;
    }

    public static void setStartUpTest(StartUpTest startUpTest0) {
        startUpTest = startUpTest0;

    }

    public StartUpTest() {
        setStartUpTest(this);
    }

    public void printSomething() {
        System.out.println("You called a method on the application");
    }

    public   Button sommeBtn;
    Button produitBtn;
    Button factorielBtn;

    public TextField tf1;
    public TextField tf2;

    public static  Label resultatLabel;
    public static  Label traceLabel;
    public static Button traceBtn;
    public static Button quiterBtn;

    @Override
    public void start(Stage stage) throws Exception {


        int topPadding=25;

        HBox hbox1=new HBox();
        HBox hbox2=new HBox();
        HBox hbox3=new HBox();
        GridPane gridPane=new GridPane();

        Scene scene = new Scene(gridPane, 500, 500);
        stage.setScene(scene);

         tf1=new TextField();
         tf2=new TextField();

        Label nombreLabel1=new Label("NB 1");
        Label nombreLabel2=new Label("NB 2");

        nombreLabel1.setStyle("-fx-font-weight: bold");
        nombreLabel1.setFont(new Font("Arial", 16));

        nombreLabel2.setStyle("-fx-font-weight: bold");
        nombreLabel2.setFont(new Font("Arial", 16));

        Label resultatTitel=new Label("Resultat");
        Label traceTitel=new Label("Trace");

        resultatLabel=new Label("resultat");
        traceLabel=new Label("trace");

        hbox1.setSpacing(25);
        hbox1.getChildren().add(nombreLabel1);
        hbox1.getChildren().add(tf1);
        hbox1.getChildren().add(nombreLabel2);
        hbox1.getChildren().add(tf2);


        hbox1.setPadding(new Insets(topPadding, 12, 15, 12));

        sommeBtn=new Button("somme");
         produitBtn=new Button("produit");
         factorielBtn=new Button("factoriel");

        sommeBtn.setStyle("-fx-font-weight: bold");
        sommeBtn.setFont(new Font("Arial", 16));
        produitBtn.setStyle("-fx-font-weight: bold");
        produitBtn.setFont(new Font("Arial", 16));
        factorielBtn.setStyle("-fx-font-weight: bold");
        factorielBtn.setFont(new Font("Arial", 16));

        sommeBtn.setMinWidth(145);
        produitBtn.setMinWidth(145);
        factorielBtn.setMinWidth(145);
         hbox2.setSpacing(20);
        hbox2.getChildren().add(sommeBtn);
        hbox2.getChildren().add(produitBtn);
        hbox2.getChildren().add(factorielBtn);
        hbox2.setPadding(new Insets(topPadding, 12, 15, 12));

        resultatLabel.setMinHeight(70);
        resultatLabel.setMinWidth(500);
        resultatLabel.setStyle("-fx-border-color: black;");
        resultatLabel.setPadding(new Insets(topPadding, 12, 15, 12));
        resultatLabel.setFont(new Font("Arial", 24));

        traceLabel.setMinHeight(70);
        traceLabel.setMinWidth(500);
        traceLabel.setStyle("-fx-border-color: black;");
        traceLabel.setPadding(new Insets(0, 12, 0, 12));
        traceLabel.setFont(new Font("Arial", 16));

        quiterBtn=new Button("quiter");
        traceBtn=new Button("trace");

        quiterBtn.setStyle("-fx-font-weight: bold");
        quiterBtn.setFont(new Font("Arial", 16));
        traceBtn.setStyle("-fx-font-weight: bold");
        traceBtn.setFont(new Font("Arial", 16));

        quiterBtn.setMinWidth(200);
        traceBtn.setMinWidth(200);
        hbox3.getChildren().add(quiterBtn);
        hbox3.getChildren().add(traceBtn);
        hbox3.setSpacing(50);
        hbox3.setPadding(new Insets(20, 0, 0, 25));

        resultatTitel.setPadding(new Insets(topPadding, 12, 15, 200));
        resultatTitel.setStyle("-fx-font-weight: bold");
        resultatTitel.setFont(new Font("Arial", 24));

        traceTitel.setPadding(new Insets(topPadding, 12, 15, 200));
        traceTitel.setStyle("-fx-font-weight: bold");
        traceTitel.setFont(new Font("Arial", 24));

        gridPane.add(hbox1,1,1);
        gridPane.add(hbox2,1,2);

        gridPane.add(resultatTitel,1,3);
        gridPane.add(resultatLabel,1,4);
        gridPane.add(traceTitel,1,5);
        gridPane.add(traceLabel,1,6);
        gridPane.add(hbox3,1,7);
        stage.show();


        latch.countDown();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void endThread(Thread[] th){
        startUpTest.quiterBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                for(int i=0;i<th.length;i++){
                    th[i].stop();
                    System.out.println("thread "+th[i].getName()+" stopped");
                }
                Platform.exit();
                System.out.println("FX thread stopped");

            }

        });

    }

}
