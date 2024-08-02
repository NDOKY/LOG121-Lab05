package com.example;

import java.util.ArrayList;

public class ModelPerspective extends Subject {
    
    private String perspective;
    ArrayList<Observer> listModelPerspective = new ArrayList<>();
    Double scaleX = 0.0;
    Double scaleY = 0.0;

    public void setScaleXY(Double scaleX, Double scaleY) {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.notifyObserver(scaleX, scaleY);
    }
    
    public Double getScaleX() {
        return scaleX;
    }
    public Double getScaleY() {
        return scaleY;
    }
    @Override
    public void addObserver(Observer vueAjoute){
        listModelPerspective.add(vueAjoute);
    }
    @Override
    public void removeObserver(Observer vueRetire){
        listModelPerspective.remove(vueRetire);
    }
    @Override
    public void notifyObserver(Double heightDouble, Double widthDouble){

        for (Observer elem : listModelPerspective) {

            elem.display();
            
        }

    }
    
    public String getPerspective(){
        return this.perspective;
    }
    
    public ModelPerspective() {
    }

    public void setPerspective(String perspective){
        this.perspective = perspective;
    }
}
