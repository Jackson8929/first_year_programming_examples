package Chap13;

public class Pet implements Cloneable{
    private String name;
    private int age;
    private PetOwner owner;

    public Pet(String sName, int nAge, PetOwner obOwner)
    {
        this.name = sName;
        this.age = nAge;
        this.owner = obOwner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PetOwner getOwner() {
        return owner;
    }

    public void setOwner(PetOwner owner) {
        this.owner = owner;
    }

    @Override
    public Object clone()
    {
        try {
            //Shallow copy
//            return super.clone();

            Pet obTemp = (Pet) super.clone();
            obTemp.owner = (PetOwner) owner.clone();
            return obTemp;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String toString()
    {
        return String.format("Pet Name %s, Age %d, %s",name,age,owner);
    }
}
