package com.example.plazofijo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import com.example.plazofijo.C0082R;
import com.example.plazofijo.business.Calculations;
import com.example.plazofijo.business.ResultsBean;
import com.example.plazofijo.util.Util;
import java.util.ArrayList;

public class SecondActivity extends ActionBarActivity {
    private TableLayout table1;

    public static class PlaceholderFragment extends Fragment {
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(C0082R.layout.fragment_second, container, false);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0082R.layout.activity_second);
        this.table1 = (TableLayout) findViewById(C0082R.id.table1);
        Intent requester = getIntent();
        buildTable(Calculations.calcultate(Double.valueOf((String) requester.getExtras().get(getResources().getString(C0082R.string.initial_amount_parameter))), Double.valueOf((String) requester.getExtras().get(getResources().getString(C0082R.string.monthly_savings_parameter))), Double.valueOf(requester.getExtras().getDouble(getResources().getString(C0082R.string.porcentage_of_interest_parameter))), Double.valueOf(requester.getExtras().getDouble(getResources().getString(C0082R.string.number_of_months_parameter))), Double.valueOf(requester.getExtras().getDouble(getResources().getString(C0082R.string.dollar_value_parameter)))));
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add((int) C0082R.id.container, new PlaceholderFragment()).commit();
        }
    }

    void buildTable(ArrayList<ResultsBean> resultsBeans) {
        for (int current = -1; current < resultsBeans.size(); current++) {
            TableRow row = new TableRow(this);
            row.setLayoutParams(new LayoutParams(-1, -2));
            TextView t1 = new TextView(this);
            t1.setLayoutParams(new LayoutParams(-2, -2));
            t1.setPadding(5, 5, 5, 5);
            t1.setGravity(17);
            TextView t2 = new TextView(this);
            t2.setLayoutParams(new LayoutParams(-2, -2));
            t2.setPadding(5, 5, 5, 5);
            t2.setGravity(17);
            TextView t3 = new TextView(this);
            t3.setLayoutParams(new LayoutParams(-2, -2));
            t3.setPadding(5, 5, 5, 5);
            t3.setGravity(17);
            TextView t4 = new TextView(this);
            t4.setLayoutParams(new LayoutParams(-2, -2));
            t4.setPadding(5, 5, 5, 5);
            t4.setGravity(17);
            TextView t5 = new TextView(this);
            t5.setLayoutParams(new LayoutParams(-2, -2));
            t5.setPadding(5, 5, 5, 5);
            t5.setGravity(17);
            if (current == -1) {
                t1.setBackgroundResource(C0082R.drawable.header_shape);
                t2.setBackgroundResource(C0082R.drawable.header_shape);
                t3.setBackgroundResource(C0082R.drawable.header_shape);
                t4.setBackgroundResource(C0082R.drawable.header_shape);
                t5.setBackgroundResource(C0082R.drawable.header_shape);
                t1.setTextColor(getResources().getColor(C0082R.color.black));
                t2.setTextColor(getResources().getColor(C0082R.color.black));
                t3.setTextColor(getResources().getColor(C0082R.color.black));
                t4.setTextColor(getResources().getColor(C0082R.color.black));
                t5.setTextColor(getResources().getColor(C0082R.color.black));
                t1.setText(getResources().getString(C0082R.string.month_table));
                t2.setText(getResources().getString(C0082R.string.increment_table));
                t3.setText(getResources().getString(C0082R.string.increment_dollars_table));
                t4.setText(getResources().getString(C0082R.string.balance_table));
                t5.setText(getResources().getString(C0082R.string.balance_dollars_table));
            } else {
                t1.setBackgroundResource(C0082R.drawable.cell_shape);
                t2.setBackgroundResource(C0082R.drawable.cell_shape);
                t3.setBackgroundResource(C0082R.drawable.cell_shape);
                t4.setBackgroundResource(C0082R.drawable.cell_shape);
                t5.setBackgroundResource(C0082R.drawable.cell_shape);
                t1.setTextColor(getResources().getColor(C0082R.color.orange));
                t2.setTextColor(getResources().getColor(C0082R.color.orange));
                t3.setTextColor(getResources().getColor(C0082R.color.orange));
                t4.setTextColor(getResources().getColor(C0082R.color.orange));
                t5.setTextColor(getResources().getColor(C0082R.color.orange));
                t1.setText(((ResultsBean) resultsBeans.get(current)).getMonth());
                t2.setText(String.valueOf(Util.doubleFormat(((ResultsBean) resultsBeans.get(current)).getIncrement())));
                t3.setText(String.valueOf(Util.doubleFormat(((ResultsBean) resultsBeans.get(current)).getIngrementInDollars())));
                t4.setText(String.valueOf(Util.doubleFormat(((ResultsBean) resultsBeans.get(current)).getBalanceInPesos())));
                t5.setText(String.valueOf(Util.doubleFormat(((ResultsBean) resultsBeans.get(current)).getBalanceInDollars())));
            }
            row.addView(t1);
            row.addView(t2);
            row.addView(t3);
            row.addView(t4);
            row.addView(t5);
            this.table1.addView(row, new TableLayout.LayoutParams(-2, -2));
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0082R.menu.second, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == C0082R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
