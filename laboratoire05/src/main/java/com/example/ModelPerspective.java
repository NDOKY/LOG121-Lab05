package com.example;

public class ModelPerspective extends Subject {
    
    private String perspective;
    
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
