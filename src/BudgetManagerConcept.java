import components.map.Map;
import components.map.Map2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class BudgetManagerConcept {
    private Map<String, Double> budget;

    private double savingGoal;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.budget = new Map2<String, Double>();
    }

    /**
     * No-argument constructor.
     */
    public BudgetManagerConcept() {
        this.createNewRep();
    }

    /**
     * Adds an income stream to this.
     *
     * @param n
     *            The name of where the income is coming from
     * @param v
     *            The amount of money per month being made
     */
    public void addIncome(String n, double v) {
        this.budget.add(n, v);
    }

    /**
     * Adds a monthly expense to this.
     *
     * @param n
     *            The name of the expense
     * @param v
     *            The amount of money per month being spent
     */
    public void addExpense(String n, double v) {
        this.budget.add(n, (v * -1));
    }

    /**
     * Removes an income or expense from this and reports the removed
     * transaction.
     *
     * @param n
     *            The name of the transaction to be removed
     * @return A pair containing the name and value of the removed transaction
     */
    public Map.Pair<String, Double> removeTransaction(String n) {
        Map.Pair<String, Double> pair = this.budget.remove(n);
        if (pair.value() < 0) {
            this.budget.add(pair.key(), (pair.value() * -1.0));
            pair = this.budget.remove(n);
        }
        return pair;
    }

    /**
     * Reports the amount of money left after income and expenses are accounted
     * for.
     *
     * @return The amount of money left after income and expenses
     */
    public double getSpendingBudget() {
        double net = 0;
        for (Map.Pair<String, Double> pair : this.budget) {
            net += pair.value();
        }
        return net;
    }

    /**
     * Sets the amount of money that the user wants to save.
     *
     * @param s
     *            The amount of money to be saved
     */
    public void setSavingGoal(double s) {
        this.savingGoal = s;
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        BudgetManagerConcept budget = new BudgetManagerConcept();
        SimpleWriter out = new SimpleWriter1L();
        SimpleReader in = new SimpleReader1L();
        out.println(
                "Add Income (i)\nAdd Expense (e)\nRemove Transaction (r)\nSee Budget (b)\nSet Saving Goal (s)");
        String input = in.nextLine();
        while (input.equals("i") || input.equals("e") || input.equals("r")
                || input.equals("b") || input.equals("s")) {
            if (input.equals("i")) {
                out.print("Enter name of income stream: ");
                String name = in.nextLine();
                out.print("Enter amount per month: ");
                double amount = in.nextDouble();
                budget.addIncome(name, amount);
            } else if (input.equals("e")) {
                out.print("Enter name of expense: ");
                String name = in.nextLine();
                out.print("Enter amount per month: ");
                double amount = in.nextDouble();
                budget.addExpense(name, amount);
            } else if (input.equals("r")) {
                out.print("Enter name of transaction to remove: ");
                String name = in.nextLine();
                Map.Pair<String, Double> pair = budget.removeTransaction(name);
                out.println("Removed \"" + pair.key() + "\" worth $"
                        + pair.value());
            } else if (input.equals("b")) {
                out.println("Spending Budget = " + budget.getSpendingBudget());
            } else {
                out.print("Enter saving goal: ");
                double amount = in.nextDouble();
                budget.setSavingGoal(amount);
            }
            out.println();
            out.println(
                    "Add Income (i)\nAdd Expense (e)\nRemove Transaction (r)\nSee Budget (b)\nSet Saving Goal (s)");
            input = in.nextLine();
        }
    }
}
