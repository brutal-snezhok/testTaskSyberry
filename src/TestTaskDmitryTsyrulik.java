
public class TestTaskDmitryTsyrulik {
    public final static int LOWEST_NUMBER_FOR_RANDOM = 0;
    public final static int HIGHEST_NUMBER_FOR_RANDOM = 99;
    public final static int SIZE_OF_MATRIX = 5;
    public final static int HIGHEST_SIZE_OF_MATRIX = 9999;
    public final static int LOWEST_SIZE_OF_MATRIX = 1;
    public final static int HIGHEST_TRIAL_NUMBER = 999999;
    public final static int LOWEST_TRIAL_NUMBER = 101;


    public static void main(String[] args) {
        System.out.println("Hello, Syberry!");

//        int[][] matrix = matrixGeneration(SIZE_OF_MATRIX);
//        check returned matrix
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix.length; j++) {
//                System.out.print(matrix[i][j] + "\t");
//            }
//            System.out.print("\n");
//        }

//        System.out.println(averageSum(12, 5));
//        simulation(16, 5, 1200, 10000);
    }

    public static int[][] matrixGeneration(int n) {
        if (n >= LOWEST_SIZE_OF_MATRIX && n <= HIGHEST_SIZE_OF_MATRIX) {
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = randomInt(LOWEST_NUMBER_FOR_RANDOM, HIGHEST_NUMBER_FOR_RANDOM);
                }
            }

            return matrix;
        } else {
            throw new IllegalArgumentException("Incorrect input number n: " + n + "! The number should be from interval (0, 10000).");
        }
    }

    public static double averageSum(int n, int m) {
        if (m > 0 && m < n) {
            int[][] matrix = matrixGeneration(n);
            int count = 0;
            int globalSum = 0;

            for (int i = 0; i < n - m + 1; i++) {
                for (int j = 0; j < n - m + 1; j++) {

                    int matrixSum = 0;
                    for (int p = i; p < m + i; p++)
                        for (int q = j; q < m + j; q++) {
                            matrixSum += matrix[p][q];
                        }

                    globalSum += matrixSum;
                    count++;
                }
            }

            return getRoundValue(globalSum, count);
        } else {
            throw new IllegalArgumentException("Incorrect input number m: " +
                    m + "! Te number should be from interval (0, n). Where is n: " + n);
        }
    }

    public static void simulation(int n, int m, int q, int trials) {
        if (trials >= LOWEST_TRIAL_NUMBER && trials <= HIGHEST_TRIAL_NUMBER) {
            int numberOfFavorableOutcomes = 0;

            for (int i = 0; i < trials; i++) {
                double averageSum = averageSum(n, m);
                if (averageSum < q) {
                    numberOfFavorableOutcomes++;
                }
            }

            System.out.println(getRoundValue(numberOfFavorableOutcomes, trials));
        } else {
            throw new IllegalStateException("Incorrect input number trials: "
                    + trials + "! The number should be from interval (100, 1000000).");
        }
    }

    private static int randomInt(int low, int high) {
        return (int) (Math.random() * (high - low + 1)) + low;
    }

    private static double getRoundValue(double dividend, int divider) {
        return Math.round(dividend / divider * 100d) / 100d;
    }
}
