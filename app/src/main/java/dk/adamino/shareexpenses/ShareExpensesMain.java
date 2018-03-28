package dk.adamino.shareexpenses;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import dk.adamino.shareexpenses.BLL.ExpenseCalculator;
import dk.adamino.shareexpenses.BLL.IExpenseCalculator;

public class ShareExpensesMain extends AppCompatActivity {

    private static final String TAG = "Tag";
    private Button mCalculateButton;
    private TextView mIncomeA, mExpenseA, mExpenseB, mIncomeB, mTotalExpense;
    private IExpenseCalculator mCalculator;
    private NumberFormat formatter = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_calculator);

        setupViews();

        setupListeners();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_expense_calculator, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.clear) {
            clearAll();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void clearAll() {
        mIncomeA.setText("");
        mIncomeB.setText("");
        mTotalExpense.setText("");
        mExpenseA.setText("");
        mExpenseB.setText("");
    }

    private void setupViews() {
        mCalculateButton = findViewById(R.id.btnCalculate);
        mIncomeA = findViewById(R.id.incomeA);
        mExpenseA = findViewById(R.id.expenseA);
        mExpenseB = findViewById(R.id.expenseB);
        mIncomeB = findViewById(R.id.incomeB);
        mTotalExpense = findViewById(R.id.totalExpense);
    }

    private void setupListeners() {
        View.OnClickListener onCalculateClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double incomeA = Double.parseDouble(mIncomeA.getText().toString());
                    double incomeB = Double.parseDouble(mIncomeB.getText().toString());
                    double totalExpense = Double.parseDouble(mTotalExpense.getText().toString());

                    mCalculator = new ExpenseCalculator(incomeA, incomeB, totalExpense);
                    String expenseA = formatter.format(mCalculator.calculateExpense(incomeA));
                    String expenseB = formatter.format(mCalculator.calculateExpense(incomeB));
                    mExpenseA.setText(expenseA);
                    mExpenseB.setText(expenseB);
                } catch (NumberFormatException nfe) {
                    Log.e(TAG, nfe.getMessage());
                }

            }
        };

        mCalculateButton.setOnClickListener(onCalculateClickListener);
    }


}
