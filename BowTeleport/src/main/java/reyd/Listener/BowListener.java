package reyd.Listener;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.projectile.EntityArrow;
import cn.nukkit.entity.projectile.EntityProjectile;
import cn.nukkit.entity.projectile.EntitySnowball;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.ProjectileHitEvent;
import cn.nukkit.level.Location;
import reyd.BowTp;

public class BowListener implements Listener {

    @EventHandler
    public void onProjectileHitEvent(ProjectileHitEvent event){
        Entity entity = event.getEntity();

        Entity entity1 = getShooter((EntityProjectile) entity);

        if (entity1 instanceof Player) {

            Player player = (Player) entity1;
            Location location = entity.getLocation();

            if (!BowTp.getInstance().bowtpPlayers.contains(player.getUniqueId())) {
                return;
            }

            if (entity instanceof EntitySnowball){
                if (BowTp.getAuctionConfig().snow()){
                    player.teleport(location);
                    player.sendTip(BowTp.getAuctionConfig().tp());
                }
            }

            if (entity instanceof EntityArrow){
                if (BowTp.getAuctionConfig().arrow()){
                    player.teleport(location);
                    player.sendTip(BowTp.getAuctionConfig().tp());
                }
            }

        }

    }

    private Entity getShooter(EntityProjectile projectile) {
        Entity source =  projectile.shootingEntity;
        return source;
    }

}
