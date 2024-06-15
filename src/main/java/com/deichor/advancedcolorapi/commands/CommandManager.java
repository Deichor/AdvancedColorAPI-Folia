package com.deichor.advancedcolorapi.commands;

import com.deichor.advancedcolorapi.General;
import com.deichor.advancedcolorapi.types.AdvancedColor;
import com.deichor.advancedcolorapi.types.сomponents.SolidText;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandManager implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if(args.length <= 0){
            commandSender.sendMessage(ChatColor.AQUA+"[AdvacedColorAPI]"+ChatColor.GRAY+" version: " + ChatColor.LIGHT_PURPLE + General.vesrion);
        }else{
            AdvancedColor color = new AdvancedColor(args[0]);

            SolidText solid = new SolidText(args[1],color);

            solid.addComponent(new SolidText(args[1],color.invert()));
            commandSender.sendMessage(solid.renderComponent().toLegacyText());
        }

        return true;
    }


}
