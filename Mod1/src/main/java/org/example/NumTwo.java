package org.example;

public class NumTwo {
    public static void main(String[] args){
        int[][] x = {{20, 34,2}, {9, 12, 18}, {3, 4, 5}};

        int minNum = 1000;

        for (int i = 0; i < x.length; i++){
            for (int j = 0; j < x[i].length; j++){
                if (minNum > x[i][j]){
                    minNum = x[i][j];
                }
            }
        }

        System.out.println(minNum);

    }
}
