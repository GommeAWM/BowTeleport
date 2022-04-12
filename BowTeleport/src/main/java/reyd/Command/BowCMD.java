package reyd.Command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import reyd.BowTp;

public class BowCMD extends Command {

    public BowCMD(String cmd, String descr){
        super(cmd, descr);
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] args) {

        if (commandSender instanceof Player){
            Player player = (Player) commandSender;

            if (!player.hasPermission("reyd.bow")){
                player.sendMessage(BowTp.getAuctionConfig().permission());
                return true;
            }

            if (BowTp.getInstance().bowtpPlayers.contains(player.getUniqueId())){
                BowTp.getInstance().bowtpPlayers.remove(player.getUniqueId());
                player.sendMessage(BowTp.getAuctionConfig().quit());
            } else if (!BowTp.getInstance().bowtpPlayers.contains(player.getUniqueId())){
                BowTp.getInstance().bowtpPlayers.add(player.getUniqueId());
                player.sendMessage(BowTp.getAuctionConfig().join());
            }

            if (args.length == 1){
                String msg = args[0];

                if (msg.equals("info")){
                    player.sendMessage("§b[§aBowTeleport§b] §fThe owner of this plugin is §aDaniel Reydovich §b(§eGommeAWM§b) §7// §cxxtdaniel");
                    return true;
                }
            }

        }

        return true;
    }
}
