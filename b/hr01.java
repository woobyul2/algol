package algo01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class hr01 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		/* ���� �� */
		int origItemsNum = sc.nextInt();
		String[] origItems = new String[origItemsNum]; 

		for(int i=0; i<origItems.length; i++)
			origItems[i] = sc.next();

		int origPricesNum = sc.nextInt();
		float[] origPrices = new float[origPricesNum]; 
		
		for(int i=0; i<origPrices.length; i++)
			origPrices[i] = (float)sc.nextDouble();
		
		/* ����Ŭ�� �Է��� �� �Ѥ� */
		int itemsNum = sc.nextInt();
		String[] items = new String[itemsNum]; 
		
		for(int i=0; i<items.length; i++)
			items[i] = sc.next();

		int pricesNum = sc.nextInt();
		float[] prices = new float[pricesNum]; 
		
		for(int i=0; i<prices.length; i++)
			prices[i] = (float)sc.nextDouble();
		
		/* ��� */
		int cnt = 0;
		
		for(int i=0; i<origItemsNum; i++){
			for(int j=0; j<itemsNum; j++){
				if(origItems[i].equals(items[j])){
					if(origPrices[i] == prices[j])
						continue;
					else
						cnt++;
				}else{
					continue;
				}
			}
		}
		System.out.println(cnt);
	}
}
