package assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class IndianParliamentMenu {

    private static List<MemberOfParliament> members = new ArrayList<>();  // Correct initialization
    private static List<Bill> bills = new ArrayList<>();
    private static List<Bill> votedBills = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParliamentHouse house = null;

        System.out.println("\nWelcome to the Indian Parliament");
        homeInfo();

        while (true) {
            System.out.println("1. Select House (Lok Sabha or Rajya Sabha)");
            System.out.println("2. Introduce a New Bill");
            System.out.println("3. View All Bills");
            System.out.println("4. Add Member");
            System.out.println("5. Vote on a Bill");
            System.out.println("6. View Voted Bills");
            System.out.println("0. Exit");
            System.out.print("Please enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    house = selectHouse(scanner);  
                    house.displayInfo(); 
                    break;
                case 2:
                    introduceBill(scanner);
                    break;
                case 3:
                    viewAllBills();
                    break;
                case 4:
                    addMember(scanner);
                    break;
                case 5:
                    voteOnBill(scanner);
                    break;
                case 6:
                    viewVotedBills();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a number between 0 and 6.");
            }
        }
    }

    private static ParliamentHouse selectHouse(Scanner scanner) {
        System.out.println("Select a House: 1. Lok Sabha 2. Rajya Sabha");
        int houseChoice = scanner.nextInt();
        if (houseChoice == 1) {
            return new LokSabha();
        } else if (houseChoice == 2) {
            return new RajyaSabha();
        } else {
            System.out.println("Invalid choice! Defaulting to Lok Sabha.");
            return new LokSabha(); 
        }
    }

    private static void introduceBill(Scanner scanner) {
        System.out.println("Enter the title of the new bill:");
        String title = scanner.nextLine();
        System.out.println("Enter the ID of the new bill:");
        int billID = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Enter the status of the new bill:");
        String status = scanner.nextLine();
        Bill newBill = new Bill(title, billID, status);
        bills.add(newBill);
        System.out.println("New bill '" + title + "' has been introduced.");
    }

    private static void viewAllBills() {
        System.out.println("Here are all the bills that have been introduced:");
        for (int i = 0; i < bills.size(); i++) {
            System.out.println((i + 1) + ". " + bills.get(i).getTitle() +
                               " - Status: " + bills.get(i).getStatus() +
                               " - Votes: " + bills.get(i).getVotes() +
                               " - Bill ID: " + bills.get(i).getBillID());
        }
    }

    private static void voteOnBill(Scanner scanner) {
        System.out.println("Enter the ID of the bill you want to vote on:");
        int billId = scanner.nextInt();
        scanner.nextLine(); 
        Bill billToVote = findBillById(billId);
        if (billToVote != null) {
            billToVote.vote();
            votedBills.add(billToVote);
            System.out.println("You have voted on bill '" + billToVote.getTitle() + "'.");
        } else {
            System.out.println("Invalid bill ID. Please enter a valid bill ID.");
        }
    }

    private static Bill findBillById(int billId) {
        for (Bill bill : bills) {
            if (bill.getBillID() == billId) {
                return bill;
            }
        }
        return null;
    }

    private static void viewVotedBills() {
        System.out.println("Here are the bills that have been voted on:");
        for (int i = 0; i < votedBills.size(); i++) {
            System.out.println((i + 1) + ". " + votedBills.get(i).getTitle() +
                               " - Votes: " + votedBills.get(i).getVotes());
        }
    }

    private static void addMember(Scanner scanner) {
        System.out.println("Enter the name of the new member:");
        String name = scanner.nextLine();
        System.out.println("Enter the constituency:");
        String constituency = scanner.nextLine();
        System.out.println("Enter the party:");
        String party = scanner.nextLine();
        MemberOfParliament newMember = new MemberOfParliament(name, constituency, party);
        members.add(newMember);
        System.out.println("Member '" + name + "' has been added.");
    }

    public static void homeInfo() {
        System.out.println("Indian Parliament is the supreme legislative body of India...");
    }
}
