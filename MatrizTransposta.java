public class MatrizTransposta {
	public static void main(String[] args) {
		int[][] matriz = new int[3][3];
		int numeroTemp;
		
		matriz[0][0] = 1;
		matriz[0][1] = 2;
		matriz[0][2] = 3;
		matriz[1][0] = 4;
		matriz[1][1] = 5;
		matriz[1][2] = 6;
		matriz[2][0] = 7;
		matriz[2][1] = 8;
		matriz[2][2] = 9;
		
		System.out.println("Matriz:");
		mostrarMatriz(matriz);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println("-------");
				numeroTemp = matriz[i][j];
				matriz[i][j] = matriz[j][i];
				matriz[j][i] = numeroTemp;
				mostrarMatriz(matriz);
			}
		}

		System.out.println("Transposta:");
		mostrarMatriz(matriz);
	}
	public static void mostrarMatriz(int[][] matriz) {
		for (int i = 0; i < 3; i++) {
			System.out.println(String.format("%d %2d %2d", matriz[i][0], matriz[i][1], matriz[i][2]));
		}
	}
}
