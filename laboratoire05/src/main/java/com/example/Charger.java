package com.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Charger implements CommandeImage, Serializable{

    
    Observer vf;
    Observer vp01;
    Observer vp02;
    ArrayList<Observer> mArrayList = new ArrayList<>();

    public void executer(){
        try {
            FileInputStream fileIn = new FileInputStream("Image.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            mArrayList = (ArrayList<Observer>)in.readObject();

            vf = mArrayList.get(0);
            vp01 = mArrayList.get(1);
            vp02 = mArrayList.get(2);
            
        } catch (IOException i) {
            i.printStackTrace();
        }catch(ClassNotFoundException c){
            c.printStackTrace();
        }
    }
    
}
