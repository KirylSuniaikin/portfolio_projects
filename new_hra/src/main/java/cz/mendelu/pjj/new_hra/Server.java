package cz.mendelu.pjj.new_hra;

import com.google.gson.Gson;
import cz.mendelu.pjj.new_hra.greenfoot.GameWorld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.util.Arrays;

/**
 *Class servera aby dva hrace mohli hrat
 *
 * @author xsuniaik
 * @version etapa 5
 */
public class Server extends Thread{

    private GameWorld gameWorld;

    public Server(GameWorld gameWorld){
        this.gameWorld= gameWorld;
    }

    @Override
    public void run() {
        try {
            var gson = new Gson();
            var ss = new ServerSocket(2000);
            System.out.println("Server run on port 2000");
            while (!isInterrupted()) {
                var cs = ss.accept();
                var barva = gameWorld.getGame().getCurentPl().color;
                System.out.println("New " + barva + " client accepted: " + cs);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
