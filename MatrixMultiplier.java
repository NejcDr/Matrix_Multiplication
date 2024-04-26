import java.util.Random;

public class MatrixMultiplier {
	
	public static float[][] generateMatrix(int n) {
		float[][] matrix = new float[n][n];
		Random random = new Random();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = (float)(random.nextDouble() * 100.0);
			}
		}
		
		return matrix;
	}
	
	public static float[][] multiply(float[][] A, float[][] B) {
		int n = A.length;
		float[][] result =  new float[n][n];
		float sum;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum = 0;
				for (int k = 0; k < n; k++) {
					sum += A[i][k] * B[k][j];
				}
				result[i][j] = sum;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int matrixSize = Integer.parseInt(args[0]);
		int numberOfMultiplications = Integer.parseInt(args[1]);
		
		long durationOfMultiplications = 0;
		long durationOfGenerations = 0;
		
		long start;
		long end;
		
		int n_gen = 2;
		int n_mul = 0;
		
		start = System.nanoTime();
		float[][] A = generateMatrix(matrixSize);
		float[][] B = generateMatrix(matrixSize);
		end = System.nanoTime();
		
		durationOfGenerations += ((end - start) / 1000000);
		
		for (int i = 0; i < numberOfMultiplications; i++) {
			start = System.nanoTime();
			A = multiply(A, B);
			end = System.nanoTime();
			
			n_mul++;
			
			durationOfMultiplications += ((end - start) / 1000000);
			
			if (i != numberOfMultiplications - 1) {
				start = System.nanoTime();
				B = generateMatrix(matrixSize);
				end = System.nanoTime();

				n_gen++;
			}
			
			durationOfGenerations += ((end - start) / 1000000);
		}
		
		
		System.out.println("Total " + n_gen + " matrixes generated.");
		System.out.println("Total " + n_mul + " matrix multiplications.");
		System.out.println("Time for generating matrixes: " + durationOfGenerations + " ms.");
		System.out.println("Time for matrix multiplications: " + durationOfMultiplications + " ms.");
	}
}