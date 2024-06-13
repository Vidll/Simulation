package Creature;
import Main.MapPlace;

public class StaticObject extends MapPlace {
    protected int HP;

    public StaticObject(){
        _makeMove = false;

    }
    public void GetDamage(int damage){
        HP -= damage;
        if(HP <= 0){
            Destroy();
        }
    }



}
