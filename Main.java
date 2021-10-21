package study;

import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static int[] numArr = new int[3]; // 입력받은 숫자를 저장하기 위한 static 배열 변수
	static String arr = ""; // 숫자를 입력하기 위한 static String 변수
	
	public static boolean numCheck(int[] arr) {
		//숫자가 중복없이 잘 입력되었는지를 검증하는 메소드
		int i, j = 0;
		
		if(arr[0] == 0) {
			System.out.println("##### 맨 앞자리에 0이 올 수 없습니다. 다시 입력해 주세요.");
			return false;
		}
		
		for(i=0; i<arr.length; i++) {
			for(j=0; j<i; j++) {
				if(arr[i] == arr[j]) {
					System.out.println("##### 같은 숫자를 입력할 수 없습니다. 다시 입력해 주세요.");
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	public static int[] numConvert(String arr) {
		// 입력받은 String을 int형 배열로 변환하는 메소드
		int i = 0;
		String[] numArr_S = arr.split("");
		for(i=0; i<numArr_S.length; i++) {
			numArr[i] = Integer.parseInt(numArr_S[i]);
		}
			
		return numArr;
	}
	
	public static String numInsert() {
		// 숫자 입력(String)
		System.out.println("##### 숫자를 공백없이 입력해 주세요. quit를 입력하면 게임이 종료됩니다. ");
		System.out.print("##### 입력 : ");
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
		String regExp = "^[0-9]+$"; // 숫자만 입력할 수 있는 정규표현식
		int[] ansArr = new int[3];
		
		// 숫자 생성(숫자 겹침x)
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
			numInsert(); // 3자리의 숫자를 입력받는다.
			if(arr.equals("quit")){
				break;
			}
			
			else if(arr.matches(regExp)) { // 정규표현식 검증으로 숫자만 입력되었는지 확인한다.
				// 숫자 검증 
				if(arr.length() != 3) {
					System.out.println("##### 숫자개수가 올바르지 않습니다. ");
				}
				else {
					numConvert(arr); // String 형으로 입력받은 arr을 int형 배열로 변환한다.
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
							System.out.println("##### 정답입니다! ");
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
				System.out.println("##### 잘못 입력하였습니다. ");
			}
		
		}
		
		System.out.println("##### 게임을 종료합니다. ");
		
		scan.close();
	}

}
