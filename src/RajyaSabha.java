package assignment;

public class RajyaSabha extends ParliamentHouse {

    public RajyaSabha() {
        super("Rajya Sabha");
    }

    @Override
    public void displayInfo() {
        System.out.println("Rajya Sabha: The Council of States. It has 250 seats.");
    }
}