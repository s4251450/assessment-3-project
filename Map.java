package Project;

import java.util.Scanner;

public class Map
{
    static Scanner input = new Scanner(System.in);
    static int row = 0;
    static int column = 0;
    Location[][]map = new Location [4][4] ;

    public static void main (String[] args) {



        boolean gameRunning = true;
        while(gameRunning)
        {
            System.out.printf("You are at the coordinates [%d, %d]\n", row, column);
            showMenu();
            int choice = input.nextInt();
            input.nextLine();
            if (choice == 1)
            {
                move();
            }
            else if (choice == 2)
            {
                gameRunning = false;
            }
        }

    }
    public static void showMenu()
    {
        System.out.println("Menu");
        System.out.println("1. Move");
        System.out.println("2. Quit");
    }
    public static void move()
    {
        System.out.println("What direction would you like to move in terms of compass directions(n/e/s/w)");
        String direction = input.nextLine();
        if (direction.equals("n"))
        {
            if (row > 0)
            {
                row -=1;
                System.out.printf("Coordinates: [%d, %d]\n", row, column);

            }
            else
            {
                System.out.println("Cannot move outside of map.");
            }


        }
        else if (direction.equals("e") )
        {
            if (column < 3)
            {
                column += 1;
                System.out.printf("Coordinates: [%d, %d]\n", row, column);
            }
            else
            {
                System.out.println("Cannot move outside of map.");
            }
        }
        else if (direction.equals("s"))
        {
            if (row < 3)
            {
                row += 1;
                System.out.printf("Coordinates: [%d, %d]\n", row, column);
            }
            else
            {
                System.out.println("Cannot move outside of map");
            }
        }
        else if (direction.equals("w"))
        {
            if (column > 0)
            {
                column -= 1;
                System.out.printf("Coordinates: [%d, %d]\n", row, column);
            }
            else
            {
                System.out.println("Cannot move outside of map/");
            }
        }
        else
        {
            System.out.println("Invalid input direction must be either (n/e/s/w)");
        }

    }




}

