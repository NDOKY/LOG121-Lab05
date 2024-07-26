package com.example;

import java.util.ArrayList;

public class ModelPerspective extends Subject {
    
    private String perspective;
    ArrayList<Observer> listModelPerspective = new ArrayList<>();

    @Override
    public void addObserver(Observer vueAjoute){
        listModelPerspective.add(vueAjoute);
    }
    @Override
    public void removeObserver(Observer vueRetire){
        listModelPerspective.remove(vueRetire);
    }
    @Override
    public void notifyObserver(){

        for (Observer elem : listModelPerspective) {

            elem.display();
            
        }

    }
    
    public ModelPerspective(String perspective){
        this.perspective = perspective;
    }
    
    public String getPerspective(){
        return this.perspective;
    }
    
    public void setPerspective(String perspective){
        this.perspective = perspective;
        this.notifyObserver();
    }
}
