package tn.esprit.gestionzoo.entites;

public class Zoo {

    private Animal[] animals = new Animal[25];
    private String name;
    private String city;
    private final int nbrCages = 25;
    private int compteurAnimal = 0;

    public Zoo() {
    }

    public Zoo(String name, String city) {
        setName(name);
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println(" Nom de zoo invalide !");
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNbrCages() {
        return nbrCages;
    }

    public void displayZoo() {
        System.out.println("myZoo : " + name + " city : " + city + " nbrCages : " + nbrCages);
    }

    public String toString() {
        return "tn.esprit.gestionzoo.entities.Zoo{name=" + name + ", city= " + city + ", nbrCages= " + nbrCages + "}";
    }

    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println(" tn.esprit.gestionzoo.entities.Zoo plein, impossible d'ajouter : " + animal.getName());
            return false;
        }

        for (int j = 0; j < compteurAnimal; j++) {
            if (animals[j].getName().equals(animal.getName())) {
                System.out.println(" tn.esprit.gestionzoo.entities.Animal déjà présent : " + animal.getName());
                return false;
            }
        }

        animals[compteurAnimal] = animal;
        compteurAnimal++;
        System.out.println(" tn.esprit.gestionzoo.entities.Animal ajouté avec succès : " + animal.getName());
        return true;
    }

    public void displayAnimals() {
        if (compteurAnimal == 0) {
            System.out.println(" tn.esprit.gestionzoo.entities.Zoo ne contient aucun animal.");
        } else {
            for (int i = 0; i < compteurAnimal; i++) {
                Animal a = animals[i];
                System.out.println("tn.esprit.gestionzoo.entities.Animal " + (i + 1) + ": " +
                        a.getFamily() + " ,name : " + a.getName() +
                        " ,age :" + a.getAge() +
                        " ,isMammal :" + a.isMammal());
            }
        }
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < compteurAnimal; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                return i; // retourne l'indice si trouvé
            }
        }
        return -1; // non trouvé
    }

    public boolean removeAnimal(Animal animal) {
        for (int j = 0; j < compteurAnimal; j++) {
            if (animals[j].getName().equals(animal.getName())) {
                for (int k = j; k < compteurAnimal - 1; k++) {
                    animals[k] = animals[k + 1];
                }
                animals[compteurAnimal - 1] = null;
                compteurAnimal--;
                System.out.println(" tn.esprit.gestionzoo.entities.Animal supprimé avec succès : " + animal.getName());
                return true;
            }
        }
        System.out.println(" tn.esprit.gestionzoo.entities.Animal non trouvé : " + animal.getName());
        return false;
    }

    public boolean isZooFull() {
        return compteurAnimal >= nbrCages;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.compteurAnimal > z2.compteurAnimal) {
            return z1;
        } else {
            return z2;
        }
    }
}
