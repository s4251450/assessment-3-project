package Project;

import java.util.Scanner;

public class Map
{
    static Scanner input = new Scanner(System.in);
    static int row = 0;
    static int column = 0;
    static Location[][]map = new Location [4][4] ;

    public static void main (String[] args) {




        boolean gameRunning = true;
        setMap();
        while(gameRunning)
        {



            System.out.println("========================");
            System.out.println("Location: " + map[row][column].getName());
            System.out.println("Description: " + map[row][column].getDescription());
            if (map[row][column].getItem() != null && !map[row][column].getItemTaken())
            {
                System.out.println("Item available: " + map[row][column].getItem());
            }
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
    public static void setMap()
    {
        //Ok so Jiaming looking at this first one replace the brackets with the location name, description,
        //and item name if there is an item on grid. Eacn grid unit has a location. Increase by [0,0] then
        //[1,0] then [1,1] then [2,1] and so on till [3,3]. Some locations have items some dont.When ur finished commit it
        //feel free to change the names and descriptions and items.
        map[0][0] = new Location("Mars", "The red earth of mars surrounds you", "key");
        map[1][0] = new Location("Jupiter", "The large atmosphere chokes you ");
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

