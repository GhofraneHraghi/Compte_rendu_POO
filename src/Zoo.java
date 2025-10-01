public class Zoo{

    Animal[] animals = new Animal[25];
    String name,city;
    final int nbrCages = 25;
    int compteurAnimal = 0;

    public Zoo() {

    }

    public Zoo(String name, String city){
        this.name = name;
        this.city= city;
    }

    public void displayZoo(){
        System.out.println("myZoo :" + name + " city :" + city + " nbrCages :" +nbrCages);
    }
    public String toString(){
        return "Zoo{name=" + name + ", city= " + city + ", nbrCages= " + nbrCages + "}";
    }


    public boolean addAnimal(Animal animal){

        if (compteurAnimal>=animals.length){
            System.out.println ("zoo plein, impossible d'ajouter" + animal.name);
            return false;

        }

        for(int j=0; j<compteurAnimal; j++){
            if(animals[j].name.equals(animal.name)){
                System.out.println("Animal déjà existe" + animal.name);
                return false;
            }
        }

            animals [compteurAnimal] = animal;
            compteurAnimal++;
            System.out.println("Animal ajouté avec succés" + animal.name);
            return true;

    }
    public void displayAnimals() {
        if (compteurAnimal == 0) {
            System.out.println("zoo ne contient aucun animal");
        } else {
            for (int i = 0; i < compteurAnimal; i++) {
                Animal a = animals[i];
                System.out.println("Animal " + (i + 1) + a.family + " ,name : " + a.name + " ,age :" + a.age + " ,isMammal :" + a.isMammal);

            }
        }
    }

        public int searchAnimal(Animal animal) {
            for (int i = 0; i < compteurAnimal; i++) {
                if (animals[i].name.equals(animal.name)) {
                    return i; // retourne l'indice si trouvé
                }
            }
            return -1; // retourne -1 si non trouvé
        }


    public boolean removeAnimal(Animal animal) {
        for (int j = 0; j < compteurAnimal; j++) {
            if (animals[j].name.equals(animal.name)) {
                for (int k = j; k < compteurAnimal-1; k++) {
                animals[k]=animals[k+1];
                }

                animals[compteurAnimal-1]=null;
                compteurAnimal--;
                System.out.println("Animal supprimé avec succés" + animal.name);
                return true;
            }
        }
        System.out.println("Animal non trouvé" + animal.name);
        return false;

    }

    public boolean isZooFull(){
        if(compteurAnimal>=nbrCages){
            return true;
        }
        else{
            return false;
        }
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.compteurAnimal > z2.compteurAnimal) {
            return z1;
        } else {
            return z2;
        }
    }


}