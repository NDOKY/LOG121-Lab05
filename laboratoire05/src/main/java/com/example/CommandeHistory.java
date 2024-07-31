package com.example;
import java.util.ArrayList;
import java.util.List;
//ma classe commandehistory est un singleton


public class CommandeHistory {
    
    private List<CommandeImage> commandes = new ArrayList<CommandeImage>();
    private static CommandeHistory instance = null;

    private CommandeHistory(CommandeImage cmdImage) {
        this.commandes.add(cmdImage);
    }

    public static CommandeHistory getInstance(CommandeImage cmdImage){
        if(instance == null){
            instance = new CommandeHistory(cmdImage);
        }
        return instance;
    }

    public void push(CommandeImage c){
        //ajoute une commande à la liste
        //lorsqu'une commande est faite

    }
    public CommandeImage pop(){
        //retire la dernière commande de la liste
        return null;
    }

}
