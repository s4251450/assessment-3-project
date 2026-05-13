package Project;

import java.util.Scanner;

public class Game
{
    static Scanner input = new Scanner(System.in);

    static Location[][]map = new Location [4][4] ;
    static Character player;

    public static void main (String[] args) {




        boolean gameRunning = true;
        createPlayer();
        setMap();
        while(gameRunning)
        {



            System.out.println("========================");
            System.out.println("Location: " + map[player.getRow()][player.getColumn()].getName());
            System.out.println("Description: " + map[player.getRow()][player.getColumn()].getDescription());
            if (map[player.getRow()][player.getColumn()].getItem() != null && !map[player.getRow()][player.getColumn()].getItemTaken())
            {
                System.out.println("Item available: " + map[player.getRow()][player.getColumn()].getItem());
            }
            if (map[player.getRow()][player.getColumn()].getEnemy() != null) {
                System.out.println("Enemy available: " + map[player.getRow()][player.getColumn()].getEnemy());
            }
            System.out.printf("You are at the coordinates [%d, %d]\n", player.getRow(), player.getColumn());
            showMenu();
            int choice = input.nextInt();
            input.nextLine();
            if (choice == 1)
            {
                move();
            }
            else if (choice == 2)
            {
                player.showInventory();
            }
            else if (choice == 3) {
                if (map[player.getRow()][player.getColumn()].getItem() != null && map[player.getRow()][player.getColumn()].getItemTaken() == false) {
                    map[player.getRow()][player.getColumn()].takeItem();




                    player.addItem(map[player.getRow()][player.getColumn()].getItem());
                    System.out.println("You took: " + map[player.getRow()][player.getColumn()].getItem());
                }
                else if (map[player.getRow()][player.getColumn()].getEnemy() != null && map[player.getRow()][player.getColumn()].getItem() == null)
                {
                    System.out.println("Combat initiated");

                }
            }
            else if (choice == 4)
            {

            }
            else if (choice == 5) {
                gameRunning = false;
            }
        }

    }
    public static void setMap()
    {
        //just change the strings to actual locations descriptions and items
        map[0][0] = new Location("location 1", "description 1", "item 1");
        map[1][0] = new Location("location 2", "description 2", null, new Enemy("Enemy 1", 30));
        map[0][1] = new Location("location 3", "description 3", "item 2");
        map[1][1] = new Location("location 4", "description 4");
        map[2][0] = new Location("location 5", "description 5", "item 3");
        map[2][1] = new Location("location 6", "description 6");
        map[2][2] = new Location("location 7", "description 7", "item 4");
        map[0][2] = new Location("location 8", "description 8");
        map[1][2] = new Location("location 9", "description 9", "item 5");
        map[3][0] = new Location("location 10", "description 10");
        map[3][1] = new Location("location 11", "description 11", "item 6");
        map[3][2] = new Location("location 12", "description 12");
        map[3][3] = new Location("location 13", "description 13", "item 7");
        map[0][3] = new Location("location 14", "description 14");
        map[1][3] = new Location("location 15", "description 15", "item 8");
        map[2][3] = new Location("location 16", "description 16");

        
    }
    public static void createPlayer()
    {
        System.out.println("\n===== Character Creation =====");
        System.out.print("Name: ");
        String name = input.nextLine();
        player = new Character(name);
        System.out.println("\nWelcome " + player.getName());
    }
    public static void showMenu()
    {
        System.out.println("Menu");
        System.out.println("1. Move");
        System.out.println("2. Show inventory");

        String item = map[player.getRow()][player.getColumn()].getItem();
        Enemy enemy = map[player.getRow()][player.getColumn()].getEnemy();
        if (item != null && !map[player.getRow()][player.getColumn()].getItemTaken())
        {
            System.out.println("3. Take Item");
        }

        else if (enemy != null && enemy.isAlive()) {
            System.out.println("3. Battle enemy");
        }
        System.out.println("4. Quit");




    }
    public static void move()
    {
        System.out.println("What direction would you like to move in terms of compass directions(n/e/s/w)");
        String direction = input.nextLine();
        if (direction.equals("n"))
        {
            if (player.getRow()> 0)
            {

                player.moveNorth();
                System.out.printf("Coordinates: [%d, %d]\n", player.getRow(), player.getColumn());

            }
            else
            {
                System.out.println("Cannot move outside of map.");
            }


        }
        else if (direction.equals("e") )
        {
            if (player.getColumn() < 3)
            {
                player.moveEast();
                System.out.printf("Coordinates: [%d, %d]\n", player.getRow(), player.getColumn());
            }
            else
            {
                System.out.println("Cannot move outside of map.");
            }
        }
        else if (direction.equals("s"))
        {
            if (player.getRow() < 3)
            {
                player.moveSouth();
                System.out.printf("Coordinates: [%d, %d]\n", player.getRow(), player.getColumn());
            }
            else
            {
                System.out.println("Cannot move outside of map");
            }
        }
        else if (direction.equals("w"))
        {
            if (player.getColumn() > 0)
            {
                player.moveWest();
                System.out.printf("Coordinates: [%d, %d]\n", player.getRow(), player.getColumn());
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

