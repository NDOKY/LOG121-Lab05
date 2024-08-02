package com.example;
import java.util.List;

import javafx.scene.image.ImageView;

public class Undo extends CommandeImage {
    private ImageView img;
    private CommandeHistory commandeHistory;
    List<CommandeImage> commandesHistory;

    public Undo(){
        //commande history est un singleton
        commandeHistory = CommandeHistory.getInstance(null);

    }
    

    @Override
    public void executer() {
        CommandeImage lastCommand = commandeHistory.pop();
        if (lastCommand != null) {
            undo(lastCommand);
            System.out.println("trsdjdjkd");
        }

    }

    private void undo(CommandeImage c) {
        if(c instanceof Zoom){
            Zoom zoom = (Zoom) c;


            //on crée un nouvel objet zoom pour pouvoir appeler la méthode executer
            Zoom undoedZoom = new Zoom(zoom.img, zoom.getX(), zoom.getY());
            undoedZoom.executer();

            System.out.println("Commande undo zoom");

        } else if(c instanceof Translation){
            Translation translation = (Translation) c;

            //on crée un nouvel objet translation pour pouvoir appeler la méthode executer
            Translation undoedTranslation = new Translation(translation.img, translation.getX(), translation.getY());
            undoedTranslation.executer();
            System.out.println("Commande undo translation");
        }

        //c.executer(); 
    }
}

