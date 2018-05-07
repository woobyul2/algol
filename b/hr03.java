package algo01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class hr03 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		int T = sc.nextInt();
		
		String votes[] = new String[T];
		LinkedHashMap<String,Integer> votesTemp = new LinkedHashMap<String,Integer>();	
		// LinkedHashMap : 중복되지 않게 Key를 갖고 순서를 유지하는 HashMap
		
		for(int i=0; i<T; i++)
			votes[i] = sc.next();

		int cnt = 1;	//각자의 투표수를 계산하기 위한 변수
		Arrays.sort(votes);
		
		for(int i=1; i<T; i++){
			if(votes[i].equals(votes[i-1])){	//앞뒤 투표자의 이름이 같다면 cnt+1
				votesTemp.put(votes[i==T-1 ? i : i-1], ++cnt);
			}else{	//앞뒤 투표자의 이름이 다르다면 cnt 멈추고 초기화
				votesTemp.put(votes[i==T-1 ? i : i-1], i==T-1 ? 1 : cnt);
				cnt = 1;
			}
		}

		/* 같은 투표수라면 제일 마지막에 max를 갖는 사람이 이긴다 */
		int max = 0;
		String name = "";
		
		for(String s: votesTemp.keySet()){
			if(max <= votesTemp.get(s)){
				name = s;
				max = Math.max(max, votesTemp.get(name));
			}
		}
		
		System.out.println(name);
	}

}
