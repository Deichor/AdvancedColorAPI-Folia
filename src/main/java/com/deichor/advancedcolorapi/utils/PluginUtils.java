package com.deichor.advancedcolorapi.utils;

import org.bukkit.Bukkit;

public class PluginUtils {
    public static boolean isFolia() {
        try {
            Class.forName("io.papermc.paper.threadedregions.RegionizedServer");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}