package com.example.plazofijo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.internal.view.SupportMenu;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.example.plazofijo.C0082R;
import com.example.plazofijo.business.Calculations;
import com.example.plazofijo.business.ResultsBean;
import com.example.plazofijo.util.Util;
import java.util.ArrayList;
import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class ThirdActivity extends ActionBarActivity {
    private RelativeLayout relativeLayout;

    public static class PlaceholderFragment extends Fragment {
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(C0082R.layout.fragment_third, container, false);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0082R.layout.activity_third);
        this.relativeLayout = (RelativeLayout) findViewById(C0082R.id.container);
        Intent requester = getIntent();
        openChart(Calculations.calcultate(Double.valueOf((String) requester.getExtras().get(getResources().getString(C0082R.string.initial_amount_parameter))), Double.valueOf((String) requester.getExtras().get(getResources().getString(C0082R.string.monthly_savings_parameter))), Double.valueOf(requester.getExtras().getDouble(getResources().getString(C0082R.string.porcentage_of_interest_parameter))), Double.valueOf(requester.getExtras().getDouble(getResources().getString(C0082R.string.number_of_months_parameter))), Double.valueOf(requester.getExtras().getDouble(getResources().getString(C0082R.string.dollar_value_parameter)))));
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add((int) C0082R.id.container, new PlaceholderFragment()).commit();
        }
    }

    private void openChart(ArrayList<ResultsBean> beans) {
        int i;
        XYSeries pesosSeries = new XYSeries(getResources().getString(C0082R.string.pesos_series));
        XYSeries dollarsSeries = new XYSeries(getResources().getString(C0082R.string.dollars_series));
        for (i = 0; i < beans.size(); i++) {
            pesosSeries.add((double) i, Util.round(((ResultsBean) beans.get(i)).getBalanceInPesos().doubleValue(), 0));
            dollarsSeries.add((double) i, Util.round(((ResultsBean) beans.get(i)).getBalanceInDollars().doubleValue(), 0));
        }
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        dataset.addSeries(pesosSeries);
        dataset.addSeries(dollarsSeries);
        XYSeriesRenderer incomeRenderer = new XYSeriesRenderer();
        incomeRenderer.setColor(-16776961);
        incomeRenderer.setPointStyle(PointStyle.CIRCLE);
        incomeRenderer.setFillPoints(true);
        incomeRenderer.setLineWidth(2.0f);
        incomeRenderer.setDisplayChartValues(true);
        XYSeriesRenderer expenseRenderer = new XYSeriesRenderer();
        expenseRenderer.setColor(-16711936);
        expenseRenderer.setPointStyle(PointStyle.CIRCLE);
        expenseRenderer.setFillPoints(true);
        expenseRenderer.setLineWidth(2.0f);
        expenseRenderer.setDisplayChartValues(true);
        XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();
        multiRenderer.setXLabels(0);
        multiRenderer.setChartTitle(getResources().getString(C0082R.string.chart_title));
        multiRenderer.setLabelsColor(SupportMenu.CATEGORY_MASK);
        multiRenderer.setXTitle(getResources().getString(C0082R.string.x_title));
        multiRenderer.setYTitle(getResources().getString(C0082R.string.y_title));
        multiRenderer.setZoomButtonsVisible(true);
        multiRenderer.setAxesColor(DefaultRenderer.BACKGROUND_COLOR);
        multiRenderer.setBackgroundColor(-1);
        multiRenderer.setMarginsColor(-1);
        multiRenderer.setApplyBackgroundColor(true);
        multiRenderer.setXLabelsColor(DefaultRenderer.BACKGROUND_COLOR);
        multiRenderer.setYLabelsColor(0, DefaultRenderer.BACKGROUND_COLOR);
        for (i = 0; i < beans.size(); i++) {
            multiRenderer.addXTextLabel((double) (i + 1), ((ResultsBean) beans.get(i)).getMonth());
        }
        multiRenderer.addSeriesRenderer(incomeRenderer);
        multiRenderer.addSeriesRenderer(expenseRenderer);
        GraphicalView graphicalView = ChartFactory.getLineChartView(getBaseContext(), dataset, multiRenderer);
        this.relativeLayout.setBackgroundColor(-1);
        this.relativeLayout.addView(graphicalView);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0082R.menu.third, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == C0082R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
