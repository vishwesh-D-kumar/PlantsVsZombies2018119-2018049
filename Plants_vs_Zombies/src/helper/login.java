package helper;
import errors.passwordMismatch;
import errors.userNameExists;
import errors.userNotFound;
import gameclasses.player;

import java.io.*;
import java.util.HashMap;

public class login implements Serializable {
    private  HashMap<String,String> nameToPass;
    private  HashMap<String,gameclasses.player> nameToPlayer;
    public login (){
        nameToPass=new HashMap<>();
        nameToPlayer=new HashMap<>();

    }
    public player getPlayer (String userName, String password ) throws userNotFound, passwordMismatch {
     if (!nameToPass.containsKey(userName)){
            throw new errors.userNotFound();
     }
     if (!nameToPass.get(userName).equals(password)){
         throw new errors.passwordMismatch();

     }
     return nameToPlayer.get(userName);

    }


//    public void onSave(){
//        nameToPass2=nameToPass;
//        nameToPlayer2=nameToPlayer;
//    }
//    public void initiliaze(){
//        if (nameToPlayer2==null){
//            nameToPlayer2=new HashMap<>();
//            nameToPass2=new HashMap<>();
//        }
//        equalize();
//

//    }
//    private void equalize(){
//        nameToPass=nameToPass2;
//        nameToPlayer=nameToPlayer2;
//
//    }
    public  void serialize() throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream (
                     new FileOutputStream("login.txt"));
            out.writeObject(this);
             } finally {
            out.close();
             }
    }
    public static login deserialize()
 throws IOException, ClassNotFoundException {
         ObjectInputStream in = null;
        try {
             in = new ObjectInputStream (
                     new FileInputStream("login.txt"));
             login s1 = (login) in.readObject();
            return s1;
             } finally {
             in.close();
             }

         }
    public void addUser(String username, String password, player player) throws userNameExists, IOException {
        if (nameToPlayer.containsKey(username)){
            throw new errors.userNameExists();

        }
        nameToPlayer.put(username,player);
        nameToPass.put(username,password);
        serialize();
    }



}
