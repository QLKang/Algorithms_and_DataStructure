/*
http://en.wikipedia.org/wiki/Eight_queens_puzzle
The eight queens puzzle is the problem of placing eight chess queens on an 8×8 chessboard so that no two queens threaten each other. Thus, a solution requires that no two queens share the same row, column, or diagonal. The eight queens puzzle is an example of the more general n-queens problem of placing n queens on an n×n chessboard, where solutions exist for all natural numbers n with the exception of n=2 or n=3.[1]
*/
// this is solution2
class EightQueensPuzzle2 {
    public List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<String[]>();
		if (n <= 0)
			return res;

		int currRow = 0;
		int[] queenInCol = new int[n];
		helper(currRow, n, queenInCol, res);
		return res;
    } // solveNQueen
    
    void helper(int currRow, int n, int[] queenInCol, List<String[]> res) {
		if (currRow == n) {
			String[] strs = new String[n];
			for (int row = 0; row < n; row++) {
				StringBuffer sb = new StringBuffer();
				for (int col = 0; col < n; col++) {
					if (queenInCol[row] == col) {
						sb.append('Q');
					} else {
						sb.append('.');
					}
				}
				strs[row] = sb.toString();
			}
			res.add(strs);
			return;
		}
		
		for (int col = 0; col < n; col++) {
			if (isValid(currRow, col, queenInCol)) {
				queenInCol[currRow] = col; // store the valid queen index of current row in the array queenInCol[].
				helper(currRow + 1, n, queenInCol, res);
			}
		}
	} // helper

    /* check if the position is valid */
	boolean isValid(int currRow, int column, int[] queenInCol) { // input parameters may be changed
		for (int i = 0; i < currRow; i++) {
			if (column == queenInCol[i]	|| Math.abs(currRow - i) == Math.abs(column - queenInCol[i]))
				return false;
		}
		return true;
	} // isValid
    
} // end solution2


class Solution1 {
	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		if (n < 1) {
			return result;
		}
		String[] rows = new String[n];
		int row = 0;
		solutions(row, n, rows, result);
		return result;
	}

	// DFS soluve question
	private void solutions(int stRow, int n, String[] rows,	ArrayList<String[]> result) {
		if (stRow >= n) {
			result.add(rows.clone());
			return;
		}

		for (int col = 0; col < n; col++) {
			if (!isValid(col, stRow, rows)) {
				continue;
			}

			char[] chars = new char[n];
			Arrays.fill(chars, '.');
			chars[col] = 'Q';

			rows[stRow] = String.copyValueOf(chars);
			solutions(stRow + 1, n, rows, result);
		}
	}

	// check if current col has conflit with previous Q
	private boolean isValid(int col, int stRow, String[] rows) {
		// checkColumn
		for (int i = 0; i < stRow; i++) {
			int qCol = rows[i].indexOf("Q");

			if (qCol == col) {
				return false;
			}

			int rowDistance = Math.abs(stRow - i);
			int colDistance = Math.abs(col - qCol);

			if (rowDistance == colDistance) {
				return false;
			}
		}
		return true;
	}
} // end solution1

public class Test {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 4;
		ArrayList<String[]> res = sol.solveNQueens(n);

		for (String[] arr : res) {

			for (String s : arr)
				System.out.print(s + "| ");
			System.out.println();
		}
	}
}
