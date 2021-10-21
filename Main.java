package study;

import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static int[] numArr = new int[3]; // �Է¹��� ���ڸ� �����ϱ� ���� static �迭 ����
	static String arr = ""; // ���ڸ� �Է��ϱ� ���� static String ����
	
	public static boolean numCheck(int[] arr) {
		//���ڰ� �ߺ����� �� �ԷµǾ������� �����ϴ� �޼ҵ�
		int i, j = 0;
		
		if(arr[0] == 0) {
			System.out.println("##### �� ���ڸ��� 0�� �� �� �����ϴ�. �ٽ� �Է��� �ּ���.");
			return false;
		}
		
		for(i=0; i<arr.length; i++) {
			for(j=0; j<i; j++) {
				if(arr[i] == arr[j]) {
					System.out.println("##### ���� ���ڸ� �Է��� �� �����ϴ�. �ٽ� �Է��� �ּ���.");
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	public static int[] numConvert(String arr) {
		// �Է¹��� String�� int�� �迭�� ��ȯ�ϴ� �޼ҵ�
		int i = 0;
		String[] numArr_S = arr.split("");
		for(i=0; i<numArr_S.length; i++) {
			numArr[i] = Integer.parseInt(numArr_S[i]);
		}
			
		return numArr;
	}
	
	public static String numInsert() {
		// ���� �Է�(String)
		System.out.println("##### ���ڸ� ������� �Է��� �ּ���. quit�� �Է��ϸ� ������ ����˴ϴ�. ");
		System.out.print("##### �Է� : ");
		arr = scan.nextLine();
		return arr;
	}
	
	public static void main(String[] args) {
		
		System.out.println("#######################################################");
		System.out.println("############## Welcome to BaseBall Game! ##############");
		System.out.println("#######################################################");
		
		int i, j = 0;
		int ballNum = 0;
		int strikeNum = 0;
		String regExp = "^[0-9]+$"; // ���ڸ� �Է��� �� �ִ� ����ǥ����
		int[] ansArr = new int[3];
		
		// ���� ����(���� ��ħx)
		for(i=0; i<ansArr.length; i++) {
			ansArr[i] = (int)((Math.random()*10));
			
			if(ansArr[0] == 0) {
				i--;
				continue;
			}
			
			for(j=0; j<i; j++) {
				if(ansArr[i] == ansArr[j]) {
					i--;
				}
			}
		}
		
		while(true) {
			numInsert(); // 3�ڸ��� ���ڸ� �Է¹޴´�.
			if(arr.equals("quit")){
				break;
			}
			
			else if(arr.matches(regExp)) { // ����ǥ���� �������� ���ڸ� �ԷµǾ����� Ȯ���Ѵ�.
				// ���� ���� 
				if(arr.length() != 3) {
					System.out.println("##### ���ڰ����� �ùٸ��� �ʽ��ϴ�. ");
				}
				else {
					numConvert(arr); // String ������ �Է¹��� arr�� int�� �迭�� ��ȯ�Ѵ�.
					if(numCheck(numArr)) {
						for(i=0; i<numArr.length; i++) {
							if(numArr[i] == ansArr[i]) strikeNum++; 
							else {
								for(j=0; j<numArr.length; j++) {
									if(numArr[i] == ansArr[j]) ballNum++;
								}
							}
						}
						
						if(strikeNum == 3) {
							System.out.println("##### �����Դϴ�! ");
							break;
						}
						else {
							System.out.println("##### strike = " + strikeNum + " ball = " + ballNum + " #####");
							strikeNum = 0;
							ballNum = 0;
						}
					}
				}
				
			}
			else {
				System.out.println("##### �߸� �Է��Ͽ����ϴ�. ");
			}
		
		}
		
		System.out.println("##### ������ �����մϴ�. ");
		
		scan.close();
	}

}
