/*
http://en.wikipedia.org/wiki/Sudoku
Problem description: 
Sudoku, originally called Number Place,[1] is a logic-based,[2][3] combinatorial[4] number-placement puzzle. The objective is to fill a 9×9 grid with digits so that each column, each row, and each of the nine 3×3 sub-grids that compose the grid (also called "boxes", "blocks", "regions", or "sub-squares") contains all of the digits from 1 to 9. The puzzle setter provides a partially completed grid, which for a well-posed puzzle has a unique solution. Completed puzzles are always a type of Latin square with an additional constraint on the contents of individual regions. For example, the same single integer may not appear twice in the same row, column or in any of the nine 3×3 subregions of the 9x9 playing board.The puzzle was popularized in 1986 by the Japanese puzzle company Nikoli, under the name Sudoku, meaning single number.[5] It became an international hit in 2005.[6]

*/


class Solution {
	public void solveSudoku(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}

		helper(0, 0, board); //我就觉得特别奇怪，如果helper是void的返回类型，则board里的值还是运算前的值，但是如果 helper 设置成char[][]的返回类型后，return的board就是运算后的值了

		return;
	} // end solveSudoku


	char[][] helper(int row, int col, char[][] B) {
		if (row > 8)
			return B;
		if (col > 8) {
			char[][] temp = helper(row + 1, 0, B);
			if(temp!=null)
				return B;
		} else { 

			if (B[row][col] == '.') {
				for (int i = 1; i <= 9; i++) {
					if (isValid(i, row, col, B)) {
						B[row][col] = (char) (i + '0'); //pay more attention to here
						char[][] temp = helper(row, col + 1, B);
						if(temp!=null)
							return B;
						B[row][col] = '.';
					}
				}
			} else {
				char[][] temp = helper(row, col + 1, B);
				if(temp!=null)
					return B;
			}
		}
		return null;
	} // end helper

	boolean isValid(int x, int row, int col, char[][] B) {
		if (isValidRow(x, row, col, B) && isValidCol(x, row, col, B)
				&& isValidSquare(x, row, col, B))
			return true;
		return false;
	} //

	boolean isValidRow(int x, int row, int col, char[][] B) {
		int i = 0;

		while (i <= 8) {
			if (B[row][i] == x + '0' && i != col)
				return false;
			i++;
		}
		return true;
	}

	boolean isValidCol(int x, int row, int col, char[][] B) {
		int i = 0;
		while (i <= 8) {
			if (B[i][col] == x + '0' && i != row)
				return false;
			i++;
		}
		return true;
	}

	boolean isValidSquare(int x, int row, int col, char[][] B) {
		int startRow = row / 3 * 3;
		int startCol = col / 3 * 3;

		for (int i = startRow; i <= startRow + 2; i++) {
			for (int j = startCol; j <= startCol + 2; j++) {
				if (B[i][j] == x + '0' && i != row && j != col) {
					return false;
				}
			}
		}
		return true;
	}
} // end solution

/*----for test, we suppose the items are Integer----*/
public class TestII {
	public static void main(String[] args) {
		Solution sol = new Solution();
		char[][] B = { 
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } 
};
		sol.solveSudoku(B);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(B[i][j] + " ");
			}
			System.out.println();
		}
	} // end main
} // end test class
