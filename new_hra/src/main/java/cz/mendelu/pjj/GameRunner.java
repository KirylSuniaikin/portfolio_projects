package cz.mendelu.pjj;


import bh.greenfoot.runner.GreenfootRunner;
import cz.mendelu.pjj.new_hra.greenfoot.GameWorld;
import cz.mendelu.pjj.new_hra.greenfoot.TitleScreen;


/**
 * A sample runner for a greenfoot project.
 */
public class GameRunner extends GreenfootRunner {
    static {
        // 2. Bootstrap the runner class.
        bootstrap(GameRunner.class,
                // 3. Prepare the configuration for the runner based on the world class
                GreenfootRunner.Configuration.forWorld(TitleScreen.class)
                        // Set the project name as you wish
                        .projectName("Catan Junior")
                        .hideControls(true)
        );
    }

    public static void main(String[] args) {
        GreenfootRunner.main(args);
    }
}