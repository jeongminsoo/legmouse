package ch01;

public class Ex09 {

	public static void main(String[] args) {
		
		int[] arr = {76, 45, 34, 89, 100, 50, 90, 92};
		int num;
		for (int i = 0; i < arr.length-1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					num = arr[i];
					arr[i] = arr[j];
					arr[j] = num;
				}
				
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
