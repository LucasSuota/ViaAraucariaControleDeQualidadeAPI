package entities;
public class Load {
    private int invoice;
    private String plate;
    private double weight;
    private String timeLeft;
    private String timeArrived;
    private String timeApp;

    public Load(int invoice, String plate, double weight, String timeLeft, String timeArrived, String timeApp) {
        this.invoice = invoice;
        this.plate = plate;
        this.weight = weight;
        this.timeLeft = timeLeft;
        this.timeArrived = timeArrived;
        this.timeApp = timeApp;
    }

    public int getInvoice() {
        return invoice;
    }

    public void setInvoice(int invoice) {
        this.invoice = invoice;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(String timeLeft) {
        this.timeLeft = timeLeft;
    }

    public String getTimeArrived() {
        return timeArrived;
    }

    public void setTimeArrived(String timeArrived) {
        this.timeArrived = timeArrived;
    }

    public String getTimeApp() {
        return timeApp;
    }

    public void setTimeApp(String timeApp) {
        this.timeApp = timeApp;
    }
}
