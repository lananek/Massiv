import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
import java.util.Comparator;
/*Даны две действительные квадратные матрицы порядка n. Получить новую матрицу путем
прибавления к элементам каждого столбца первой матрицы произведения всех элементов
соответствующих строк второй матрицы. Произведения вывести на консоль. Частично
отсортировать первую строку по убыванию с индекса i по j, используя Соmparator. Частично
скопировать строку в другой массив.*/

public class Massiv {

    public static class MemberComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            if (a.equals(b)) return 0;
            else if (a > b) return -1;
            else return 1;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] matrix1 = new int[n][n];

        Random rnd = new Random();
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = rnd.nextInt(10) + 1;
            }
        }
        System.out.print("Matrix1 : \n");
        for (int i = 0; i < matrix1.length; i++, System.out.println()) {
            for (int j = 0; j < matrix1[i].length; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
        }
        System.out.print("\n");
        int[][] matrix2 = new int[n][n];
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix2[i][j] = rnd.nextInt(10) + 1;
            }
        }
        System.out.print("Matrix2 : \n");
        for (int i = 0; i < matrix2.length; i++, System.out.println()) {
            for (int j = 0; j < matrix2[i].length; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
        }
        System.out.print("\n");
        int[] pr = new int[n];
        System.out.print("Multiplication:\n");
        for (int i = 0; i < n; i++) {
            pr[i] = 1;
            for (int j = 0; j < n; j++) {
                pr[i] *= matrix2[i][j];
            }
            System.out.print(pr[i] + " ");

        }
        Integer[][] new_matrix = new Integer[n][n];

        for (int j=0;j<n;j++) {
            for (int i = 0; i < n; i++) {
                new_matrix[j][i] = matrix1[j][i] + pr[i];
            }
        }
        System.out.println("\nNew matrix:");
        for (int j=0;j< new_matrix.length; j++,System.out.println()) {
            for (int i=0;i< new_matrix[j].length; i++) {
                System.out.print(new_matrix[j][i]+ " ");
            }
        }

        Arrays.sort(new_matrix[0], 0,  n, new MemberComparator());
        System.out.println("\nNew matrix with sort_comparator:");
        for (int j=0;j< new_matrix.length; j++,System.out.println()) {
            for (int i=0;i< new_matrix[j].length; i++) {
                System.out.print(new_matrix[j][i]+ " ");
            }
        }
        System.arraycopy(matrix1, 0, matrix2, 0, n-1);
        System.out.print("Matrix2 with copy : \n");
        for (int i = 0; i < matrix2.length; i++, System.out.println()) {
            for (int j = 0; j < matrix2[i].length; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
        }
    }
}
