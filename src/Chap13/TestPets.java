package Chap13;

public class TestPets
{
    public static void main(String[] args) {
        Pet obPet1 = new Pet("Misty",12, new PetOwner("Bryce"));
        Pet obPet2 = new Pet("Louie",1, new PetOwner("Kristen"));

        System.out.printf("\n%s\n", obPet1);
        Pet obPet1Clone = (Pet) obPet1.clone();

        //First things show shallow works for strings

        obPet1Clone.setName("MistyClone");
        obPet1Clone.setAge(13);

        System.out.printf("Original Pet 1 %s\n", obPet1);
        System.out.printf("Clone Pet 1 %s\n", obPet1Clone);

        //Show problems with shallow for references
        Pet obPet2Clone = (Pet) obPet2.clone();
        obPet2.getOwner().setName("Alex");

        System.out.printf("Pet 2 Og %s\n",obPet2);
        System.out.printf("Pet 2 Clone %s\n",obPet2Clone);

    }


}
