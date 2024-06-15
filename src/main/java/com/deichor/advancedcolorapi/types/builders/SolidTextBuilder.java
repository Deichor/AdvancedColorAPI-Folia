package com.deichor.advancedcolorapi.types.builders;

import com.deichor.advancedcolorapi.types.AdvancedColor;
import com.deichor.advancedcolorapi.types.сomponents.GradientedText;
import com.deichor.advancedcolorapi.types.сomponents.SolidText;

import java.util.ArrayList;

public class SolidTextBuilder{

    private AdvancedColor color;
    private String text;

    public SolidTextBuilder text(String text){
        this.text = text;
        return this;
    }

    public SolidTextBuilder color(AdvancedColor color){
        this.color = color;
        return this;
    }

    public SolidTextBuilder color(String color){
        this.color = new AdvancedColor(color);
        return this;
    }

    public SolidText build(){
        return new SolidText(text,color);
    }
}
