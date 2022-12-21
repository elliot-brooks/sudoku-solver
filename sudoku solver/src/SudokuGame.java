import structure.Board;



public class SudokuGame {

    public static void menu() {
        int choice = 0;
        while (choice != 2) {
            System.out.println(Consts.MENU);
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
        Board gameGrid = Generator.generateBoard();


        while (!gameFinished) {
            System.out.println("\n" + gameGrid);

            // Initialise board (example at the moment but soon to be generated)

            //ask for coordiantes
            System.out.println("Enter the desired coordinates (e.g. 3,2)");
            System.out.println("or");
            System.out.println("Enter q to quit and c to check the board (or s to solve it)");
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
                Solver.solveBoard(gameGrid);

                System.out.print("Solved");
                System.out.println("\n" + gameGrid);

                gameFinished = true;

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
        menu();
    }

    

}
