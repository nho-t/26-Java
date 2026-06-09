package day05;

public class Array06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double score[][] = {{3.3, 3.4}, {3.5, 3.6}, {3.7, 4.0}, {4.1, 4.2}};
		
		double sum = 0;
		
		try {
			for (int year = 0; year<5; year++) 
				for (int term = 0; term<score[year].length; term++)
					sum += score[year][term];	
		} catch (ArrayIndexOutOfBoundsException ao) {
			ao.printStackTrace();
		}
		
		int n = score.length;
		int m = score[0].length;
		System.out.println("4년 전체 평점 평균은 " + sum/(n*m));

	}

}
