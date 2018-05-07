package algo01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class hr06 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		int n = sc.nextInt();
		int a[] = new int[n];

		for(int i=0; i<n; i++)
			a[i] = sc.nextInt();
		
		int k = sc.nextInt();
		
		/* 중복을 허용하는 pair들의 집합을 구한다 */
		HashSet<HashSet<Integer>> set = new HashSet<HashSet<Integer>>();
		HashSet<Integer> pair = new HashSet<Integer>();
		
		for(int i=0; i<a.length; i++){
			for(int j=i; j<a.length; j++){
				if(a[j] + a[i] == k){
					pair.add(a[j]);
					pair.add(a[i]);
					set.add(pair);
				}
			}
		}
		System.out.println(set.size());
	}

}
