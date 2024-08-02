package com.example;
import javafx.scene.image.ImageView;

public class Undo extends CommandeImage {
    private ImageView img;
    private CommandeHistory commandeHistory;

    public Undo(){
        //commande history est un singleton
        commandeHistory = CommandeHistory.getInstance();

    }
    

    @Override
    public void executer() {
        CommandeImage lastCommand = commandeHistory.pop();
        if (lastCommand != null) {
            undo(lastCommand);
        }
    }

    private void undo(CommandeImage c) {
        if(c instanceof Zoom){
            Zoom zoom = (Zoom) c;


            //on crée un nouvel objet zoom pour pouvoir appeler la méthode executer
            Zoom undoedZoom = new Zoom(img, zoom.getX(), zoom.getY());
            undoedZoom.executer();

        } else if(c instanceof Translation){
            Translation translation = (Translation) c;

            //on crée un nouvel objet translation pour pouvoir appeler la méthode executer
            Translation undoedTranslation = new Translation(img, c.getX(), translation.getY());
            undoedTranslation.executer();
        }

        c.executer(); 
    }
}

