package com.deichor.advancedcolorapi.types;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTextComponent implements Cloneable {
    protected List<BaseTextComponent> _components = new ArrayList<>();

    public TextComponent renderComponent() {
        TextComponent txt = new TextComponent();
        for (BaseTextComponent component : _components) {
            txt.addExtra(component.renderComponent());
        }
        return txt;
    }

    @Deprecated
    public String getJsonText(){
        return renderComponent().toLegacyText();
    }

    public String getRenderedText(){
        return renderComponent().toLegacyText();
    }


    public void addComponent(BaseTextComponent component){
        _components.add(component);
    }


    @Override
    public  Object clone() {
        try {
            return (BaseComponent) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return this;
        }
    }
}
