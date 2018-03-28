package dk.adamino.shareexpenses;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShareExpensesMain extends AppCompatActivity {

    private static final String TAG = "Tag";
    private Button mCalculateButton;
    private TextView mIncomeA, mExpenseA, mExpenseB, mIncomeB, mTotalExpense;
    private ExpenseCalculator mCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_calculator);

        mCalculateButton = findViewById(R.id.btnCalculate);
        mIncomeA = findViewById(R.id.incomeA);
        mExpenseA = findViewById(R.id.expenseA);
        mExpenseB = findViewById(R.id.expenseB);
        mIncomeB = findViewById(R.id.incomeB);
        mTotalExpense = findViewById(R.id.totalExpense);


        View.OnClickListener onCalculateClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double incomeA = Double.parseDouble(mIncomeA.getText().toString());
                    double incomeB = Double.parseDouble(mIncomeB.getText().toString());
                    double totalExpense = Double.parseDouble(mTotalExpense.getText().toString());

                    mCalculator = new ExpenseCalculator(incomeA, incomeB, totalExpense);
                    String expenseA = mCalculator.getExpenseA();
                    String expenseB = mCalculator.getExpenseB();
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
