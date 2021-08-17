package com.its;

public class Test {

	public static void main(String[] args) {
		
		int maxCnt = 10;
		
		for(int i=maxCnt; i>0; i--) {
			if( i % 2 == 0) {
				
				//공백
				int spaceCnt = maxCnt -i;
				
				for(int j=0; j<spaceCnt; j++) {
					System.out.print(" ");
				}
				
				for(int j=spaceCnt; j<maxCnt; j++) {
					//*
					System.out.print("*");				
				}
				System.out.println();
			}
		}
		
		
	}

}
