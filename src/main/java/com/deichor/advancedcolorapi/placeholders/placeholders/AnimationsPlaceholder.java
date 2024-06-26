package com.deichor.advancedcolorapi.placeholders.placeholders;

import com.deichor.advancedcolorapi.placeholders.Placeholder;
import com.deichor.advancedcolorapi.placeholders.animations.Moving;
import com.deichor.advancedcolorapi.types.AdvancedColor;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class AnimationsPlaceholder extends Placeholder {

    HashMap<Integer, Moving> animationHashMap = new HashMap<Integer, Moving>();

    public AnimationsPlaceholder() {
        super("an");
    }

    @Override
    public TextComponent render(String[] args, Player p) {

        StringBuilder allArgsBuilder = new StringBuilder(args[5]);
        for (String arg : args) {
            allArgsBuilder.append("_").append(arg);
        }
        String argsText = allArgsBuilder.toString().replaceAll("\\$\\{nick}",p.getName());

        StringBuilder textBuilder = new StringBuilder(args[5]);
        for(int i = 6; i < args.length; i++){
            textBuilder.append("_").append(args[i]);
        }
        String text = textBuilder.toString().replaceAll("\\$\\{nick}",p.getName());

        if(animationHashMap.containsKey(argsText.hashCode())){
            return animationHashMap.get(argsText.hashCode()).getText();
        }
        if(args[1].equals("move")){
            double x = Double.parseDouble(args[2]);
            int speed = Integer.parseInt(args[3]);

            ArrayList<AdvancedColor> colors_text = new ArrayList<>();
            for (String c : args[4].split(",")) {
                colors_text.add(new AdvancedColor(c));
            }

            Moving an = new Moving(text, speed,x,colors_text);

            animationHashMap.put(argsText.hashCode(),an);
            return an.getText();
        }else {
            return new TextComponent("undefined animation");
        }
    }
}
