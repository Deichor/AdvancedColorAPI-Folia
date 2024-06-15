package com.deichor.advancedcolorapi.placeholders.placeholders;

import com.deichor.advancedcolorapi.AdvancedColorAPI;
import com.deichor.advancedcolorapi.placeholders.Placeholder;
import com.deichor.advancedcolorapi.types.AdvancedColor;
import com.deichor.advancedcolorapi.types.comps.GradientedText;

import com.deichor.advancedcolorapi.utils.PluginUtils;
import io.papermc.paper.threadedregions.scheduler.ScheduledTask;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class RainbowPlaceholder extends Placeholder {
    private final float[] h = {0f};
    private float s = 1f;
    private float l = 1f;

    private final float[] h2 = {0.1f};

    private final float[] i = {0};
    private int id = 0;
    private final int finalId = id;

    private ArrayList<AdvancedColor> colors = new ArrayList<>();

    public RainbowPlaceholder() {
        super("rainbow");



        if(PluginUtils.isFolia()){

            Bukkit.getGlobalRegionScheduler().runAtFixedRate(AdvancedColorAPI.i, tasking -> {
                if(i[0] > 4f){

                    tasking.cancel();
                }

                h[0] += 0.02f;
                h2[0] += 0.02f;

                colors = new ArrayList<>();
                colors.add(new AdvancedColor(AdvancedColor.hsl2rgb(h[0],s,l)));
                colors.add(new AdvancedColor(AdvancedColor.hsl2rgb(h2[0],s,l)));

                i[0] += 0.02F;
            }, 1, 1);

        }else {
            id = Bukkit.getScheduler().scheduleSyncRepeatingTask(AdvancedColorAPI.i, () -> {
                if(i[0] > 4f){
                    Bukkit.getScheduler().cancelTask(finalId);
                }

                h[0] += 0.02f;
                h2[0] += 0.02f;

                colors = new ArrayList<>();
                colors.add(new AdvancedColor(AdvancedColor.hsl2rgb(h[0],s,l)));
                colors.add(new AdvancedColor(AdvancedColor.hsl2rgb(h2[0],s,l)));

                i[0] += 0.02F;
            },0,1);
        }

    }

    @Override
    public TextComponent render(String[] args, Player p) {
        StringBuilder text = new StringBuilder(args[1]);
        for(int i = 2; i < args.length; i++){
            text.append("_").append(args[i]);
        }

        GradientedText gradientedText = new GradientedText(text.toString().replaceAll("\\$\\{nick}", p.getName()), colors, 0.4d);
        return gradientedText.renderComponent();
    }
}
