package Project;
import java.util.Random;

public class Enemy
{
    private String name;
    private int health;
    private int damage;
    public Enemy(String name, int health) {
        Random r1 = new Random();
        this.name = name;
        this.health = health;
        this.damage = r1.nextInt(10, 20);
    }
    //getters
    public String getName()
    {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getDamage() {
        return damage;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public boolean isAlive() {
        return health > 0;
    }
    public void takeDamage(int damage)
    {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }
    public String toString() {
        return "\n" + name + "\nHP: " + health;
    }


}
