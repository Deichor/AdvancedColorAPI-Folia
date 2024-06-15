package  com.deichor.advancedcolorapi;

import com.deichor.advancedcolorapi.commands.CommandManager;
import com.deichor.advancedcolorapi.placeholders.PlaceholderRegister;
import com.deichor.advancedcolorapi.placeholders.placeholders.AnimationsPlaceholder;
import com.deichor.advancedcolorapi.placeholders.placeholders.GradientPlaceholder;
import com.deichor.advancedcolorapi.placeholders.placeholders.RainbowPlaceholder;
import com.deichor.advancedcolorapi.placeholders.placeholders.SolidColorPlaceholder;
import com.deichor.advancedcolorapi.utils.Debug;
import com.deichor.advancedcolorapi.utils.PluginUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class AdvancedColorAPI extends JavaPlugin {

    public static AdvancedColorAPI i;

    @Override
    public void onEnable() {
        getCommand("ac").setExecutor(new CommandManager());
        General.logger = getLogger();
        Debug.setLogger(getLogger());
        General.On();
        i = this;

        if(Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")){
            PlaceholderRegister placeholderRegister = new PlaceholderRegister();

            placeholderRegister
                    .registerPlaceholder(new AnimationsPlaceholder())
                    .registerPlaceholder(new GradientPlaceholder())
                    .registerPlaceholder(new SolidColorPlaceholder())
                    .registerPlaceholder(new RainbowPlaceholder());

            placeholderRegister.register();

        }
    }
}
