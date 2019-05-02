import java.io.IOException;
import java.util.Scanner;

public class Board {
    static int col1, col2, col3, col4, col5, col6, col7, position, value;
    static boolean player1, player2, win;

    //carica matrice
    public static void input(int grid[][]) throws IOException {
        while ((col1 >= 0 || col2 >= 0 || col3 >= 0 || col4 >= 0 || col5 >= 0 || col6 >= 0 || col7 >= 0) && (win)) {
            if (player1) System.out.print("Player 1: ");
            else System.out.print("Player 2: ");

            Scanner in = new Scanner(System.in);

            position = in.nextInt();
            position = position - 1;

            switch(position) {
                case 0:
                    if (col1 >= 0) {
                        round();
                        grid[col1][position] = value;
                        CheckWin(grid, col1, position);
                        print(grid);
                        col1 = col1 - 1;
                    }
                    else System.out.println("Colonna piena");
                    break;
                case 1:
                    if (col2 >= 0) {
                        round();
                        grid[col2][position] = value;
                        CheckWin(grid, col2, position);
                        print(grid);
                        col2 = col2 - 1;
                    }
                    else System.out.println("Colonna piena");
                    break;
                case 2:
                    if (col3 >= 0) {
                        round();
                        grid[col3][position] = value;
                        CheckWin(grid, col3, position);
                        print(grid);
                        col3 = col3 - 1;
                    }
                    else System.out.println("Colonna piena");
                    break;
                case 3:
                    if (col4 >= 0) {
                        round();
                        grid[col4][position] = value;
                        CheckWin(grid, col4, position);
                        print(grid);
                        col4 = col4 - 1;
                    }
                    else System.out.println("Colonna piena");
                    break;
                case 4:
                    if (col5 >= 0) {
                        round();
                        grid[col5][position] = value;
                        CheckWin(grid, col5, position);
                        print(grid);
                        col5 = col5 - 1;
                    }
                    else System.out.println("Colonna piena");
                    break;
                case 5:
                    if (col6 >= 0) {
                        round();
                        grid[col6][position] = value;
                        CheckWin(grid, col6, position);
                        print(grid);
                        col6 = col6 - 1;
                    }
                    else System.out.println("Colonna piena");
                    break;
                case 6:
                    if (col7 >= 0) {
                        round();
                        grid[col7][position] = value;
                        CheckWin(grid, col7, position);
                        print(grid);
                        col7 = col7 - 1;
                    }
                    else System.out.println("Colonna piena");
                    break;
                default: System.out.println("Error number");
            }
        }
    }

    //controlla se player ha vinto
    private static void CheckWin(int array[][], int y, int x) {
        int sign; //segno player

        //orizontale
        System.out.println(x);
        if (x < 4) { //verso sx
            for (int i = 0; i < 4; i++) {
                sign = array[y][i];
                if (sign == array[y][i+1] && sign == array[y][i+2] && sign == array[y][i+3]) {
                    winner(sign);
                    if (!win) System.out.println("orizzontale da sx verso dx");
                    break;
                }
            }
        }
        else { //verso dx
            for (int i = 6; i > 3; i--) {
                sign = array[y][i];
                if (sign == array[y][i-1] && sign == array[y][i-2] && sign == array[y][i-3]) {
                    winner(sign);
                    if (!win) System.out.println("orizzontale da dx verso sx");
                    break;
                }
            }
        }

        //verticale
        if (y <= 2 && win) {
            sign = array[y][x];
            if (sign == array[y+1][x] && sign == array[y+2][x] && sign == array[y+3][x]) {
                winner(sign);
                if (!win) System.out.println("verticale");
            }
        }


        //diagonali
        for (int j = 0; j < 6; j++) {
            if(!win) break;
            for (int i = 0; i < 7; i++) {
                sign = array[j][i];
                if (sign != 0) {
                    if (j > 2 && i <= 3) { //basso sx
                        if (sign == array[j-1][i+1] && sign == array[j-2][i+2] && sign == array[j-3][i+3]) {
                            winner(sign);
                            if (!win) break;
                        }
                    }
                    else if (j <= 2 && i <= 3) { //alto sx
                        if (sign == array[j+1][i+1] && sign == array[j+2][i+2] && sign == array[j+3][i+3]) {
                            winner(sign);
                            if (!win) break;
                        }
                    }
                    else if (j <= 2 && i >= 3) { //alto dx
                        if (sign == array[j+1][i-1] && sign==array[j+2][i-2] && sign==array[j+3][i-3]) {
                            winner(sign);
                            if (!win) break;
                        }
                    }
                    else if (j > 2 && i >= 3) { //basso dx
                        if (sign == array[j-1][i-1] && sign==array[j-2][i-2] && sign==array[j-3][i-3]) {
                            winner(sign);
                            if (!win) break;
                        }
                    }
                }
            }
        }


    }

    private static void winner(int player){
        if (player == 1){
            System.out.println("Giocatore 1 Vince");
            win = false;
        }
        else if (player == 2){
            System.out.println("Giocatore 2 Vince");
            win = false;
        }
    }

    //gestisce round dei giocatori
    private static void round(){
        if (player1){
            player1 = false;
            player2 = true;
            value = 1;
        }
        else {
            player1 = true;
            player2 = false;
            value = 2;
        }
    }

    //prova per caricare matrice
    public static void load(int array[][]) throws IOException{
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print("INSERISCI"+i+j+": ");
                Scanner in = new Scanner(System.in);
                array[i][j]=in.nextInt();
            }
        }
    }

    //stampa matrice
    private static void print(int array[][]){
        System.out.println();
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 7; j++) System.out.print(array[i][j] + " ");
            System.out.println();
        }
    }
}