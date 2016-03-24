package com.android.chart.interfaces.dataprovider;


import com.android.chart.components.YAxis;
import com.android.chart.data.BarLineScatterCandleBubbleData;
import com.android.chart.utils.Transformer;


public interface BarLineScatterCandleBubbleDataProvider extends ChartInterface {

    Transformer getTransformer(YAxis.AxisDependency axis);
    int getMaxVisibleCount();
    boolean isInverted(YAxis.AxisDependency axis);
    
    int getLowestVisibleXIndex();
    int getHighestVisibleXIndex();

    BarLineScatterCandleBubbleData getData();
}
