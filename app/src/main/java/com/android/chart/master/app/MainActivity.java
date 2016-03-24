package com.android.chart.master.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button button;
    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
    }

    private void assignViews() {
        button = (Button) findViewById(R.id.button);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.button:
                //TODO implement
                i = new Intent(this, BarChartActivity.class);
                startActivity(i);
                break;
            case R.id.button1:
                //TODO implement
                i = new Intent(this, HorizontalBarChartActivity.class);
                startActivity(i);
                break;
            case R.id.button2:
                //TODO implement
                i = new Intent(this, PieChartActivity.class);
                startActivity(i);
                break;
            case R.id.button3:
                //TODO implement
                i = new Intent(this, BarChartActivityMultiDataset.class);
                startActivity(i);
                break;

        }
    }

}
