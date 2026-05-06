package Project;

public class Location {
    private String name;
    private String description;
    private String item;
    private boolean itemTaken;
    public Location(String name, String description)
    {
        this.name = name;
        this.description = description;
        this.item = null;
    }
    public Location(String name, String description, String item) {
        this.name = name;
        this.description = description;
        this.item = item;
    }
    //getters
    public String getName()
    {
        return name;
    }
    public String getDescription()
    {
        return description;
    }
    public String getItem()
    {
        return item;
    }
    public boolean getItemTaken()
    {
     return itemTaken;
    }
    //setters
    public void setName(String name)
    {
        this.name = name;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public void setItem(String item)
    {
        this.item = item;
        this.itemTaken = false;
    }
    public String takeItem() {
        if (item !=null && ! itemTaken)
        {
            itemTaken = true;
            return item;
        }
        return null;
    }




}
