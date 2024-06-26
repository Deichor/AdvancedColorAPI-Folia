package com.deichor.advancedcolorapi.placeholders;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public abstract class Placeholder {
    protected String _name;

    public Placeholder(String name){
        _name = name;
    }

    public String getName(){
        return _name;
    }
    public TextComponent render(String[] args, Player p){
        return new TextComponent(_name+" placeholder");
    }
    public void setName(String name){
        _name = name;
    }
}
