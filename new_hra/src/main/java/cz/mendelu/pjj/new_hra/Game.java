package cz.mendelu.pjj.new_hra;



import javax.lang.model.type.NullType;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Game implements Serializable {
    static Player pl1;
    static Player pl2;
    static Player curentPl;
    public Mapa mapa;

    Game() {
       this.mapa=new Mapa();
       pl1= new Player("Blue");
       pl2= new Player("Yellow");
       curentPl=pl1;
    }


    public static  Game createNewGame(){
       Game game= new Game();
       return game;
}

    public void hodHry(){

    }

    public static void changeCurrentPlayer(){
        if(curentPl==pl1){
            curentPl=pl2;
        }else
            curentPl=pl1;
    }


    public static File file(String name) {
        var dir = new File("saves");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return new File(dir, name + ".game");
    }

    /**
     * Save game to folder
     * @param game -- the game
     * @param name -- name of file
     *
     * @author xsuniaik
     * @version etapa 4
     */
    public static void save(Game game, String name) {
        try (var out = new ObjectOutputStream(new FileOutputStream(file(name))))  {
            out.writeObject(game);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Load game from save folder.
     * @param name-- name of file
     * @return loaded game
     *
     * @author xsuniaik
     * @version etapa 4
     */
    public static Game load(String name) {
        try (var in = new ObjectInputStream(new FileInputStream(file(name))))  {
            return (Game) in.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Load game failed.", e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Load game failed.", e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Load game failed.", e);
        }

    }


    public Mapa getMapa() {
        return mapa;
    }

    public static Player getCurentPl() {
        return curentPl;
    }
}