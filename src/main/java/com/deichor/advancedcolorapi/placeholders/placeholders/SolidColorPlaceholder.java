package com.deichor.advancedcolorapi.placeholders.placeholders;

import com.deichor.advancedcolorapi.placeholders.Placeholder;
import com.deichor.advancedcolorapi.types.AdvancedColor;
import com.deichor.advancedcolorapi.types.сomponents.SolidText;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class SolidColorPlaceholder extends Placeholder {
    public SolidColorPlaceholder() {
        super("color");
    }

    @Override
    public TextComponent render(String[] args, Player p) {
        return new SolidText(args[2].toString().replaceAll("\\$\\{nick}",p.getName()),new AdvancedColor(args[1])).renderComponent();
    }
}
