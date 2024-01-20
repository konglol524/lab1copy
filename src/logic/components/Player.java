package logic.components;

import exception.BadStatusException;

import java.util.ArrayList;

public class Player {
    private String name;
    private Status status;
    private int energy;
    private int money;

    private ArrayList<Food> foods;
    private ArrayList<Potion> potions;
    private ArrayList<Ore> ores;

    public Player(String name, Status status){
        this(name, status, 10, 100);
    }

    public Player(String name, Status status, int energy, int money){
        try{
            this.setName(name);
            this.setStatus(status);
            this.getStatus().setHp(Math.max(1, this.getStatus().getHp()));
            this.setEnergy(energy);
            this.setMoney(money);
            this.setFoods(new ArrayList<Food>());
            this.setPotions(new ArrayList<Potion>());
            this.setOres(new ArrayList<Ore>());
        } catch (BadStatusException e){
            System.out.println("Bad status player!");
        }
    }

    public boolean buyOre(Ore ore){
        if(this.getMoney() >= ore.getCost()){
            this.setMoney(this.getMoney() - ore.getCost());
            this.getOres().add(ore);
            return true;
        } else {
            return false;
        }
    }

    public void drinkPotion(int index){
        try {
            this.getStatus().addStatus(this.getPotions().get(index).getIncreasingStatus());
            this.getPotions().remove(index);
        } catch (IndexOutOfBoundsException e){
            return;
        } catch (BadStatusException d){
            System.out.println("Bad status player potion!");
        }
    }

    public void eatFood(int index){
        try {
            this.setEnergy(this.getEnergy() + this.getFoods().get(index).getEnergy());
            this.getFoods().remove(index);
        } catch (IndexOutOfBoundsException e){
            return;
        }
    }

    public void sellPotion(int index){
        try {
            this.setMoney(this.getMoney() + this.getPotions().get(index).getPrice());
            this.getPotions().remove(index);
        } catch (IndexOutOfBoundsException e){
            return;
        }
    }

    public void sellFood (int index){
        try {
            this.setMoney(this.getMoney() + this.getFoods().get(index).getPrice());
            this.getFoods().remove(index);
        } catch (IndexOutOfBoundsException e){
            return;
        }
    }

    public void attack(Monster monster){
        try {
            int damage = this.getStatus().getAttack() - monster.getStatus().getDurability();
            damage = Math.max(damage, 0);
            monster.getStatus().setHp( Math.max(monster.getStatus().getHp() - damage,0));
        } catch (BadStatusException e){
            System.out.println("Bad Status!");
        }
    }

    public void magicAttack(Monster monster){
        try {
            monster.getStatus().setHp( Math.max(monster.getStatus().getHp() - this.getStatus().getMagic(),0));
        } catch (BadStatusException e){
            System.out.println("Bad Status!");
        }
    }

    public Status getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public int getEnergy() {
        return energy;
    }

    public ArrayList<Ore> getOres() {
        return ores;
    }

    public int getMoney() {
        return money;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public void setEnergy(int energy) {
        this.energy = Math.max(0, energy);
    }

    public void setMoney(int money) {
        this.money = Math.max(0, money);
    }

    public void setOres(ArrayList<Ore> ores) {
        this.ores = ores;
    }
}
