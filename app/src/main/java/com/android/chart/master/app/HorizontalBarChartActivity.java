
package com.android.chart.master.app;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.android.chart.charts.HorizontalBarChart;
import com.android.chart.components.Legend;
import com.android.chart.components.Legend.*;
import com.android.chart.components.XAxis;
import com.android.chart.components.XAxis.*;
import com.android.chart.components.YAxis;
import com.android.chart.components.YAxis.*;
import com.android.chart.data.BarData;
import com.android.chart.data.BarDataSet;
import com.android.chart.data.BarEntry;
import com.android.chart.data.Entry;
import com.android.chart.highlight.Highlight;
import com.android.chart.interfaces.datasets.IBarDataSet;
import com.android.chart.listener.OnChartValueSelectedListener;
import com.android.chart.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class HorizontalBarChartActivity extends DemoBase  {

    protected HorizontalBarChart mChart;

    private Typeface tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_horizontalbarchart);


        mChart = (HorizontalBarChart) findViewById(R.id.chart1);

        mChart.setDrawBarShadow(false);

        mChart.setDrawValueAboveBar(true);

        mChart.setDescription("");

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        mChart.setMaxVisibleValueCount(60);

        // scaling can now only be done on x- and y-axis separately
        mChart.setPinchZoom(false);

        // draw shadows for each bar that show the maximum value
        // mChart.setDrawBarShadow(true);

        // mChart.setDrawXLabels(false);

        mChart.setDrawGridBackground(false);

        // mChart.setDrawYLabels(false);

        tf = Typeface.createFromAsset(getAssets(), "OpenSans-Regular.ttf");

        XAxis xl = mChart.getXAxis();
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);
        xl.setTypeface(tf);
        xl.setDrawAxisLine(false);
        xl.setDrawGridLines(false);
        xl.setGridLineWidth(0.3f);

        YAxis yl = mChart.getAxisLeft();
        yl.setTypeface(tf);
        yl.setDrawAxisLine(false);
        yl.setDrawGridLines(true);
        yl.setGridLineWidth(0.3f);
        yl.setAxisMinValue(0f); // this replaces setStartAtZero(true)
//        yl.setInverted(true);

        YAxis yr = mChart.getAxisRight();
        yr.setTypeface(tf);
        yr.setDrawAxisLine(true);
        yr.setDrawGridLines(false);
        yr.setAxisMinValue(0f); // this replaces setStartAtZero(true)
//        yr.setInverted(true);

        setData(5, 500);
        mChart.animateY(2500);

    }


    private void setData(int count, float range) {

        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
        ArrayList<String> xVals = new ArrayList<String>();

        for (int i = 0; i < count; i++) {
            xVals.add(mMonths[i % 12]);
        }

        yVals1.add(new BarEntry((float)50, 0));
        yVals1.add(new BarEntry((float)100, 1));
        yVals1.add(new BarEntry((float)200, 2));
        yVals1.add(new BarEntry((float)100, 3));
        yVals1.add(new BarEntry((float)400, 4));


        BarDataSet set1 = new BarDataSet(yVals1, "DataSet 1");
        ArrayList<Integer> colors = new ArrayList<Integer>();
        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);
        set1.setColors(colors);



        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);
        set1.setBarSpacePercent(75f);

        BarData data = new BarData(xVals, dataSets);
        data.setValueTextSize(10f);
        data.setValueTypeface(tf);

        mChart.setData(data);

    }

}
