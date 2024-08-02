package com.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Sauvegarder extends CommandeImage implements Serializable{

    transient Observer vf;
    Observer vp01;
    Observer vp02;
    ArrayList<Observer> mArrayList = new ArrayList<>();

    public Sauvegarder(VueFixe vf, VuePerspective vp01, VuePerspective vp02){

        this.vf = vf;
        this.vp01 = vp01;
        this.vp02 = vp02;

    }
    
    public void executer(){
        
        try {

            FileOutputStream fileOut = new FileOutputStream("Image.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fileOut);
            //mArrayList.add(vf);
            mArrayList.add(vp01);
            mArrayList.add(vp02);
            oos.writeObject(mArrayList);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
    
}
