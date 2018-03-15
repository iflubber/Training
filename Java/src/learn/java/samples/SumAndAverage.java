package learn.java.samples;

public class SumAndAverage {
	int min;
	int max;
	int sum;
	double average;
	
	void calculateSum(){
		for(int i =min; i<=max; i++)
			sum+=i;
	}
	
	void calculateSum1(){
		int i=min;
		while(i<=max){
			sum+=i;
			i++;
		}
	}
	
	void calculateSum2(){
		int i=min;
		do{
			sum+=i;
			i++;
		}while(i<=max);
	}
	
	void calculateSumOfOddNumbers(){
		for(int i =min; i<=max; i++){
			if(i%2!=0)
				sum+=i;
		}
	}

	void calculateSumOfNumbersDivisibleBy(int n){
		for(int i =min; i<=max; i++){
			if(i%n==0)
				sum+=i;
		}
	}

	void calculateSumOfSquares(){
		for(int i =min; i<=max; i++){
				int sqr=i*i;
				sum+=sqr;
		}
	}

	void calculateAvg(){
		average = sum/max;
	}
	
	SumAndAverage(){
		sum=0;
		average=0;
	}
	
	public static void main(String[] args) {
		SumAndAverage saa = new SumAndAverage();
		System.out.println("******Numbers between 1 to 100******");
		saa.min=1;
		saa.max=100;

		System.out.println("******Using for loop******");
		saa.calculateSum();
		saa.calculateAvg();
		
		System.out.println("The Sum is " + saa.sum + " and the Average is " + saa.average);

		saa = new SumAndAverage();
		saa.min=1;
		saa.max=100;
		System.out.println("******Using while loop******");
		saa.calculateSum1();
		saa.calculateAvg();
		
		System.out.println("The Sum is " + saa.sum + " and the Average is " + saa.average);

		saa = new SumAndAverage();
		saa.min=1;
		saa.max=100;
		System.out.println("******Using do...while loop******");
		saa.calculateSum2();
		saa.calculateAvg();
		
		System.out.println("The Sum is " + saa.sum + " and the Average is " + saa.average);

		saa = new SumAndAverage();
		System.out.println("******Numbers between 111 to 8899******");
		saa.min=111;
		saa.max=8899;
		int count=0;
		for(int i=saa.min;i<=saa.max;i++)
			count++;
		System.out.println("Count of numbers between 111 to 8899 is " + count);
		saa.calculateSum();
		saa.calculateAvg();
		
		System.out.println("The Sum is " + saa.sum + " and the Average is " + saa.average);

		saa = new SumAndAverage();
		System.out.println("******Numbers between 1 to 100******");
		saa.min=1;
		saa.max=100;

		System.out.println("******Using for loop******");
		saa.calculateSumOfOddNumbers();
		saa.calculateAvg();
		
		System.out.println("The Sum of Odd Numbers is " + saa.sum + " and the Average is " + saa.average);

		saa = new SumAndAverage();
		System.out.println("******Numbers between 1 to 100******");
		saa.min=1;
		saa.max=100;

		System.out.println("******Using for loop******");
		saa.calculateSumOfNumbersDivisibleBy(7);
		saa.calculateAvg();
		
		System.out.println("The Sum of Numbers Divisible By 7 is " + saa.sum + " and the Average is " + saa.average);

		saa = new SumAndAverage();
		System.out.println("******Numbers between 1 to 100******");
		saa.min=1;
		saa.max=100;

		System.out.println("******Using for loop******");
		saa.calculateSumOfSquares();
		saa.calculateAvg();
		
		System.out.println("The Sum of Squares is " + saa.sum + " and the Average is " + saa.average);
	}

}
