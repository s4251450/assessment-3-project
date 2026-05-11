package Project;

import java.util.ArrayList;

public class Character {
    private String name;
    private int row;
    private int column;
    private int health;
    private int maxHealth;
    private ArrayList<String> inventory;
    public Character(String name)
    {
        this.name = name;
        this.row = 0;
        this.column = 0;
        this.maxHealth = 100;
        this.health = maxHealth;
        inventory = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public int getRow() {
        return row;
    }
    public int getColumn(){
        return column;
    }
    public int getHealth() {
        return health;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public void setPosition(int row, int column){
        this.row = row;
        this.column = column;
    }
    public void moveNorth()
    {
        row--;

    }
    public void moveSouth() {
        row++;
    }
    public void moveEast() {
        column ++;
    }
    public void moveWest() {
        column --;
    }
    public void addItem(String item) {
        inventory.add(item);
    }
    public void showInventory() {
        System.out.println("\n==== Inventory ====");
        if (inventory.isEmpty()) {
            System.out.println("Inventory is Empty");

        }
        else {
            for (String item: inventory) {
                System.out.println("- " + item);
            }
        }
    }
}

