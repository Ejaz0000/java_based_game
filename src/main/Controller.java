package main;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    AnimationTimer gameloop;

    @FXML
    private Rectangle bird;


    @FXML
    private Rectangle rec01;

    @FXML
    private Rectangle rec02;

    @FXML
    private Rectangle rec03;

    @FXML
    private Rectangle rec04;

    @FXML
    private Rectangle rec05;

    @FXML
    private Rectangle rec06;

    @FXML
    private Rectangle rec07;

    @FXML
    private Rectangle rec08;

    @FXML
    private Rectangle rec09;

    @FXML
    private Rectangle rec10;

    @FXML
    private Rectangle rec11;

    @FXML
    private Rectangle rec12;

    @FXML
    private Rectangle rec13;

    @FXML
    private Rectangle rec14;

    @FXML
    private Rectangle rec15;

    @FXML
    private AnchorPane plane;

    @FXML
    private Text start_txt;

    @FXML
    private Text instruct_txt;

    @FXML
    private Text lvl01;


    double yDelta = 0.02;
    double xDelta = 20;
    double time =0;
    int jumpheight=40;

    Rectangle[] rectangles = new Rectangle[15];




    @FXML
    void pressed(KeyEvent event) {
        if(event.getCode() == KeyCode.RIGHT && !(start_txt.isVisible())){
            gameloop.start();
            fly(xDelta);

        }

        if(event.getCode() == KeyCode.LEFT && !(start_txt.isVisible())){
            gameloop.start();
            fly(-xDelta);

        }

        if(event.getCode() == KeyCode.ENTER){
            start_txt.setVisible(false);
            instruct_txt.setVisible(false);

            gameloop.start();
        }

        if(event.getCode() == KeyCode.UP){
            gameloop.stop();
            Nextlvl nextlvl = new Nextlvl();
            try {
                nextlvl.changelvl(lvl01);
            }catch (Exception e){
                System.out.println(e.getCause());
            }

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        load();

        gameloop = new AnimationTimer() {

            @Override
            public void handle(long l) {
                update();
            }
        };



    }

    public void load(){

        rectangles[0] = rec01;
        rectangles[1] = rec02;
        rectangles[2] = rec03;
        rectangles[3] = rec04;
        rectangles[4] = rec05;
        rectangles[5] = rec06;
        rectangles[6] = rec07;
        rectangles[7] = rec08;
        rectangles[8] = rec09;
        rectangles[9] = rec10;
        rectangles[10] = rec11;
        rectangles[11] = rec12;
        rectangles[12] = rec13;
        rectangles[13] = rec14;
        rectangles[14] = rec15;
    }

    public void fly(double move_dir){
        if(bird.getLayoutY()+bird.getY() <= jumpheight){
            moveBirdY(-(bird.getLayoutY() + bird.getY()));
            moveBirdX(move_dir);
            time = 0;
            return;
        }


        moveBirdY(-jumpheight);
        moveBirdX(move_dir);
        time=0;
    }

    public void update(){
        time++;

        moveBirdY(yDelta*time);

        if(isBirdDead()){
            resetBird();
            start_txt.setVisible(true);
        }

        if(isBirdWon()){
            gameloop.stop();
            time=0;
            Nextlvl nextlvl = new Nextlvl();
            try {
                nextlvl.changelvl(lvl01);
            }catch (Exception e){
                System.out.println(e);
            }

        }

    }

    private boolean isBirdWon() {

        double birdY = bird.getLayoutY()+bird.getY();

        return birdY >= plane.getHeight();
    }

    private void resetBird() {
        gameloop.stop();
        bird.setY(0);
        bird.setX(0);
        time=0;
    }

    private boolean isBirdDead() {


        for (Rectangle rectangle : rectangles) {
            if (rectangle.getBoundsInParent().intersects(bird.getBoundsInParent())) {
                return true;
            }
        }



        return false;
    }


    private void moveBirdY(double positionChange){
        bird.setY(bird.getY() + positionChange);

    }private void moveBirdX(double positionChange){
        bird.setX(bird.getX() + positionChange);
    }
}
