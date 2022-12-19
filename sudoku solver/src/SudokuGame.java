import structure.Board;



public class SudokuGame {

    public static void menu() {
        int choice = 0;
        while (choice != 2) {
            System.out.print("\n--------------");
            System.out.print("\n----SUDOKU----");
            System.out.print("\n--------------\n");
            System.out.println("Please choose an option");
            System.out.println("1. New Game");
            System.out.println("2. Quit");
            String input = System.console().readLine();
            choice = Integer.valueOf(input);

            if (choice == 1) {
                play();
            }
            if (choice == 2) {
                return;
            }
        }
    }


    public static void play() {
        boolean gameFinished = false;

        Integer[][] gameExample = new Integer[][]{
            { 0, 0, 0, 2, 6, 0, 7, 0, 1 },
            { 6, 8, 0, 0, 7, 0, 0, 9, 0 },
            { 1, 9, 0, 0, 0, 4, 5, 0, 0 },
            { 8, 2, 0, 1, 0, 0, 0, 4, 0 },
            { 0, 0, 4, 6, 0, 2, 9, 0, 0 },
            { 0, 5, 0, 0, 0, 3, 0, 2, 8 },
            { 0, 0, 9, 3, 0, 0, 0, 7, 4 },
            { 0, 4, 0, 0, 5, 0, 0, 3, 6 },
            { 7, 0, 3, 0, 1, 8, 0, 0, 0 }

        };
        Board gameGrid = Board.patternToGrid(gameExample);


        while (!gameFinished) {
            System.out.println("\n" + gameGrid);

            // Initialise board (example at the moment but soon to be generated)

            //ask for coordiantes
            System.out.println("Enter the desired coordinates (e.g. 3,2)");
            System.out.println("or");
            System.out.println("Enter q to quit and c to check the board");
            String input = System.console().readLine();

            if (input.charAt(0) == 'q') {
                gameFinished = true;
                return;
            }
            else if (input.charAt(0) == 'c'){
                gameFinished = gameGrid.isSolved();
                if (gameFinished == false) {
                    System.out.println("\nIncorrect Solution");
                }
                else {
                    System.out.println("\nCorrect Solution");

                }
                
            }
            else if (input.charAt(0) == 's') {
                Solver.solveBoard(gameGrid.getBoardArray());

            }
            else {
                int x = Integer.valueOf(""+input.charAt(0));
                int y = Integer.valueOf(""+input.charAt(2));
                System.out.println("Enter the value you would like to enter here (1-9)");
                input = System.console().readLine();
                int value = Integer.valueOf(input);
                gameGrid.setTile(x, y, value);    
            }



        }



    }












    public static void main(String[] args) {
        /** 
        Integer[][] example1 = new Integer[][]{
            { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
            { 9, 1, 2, 3, 4, 5, 6, 7, 8 },
            { 8, 9, 1, 2, 3, 4, 5, 6, 7 },
            { 7, 8, 9, 1, 2, 3, 4, 5, 6 },
            { 6, 7, 8, 9, 1, 2, 3, 4, 5 },
            { 5, 6, 7, 8, 9, 1, 2, 3, 4 },
            { 4, 5, 6, 7, 8, 9, 1, 2, 3 },
            { 3, 4, 5, 6, 7, 8, 9, 1, 2 },
            { 2, 3, 4, 5, 6, 7, 8, 9, 1 }

        };




        Integer[][] solvedSudoku = new Integer[][]{
            { 1, 2, 3, 6, 7, 8, 9, 4, 5 },
            { 5, 8, 4, 2, 3, 9, 7, 6, 1 },
            { 9, 6, 7, 1, 4, 5, 3, 2, 8 },
            { 3, 7, 2, 4, 6, 1, 5, 8, 9 },
            { 6, 9, 1, 5, 8, 3, 2, 7, 4 },
            { 4, 5, 8, 7, 9, 2, 6, 1, 3 },
            { 8, 3, 6, 9, 2, 4, 1, 5, 7 },
            { 2, 1, 9, 8, 5, 7, 4, 3, 6 },
            { 7, 4, 5, 3, 1, 6, 8, 9, 2 }

        };
        */



        // add these rows to create a test grid to check the toString function
        /**
        SuperGrid testGrid = SuperGrid.patternToGrid(solvedSudoku);
        SuperGrid testGrid2 = SuperGrid.patternToGrid(example1);


        System.out.println(testGrid.toString());
        testGrid.isSolved();

        System.out.println(testGrid2.toString());
        testGrid2.isSolved();
        */

        menu();

    }

    

}
