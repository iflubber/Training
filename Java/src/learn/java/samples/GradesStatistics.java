package learn.java.samples;

import java.util.Arrays;
import java.util.Scanner;

public class GradesStatistics {
	int n;
	String grades;
	double avg;
	int min;
	int max;
	double median;
	double stddev;
	
	void calculateAverage(){
		avg=0;
		double sum=0;
		String[] numbers = grades.split(",");
		for(String no: numbers){
			sum+=Integer.parseInt(no);
		}
		avg = sum/n;
	}
	
	void findMinMax(){
		String[] numbers = grades.split(",");
		min = Integer.parseInt(numbers[0]);
		max = Integer.parseInt(numbers[0]);
		for(String no: numbers){
			if(Integer.parseInt(no)<min)
				min=Integer.parseInt(no);
			if(Integer.parseInt(no)>max)
				max=Integer.parseInt(no);
		}
	}
	
	void calculateStdDev(){
		String[] numbers = grades.split(",");
		stddev=0;
		double sumSqr=0;
		for(String no:numbers){
			double n = Integer.parseInt(no);
			sumSqr+=(n-avg)*(n-avg);
		}
		stddev=Math.sqrt(sumSqr/n);
	}
	
	void calculateMedian(){
		String[] grade = grades.split(",");
		double[] numbers = new double[grade.length];
		int i=0;
		for(String g: grade){
			numbers[i]=Double.parseDouble(g);
			i++;
		}
		Arrays.sort(numbers);
		if(n%2==0){
			median = (numbers[(n/2)-1] + numbers[n/2])/2;
		}else
			median = numbers[(n/2)];
	}
	
	public static void main(String[] args) {
		GradesStatistics gs = new GradesStatistics();
		
		Scanner in = new Scanner(System.in);
		System.out.println("How many grades you want to enter?");
		gs.n=in.nextInt();
		
		System.out.println("Enter " + gs.n + " grades: (comma-separated, between 0 and 100 inclusive)");
		gs.grades=in.next();
		
		gs.calculateAverage();
		gs.findMinMax();
		gs.calculateMedian();
		gs.calculateStdDev();
		
		System.out.println("Five-point Summary:");
		System.out.printf("Average: %.2f\n",gs.avg);
		System.out.printf("Minimum: %d\n",gs.min);
		System.out.printf("Maximum: %d\n",gs.max);
		System.out.printf("Median: %.2f\n",gs.median);
		System.out.printf("Standard Deviation: %.2f\n",gs.stddev);
	}

}
