package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entites.Animal;
import tn.esprit.gestionzoo.entites.Zoo;

public class ZooManagement {
    public static void main(String[] args) {

        // Création d'un animal
        Animal lion = new Animal();
        lion.setFamily("Félidé");
        lion.setName("Lion");
        lion.setAge(5);
        lion.setMammal(true);

        // Création d'un zoo
        Zoo myZoo = new Zoo();
        myZoo.setName("zoo");
        myZoo.setCity("Tunis");

        System.out.println("tn.esprit.gestionzoo.entities.Animal : " + lion.getName() +
                " family : " + lion.getFamily() +
                " age : " + lion.getAge() +
                " isMammal : " + lion.isMammal());

        System.out.println("tn.esprit.gestionzoo.entities.Zoo : " + myZoo.getName() +
                " city : " + myZoo.getCity() +
                " nbrCages : " + myZoo.getNbrCages());

        // Nouveau zoo
        Zoo myZoo1 = new Zoo("zoo1", "Tunis");

        Animal lion1 = new Animal("Félidé", "Lion", 5, true);
        Animal chat = new Animal("chatfamily", "chat", 6, false);
        Animal chien = new Animal("chienfamily", "chien", 8, false);

        System.out.println("tn.esprit.gestionzoo.entities.Animal : " + lion1.getName() +
                " family : " + lion1.getFamily() +
                " age : " + lion1.getAge() +
                " isMammal : " + lion1.isMammal());

        System.out.println("zoo : " + myZoo1.getName() +
                " city : " + myZoo1.getCity() +
                " nbrCages : " + myZoo1.getNbrCages());

        // Affichage du zoo
        myZoo.displayZoo();
        System.out.println(myZoo);
        System.out.println(lion);

        // Ajouter plusieurs animaux
        for (int i = 1; i < 30; i++) {
            Animal a = new Animal("Family" + i, "tn.esprit.gestionzoo.entities.Animal" + i, i, true);
            boolean added = myZoo.addAnimal(a);
            if (added) {
                System.out.println("tn.esprit.gestionzoo.entities.Animal " + a.getName() + " ajouté");
            } else {
                System.out.println("tn.esprit.gestionzoo.entities.Animal " + a.getName() + " pas de place");
            }
        }

        myZoo.displayAnimals();

        // Rechercher un animal
        Animal souris = new Animal("Famille3", "souris", 9, true);
        myZoo1.addAnimal(souris);
        int indice = myZoo1.searchAnimal(souris);
        if (indice != -1) {
            System.out.println(" L'animal " + souris.getName() + " trouvé à l'indice " + indice);
        } else {
            System.out.println(" L'animal " + souris.getName() + " non trouvé");
        }

        // Suppression d’un animal
        boolean supprime = myZoo1.removeAnimal(souris);
        if (supprime) {
            System.out.println(" L'animal " + souris.getName() + " a été supprimé.");
        } else {
            System.out.println(" Impossible de supprimer l'animal " + souris.getName());
        }

        // Suppression d’un animal inexistant
        Animal tigre = new Animal("Félidé", "Tigre", 6, true);
        supprime = myZoo1.removeAnimal(tigre);
        if (supprime) {
            System.out.println("L'animal " + tigre.getName() + " a été supprimé.");
        } else {
            System.out.println("Impossible de supprimer l'animal " + tigre.getName());
        }

        // Vérifier si zoo plein
        if (myZoo.isZooFull()) {
            System.out.println("Le zoo " + myZoo.getName() + " est plein !");
        } else {
            System.out.println(" Il reste de la place dans le zoo " + myZoo.getName());
        }

        // Comparaison de deux zoos
        Zoo zooPlusPeuple = Zoo.comparerZoo(myZoo, myZoo1);
        System.out.println(" Le zoo avec le plus d'animaux est : " + zooPlusPeuple.getName());
    }
}
