public class ZooManagement {
    public static void main(String[] args) {

        // Création d'un animal
        Animal lion = new Animal();
        lion.family = "Félidé";
        lion.name = "Lion";
        lion.age = 5;
        lion.isMammal = true;

        // Création d'un zoo
        Zoo myZoo = new Zoo();
        myZoo.name = "zoo";
        myZoo.city = "Tunis";

        System.out.println("Animal :" + lion.name + " family :" + lion.family + " son age :" + lion.age + " isMammal :" + lion.isMammal);
        System.out.println("Zoo :" + myZoo.name + " son city :" + myZoo.city + " nbrCages :" + myZoo.nbrCages);

        // Nouveau zoo
        Zoo myZoo1 = new Zoo("zoo1", "Tunis");

        Animal lion1 = new Animal("Felidé", "Lion", 5, true);
        Animal chat = new Animal("chatfamily", "chat", 6, false);
        Animal chien = new Animal("chienfamily", "chien", 8, false);

        System.out.println("Animal : " + lion1.name + " family : " + lion1.family + " age :" + lion1.age + " isMammal :" + lion1.isMammal);
        System.out.println("zoo : " + myZoo1.name + " city :" + myZoo1.city + " nbrCages :" + myZoo1.nbrCages);

        // Affichage du zoo
        myZoo.displayZoo();
        System.out.println(myZoo);
        System.out.println(myZoo.toString());
        System.out.println(lion.toString());

        // Ajouter plusieurs animaux
        for (int i = 1; i < 30; i++) {
            Animal a = new Animal("Family" + i, "Animal" + i, i, true);
            boolean added = myZoo.addAnimal(a);
            if (added) {
                System.out.println("Animal " + a.name + " ajouté avec succès");
            } else {
                System.out.println("Animal " + a.name + " pas de place");
            }
        }
        myZoo.displayAnimals();

        // Ajouter un animal et tester la recherche
        Animal souris = new Animal("Famille3", "souris", 9, true);
        myZoo1.addAnimal(souris);
        int indice = myZoo1.searchAnimal(souris);

        if (indice != -1) {
            System.out.println("L'animal " + souris.name + " a été trouvé à l'indice " + indice);
        } else {
            System.out.println("L'animal " + souris.name + " n'a pas été trouvé");
        }

        // Tester la suppression d'un animal existant
        boolean supprime = myZoo1.removeAnimal(souris);
        if (supprime) {
            System.out.println("L'animal " + souris.name + " a été supprimé avec succès.");
        } else {
            System.out.println("Impossible de supprimer l'animal " + souris.name);
        }

        // Tester la suppression d'un animal qui n'existe pas
        Animal tigre = new Animal("Félidé", "Tigre", 6, true);
        supprime = myZoo1.removeAnimal(tigre);
        if (supprime) {
            System.out.println("L'animal " + tigre.name + " a été supprimé avec succès.");
        } else {
            System.out.println("Impossible de supprimer l'animal " + tigre.name);
        }

        // Vérifier si le zoo est plein
        if (myZoo.isZooFull()) {
            System.out.println("Le zoo " + myZoo.name + " est plein !");
        } else {
            System.out.println("Il reste de la place dans le zoo " + myZoo.name);
        }

        // Comparer les deux zoos
        Zoo zooPlusPeuple = Zoo.comparerZoo(myZoo, myZoo1);
        System.out.println("Le zoo avec le plus d'animaux est : " + zooPlusPeuple.name);
    }
}
