package com.deichor.advancedcolorapi.placeholders.placeholders;

import com.deichor.advancedcolorapi.placeholders.Placeholder;
import com.deichor.advancedcolorapi.types.AdvancedColor;
import com.deichor.advancedcolorapi.types.comps.GradientedText;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class GradientPlaceholder extends Placeholder {
    public GradientPlaceholder() {
        super("gradient");
    }

    @Override
    public TextComponent render(String[] args, Player p) {
        if (
                args.length < 4
        ) return new TextComponent("args error");

        double x = Double.parseDouble(args[2]);
        ArrayList<AdvancedColor> colors_text = new ArrayList<>();
        for (String c : args[1].split(",")) {
            colors_text.add(new AdvancedColor(c));
        }

        StringBuilder text = new StringBuilder(args[3]);
        for(int i = 4; i < args.length; i++){
            text.append("_").append(args[i]);
        }

        GradientedText gradientedText = new GradientedText(text.toString().replaceAll("\\$\\{nick}", p.getName()), colors_text, x);
        return gradientedText.renderComponent();
    }
}
