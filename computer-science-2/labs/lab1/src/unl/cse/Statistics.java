package unl.cse;

public class Statistics {

	public static int getSum(int array[]) {
		if(array == null || array.length == 0)
			return 0;
		int answer = 0;
	    for(int i : array){
	        answer += i;
		}
	    return answer;
	}
	
	public static double getAverage(int array[]) {
		if(array == null || array.length < 1)
			return 0;
		int sum = getSum(array);
		return sum / (double) array.length;
	}

	public static int getMin(int array[]) {
		if(array == null || array.length == 0)
			return 0;
		int min = array[0];
		for(int i=1; i<array.length; i++) {
			if(array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}
	
	public static int getMax(int array[]) {
		if(array == null || array.length == 0)
			return 0;
		int max = array[0];
		for(int i=1; i<array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}
}
