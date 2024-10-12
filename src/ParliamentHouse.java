package assignment;

public abstract class ParliamentHouse {
    protected String name;

    public ParliamentHouse(String name) {
        this.name = name;
    }

    public abstract void displayInfo();
}
