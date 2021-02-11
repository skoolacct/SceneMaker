/*
 * SceneMaker
 *
 * Testbed to try out new Scene designs
 *
 */



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.util.Random;


public class SceneMaker extends Application
{

    private int count = 0;
    private int incorrect = 0;

    private Label myLabelScene1 = new Label("Score = 0");
    private Label counterTwo = new Label("0");
    private Label myLabelScene2 = new Label("100");
    private Label whichPerson = new Label("");
    private Label incorrectCount = new Label("Wrong answers: " + incorrect);
    private Label accuracy = new Label("Accuracy: 0");
    private Stage safeStage;        // common stage used for all scenes

    private Random x = new Random();
    private int num = x.nextInt(3);

    private Scene scene1;
    private Scene scene2;
    private Scene scene3;
    private Scene scene4;
    private Scene scene5;

    @Override
    public void start(Stage stage) throws Exception
    {

        this.safeStage = stage;


        // JavaFX must have a Scene (window content) inside a Stage (window)
        // Build scenes for each screen ahead of time
        scene1 = makeScene1();
        scene2 = makeScene2();
        scene3 = makeScene3();
        scene4 = makeScene4();
        scene5 = makeScene5();


        // Set the title and scene for the first screen to be visible
        stage.setTitle("JavaFX Example");
        stage.setScene(scene3);

        // Show the Stage (window)
        stage.show();
    }


    public Scene makeScene1()
    {
        int minWidth = 300;
        int minHeight = 300;

        // Implement the layout of this scene/screen
        Button myButton = new Button("Person 1");
        Button buttonTwo = new Button("Person 2");
        Button buttonThree = new Button("Person 3");
        Button buttonFour = new Button("Person 4");

        // Create a new grid pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(minWidth, minHeight);
        pane.setVgap(10);
        pane.setHgap(10);

        //set an action on the button using method reference
        myButton.setOnAction(this::buttonClickScene1);
        buttonTwo.setOnAction(this::addTwoButton);
        buttonThree.setOnAction(this::addThreeButton);
        buttonFour.setOnAction(this::addFourButton);

        setWhichPerson();

        // Add labels into the pane
        pane.add(myLabelScene1, 0, 0);
        pane.add(whichPerson, 0, 1);
        pane.add(incorrectCount, 0, 2);
        pane.add(accuracy, 0, 3);

        // Add buttons into the pane
        pane.add(myButton, 1, 0);
        pane.add(buttonTwo, 1, 1);
        pane.add(buttonThree, 1, 2);
        pane.add(buttonFour, 1, 3);

        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(pane, 300,200);
        return scene;
    }


    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     */

    /*
    count = count + 1;
    myLabelScene1.setText(Integer.toString(count));
    if ((count % 5) == 0){
        safeStage.setTitle("Next Scene");
        safeStage.setScene(scene2);

        // Show the Stage (window)
        safeStage.show();
    }
    */

    private void setNewRandNum(){
        num = x.nextInt(3);
        setWhichPerson();
    }

    private void buttonClickScene1(ActionEvent event)
    {
        if (num == 0){
            count ++;
            myLabelScene1.setText("Score = " + count);
        }else{
            incorrect ++;
            incorrectCount.setText("Wrong answers: " + incorrect);
        }
        setNewRandNum();
        accuracy.setText("Accuracy: " + doAccuracy());
        checkNextScene();
        //System.out.println(count);
    }

    private void addTwoButton(ActionEvent event){
        if (num == 1){
            count ++;
            myLabelScene1.setText("Score = " + count);
        }else{
            incorrect ++;
            incorrectCount.setText("Wrong answers: " + incorrect);
        }
        setNewRandNum();
        accuracy.setText("Accuracy: " + doAccuracy());
        checkNextScene();
        //System.out.println(count);
    }

    private void addThreeButton(ActionEvent event){
        if (num == 2){
            count ++;
            myLabelScene1.setText("Score = " + count);
        }else{
            incorrect ++;
            incorrectCount.setText("Wrong answers: " + incorrect);
        }
        setNewRandNum();
        accuracy.setText("Accuracy: " + doAccuracy());
        checkNextScene();
        //System.out.println(count);
    }

    private void addFourButton(ActionEvent event){
        if (num == 3){
            count ++;
            myLabelScene1.setText("Score = " + count);
        }else{
            incorrect ++;
            incorrectCount.setText("Wrong answers: " + incorrect);
        }
        setNewRandNum();
        accuracy.setText("Accuracy: " + doAccuracy());
        checkNextScene();
        //System.out.println(count);
    }

    private void setWhichPerson(){
        whichPerson.setText("Person " + (num+1));
    }

    // get accuracy of the player
    private int doAccuracy(){
        double acc;
        if(incorrect != 0){
            acc = (double)count / (count + incorrect);
            acc = acc * 100;
        }else{
            acc = 100;
        }
        return (int)acc;
    }

    private void checkNextScene(){
        if ((count % 5) == 0){
            safeStage.setTitle("Next Scene");
            safeStage.setScene(scene2);

            // Show the Stage (window)
            safeStage.show();
        }
    }

    ////////////////////////////////////////////////////////////////


    public Scene makeScene2()
    {
        // Implement the layout of this scene/screen
        Button myButton = new Button("Next");

        // Create a new grid pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(300, 300);
        pane.setVgap(10);
        pane.setHgap(10);

        //set an action on the button using method reference
        myButton.setOnAction(this::buttonClickScene2);

        // Add the button and label into the pane
        pane.add(myLabelScene2, 0, 0);
        pane.add(myButton, 1, 0);

        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(pane, 500,400);
        return scene;
    }



    /**
     * This will be executed when the button is clicked
     *
     */
    private void buttonClickScene2(ActionEvent event)
    {
        // Counts number of button clicks and shows the result on a label
        //count = count + 1;
        //myLabel.setText(Integer.toString(count));
        myLabelScene2.setText(Integer.toString(count+100));
        {
            safeStage.setTitle("First Scene");
            safeStage.setScene(scene1);

            // Show the Stage (window)
            safeStage.show();
        }


    }

    ////////////////////////////////////////////////////////////////

    public Label title = new Label("Gamemode");
    public ImageView picture = new ImageView("dorime_pic.jpg");

    public Scene makeScene3()
    {
        int minWidth = 400;
        int minHeight = 400;

        Button buttonOne = new Button("Person 1");
        Button buttonTwo = new Button("Person 2");
        Button buttonThree = new Button("Person 3");
        Button buttonFour = new Button("Person 4");

        // Create a new grid pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(minWidth, minHeight);
        pane.setVgap(10);
        pane.setHgap(10);

        //setting the fit height and width of the image view
        picture.setFitHeight(250);
        picture.setFitWidth(250);

        title.setTextAlignment(TextAlignment.CENTER);

        //Setting the preserve ratio of the image view
        picture.setPreserveRatio(true);

        // add things to screen
        pane.add(title, 0, 0, 3, 1);
        pane.add(picture, 0, 1);

        pane.add(buttonOne, 1, 1);
        pane.add(buttonTwo, 1, 2);
        pane.add(buttonThree, 1, 3);
        pane.add(buttonFour, 1, 4);


        Scene scene = new Scene(pane, 400,400);
        return scene;
    }


    public Scene makeScene4()
    {
        return null;
    }

    public Scene makeScene5()
    {
        return null;
    }

}