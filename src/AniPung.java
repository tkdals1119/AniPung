import java.util.Scanner;

public class AniPung {
	private int[][] anipung = new int[5][5];
	private int count = 0;
	private int start = 0;
	private int final_check = 0;

	public AniPung(int[][] game)
	{
		this.anipung = game;
		
		calculate(anipung);
	}

	private void calculate(int[][] anipung) {
				
		final_check = 0;
		for(int i=0; i<5; i++)
		{
			count=0;
			for(int j=0; j<4; j++)
			{
				if(anipung[i][j]==anipung[i][j+1])
				{
					count++;
					
					if(count==1) // (1~4), (2~4) 동일 시
					{
						start = j;
					}
					
					if(count>=2 && j==3)
					{						
						for(int z=start; z<=j+1; z++)
						{
							if(anipung[i][z] != 0)
							{
								anipung[i][z]=0;
								final_check=1;
							}
							else
							{
								anipung[i][z]=0;
							}						}
					}
				}
				else
				{
					if(count>=2)
					{
						for(int z=j-count; z<=j; z++)
						{
							if(anipung[i][z] != 0)
							{
								anipung[i][z]=0;
								final_check=1;
							}
							else
							{
								anipung[i][z]=0;
							}								
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
							if(anipung[z][j] != 0)
							{
								anipung[z][j]=0;
								final_check=1;
							}
							else
							{
								anipung[z][j]=0;
							}
						}
					}
				}
				else
				{
					if(count>=2)
					{
						for(int z=i-count; z<=i; z++)
						{
							if(anipung[z][j] != 0)
							{
								anipung[z][j]=0;
								final_check=1;
							}
							else
							{
								anipung[z][j]=0;
							}						
						}
					}
					count=0;
				}
			}
		}	
		
		if(final_check == 0)
		{
			show(anipung);
		}
		else
		{
			move(anipung);
		}
	}

	private void move(int[][] anipung) {
		// TODO Auto-generated method stub

		for(int i=0; i<5; i++)
		{
			for(int j=0; j<5; j++)
			{
				if(anipung[i][j]==0)
				{
					for(int z=i; z>=0; z--)
					{
						if(z==0)
						{
							anipung[z][j]=0;
						}
						else
						{
							anipung[z][j] = anipung[z-1][j]; 
						}
					}
				}
			}
		}
		calculate(anipung);
	}

	private void show(int[][] anipung) {
		// TODO Auto-generated method stub
		for(int i=0; i<5; i++)
		{
			for(int j=0; j<5; j++)
			{
				System.out.print(anipung[i][j]+" ");
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
				int game_num = sc.nextInt();
				if(game_num>4)
				{
					System.out.println("1~4 이내의 숫자로 입력해주세요.");
				}
				else
				{
					game[i][j] = game_num;
				}
			}
		}
		
		AniPung ani = new AniPung(game);
	}	
}
