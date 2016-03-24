
package com.android.chart.master.app;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;
import com.android.chart.animation.Easing;
import com.android.chart.charts.PieChart;
import com.android.chart.data.Entry;
import com.android.chart.data.PieData;
import com.android.chart.data.PieDataSet;
import com.android.chart.utils.ColorTemplate;

import java.util.ArrayList;

public class PieChartActivity extends DemoBase  {

    private PieChart mChart;

    private Typeface tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_piechart);
        mChart = (PieChart) findViewById(R.id.chart1);
        mChart.setUsePercentValues(false);
//        mChart.setExtraOffsets(5, 10, 5, 5);

        mChart.setDragDecelerationFrictionCoef(0.95f);

        tf = Typeface.createFromAsset(getAssets(), "OpenSans-Regular.ttf");

        mChart.setCenterTextTypeface(Typeface.createFromAsset(getAssets(), "OpenSans-Light.ttf"));
        mChart.setDrawCenterText(false);
        mChart.setDrawHoleEnabled(true);
        mChart.setRotationEnabled(false); // 滚动
        mChart.setHighlightPerTapEnabled(false);
        mChart.setHoleColor(Color.WHITE);
        mChart.setDescription("");

        mChart.setTransparentCircleColor(Color.WHITE);
        mChart.setTransparentCircleAlpha(110);

        mChart.setHoleRadius(88f);
        mChart.setTransparentCircleRadius(0f);



        mChart.setRotationAngle(-90);
        // enable rotation of the chart by touch




        setData(1, 100);

        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);

    }

    private void setData(int count, float range) {


        ArrayList<Entry> yVals1 = new ArrayList<Entry>();

        yVals1.add(new Entry((float) 90.0f, 0));
        yVals1.add(new Entry((float) 10.0f, 1));

        ArrayList<String> xVals = new ArrayList<String>();

        PieDataSet dataSet = new PieDataSet(yVals1, "");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);

        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);

        PieData data = new PieData(xVals, dataSet);

        mChart.setData(data);

        mChart.highlightValues(null);

        mChart.invalidate();
    }


}
