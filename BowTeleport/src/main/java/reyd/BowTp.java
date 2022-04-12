package reyd;

import cn.nukkit.command.SimpleCommandMap;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import reyd.Command.BowCMD;
import reyd.Listener.BowListener;
import reyd.Utils.BowCFG;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class BowTp extends PluginBase {

    private static BowCFG bowCFG;


    private static BowTp instance;
    public Set<UUID> bowtpPlayers = new HashSet<>();

    @Override
    public void onEnable() {
        bowCFG = new BowCFG(this);
        bowCFG.createDefaultConfig();
        instance = this;
        register();
        this.getLogger().info("§fEnable: §aBowTeleport");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("§fDisable: §cBowTeleport");
    }

    private void register(){
        SimpleCommandMap simpleCommandMap = getServer().getCommandMap();
        simpleCommandMap.register("help", new BowCMD("bowtp", BowTp.bowCFG.descr()));

        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new BowListener(), this);
    }

    public static BowTp getInstance(){
        return instance;
    }

    public static BowCFG getAuctionConfig(){
        return bowCFG;
    }

}
