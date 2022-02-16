package by.kukyan.customarr.observer.impl;

import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.entity.CustomCollection;

import java.util.EventObject;

public class CustomArrayEvent extends EventObject {

    public CustomArrayEvent(CustomCollection source) {
        super(source);
    }
    @Override
    public CustomArray getSource(){
        return (CustomArray) super.getSource();
    }
}
