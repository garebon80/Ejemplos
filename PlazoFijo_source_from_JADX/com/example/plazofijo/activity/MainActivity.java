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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.plazofijo.C0082R;
import com.example.plazofijo.util.Util;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {
    private ArrayAdapter<String> dataAdapter1;
    private ArrayAdapter<String> dataAdapter2;
    private ArrayAdapter<String> dataAdapter3;
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private EditText text1;
    private EditText text2;

    public static class PlaceholderFragment extends Fragment {
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(C0082R.layout.fragment_main, container, false);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0082R.layout.activity_main);
        this.text1 = (EditText) findViewById(C0082R.id.editText1);
        this.text2 = (EditText) findViewById(C0082R.id.editText2);
        this.spinner1 = (Spinner) findViewById(C0082R.id.spinner1);
        this.spinner2 = (Spinner) findViewById(C0082R.id.spinner2);
        this.spinner3 = (Spinner) findViewById(C0082R.id.spinner3);
        this.dataAdapter1 = new ArrayAdapter(this, 17367048, createDoubleList());
        this.dataAdapter1.setDropDownViewResource(17367049);
        this.spinner1.setAdapter(this.dataAdapter1);
        this.dataAdapter2 = new ArrayAdapter(this, 17367048, createIntegerList());
        this.dataAdapter2.setDropDownViewResource(17367049);
        this.spinner2.setAdapter(this.dataAdapter2);
        this.dataAdapter3 = new ArrayAdapter(this, 17367048, createDoubleList());
        this.dataAdapter3.setDropDownViewResource(17367049);
        this.spinner3.setAdapter(this.dataAdapter3);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add((int) C0082R.id.container, new PlaceholderFragment()).commit();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C0082R.id.button1:
                Intent intent1 = new Intent(this, SecondActivity.class);
                intent1.putExtra(getResources().getString(C0082R.string.initial_amount_parameter), this.text1.getText().toString());
                intent1.putExtra(getResources().getString(C0082R.string.monthly_savings_parameter), this.text2.getText().toString());
                intent1.putExtra(getResources().getString(C0082R.string.porcentage_of_interest_parameter), Double.valueOf(this.spinner1.getSelectedItem().toString()));
                intent1.putExtra(getResources().getString(C0082R.string.number_of_months_parameter), Double.valueOf(this.spinner2.getSelectedItem().toString()));
                intent1.putExtra(getResources().getString(C0082R.string.dollar_value_parameter), Double.valueOf(this.spinner3.getSelectedItem().toString()));
                validations(intent1);
            case C0082R.id.button2:
                Intent intent2 = new Intent(this, ThirdActivity.class);
                intent2.putExtra(getResources().getString(C0082R.string.initial_amount_parameter), this.text1.getText().toString());
                intent2.putExtra(getResources().getString(C0082R.string.monthly_savings_parameter), this.text2.getText().toString());
                intent2.putExtra(getResources().getString(C0082R.string.porcentage_of_interest_parameter), Double.valueOf(this.spinner1.getSelectedItem().toString()));
                intent2.putExtra(getResources().getString(C0082R.string.number_of_months_parameter), Double.valueOf(this.spinner2.getSelectedItem().toString()));
                intent2.putExtra(getResources().getString(C0082R.string.dollar_value_parameter), Double.valueOf(this.spinner3.getSelectedItem().toString()));
                validations(intent2);
            case C0082R.id.button3:
                this.text1.setText("");
                this.text2.setText("");
                this.spinner1.setAdapter(this.dataAdapter1);
                this.spinner2.setAdapter(this.dataAdapter2);
                this.spinner3.setAdapter(this.dataAdapter3);
            default:
        }
    }

    public void validations(Intent intent) {
        if (this.text1.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), getResources().getString(C0082R.string.initial_amount_alert), 0).show();
        } else if (this.text2.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), getResources().getString(C0082R.string.monthly_savings_alert), 0).show();
        } else if (this.spinner1.getSelectedItem().toString().equalsIgnoreCase("0.0")) {
            Toast.makeText(getApplicationContext(), getResources().getString(C0082R.string.porcentage_of_interest_alert), 0).show();
        } else if (this.spinner2.getSelectedItem().toString().equalsIgnoreCase("0")) {
            Toast.makeText(getApplicationContext(), getResources().getString(C0082R.string.number_of_months_alert), 0).show();
        } else if (this.spinner3.getSelectedItem().toString().equalsIgnoreCase("0.0")) {
            Toast.makeText(getApplicationContext(), getResources().getString(C0082R.string.dollar_value_alert), 0).show();
        } else {
            startActivity(intent);
        }
    }

    public List<String> createIntegerList() {
        List<String> list = new ArrayList();
        for (int i = 0; i < 101; i++) {
            list.add(Integer.toString(i));
        }
        return list;
    }

    public List<String> createDoubleList() {
        List<String> list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            double valor = (double) i;
            for (int j = 0; j < 100; j++) {
                list.add(Double.toString(Util.round(valor, 2)));
                valor += 0.01d;
            }
        }
        return list;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0082R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == C0082R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
