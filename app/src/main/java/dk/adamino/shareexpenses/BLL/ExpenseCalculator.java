package dk.adamino.shareexpenses.BLL;

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
    public double calculateExpense(double income) {
        double expensePercentage = (income/totalIncome) * 100;
        double expense = (totalExpense/100) * expensePercentage;
        // Make sure the expense will never surpass the income!
        if (expense > income) {
            expense = income;
        }
        return expense;
    }
}
