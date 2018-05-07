package algo01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class hr07 {
	static int top;
    static int[] S;

	public static void print(){
		if(top < 0)
			System.out.println("EMPTY");
		else
			System.out.println(S[top]);
	}
	
	public static void push(int[] S, int k){
		S[++top] = k;
	}
	
	public static void pop(int[] S){
		--top;
	}
	
	public static void inc(int[] S, int e, int k){
		for(int i=0; i<e; i++)
			S[i] += k;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		int n = sc.nextInt();
		String operations[] = new String[n];
		S = new int[n];
		top = -1;

		for(int i=0; i<n; i++){
			operations[i] = sc.nextLine();
			String[] temp = operations[i].split(" ");
			
			if(temp[0].equals("push"))
				push(S,Integer.parseInt(temp[1].toString()));
			else if(temp[0].equals("pop"))
				pop(S);
			else if(temp.length > 2)
				inc(S,Integer.parseInt(temp[1].toString()),Integer.parseInt(temp[2].toString()));
			print();
		}
	}
}
