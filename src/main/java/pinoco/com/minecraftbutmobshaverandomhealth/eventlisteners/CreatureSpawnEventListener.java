package pinoco.com.minecraftbutmobshaverandomhealth.eventlisteners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class CreatureSpawnEventListener implements Listener {

    private final Random random = new Random();
    private final JavaPlugin plugin;

    public CreatureSpawnEventListener(JavaPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onCreatureSpawnEvent(CreatureSpawnEvent e) {
        Entity entity = e.getEntity();
        if (entity instanceof Monster) {
            Monster monster = (Monster) entity;

            double minHealth = 1.0;
            double maxHealth = monster.getMaxHealth() * plugin.getConfig().getDouble("Mobs.MaxHealthMultiplier", 1.0);
            double health = (double) this.random.nextInt((int) (maxHealth - minHealth)) + minHealth;

            monster.setMaxHealth(maxHealth);
            monster.setHealth(health);
        }
    }

}
