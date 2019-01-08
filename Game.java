import java.lang.Math;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Game{

	public static void main(String[] args){
		int[][] board;
		int x = 75;
		int y = 50;

		board = random_state(x,y);
/*
		File file = new File("/home/user/AAAprojekts/Game_of_Life/toad.txt");
		
		try{

			Scanner scan = new Scanner(file);
			ArrayList<Integer> numbers = new ArrayList<>();

			while(scan.hasNextLine()){
				int num = scan.nextInt();
				numbers.add(new Integer(num));
			}
			scan.close();

			int idx = 0;
			int[][] tarmp = new int[6][6];

			for(int i = 0; i < 6; i++){
				for(int j = 0; j < 6; j++){
					tarmp[i][j] = numbers.get(idx);
					idx++;
					System.out.print(tarmp[i][j] + " ");
				}
				System.out.println();
			}

			board = tarmp;

		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
*/

		try{
			for(int i = 0; i < 100; i++){
				board = get_next_state(board);
				render(board, x, y);
				Thread.sleep(250);
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

	public static int[][] random_state(int width, int height){

		int[][] rando = dead_state(width, height);

		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				if(Math.random() >= 0.5){
					rando[i][j] = 0;
				}
				else{
					rando[i][j] = 1;
				}
			}
		}

		return rando;
	}

	public static int[][] dead_state(int width, int height){

		int[][] dead = new int[height][width];

		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				dead[i][j] = 0;
			}
		}

		return dead;
	}

	public static void render(int[][] board, int width, int height){

		System.out.print("- - - - - - - - - -");
		System.out.print("- - - - - - - - - -");
		System.out.print("- - - - - - - - - -");
		System.out.print("- - - - - - - - - -");
		System.out.print("- - - - - - - - - -\n");

		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				if(board[i][j] == 1){
					System.out.print('$');
				}
				else{
					System.out.print(' ');
				}
				System.out.print(" ");
			}
			System.out.print("\n");
		}

		System.out.print("- - - - - - - - - -");
		System.out.print("- - - - - - - - - -");
		System.out.print("- - - - - - - - - -");
		System.out.print("- - - - - - - - - -");
		System.out.print("- - - - - - - - - -\n");
	}

	public static int[][] get_next_state(int[][] board){

		boolean alive;
		int temp[][] = new int[board.length][board[0].length];

		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				int neighbors = 0;
				if(board[i][j] == 0){
					alive = false;
					temp[i][j] = 0;
				}
				else{
					alive = true;
					temp[i][j] = 1;
				}

				if(i == 0){
					if(j == 0){

					}

					if(j == board[i].length-1){

					}
				}
				else if(i == board.length-1){
					if(j == 0){

					}

					if(j == board[i].length-1){

					}
				}
				else if(j == 0 || j == board[i].length-1){

				}
				else{
					//check neighbors in row above
					neighbors += board[i-1][j-1];
					neighbors += board[i-1][j];
					neighbors += board[i-1][j+1];

					//check neighbors in same row
					neighbors += board[i][j-1];
					neighbors += board[i][j+1];

					//check neighbors in row below
					neighbors += board[i+1][j-1];
					neighbors += board[i+1][j];
					neighbors += board[i+1][j+1];
				}

				if(alive && neighbors <= 1){
					temp[i][j] = 0;
				}
				else if(alive && neighbors == 2 || neighbors == 3){
					temp[i][j] = 1;
				}
				else if(alive && neighbors > 3){
					temp[i][j] = 0;
				}

				if(!alive && neighbors == 3){
					temp[i][j] = 1;
				}
			}
		}

		return temp;
	}

}