package xchart;

import java.util.ArrayList;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.Styler.LegendPosition;


public class SinMain {

	public static void main(String[] args) {
		/*Create and Customize Chart*/
		XYChart chart = new XYChartBuilder().width(800).height(600).build();
	    chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Scatter);
	    chart.getStyler().setChartTitleVisible(false);
	    chart.getStyler().setLegendPosition(LegendPosition.InsideSW);
	    chart.getStyler().setMarkerSize(5);
	    
	    /*Generate data*/
	    ArrayList<Double> listX = new ArrayList<Double>();
	    ArrayList<Double> listY = new ArrayList<Double>();
		for(double x = 0 ; x <= 2* Math.PI; x = x + Math.PI/1000){
			double y = (1 + x / Math.PI) * Math.cos(x) * Math.cos(40 * x);
			listY.add(y);
			listX.add(x);
		}
	    /*series*/
	    chart.addSeries("Chart", listX, listY);
	    new SwingWrapper<>(chart).displayChart();



	}
	
	
	
}
