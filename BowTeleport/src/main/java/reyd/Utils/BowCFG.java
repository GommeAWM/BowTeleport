package reyd.Utils;

import cn.nukkit.utils.Config;
import reyd.BowTp;

import java.io.File;

public class BowCFG {

    private BowTp bowTp;
    private File file;
    private Config config;

    public BowCFG(BowTp bowTp){
        this.bowTp = bowTp;
        this.file = new File(bowTp.getDataFolder(), "/config.yml");
        this.config = new Config(this.file, Config.YAML);
    }

    public void createDefaultConfig(){
        this.addDefault("options.messages.join", "§aBow Teleportation has been enabled!");
        this.addDefault("options.messages.quit", "§cBow Teleportation has been disabled!");
        this.addDefault("options.messages.teleport", "§cYou have successfully teleported");
        this.addDefault("options.messages.permission", "§cYou need Permission");
        this.addDefault("options.command.description", "§cBow Teleportation");
        this.addDefault("options.snowball", true);
        this.addDefault("options.arrow", true);
    }


    public String join() {
        return this.config.getString("options.messages.join");
    }

    public String quit() {
        return this.config.getString("options.messages.quit");
    }

    public String tp() {
        return this.config.getString("options.messages.teleport");
    }

    public String permission() {
        return this.config.getString("options.messages.permission");
    }

    public boolean snow() {
        return this.config.getBoolean("options.snowball");
    }

    public boolean arrow() {
        return this.config.getBoolean("options.arrow");
    }

    public String descr() {
        return this.config.getString("options.command.description");
    }

    public void addDefault(String path, Object object){
        if(!this.config.exists(path)){
            this.config.set(path, object);
            this.config.save(this.file);
        }
    }

}
