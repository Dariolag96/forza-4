import java.io.IOException;

public class Main {
    public static void main(String[] arg0) throws IOException {
        int [][] grid;
        Board.col1=Board.col2=Board.col3=Board.col4=Board.col5=Board.col6=Board.col7=5;
        Board.player1=true;
        Board.player2=false;
        Board.win=true;
        grid= new int [6][7];

        Board.input(grid);

    }
        }
