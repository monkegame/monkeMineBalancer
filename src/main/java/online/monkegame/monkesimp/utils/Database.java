package online.monkegame.monkesimp.utils;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Database {


    private File folder;
    private Logger logger;

    public Database(JavaPlugin plugin) {
        this.folder = plugin.getDataFolder();
        this.logger = plugin.getLogger();
    }

    public void createDataBase() {

        String dbFolder = folder + System.getProperty("file.separator") + "";

        //create files
        try {
            if (new File(dbFolder).mkdir() && new File(dbFolder + System.getProperty("file.separator") + "timespent.db").createNewFile()) {
                logger.info("Database created.");
            } else {
                logger.info("Database found, using it.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //create table in db
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dbFolder + System.getProperty("file.separator") + "timespent.db");
             PreparedStatement createQuery = conn.prepareStatement("""
                     CREATE TABLE IF NOT EXISTS "clan" 
                     (\s 
                     	"uuid" TEXT UNIQUE, 
                     	"clan" TEXT, 
                     	PRIMARY KEY("uuid") 
                     );
                     """)) {
            createQuery.execute();
        } catch (SQLException ea) {
            ea.printStackTrace();
        }

    }

}
