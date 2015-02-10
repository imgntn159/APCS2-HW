public class mazesolver {
	public char[][] Solver(int a, char[][] arr, int b){
		int x = 0;
		int y = 0;
		main:
		for (int q = 0;q<arr.length;q++){
			for (int p = 0;p<arr[0].length;p++){
				if (arr[p][q] == 'S'){
					x = p;
					y = q;
					break main;
				}
			}
		}
		return Solverhelp(x, y, arr, something);
	}
}