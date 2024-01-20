package logic.components;

import exception.BadStatusException;

public class Monster {
    private String name;
    private Status status;
    private Food food;
    private Potion potion;

    public Monster(String name, Status status){
        try {
             setName(name);
             setStatus(status);
             setFood(null);
             setPotion(null);
             this.getStatus().setHp( Math.max(1, this.getStatus().getHp()));
        } catch (BadStatusException e){
            System.out.println("Bad Status!");
        }
    }

    public void attack(Player player){
        try {
            int damage = this.getStatus().getAttack() - player.getStatus().getDurability();
            damage = Math.max(damage, 0);
            player.getStatus().setHp( Math.max(player.getStatus().getHp() - damage,0));
        } catch (BadStatusException e){
            System.out.println("Bad Status!");
        }
    }

    public void magicAttack(Player player){
        try {
            player.getStatus().setHp( Math.max(player.getStatus().getHp() - this.getStatus().getMagic(),0));
        } catch (BadStatusException e){
            System.out.println("Bad Status!");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public Food getFood() {
        return food;
    }

    public Potion getPotion() {
        return potion;
    }

    public Status getStatus() {
        return status;
    }
}
