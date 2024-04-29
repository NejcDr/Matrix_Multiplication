import java.util.Random;

public class MatrixMultiplier {
	
	public static int [][] generateMatrixInt(int n) {
		int[][] matrix = new int[n][n];
		Random random = new Random();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = (int)(random.nextInt(201) - 100);
			}
		}
		
		return matrix;
	}
	
	public static float[][] generateMatrixFloat(int n) {
		float[][] matrix = new float[n][n];
		Random random = new Random();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = (float)(random.nextDouble() * 200.0f - 100.0f);
			}
		}
		
		return matrix;
	}
	
	public static int[][] multiplyMatrixInt(int[][] A, int[][] B) {
		int n = A.length;
		int[][] result = new int[n][n];
		int sum;
		
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
	
	public static float[][] multiplyMatrixFloat(float[][] A, float[][] B) {
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
		
		//Integer variables
		long durationOfGenerationsInt = 0;
		long durationOfMultiplicationsInt = 0;
		
		//Float variables
		long durationOfGenerationsFloat = 0;
		long durationOfMultiplicationsFloat = 0;
		
		//Other variables
		int n_gen = 2;
		int n_mul = 0;
		
		//Time variables
		long start;
		long end;
		
		//Start Integer matrix generation
		start = System.nanoTime();
		int[][] A_int = generateMatrixInt(matrixSize);
		int[][] B_int = generateMatrixInt(matrixSize);
		end = System.nanoTime();
		durationOfGenerationsInt += (end - start);
		
		//Start Float matrix generation
		start = System.nanoTime();
		float[][] A_float = generateMatrixFloat(matrixSize);
		float[][] B_float = generateMatrixFloat(matrixSize);
		end = System.nanoTime();
		durationOfGenerationsFloat += (end - start);
		
		for (int i = 0; i < numberOfMultiplications; i++) {
			//Integer matrix multiplication
			start = System.nanoTime();
			A_int = multiplyMatrixInt(A_int, B_int);
			end = System.nanoTime();
			durationOfMultiplicationsInt += (end - start);
		
			//Float matrix multiplication
			start = System.nanoTime();
			A_float = multiplyMatrixFloat(A_float, B_float);
			end = System.nanoTime();
			durationOfMultiplicationsFloat += (end - start);
			
			n_mul++;
			
			if (i != numberOfMultiplications - 1) {
				//Integer matrix generation
				start = System.nanoTime();
				B_int = generateMatrixInt(matrixSize);
				end = System.nanoTime();
				durationOfGenerationsInt += (end - start);
				
				//Float matrix generation
				start = System.nanoTime();
				B_float = generateMatrixFloat(matrixSize);
				end = System.nanoTime();
				durationOfGenerationsFloat += (end - start);
				
				n_gen++;
			}
		}
		
		long total_int_gen = durationOfGenerationsInt / 1000000;
		long total_int_mul = durationOfMultiplicationsInt / 1000000;
		long avg_int_gen = (durationOfGenerationsInt / 1000000) / n_gen;
		long avg_int_mul = (durationOfMultiplicationsInt / 1000000) / n_mul;
		
		System.out.println("INTEGER MATRIX RESULT:");
		System.out.println("Number of matrixes generated: " + n_gen);
		System.out.println("Number of matrix multiplications: " + n_mul);
		System.out.println();
		System.out.println("Total matrix generation time: " + total_int_gen + " ms");
		System.out.println("Total matrix multiplication time: " + total_int_mul + " ms");
		System.out.println();
		System.out.println("Avarage matrix generation time: " + avg_int_gen + " ms");
		System.out.println("Avarage matrix multiplication time: " + avg_int_mul + " ms");
		
		System.out.println();
		System.out.println();
		
		long total_float_gen = durationOfGenerationsFloat / 1000000;
		long total_float_mul = durationOfMultiplicationsFloat / 1000000;
		long avg_float_gen = (durationOfGenerationsFloat / 1000000) / n_gen;
		long avg_float_mul = (durationOfMultiplicationsFloat / 1000000) / n_mul;
		
		System.out.println("FLOAT MATRIX RESULT:");
		System.out.println("Number of matrixes generated: " + n_gen);
		System.out.println("Number of matrix multiplications: " + n_mul);
		System.out.println();
		System.out.println("Total matrix generation time: " + total_float_gen + " ms");
		System.out.println("Total matrix multiplication time: " + total_float_mul + " ms");
		System.out.println();
		System.out.println("Avarage matrix generation time: " + avg_float_gen + " ms");
		System.out.println("Avarage matrix multiplication time: " + avg_float_mul + " ms");
	}
}