import java.util.Scanner;

public class AniPung {
	private int[][] anipung = new int[5][5];
	private int count = 0; // 동일한 숫자가 몇번 연속되는지 체크, count가 2 이상일 경우 0으로 바꿈
	private int start = 0; // 연속되는 숫자들의 첫번째 인덱스
	private int final_check = 0; // 재귀 로직의 끝을 판별

	public AniPung(int[][] game)
	{
		this.anipung = game;
		
		calculate(anipung);
	}

	private void calculate(int[][] anipung) { // 연속 3개 이상의 숫자가 동일 할 시 0으로 대체, 행 계산과 열 계산을 따로 함
				
		final_check = 0;
		for(int i=0; i<5; i++) // 행의 판별
		{
			count=0;
			for(int j=0; j<4; j++)
			{
				if(anipung[i][j]==anipung[i][j+1])
				{
					count++;
					if(count==1) // 동일한 숫자를 인식할 때 첫번째 인덱스를 기억
					{
						start = j;
					}
					
					if(count>=2 && j==3)
					{						
						for(int z=start; z<=j+1; z++)
						{
							if(anipung[i][z] != 0) // 더 이상 판별할 숫자가 없다는 말은 세개 이상의 연속된 동일한 숫자가 없다는 뜻. 이 때는 동일한 숫자가 0밖에 없으므로 0끼리만 계산이 됨.
								                   // 즉, 아직 판별할 숫자가 있다는 것은 0이 아닌 연속된 숫자들을 0으로 바꿀게 있다는 뜻이므로 이 때 final_check 변수를 1로 선언
							{
								anipung[i][z]=0;
								final_check=1; // final_check가 0이면 더 이상 판별 할 숫자가 없음
								               // final_check가 1이면 아직 판별 할 숫자 있음
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
		
		
		for(int j=0; j<5; j++) // 열의 판별, 기본 로직은 행의 판별과 동일
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
		
		if(final_check == 0) // final_check가 함수 초기에 선언한 0 그대로 이므로, 더 이상 판별할 숫자가 없어 show 함수를 통해  최종 결과를 출력
		{
			show(anipung);
		}
		else
		{
			move(anipung);
		}
	}

	private void move(int[][] anipung) { // 데이터 값이 0인 부분들은 첫번째 행을 제외하고 위의 행 숫자가 내려와 대체

		for(int i=0; i<5; i++)
		{
			for(int j=0; j<5; j++)
			{
				if(anipung[i][j]==0)
				{
					for(int z=i; z>=0; z--)
					{
						if(z==0) // 첫번째 행의 데이터 값이 0이면 그대로 0으로  선언
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

	private void show(int[][] anipung) { // 최종 출력
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
