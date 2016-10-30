package dk.adamino.shareexpenses;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShareExpensesMain extends AppCompatActivity {

    private Button mCalculateButton;
    private TextView mIncomeA;
    private TextView mExpenseA;
    private TextView mExpenseB;
    private TextView mIncomeB;
    private TextView mTotalExpense;
    private ExpenseCalculator mCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_calculator);

        mCalculateButton = (Button) findViewById(R.id.btnCalculate);
        mIncomeA = (TextView) findViewById(R.id.incomeA);
        mExpenseA = (TextView) findViewById(R.id.expenseA);
        mExpenseB = (TextView) findViewById(R.id.expenseB);
        mIncomeB = (TextView) findViewById(R.id.incomeB);
        mTotalExpense = (TextView) findViewById(R.id.totalExpense);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double incomeA = Double.parseDouble(mIncomeA.getText().toString());
                double incomeB = Double.parseDouble(mIncomeB.getText().toString());
                double totalExpense = Double.parseDouble(mTotalExpense.getText().toString());

                mCalculator = new ExpenseCalculator(incomeA, incomeB, totalExpense);
                String expenseA = mCalculator.getExpenseA();
                String expenseB = mCalculator.getExpenseB();
                mExpenseA.setText("" + expenseA + " Kr");
                mExpenseB.setText("" + expenseB + " Kr");

            }
        };

        mCalculateButton.setOnClickListener(listener);
    }


}
