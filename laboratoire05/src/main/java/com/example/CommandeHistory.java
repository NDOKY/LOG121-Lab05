package com.example;
import java.util.ArrayList;
import java.util.List;
//ma classe commandehistory est un singleton


public class CommandeHistory {
    
    private static CommandeHistory instance;

    public static List<CommandeImage> commandesHistory;
    
    private CommandeHistory(CommandeImage cmd) {
        //contructeur privé pour ma classe singleton
        //initialise la liste de commandes
        commandesHistory = new ArrayList<CommandeImage>();
        commandesHistory.add(cmd);
    }

    public static CommandeHistory getInstance(CommandeImage cmd){
        if(instance == null){
            instance = new CommandeHistory(cmd);
        }
        else{
            commandesHistory.add(cmd);
        }
        return instance;
    }

    public void push(CommandeImage c){
        //ajoute une commande c à la liste commandes
        commandesHistory.add(c);
        
    }
    public CommandeImage pop(){
        //retire la dernière commande de la liste
        CommandeImage cmd;
        if (commandesHistory.isEmpty()) {
            return null; // or throw an exception, depending on your requirements
        }
        else{
            System.out.println("taille de la liste : " + commandesHistory.size());
            cmd = commandesHistory.remove(commandesHistory.size() - 2);
            //cmd = (Zoom)commandesHistory.remove(commandesHistory.size() - 1); 
            
        }
        return cmd;
        //return null;
    }

}
