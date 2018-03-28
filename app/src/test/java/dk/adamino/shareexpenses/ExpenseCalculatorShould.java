package dk.adamino.shareexpenses;

import org.junit.Test;

import dk.adamino.shareexpenses.BLL.ExpenseCalculator;
import dk.adamino.shareexpenses.BLL.IExpenseCalculator;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExpenseCalculatorShould {

    private IExpenseCalculator mExpenseCalculator;

    @Test
    public void calculateExpenseA() {
        double incomeA = 20_000;
        double incomeB = 5_000;
        double totalExpense = 12_000;
        mExpenseCalculator = new ExpenseCalculator(incomeA, incomeB, totalExpense);

        double expensePercentageA = (incomeA/(incomeA + incomeB)) * 100;
        double expectedExpenseA = (totalExpense/100) * expensePercentageA;
        double actualExpenseA = mExpenseCalculator.calculateExpense(incomeA);

        assertEquals(expectedExpenseA, actualExpenseA, 0);
    }

    @Test
    public void calculateExpense_withHighestIncomeA_toPayMost() {
        double incomeA = 20_000;
        double incomeB = 5_000;
        double totalExpense = 12_000;
        mExpenseCalculator = new ExpenseCalculator(incomeA, incomeB, totalExpense);

        double actualExpenseA = mExpenseCalculator.calculateExpense(incomeA);
        double actualExpenseB = mExpenseCalculator.calculateExpense(incomeB);

        assertTrue("ExpenseA should be larger", actualExpenseA > actualExpenseB);
    }

    @Test
    public void calculateExpense_withOnlyIncomeA_toBeOnlyOneToPay() {
        double incomeA = 20_000;
        double incomeB = 0;
        double totalExpense = 12_000;
        mExpenseCalculator = new ExpenseCalculator(incomeA, incomeB, totalExpense);


        double actualExpenseA = mExpenseCalculator.calculateExpense(incomeA);
        double actualExpenseB = mExpenseCalculator.calculateExpense(incomeB);

        assertTrue("ExpenseA should pay", actualExpenseA > actualExpenseB);
        assertTrue("ExpenseB should NOT pay", actualExpenseB == 0);
    }
    @Test
    public void calculateExpense_withOnlyIncomeA_toPayNoMoreThanEntireIncome() {
        double incomeA = 10_000;
        double incomeB = 0;
        double totalExpense = 12_000;
        mExpenseCalculator = new ExpenseCalculator(incomeA, incomeB, totalExpense);


        double actualExpenseA = mExpenseCalculator.calculateExpense(incomeA);

        assertTrue("ExpenseA should not pay more than entire income",
                actualExpenseA <= incomeA);
    }
}