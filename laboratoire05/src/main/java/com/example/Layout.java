package com.example;

public class Layout {
    
    public VuePerspective01 vue01;
    public VuePerspective02 vue02;
    public VueFixe vueFixe;
    public Charger load;
    public Sauvegarder save;

    public Layout(){
        this.vue01 = new VuePerspective01();
        this.vue02 = new VuePerspective02();
        this.vueFixe = new VueFixe();
        this.load = new Charger();
        this.save = new Sauvegarder();
    }


    public void buildStage(){
        
        //Créer la fenêtre principale
        //Créer la barre de menu
        //Créer la barre d'outils
        //Créer 3 zone de dessin
        //  - une pour l'image fixe
        //  - une pour l'image 1
        //  - une pour l'image2
        //Créer les boutons de zoom
        //Créer les boutons de déplacement
        //Créer le button undo
        //Creer le button redo
        //Créer le button save
        //Créer le button load
        //Créer le button quitter

    }
}
