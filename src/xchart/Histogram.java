package xchart;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler.LegendPosition;

public class Histogram {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<String> listX = new ArrayList<String>();
		ArrayList<Integer> listY = new ArrayList<Integer>(Collections.nCopies(1000, 0)); // create arraylist with 1000 copies contain 0;

		for(int i = 0; i < 100; i= i + 10){ // create strings 1-10,11-20,... and add them to listX//
			listX.add(String.valueOf(i +1) +" - " + String.valueOf(i +10) );
		}
		
       /*read from file*/
		try {
			File number = new File("C:\\java_courses\\1DV507\\src\\xchart\\numbers.txt");
			Scanner scan = new Scanner(number);
			while (scan.hasNext()) {
				numbers.add(scan.nextInt()); //store numbers in array list list//
			}
			for (int i = 0; i < numbers.size(); i++) {
				for (int j = 0; j < 10; j++) { //add the number counts to listY from 1-10 11-20 to 91-100
					if (numbers.get(i) >= (j * 10 + 1) && numbers.get(i) <= (j * 10 + 10)) {
						listY.set(j, listY.get(j) + 1); //increase value of listY index 0+1 1+1 2+1 to count numbers for each period 1-10,..//
					}
				}
			}
			/*get pie chart*/
		    PieChart chart = getChart(listX,listY);
		    new SwingWrapper<PieChart>(chart).displayChart();
            /*get bar chart*/
		    CategoryChart chart2 = getBarChart(listX,listY);
		    new SwingWrapper<CategoryChart>(chart2).displayChart();
		

			scan.close();

		}
	

		catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static  PieChart getChart(ArrayList<String> listX, ArrayList<Integer> listY) {

	    // Create Chart
	    PieChart chart = new PieChartBuilder().width(800).height(600).title("Pie Histogram").build();

	    for(String i : listX){
	    	chart.addSeries(String.valueOf(i), listY.get(listX.indexOf(i)));
	    }
	

	    return chart;
	  }
	
	public static CategoryChart getBarChart(ArrayList<String> listX, ArrayList<Integer> listY) {

	    //Create BarChart//
	    CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Bar Histogram").xAxisTitle("Score").yAxisTitle("Number").build();

	    //Customize Chart//
	    chart.getStyler().setLegendPosition(LegendPosition.InsideNW);
	    chart.getStyler().setHasAnnotations(true);

	    // Series
		ArrayList<Integer> listYNew = new ArrayList<Integer>();
		for(String i : listX){
	    	listYNew.add(listY.get(listX.indexOf(i)));
	    }
	    chart.addSeries(" ", listX, listYNew);

	    return chart;
	  }

}
