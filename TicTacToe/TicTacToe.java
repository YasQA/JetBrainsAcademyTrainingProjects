// Tic-Tac-Toe game 

import java.util.Scanner;

public class Main {
    private static char[][] array = new char[3][3];
    private static int symbolsX = 0;
    private static int symbolsO = 0;
    private static boolean hasEmpty = true;
    private static boolean isGameFinished = false;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        char nextMove = 'X';

        for (int i = 0; i < 3; i++ ) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = '_';
            }            
        } 

        printTable();

        while (!isGameFinished) {
            getMove(nextMove);
            printTable();
            
            switch (checkResult()) {
                case "Impossible" : {
                    System.out.println("Impossible");                   
                    break;
                }
                case "Game not finished" : {                   
                    break;
                }
                case "Draw" : {   
                    System.out.println("Draw");
                    isGameFinished = true;                
                    break;
                }
                case "X wins" : {
                    System.out.println("X wins");
                    isGameFinished = true;                      
                    break;
                }
                case "O wins" : {
                    System.out.println("O wins");
                    isGameFinished = true;                    
                    break;
                }
                default: {
                    break;
                }
            }
            nextMove = nextMove == 'X' ? 'O' : 'X';
        }
        sc.close();   
    }

    // Gets move from the user
    private static void getMove(char xo) {
        int coordinateX = 0;
        int coordinateY = 0;
        boolean isCorrectCoordinatesEntered = false;

        System.out.printf("Enter the coordinates: ");

        String input = sc.nextLine();

        while (!isCorrectCoordinatesEntered) {
            try {
                String [] pieces = input.split(" ");
                coordinateX = Integer.parseInt(pieces[0]);
                coordinateY = Integer.parseInt(pieces[1]);

                if (coordinateX < 1 || coordinateX > 3 || coordinateY < 1 || coordinateY > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    System.out.printf("Enter the coordinates: ");
                    input = sc.nextLine();
                } else if (array[3 - coordinateY][coordinateX - 1] != '_') {
                    System.out.println("This cell is occupied! Choose another one!");
                    System.out.printf("Enter the coordinates: ");
                    input = sc.nextLine();
                } else {
                    isCorrectCoordinatesEntered = true;
                }
            }
            catch (Exception e) {
                System.out.println("You should enter numbers!");
                System.out.printf("Enter the coordinates: ");
                input = sc.nextLine();
            }
        }

        array[3 - coordinateY][coordinateX - 1] = xo;

        if (xo == 'X') {
            symbolsX++;
        } else {
            symbolsO++;
        }

        if (9 - symbolsO - symbolsX == 0) {
            hasEmpty = false;
        }
    }

    //prints current table of the game
    public static void printTable() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.println("| " + array[i][0] + " " + array[i][1] + " " + array[i][2] + " |");
        }
        System.out.println("---------");
    }
    
    //check and return current state of the game (result)
    public static String checkResult() {        
        String gameResult = "";
        if ((hasThreeInRow('X') > 0 && hasThreeInRow('O') > 0) 
            || symbolsX <= symbolsO - 2
            || symbolsO <= symbolsX - 2) {
            gameResult = "Impossible";
        } else if (hasEmpty && hasThreeInRow('X') == 0 && hasThreeInRow('O') == 0) {
            gameResult = "Game not finished";
        } else if (!hasEmpty && hasThreeInRow('X') == 0 && hasThreeInRow('O') == 0) {
            gameResult = "Draw";
        } else if (hasThreeInRow('X') > 0 && hasThreeInRow('O') == 0) {
            gameResult = "X wins";
        } else if (hasThreeInRow('O') > 0 && hasThreeInRow('X') == 0) {
            gameResult = "O wins";
        }      
        return gameResult;
    }

    //calculates number of symbols from input inside array from input
    public static int numberOfSymbols(char symbol) {
        int number = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
            {
                if (array[i][j] == symbol) {
                    number++;
                }
            }    
        } 
        return number;
    }

    // returns number of lines\diagonals where symbols (X or O) 3 in a row 
    public static int hasThreeInRow(char symbolLocal) {
        int sumOfThreeSymbols = 0;
        int sum = 0;
        if (symbolLocal == 88) {
            sumOfThreeSymbols = 264; //sum of 3 'X';
        } else if (symbolLocal == 79) {
            sumOfThreeSymbols = 237; //sum of 3 'O';
        }

        for (int i = 0; i < 3; i++) {
            if (array[i][0] + array[i][1] + array[i][2] == sumOfThreeSymbols) {
                sum++;
            }
            if (array[0][i] + array[1][i] + array[2][i] == sumOfThreeSymbols) {
                sum++;
            }
        }

        if (array[0][0] + array[1][1] + array[2][2] == sumOfThreeSymbols) {
            sum++;
        }

        if (array[2][0] + array[1][1] + array[0][2] == sumOfThreeSymbols) {
            sum++;
        }
        return sum;
    }
}