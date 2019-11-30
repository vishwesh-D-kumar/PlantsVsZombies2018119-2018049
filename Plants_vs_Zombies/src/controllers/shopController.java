package controllers;

import gameclasses.player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class shopController implements Serializable {
    @FXML private Button slotBuyButton;
    @FXML private TextField  slotPriceText;
    @FXML private TextField error;
    @FXML private ImageView bg;
    @FXML private ImageView snowpeashooter;
    @FXML private ImageView firepeashooter;
    @FXML private ImageView torchwood;
    @FXML private ImageView wallnut;
    @FXML private ImageView potatomine;

    private  player mainplayer;
    private int slotPrice=100;
//    public shopController(){
//        bg.setImage("@../sprites/background/menu_bg.jpg");
//    }


    public void setMainplayer(){
        mainplayer=player.getCurrPlayer();
        System.out.println(mainplayer.getCoins());

    }
    public void buySlot(ActionEvent evt) {
        setMainplayer();
        try{
            mainplayer.reduceCoins(slotPrice);
            mainplayer.addSlot();
            error.setText("You now have "+ mainplayer.getNumSlots());
        }
        catch (Exception e){
            //Set the textfield for errors
            error.setText(e.getMessage());
        }
    }


    public void buyPlant(MouseEvent mouseEvent) {
        setMainplayer();
        System.out.println(        (  (ImageView)mouseEvent.getSource()).getId()
        );
        int cost=10000000;
        //Uncomment code
        switch (        (  (ImageView)mouseEvent.getSource()).getId()
        ){
            case "snowpeashooter":
                error.setText("Cost of this is : "+20);
        cost=20;
                try{
                    mainplayer.reduceCoins(cost);
                    mainplayer.getUnlockedPlants()[1]=true;
//                    mainplayer.getUnlockedPlants().add(new entity.SnowPea());



                }
                catch(Exception e){
                    error.setText(e.getMessage());
                }
                break;
            case "wallnut":
                error.setText("Cost of this is : "+40);
                cost=40;
                try{
                    mainplayer.reduceCoins(cost);
//                    mainplayer.getUnlockedPlants().add(new entity.SnowPea(0,0));
                    mainplayer.getUnlockedPlants()[2]=true;

                }
                catch(Exception e){
                    error.setText(e.getMessage());

                }
                break;
            case "torchwood":
                error.setText("Cost of this is : "+200);
                cost=200;
                try{
                    mainplayer.reduceCoins(cost);
                    mainplayer.getUnlockedPlants()[3]=true;



                }
                catch(Exception e){
                    error.setText(e.getMessage());
                }
                break;
            case "firepeashooter":
                error.setText("Cost of this is : "+100);

                cost=100;
                try{
                    mainplayer.reduceCoins(cost);
                    mainplayer.getUnlockedPlants()[4]=true;

                }
                catch(Exception e){
                    error.setText(e.getMessage());
                }
                break;
            case "potatomine":
                error.setText("Cost of this is : "+300);
                cost=300;

                try{
                    mainplayer.reduceCoins(cost);
                    mainplayer.getUnlockedPlants()[5]=true;

                }
                catch(Exception e){
                    error.setText(e.getMessage());
            }
                break;
            default:
                cost=300;
                error.setText("error");
                break;



        }

    }

    public void showPrice(MouseEvent mouseEvent)
        {
//            setMainplayer();

            switch (((ImageView)mouseEvent.getSource()).getId()){
                case "snowpeashooter":
                    error.setText("Cost of this is : "+20);
                    break;
                case "wallnut":
                    error.setText("Cost of this is : "+40);
                    break;
                case "torchwood":
                    error.setText("Cost of this is : "+200);
                    break;
                case "firepeashooter":
                    error.setText("Cost of this is : "+100);
                    break;
                case "potatomine":
                    error.setText("Cost of this is : "+300);
                    break;
                default:
                    error.setText("error");
                    break;



            }

        }

}

