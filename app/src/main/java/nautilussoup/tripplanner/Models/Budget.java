package nautilussoup.tripplanner.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Budget implements Serializable {
    private double maxBudget;
    private double amountSpent;
    private List payments;

    public Budget(double maxBudget) {
        this.maxBudget = maxBudget;
        amountSpent = 0;
        payments = new ArrayList<Payment>();
    }

    public void addPayment(Person personPaying, double amount, String description) {
        amountSpent += amount;
        payments.add(new Payment(personPaying, amount, description));
    }

    public double getMaxBudget() {
        return maxBudget;
    }

    public void setMaxBudget(double maxBudget) {
        this.maxBudget = maxBudget;
    }

    public double getAmountSpent() {
        return amountSpent;
    }

    public void setAmountSpent(double amountSpent) {
        this.amountSpent = amountSpent;
    }

    public List getPayments() {
        return payments;
    }

    public void setPayments(List payments) {
        this.payments = payments;
    }
}
