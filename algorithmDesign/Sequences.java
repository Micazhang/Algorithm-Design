package algorithmDesign;

import java.util.Random;

public class Sequences {

	public static int editDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
	 
		// len1+1, len2+1, because finally return dp[len1][len2]
		int[][] dp = new int[len1 + 1][len2 + 1];
	 
		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}
	 
		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}
	 
		//iterate though, and check last char
		for (int i = 0; i < len1; i++) {
			char c1 = word1.charAt(i);
			for (int j = 0; j < len2; j++) {
				char c2 = word2.charAt(j);
	 
				//if last two chars equal
				if (c1 == c2) {
					//update dp value for +1 length
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					int replace = dp[i][j] + 1;
					int insert = dp[i][j + 1] + 1;
					int delete = dp[i + 1][j] + 1;
	 
					int min = replace > insert ? insert : replace;
					min = delete > min ? min : delete;
					dp[i + 1][j + 1] = min;
				}
			}
		}
	 
		return dp[len1][len2];
	}
	
	public static void main(String[] args) {
		// two arbitrary strings
//		String s1 = "intranet torrain";
//		String s2 = "internet domain";
//		int d = editDistance(s1, s2);
//		long totaltime=0;
////		System.out.println("Dist between '" + s1 + "' and '" + s2 + "' = " + d);
		Random r = new Random();
		int NumofTimes = 1000;
//		int len = 5;
//		String str = new String();
//		//generate 1000 words
//		String[] lst= new String[1000]; 
//		String s1r = "";
//		String s2r = "";
//		for (int i=0; i <1000;i++)
//		{
//			
//			for( int j = 0; j < len; j++ )
//				str  += (char) ( 'a' + r.nextInt( 26 ) );
////		
//			lst[i] = str;
//		}
//		// calculate distance between each pair in list
//		
//		
//		// random strings
//		 Random r = new Random( );
		
//
//		long t1= System.currentTimeMillis();
//		for ( int c =0; c<10;c++){
//			for( int j = 0; j < len; j++ ){
//				s1r += (char) ( 'a' + r.nextInt(26));
//				s2r += (char) ( 'a' + r.nextInt(26));
//			}
//			int dr = editDistance(s1r, s2r);
//		System.out.println("Dist between '" + s1r + "' and '" + s2r + "' = " + dr);
//		}//1000 loop
//		long t2 = System.currentTimeMillis();
//		totaltime += t2-t1;  // totaltime = totaltime + (t2-t1);
//		System.out.println("avg dist for 1000 random pairs of strings " + totaltime/1000);
		String s1r = "";
		String s2r = "";
		int len1 = 10;
		long starttime1 = 0;
		long endtime1 = 0;
		long avg_CPU1;
		starttime1 = System.nanoTime();
		for (int j = 0; j< NumofTimes; j++)
		{
			for (int i = 0; i < len1; i++)
			{
				s1r += (char) ('a' + r.nextInt(26));
				s2r += (char) ('a' + r.nextInt(26));					
			}
			int distance1 = editDistance(s1r, s2r);
			endtime1 = System.nanoTime() - starttime1;
		}
		avg_CPU1 = (endtime1 / NumofTimes);
		System.out.println("Avg CPU time in nanoseconds for 1000 pair of random words of lenth "+len1+" : "+avg_CPU1);

		String s3r = "";
		String s4r = "";
		int len2 = 20;
		long starttime2 = 0;
		long endtime2 = 0;
		long avg_CPU2;
		
		for (int j = 0; j< NumofTimes; j++)
		{
			for (int i = 0; i < len2; i++)
			{
				s3r += (char) ('a' + r.nextInt(26));
				s4r += (char) ('a' + r.nextInt(26));					
			}
			starttime2 = System.nanoTime();
			int distance2 = editDistance(s3r, s4r);
			endtime2 = System.nanoTime() - starttime2;
		}
		avg_CPU2 = (endtime2 / NumofTimes);
		System.out.println("Avg CPU time in nanoseconds for 1000 pair of random words of lenth "+len2+" : "+avg_CPU2);

		
		String s5r = "";
		String s6r = "";
		int len3 = 50;
		long starttime3 = 0;
		long endtime3 = 0;
		long avg_CPU3;
		
		starttime3 = System.nanoTime();	
		for (int j = 0; j< NumofTimes; j++)
		{
			for (int i = 0; i < len3; i++)
			{
				s5r += (char) ('a' + r.nextInt(26));
				s6r += (char) ('a' + r.nextInt(26));					
			}
	
			int distance3 = editDistance(s5r, s6r);
			endtime3 = System.nanoTime() - starttime3;
		}
		avg_CPU3 = (endtime3 / NumofTimes);
		System.out.println("Avg CPU time in nanoseconds for 1000 pair of random words of lenth "+len3+" : "+avg_CPU3);
		
		
		String s7r = "";
		String s8r = "";
		int len4 = 100;
		long starttime4 = 0;
		long endtime4 = 0;
		long avg_CPU4;
		
		for (int j = 0; j< NumofTimes; j++)
		{
			for (int i = 0; i < len4; i++)
			{
				s7r += (char) ('a' + r.nextInt(26));
				s8r += (char) ('a' + r.nextInt(26));					
			}
			starttime4 = System.nanoTime();
			int distance4 = editDistance(s7r, s8r);
			endtime4 = System.nanoTime() - starttime4;
		}
		avg_CPU4 = (endtime4 / NumofTimes);
		System.out.println("Avg CPU time in nanoseconds for 1000 pair of random words of lenth "+len4+" : "+avg_CPU4);

	}//main
}//class