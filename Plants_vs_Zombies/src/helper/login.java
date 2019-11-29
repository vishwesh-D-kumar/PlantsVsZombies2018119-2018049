package helper;
import errors.passwordMismatch;
import errors.userNameExists;
import errors.userNotFound;
import gameclasses.player;

import java.io.Serializable;
import java.util.HashMap;

public class login implements Serializable {
    private static HashMap<String,String> nameToPass;
    private static HashMap<String,gameclasses.player> nameToPlayer;
    private  HashMap<String,String> nameToPass2;
    private  HashMap<String,gameclasses.player> nameToPlayer2;

    public static player getPlayer (String userName, String password ) throws userNotFound, passwordMismatch {
     if (!nameToPass.containsKey(userName)){
            throw new errors.userNotFound();
     }
     if (!nameToPass.get(userName).equals(password)){
         throw new errors.passwordMismatch();

     }
     return nameToPlayer.get(userName);

    }

    public static void setNameToPass(HashMap<String, String> nameToPass) {
        login.nameToPass = nameToPass;
    }

    public static void setNameToPlayer(HashMap<String, player> nameToPlayer) {
        login.nameToPlayer = nameToPlayer;
    }
    public void onSave(){
        nameToPass2=nameToPass;
        nameToPlayer2=nameToPlayer;
    }
    public void initiliaze(){
        if (nameToPlayer2==null){
            nameToPlayer2=new HashMap<>();
            nameToPass2=new HashMap<>();
        }
        equalize();


    }
    private void equalize(){
        nameToPass=nameToPass2;
        nameToPlayer=nameToPlayer2;

    }
    public void addUser(String username, String password, player player) throws userNameExists {
        if (nameToPlayer.containsKey(username)){
            throw new errors.userNameExists();

        }
        nameToPlayer.put(username,player);
        nameToPass.put(username,password);

    }


}
