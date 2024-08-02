package com.example;
import java.util.ArrayList;
import java.util.List;
//ma classe commandehistory est un singleton


public class CommandeHistory {
    
    private static CommandeHistory instance;

    private List<CommandeImage> commandesHistory;
    
    private CommandeHistory() {
        //contructeur privé pour ma classe singleton
        //initialise la liste de commandes
        List<CommandeImage> commandesHistory = new ArrayList<CommandeImage>();
    }

    public static CommandeHistory getInstance(){
        if(instance == null){
            instance = new CommandeHistory();
        }
        return instance;
    }

    public void push(CommandeImage c){
        //ajoute une commande c à la liste commandes
        //commandesHistory.add(c);
        
    }
    public CommandeImage pop(){
        //retire la dernière commande de la liste
        /* if (commandesHistory.isEmpty()) {
            return null; // or throw an exception, depending on your requirements
        }
        return commandesHistory.remove(commandesHistory.size() - 1); */
        return null;
    }

}
