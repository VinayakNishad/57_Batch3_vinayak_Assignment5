package assignment;

public class Bill implements Votable {
    private String title;
    private String status;
    private int votes;
    private int billId;

    // Copy Constructor
    public Bill(Bill original) {
        this.title = original.title;
        this.status = original.status;
        this.votes = original.votes;
        this.billId = original.billId;
    }

    public Bill(String title, int billId, String status) {
        this.title = title;
        this.status = status;
        this.billId = billId;
        this.votes = 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
    public int getBillID() {
        return billId;
    }

    public void setBillID(int billId) {
        this.billId = billId;
    }

    @Override
    public void vote() {
        System.out.println("Voting on bill '" + title + "'");
        votes++;
    }
}

