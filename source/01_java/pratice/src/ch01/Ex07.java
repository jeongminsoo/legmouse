package ch01;

public class Ex07 {

	public static void main(String[] args) {
		
		int[] arr = {76, 45, 34, 89, 100, 50, 90, 92};
		
		int sum = 0;
		int max = 0;
		int min = 999;
		
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			
			if (max < arr[i]) {
				max = arr[i];
			}
			
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		double avg = sum / arr.length;
		System.out.printf("�հ� : %d \t��� : %.2f\n�ִ밪 : %d\t�ּҰ� : %d\n",
								sum, avg, max, min);
	}
}
