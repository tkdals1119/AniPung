import java.util.Scanner;

public class AniPung {
	private int[][] anipung = new int[5][5];
	private int count = 0; // ������ ���ڰ� ��� ���ӵǴ��� üũ, count�� 2 �̻��� ��� 0���� �ٲ�
	private int start = 0; // ���ӵǴ� ���ڵ��� ù��° �ε���
	private int final_check = 0; // ��� ������ ���� �Ǻ�

	public AniPung(int[][] game)
	{
		this.anipung = game;
		
		calculate(anipung);
	}

	private void calculate(int[][] anipung) { // ���� 3�� �̻��� ���ڰ� ���� �� �� 0���� ��ü, �� ���� �� ����� ���� ��
				
		final_check = 0;
		for(int i=0; i<5; i++) // ���� �Ǻ�
		{
			count=0;
			for(int j=0; j<4; j++)
			{
				if(anipung[i][j]==anipung[i][j+1])
				{
					count++;
					if(count==1) // ������ ���ڸ� �ν��� �� ù��° �ε����� ���
					{
						start = j;
					}
					
					if(count>=2 && j==3)
					{						
						for(int z=start; z<=j+1; z++)
						{
							if(anipung[i][z] != 0) // �� �̻� �Ǻ��� ���ڰ� ���ٴ� ���� ���� �̻��� ���ӵ� ������ ���ڰ� ���ٴ� ��. �� ���� ������ ���ڰ� 0�ۿ� �����Ƿ� 0������ ����� ��.
								                   // ��, ���� �Ǻ��� ���ڰ� �ִٴ� ���� 0�� �ƴ� ���ӵ� ���ڵ��� 0���� �ٲܰ� �ִٴ� ���̹Ƿ� �� �� final_check ������ 1�� ����
							{
								anipung[i][z]=0;
								final_check=1; // final_check�� 0�̸� �� �̻� �Ǻ� �� ���ڰ� ����
								               // final_check�� 1�̸� ���� �Ǻ� �� ���� ����
							}
							else
							{
								anipung[i][z]=0;
							}						
						}
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
		
		
		for(int j=0; j<5; j++) // ���� �Ǻ�, �⺻ ������ ���� �Ǻ��� ����
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
		
		if(final_check == 0) // final_check�� �Լ� �ʱ⿡ ������ 0 �״�� �̹Ƿ�, �� �̻� �Ǻ��� ���ڰ� ���� show �Լ��� ����  ���� ����� ���
		{
			show(anipung);
		}
		else
		{
			move(anipung);
		}
	}

	private void move(int[][] anipung) { // ������ ���� 0�� �κе��� ù��° ���� �����ϰ� ���� �� ���ڰ� ������ ��ü

		for(int i=0; i<5; i++)
		{
			for(int j=0; j<5; j++)
			{
				if(anipung[i][j]==0)
				{
					for(int z=i; z>=0; z--)
					{
						if(z==0) // ù��° ���� ������ ���� 0�̸� �״�� 0����  ����
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

	private void show(int[][] anipung) { // ���� ���
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
				
				if(game_num<1 || game_num>4)
				{
					System.out.println("1~4 �̳��� ���ڷ� �Է����ּ���.");
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
