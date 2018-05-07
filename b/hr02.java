package algo01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class hr02 {
	public static int calc(String exp, int max){
		int cnt = 0;	//'>'의 개수
		int result = 1;

		while(exp.indexOf("<>") > -1)	//String에서 '<>을 없애놓고 시작
			exp = exp.replace("<>", "");
		
		char[] temp = exp.toCharArray();
		
		for(int i=0; i<temp.length; i++){
			if(temp[i] =='<'){	//'<'가 존재하면 실패, 
				result = 0;
				break;
			}else if(temp[i] =='>'){	//'>'의 개수가 max 값보다 많다면 실패.
				if(++cnt > max){
					result = 0;
					break;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("sample.txt"));
		int T = sc.nextInt();
		String expressions[] = new String[T];
		
		for(int i=0; i<T; i++)
			expressions[i] = sc.next();
		
		int K = sc.nextInt();
		int[] maxReplacements = new int[K];
		
		for(int i=0; i<K; i++){
			maxReplacements[i] = sc.nextInt();
			System.out.println(calc(expressions[i],maxReplacements[i]));
		}
	}

}
