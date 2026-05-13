package Project;

import java.util.ArrayList;

public class Character {
    private String name;
    private int row;
    private int column;
    private int health;
    private int maxHealth;
    private int damage;
    private ArrayList<String> inventory;
    public Character(String name)
    {
        this.name = name;
        this.row = 0;
        this.column = 0;
        this.maxHealth = 100;
        this.health = maxHealth;
        this.damage = 10;
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
    public boolean isAlive() {
        return health > 0;
    }
    public void increaseDamage(int amount) {
        this.damage += amount;
    }
    public void levelUp(Enemy enemy)
    {
        if (!enemy.isAlive()) {
            increaseDamage(5);
            System.out.println("You have successfully leveled up.\nYour damage has increased by 5");
        }
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
    public void takeDamage(int damage)
    {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
     }
}

