package hr.devetibit.givemeblood.fragments;

import hr.devetibit.givemeblood.R;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.achartengine.ChartFactory; 
import org.achartengine.GraphicalView; 
import org.achartengine.chart.PointStyle; 
import org.achartengine.model.XYMultipleSeriesDataset; 
import org.achartengine.model.XYSeries; 
import org.achartengine.renderer.XYMultipleSeriesRenderer; 
import org.achartengine.renderer.XYSeriesRenderer;

public class Statistics extends Fragment {
	Context context;
	Typeface custom_font;
	
	public Statistics(Context context, Typeface custom_font) {
		this.context = context;
		this.custom_font = custom_font;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.statistics, container, false);
		
		XYSeries series = new XYSeries("chart");
		
		series.add(0.1, 2.0);
		series.add(1.0, 1.0); 
		series.add(2.0, 2.0);
		series.add(3.0, 3.0);
		series.add(4.0, 3.0);
		series.add(5.0, 3.0);
		series.add(6.0, 2.0);
		series.add(7.0, 1.0);
		series.add(8.0, 4.0);
		series.add(9.0, 3.0);
		
		XYSeriesRenderer renderer = new XYSeriesRenderer();
		renderer.setLineWidth(5);
		renderer.setColor(Color.RED);
		renderer.setDisplayBoundingPoints(true);
		renderer.setPointStyle(PointStyle.CIRCLE);
	    renderer.setChartValuesTextSize(10);
	    renderer.setChartValuesTextSize(12);
	    renderer.setPointStrokeWidth(5f);
	    
	    
		XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
		mRenderer.addSeriesRenderer(renderer);
		//mRenderer.setMarginsColor(Color.argb(0x00, 0xff, 0xff, 0xff));
		mRenderer.setPanEnabled(false, false); 
		mRenderer.setYAxisMax(10);
		mRenderer.setYAxisMin(0);
		mRenderer.setXAxisMax(10);
		mRenderer.setXAxisMin(0);
		mRenderer.setShowGrid(true);
		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
		dataset.addSeries(series);
		LinearLayout a = (LinearLayout) rootView.findViewById(R.id.chart); 
		
		
		
		GraphicalView chartView; 
		chartView = ChartFactory.getLineChartView(context, dataset, mRenderer); 
		a.addView(chartView, 0);
		
		return rootView;
	}
}
