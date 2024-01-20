package logic.components;

import exception.BadStatusException;

public class Status {
    private int hp;
    private int durability;
    private int attack;
    private int magic;
    public Status(int hp, int durability, int attack, int magic) throws BadStatusException{
        this.setAttack(attack);
        this.setDurability(durability);
        this.setHp(hp);
        this.setMagic(magic);
    }

    public void setAttack(int attack) throws BadStatusException  {
        if(attack < 0){
            throw new BadStatusException();
        } else {
            this.attack = attack;
        }
    }

    public void setDurability(int durability) throws BadStatusException{
        if(durability < 0){
            throw new BadStatusException();
        } else {
            this.durability = durability;
        }
    }

    public void setHp(int hp) throws BadStatusException {
        if(hp < 0){
            throw new BadStatusException();
        } else {
            this.hp= hp;
        }
    }

    public void setMagic(int magic) throws BadStatusException {
        if(magic < 0){
            throw new BadStatusException();
        } else {
            this.magic = magic;
        }
    }

    public int getAttack() {
        return attack;
    }


    public int getDurability() {
        return durability;
    }

    public int getHp() {
        return hp;
    }

    public int getMagic() {
        return magic;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Status){
            Status o2 = (Status) o;
            boolean sameHp = this.getHp() == o2.getHp();
            boolean sameAtk = this.getAttack() == o2.getAttack();
            boolean sameDur = this.getDurability() == o2.getDurability();
            boolean sameMag = this.getMagic() == o2.getMagic();
            return (sameHp && sameAtk && sameDur && sameMag);
        } else {
            return false;
        }
    }

    public void addStatus(Status another) throws BadStatusException{
        setMagic(this.getMagic() + another.getMagic());
        setHp(this.getHp() + another.getHp());
        setAttack(this.getAttack()+ another.getAttack());
        setDurability(this.getDurability()+ another.getDurability());
    }
}
