package com.deichor.advancedcolorapi;

import com.deichor.advancedcolorapi.placeholders.PlaceholderRegister;
import org.bukkit.ChatColor;

import java.util.logging.Logger;

public class General {

    public static Logger logger;

    public static final String vesrion = "1.6.3";

    public static void On(){

        logger.info(ChatColor.BLUE+"[AdvacedColorAPI] Spigot version");
        logger.info(ChatColor.AQUA+"[AdvacedColorAPI] Loaded!");

        logger.info(ChatColor.DARK_RED+"==============================================");
        logger.info(ChatColor.RED+"This plugin is just a library for developing other plugins!\n");
        logger.info(ChatColor.RED+"\n" );
        logger.info(ChatColor.RED+"It contains commands for testing the plugin!");
        logger.info(ChatColor.RED+"(If you are using Spigot)");
        logger.info(ChatColor.DARK_RED+"==============================================");


    }
}
