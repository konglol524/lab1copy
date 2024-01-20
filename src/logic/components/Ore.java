package logic.components;

public class Ore {
    private String name;
    private int cost;
    public Ore(String name, int cost){
        this.setCost(cost);
        this.setName(name);
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Ore){
            Ore o2 = (Ore) o;
            boolean sameName = this.getName().equals(o2.getName());
            boolean sameCost = this.getCost() == o2.getCost();
            return (sameCost && sameName);
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = Math.max(cost, 1);;
    }
}
