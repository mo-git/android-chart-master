
package com.android.chart.custom;

import android.content.Context;
import android.widget.TextView;
import com.android.chart.components.MarkerView;
import com.android.chart.data.Entry;
import com.android.chart.highlight.Highlight;
import com.android.chart.master.app.R;
import com.android.chart.utils.Utils;

/**
 * Custom implementation of the MarkerView.
 * 
 * @author Philipp Jahoda
 */
public class MyMarkerView extends MarkerView {

    private TextView tvContent;

    public MyMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);

        tvContent = (TextView) findViewById(R.id.tvContent);
    }

    // callbacks everytime the MarkerView is redrawn, can be used to update the
    // content (user-interface)
    @Override
    public void refreshContent(Entry e, Highlight highlight) {

            tvContent.setText("" + Utils.formatNumber(e.getVal(), 0, true));
    }

    @Override
    public int getXOffset(float xpos) {
        // this will center the marker-view horizontally
        return -(getWidth() / 2);
    }

    @Override
    public int getYOffset(float ypos) {
        // this will cause the marker-view to be above the selected value
        return -getHeight();
    }
}
