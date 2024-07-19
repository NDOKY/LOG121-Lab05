package com.example;
import java.util.ArrayList;
import java.util.List;
//ma classe commandehistory est un singleton


public class CommandeHistory {
    
    private List<Commande> commandes = new ArrayList<Commande>();
    private static CommandeHistory instance = null;

    public static CommandeHistory getInstance(){
        if(instance == null){
            instance = new CommandeHistory();
        }
        return instance;
    }

    public void push(Commande c){
        //ajoute une commande à la liste

    }
    public Commande pop(){
        //retire la dernière commande de la liste
        return null;
    }

    private CommandeHistory(){

    }

}
