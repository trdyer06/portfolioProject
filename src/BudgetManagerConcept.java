import components.map.Map;
import components.map.Map2;

public class BudgetManagerConcept {
    private Map<String, Double> budget;

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

    public void addIncome(String n, double v) {
        this.budget.add(n, v);
    }

    public void addExpense(String n, double v) {
        this.budget.add(n, (v * -1.0));
    }

    public Map.Pair<String, Double> removeTransaction(String n) {
        Map.Pair<String, Double> pair = this.budget.remove(n);
        if (pair.value() > 0) {
            this.budget.add(pair.key(), (pair.value() * -1.0));
            pair = this.budget.remove(n);
        }
        return pair;
    }
}
