package algo01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class hr05 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		int n = sc.nextInt();
		int a[] = new int[n];

		for(int i=0; i<n; i++)
			a[i] = sc.nextInt();
		
		int max = 0;
		
		/* °è»ê */
		for(int i=1; i<a.length; i++){
			for(int j=0; j<i; j++){
				if(a[i] > a[j]){
					max = Math.max(max, a[i] - a[j]);
				}
			}
		}
		
		System.out.println(max);
	}

}
