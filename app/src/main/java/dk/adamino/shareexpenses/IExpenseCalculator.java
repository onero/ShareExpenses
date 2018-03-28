package dk.adamino.shareexpenses;

/**
 * Created by Adamino.
 */
interface IExpenseCalculator {

    /***
     * Calculate Expense A
     * @return the amount A should pay as a double
     */
    double calculateExpenseA();

    /***
     * Calculate Expense B
     * @return the amount B should pay as a double
     */
    double calculateExpenseB();
}
