package pinoco.com.minecraftbutmobshaverandomhealth;

import org.bukkit.plugin.java.JavaPlugin;
import pinoco.com.minecraftbutmobshaverandomhealth.eventlisteners.CreatureSpawnEventListener;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        registerEventListeners();
    }

    private void registerEventListeners() {
        new CreatureSpawnEventListener(this);
    }
}
