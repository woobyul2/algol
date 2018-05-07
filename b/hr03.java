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
		// LinkedHashMap : �ߺ����� �ʰ� Key�� ���� ������ �����ϴ� HashMap
		
		for(int i=0; i<T; i++)
			votes[i] = sc.next();

		int cnt = 1;	//������ ��ǥ���� ����ϱ� ���� ����
		Arrays.sort(votes);
		
		for(int i=1; i<T; i++){
			if(votes[i].equals(votes[i-1])){	//�յ� ��ǥ���� �̸��� ���ٸ� cnt+1
				votesTemp.put(votes[i==T-1 ? i : i-1], ++cnt);
			}else{	//�յ� ��ǥ���� �̸��� �ٸ��ٸ� cnt ���߰� �ʱ�ȭ
				votesTemp.put(votes[i==T-1 ? i : i-1], i==T-1 ? 1 : cnt);
				cnt = 1;
			}
		}

		/* ���� ��ǥ����� ���� �������� max�� ���� ����� �̱�� */
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
