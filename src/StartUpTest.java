import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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

        Label nombreLabel1=new Label("nombre 1");
        Label nombreLabel2=new Label("nombre 2");
         resultatLabel=new Label("resultat");

        hbox1.getChildren().add(nombreLabel1);
        hbox1.getChildren().add(tf1);
        hbox1.getChildren().add(nombreLabel2);
        hbox1.getChildren().add(tf2);
        hbox1.setPadding(new Insets(topPadding, 12, 15, 12));

        sommeBtn=new Button("somme");
         produitBtn=new Button("produit");
         factorielBtn=new Button("factoriel");

        hbox2.getChildren().add(sommeBtn);
        hbox2.getChildren().add(produitBtn);
        hbox2.getChildren().add(factorielBtn);
        hbox2.setPadding(new Insets(topPadding, 12, 15, 12));

        resultatLabel.setMinHeight(100);
        resultatLabel.setMinWidth(100);
        resultatLabel.setBackground(new Background(new BackgroundFill(Color.rgb(255, 242, 155), CornerRadii.EMPTY, Insets.EMPTY)));
        resultatLabel.setPadding(new Insets(topPadding, 12, 15, 12));

        Button quiterBtn=new Button("quiter");
        Button traceBtn=new Button("trace");

        hbox3.getChildren().add(quiterBtn);
        hbox3.getChildren().add(traceBtn);
        hbox3.setPadding(new Insets(topPadding, 12, 15, 12));

        gridPane.add(hbox1,1,1);
        gridPane.add(hbox2,1,2);
        gridPane.add(resultatLabel,1,3);
        gridPane.add(hbox3,1,4);
        stage.show();


        latch.countDown();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }


}
