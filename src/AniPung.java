import java.util.Scanner;

public class AniPung {
	private int[][] anipung = new int[5][5];
	private int[][] change_anipung = new int[5][5];
	private int count = 0;
	private int first = 0;
	private int second = 0;
	private int start = 0;


	public AniPung(int[][] game)
	{
		this.anipung = game;
		this.change_anipung = game;
		
		calculate(anipung);
	}

	private void calculate(int[][] anipung) {
		// TODO Auto-generated method stub
		for(int i=0; i<5; i++)
		{
			count=0;
			for(int j=0; j<4; j++)
			{
				if(anipung[i][j]==anipung[i][j+1])
				{
					count++;
					
					if(count==1)
					{
						start = j;
					}
					if(count>=2 && j==3)
					{
						for(int z=start; z<=j+1; z++)
						{
							change_anipung[i][z]=0;
						}
					}
				}
				else
				{
					if(count>=2)
					{
						for(int z=j-count; z<=j; z++)
						{
							change_anipung[i][z]=0;
						}
					}
					count=0;
				}
			}
		}
		
		
		
		
		for(int j=0; j<5; j++)
		{
			count=0;
			for(int i=0; i<4; i++)
			{
				if(anipung[i][j]==anipung[i+1][j])
				{
					count++;
					
					if(count==1)
					{
						start = i;
					}
					if(count>=2 && i==3)
					{
						for(int z=start; z<=i+1; z++)
						{
							change_anipung[z][j]=0;
						}
					}
				}
				else
				{
					if(count>=2)
					{
						for(int z=i-count; z<=i; z++)
						{
							change_anipung[z][j]=0;
						}
					}
					count=0;
				}
			}
		}
		
		
		
		
		show(change_anipung);
	}

	private void show(int[][] change_anipung) {
		// TODO Auto-generated method stub
		for(int i=0; i<5; i++)
		{
			for(int j=0; j<5; j++)
			{
				System.out.print(change_anipung[i][j] + " ");
			}
			System.out.println("");
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
