package homework_2023_12_18;

public class Task8 {
    //    Создайте функциональный интерфейс MatrixProcessor с методом process, который принимает
//    двумерный массив (матрицу) целых чисел и выполняет над ним операцию.
//    Напишите метод, который принимает матрицу и MatrixProcessor, и выполняет операцию нахождения транспонированной матрицы.
    public static void main(String[] args) {
        int[][] matrix = {{1, 2},
                          {3,4},
                          {5,6}};

        printMatrix(matrix);
        printMatrix(matrixProcessor(matrix, Task8::transportMatrix));
    }

    public static int[][] matrixProcessor(int[][] matrix, MatrixProcessor matrixProcessor) {
        return matrixProcessor.process(matrix);
    }

    public static int[][] transportMatrix(int[][] matrix) {
        int [][] newMatrix = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }

        return newMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

interface MatrixProcessor {
    int[][] process(int[][] matrix);
}