package nautilussoup.tripplanner.Models;

import java.io.Serializable;

public class Payment implements Serializable {
    private static final long serialVersionUID = 23L;
    private Person personPaying;
    private double amount;
    private String description;

    public Payment(Person personPaying, double amount, String description) {
        this.personPaying = personPaying;
        this.amount = amount;
        this.description = description;
    }

    public Person getPersonPaying() {
        return personPaying;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

}
