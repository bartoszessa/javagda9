package zad1;

public class Visit {

    private int id;
    private Patient patient;
    private String doctorsName;
    private double price;
    private String date;

    public Visit() {
    }

    public Visit(Patient patient, String doctorsName, double price, String date) {
        this.patient = patient;
        this.doctorsName = doctorsName;
        this.price = price;
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDoctorsName() {
        return doctorsName;
    }

    public void setDoctorsName(String doctorsName) {
        this.doctorsName = doctorsName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", patient=" + patient +
                ", doctorsName='" + doctorsName + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                '}';
    }
}
