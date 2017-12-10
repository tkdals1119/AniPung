import java.util.Scanner;

public class AniPung {
	private int[][] anipung = new int[5][5];
	private int count = 0;
	private int first = 0;
	private int second = 0;

	public AniPung(int[][] game)
	{
		this.anipung = game;
		
		calculate(anipung);
	}

	private void calculate(int[][] anipung) {
		// TODO Auto-generated method stub
		 
		for(int i=0; i<5; i++)
		{
			for(int j=0; j<5; j++)
			{
				anipung[i][j] = first;
				anipung[i][j+1] = second;
				
				if(first==second)
				{
						first = second;
						count++;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] game = new int[5][5];
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<5; i++)
		{
			for(int j=0; j<5; j++)
			{
				game[i][j] = sc.nextInt();
			}
		}
		
		AniPung ani = new AniPung(game);
	}	
}
