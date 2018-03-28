package dk.adamino.shareexpenses.BLL;

/**
 * Created by Adamino.
 */
public interface IExpenseCalculator {

    /***
     * Calculate Expense
     * @param income
     * @return the amount the person with provided should pay as double
     */
    double calculateExpense(double income);
}
