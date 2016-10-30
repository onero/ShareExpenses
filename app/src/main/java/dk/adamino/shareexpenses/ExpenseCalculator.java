package dk.adamino.shareexpenses;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by gta1 on 30-10-2016.
 */

public class ExpenseCalculator {

    private final double incomeA;
    private final double incomeB;
    private final double totalExpense;
    private final double totalIncome;
    private NumberFormat formatter = new DecimalFormat("#0.00");

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

    /**
     * Returns the expenses for each person depending on their personal income
     *
     */
    public void getSharedExpense() {
        NumberFormat formatter = new DecimalFormat("#0.00");

        double totalIncome = incomeA + incomeB;
        double percentExpenseA = incomeA / totalIncome * 100;
        double percentExpenseB = 100 - percentExpenseA;
        double expenseA = (totalExpense / 100) * percentExpenseA;
        double expenseB = totalExpense - expenseA;

        System.out.println("Of the total expense " + formatter.format(totalExpense) + " Kr");
        System.out.println("A should pay " + formatter.format(expenseA) + " Kr " + "(" + formatter.format(percentExpenseA) + "%)"
                + "\nAnd B should pay " + formatter.format(expenseB) + " Kr " + "(" + formatter.format(percentExpenseB) + "%)");
    }

    /**
     * Returns the total amount that A should pay
     */
    public String getExpenseA() {
        double expensePercentageA = (incomeA/totalIncome) * 100;
        double expenseA = (totalExpense/100) * expensePercentageA;
        return formatter.format(expenseA);

    }

    /**
     * Returns the total amount that B should pay
     */
    public String getExpenseB() {
        double expensePercentageB = (incomeB/totalIncome) * 100;
        double expenseB = (totalExpense/100) * expensePercentageB;
        return formatter.format(expenseB);
    }
}
