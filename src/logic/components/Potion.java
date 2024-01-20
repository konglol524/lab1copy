package logic.components;

public class Potion {
    private String name;
    private int price;
    private Status increasingStatus;

    public Potion(String name, int price, Status increasingStatus){
        this.setIncreasingStatus(increasingStatus);
        this.setPrice(price);
        this.setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = Math.max(price, 1);
    }

    public void setIncreasingStatus(Status increasingStatus) {
        this.increasingStatus = increasingStatus;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Status getIncreasingStatus() {
        return increasingStatus;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Potion){
            Potion o2 = (Potion) o;
            boolean samePrice = this.getPrice() == o2.getPrice();
            boolean sameName = this.getName() == o2.getName();
            boolean sameStatus = this.getIncreasingStatus().equals(o2.getIncreasingStatus());
            return (sameName && sameStatus && samePrice);
        } else {
            return false;
        }
    }
}
