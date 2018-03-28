package dk.adamino.shareexpenses;

/**
 * Created by Adamino on 30-10-2016.
 */

public class ExpenseCalculator implements IExpenseCalculator {

    private final double incomeA, incomeB, totalExpense, totalIncome;

    /**
     * Creates the calculator with information about the two peoples income and
     * the totalExpense
     *
     * @param incomeA
     * @param incomeB
     * @param totalExpense
     */
    public ExpenseCalculator(double incomeA, double incomeB, double totalExpense) {
        this.incomeA = incomeA;
        this.incomeB = incomeB;
        this.totalExpense = totalExpense;
        totalIncome = incomeA + incomeB;
    }

    @Override
    public double calculateExpenseA() {
        double expensePercentageA = (incomeA/totalIncome) * 100;
        double expenseA = (totalExpense/100) * expensePercentageA;
        return expenseA;

    }

    @Override
    public double calculateExpenseB() {
        double expensePercentageB = (incomeB/totalIncome) * 100;
        double expenseB = (totalExpense/100) * expensePercentageB;
        return expenseB;
    }
}
