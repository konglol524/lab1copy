package logic.components;

public class Food {
    private String name;
    private int price;
    //must be positive
    private int energy;
    //must be positive
    public Food(String name, int price, int energy){
        setEnergy(energy);
        setName(name);
        setPrice(price);
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Food){
            Food o2 = (Food) o;
            boolean samePrice = this.getPrice() == o2.getPrice();
            boolean sameEnergy = this.getEnergy() == o2.getEnergy();
            boolean sameName = this.getName().equals(o2.getName());
            return (samePrice && sameEnergy && sameName);
        } else {
            return false;
        }
    }

    //Getter
    public int getPrice() {
        return price;
    }

    public int getEnergy() {
        return energy;
    }

    public String getName() {
        return name;
    }
    //Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = Math.max(price, 1);
    }

    public void setEnergy(int energy) {
        this.energy = Math.max(energy, 1);
    }
}
