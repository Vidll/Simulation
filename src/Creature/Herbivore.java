package Creature;

import Main.Map;
import java.util.ArrayList;

public class Herbivore extends DynamicObject{
    protected ArrayList<Node> path = new ArrayList<>();

    public Herbivore(int speed, int hp, int damage, Map map) {
        super(speed, hp, damage, map);
        _mapSymbol = 'H';
        _currentPlaceType = PlaceType.Herbivore;
    }

    @Override
    public void MakeMove() {
        super.MakeMove();
        if(HP <= 0)
            return;

        if(TargetObject == null){
            TargetObject = FindNearestPlace(GetListMapPlaceFromStaticObjectList(GetMap().GetGrassList()));
        }
        if(TargetObject != null && path.isEmpty()){
            path = aStar.astar(new Node(this,null),new Node(TargetObject,null));
            path.remove(0);
        }
        if(path.isEmpty())
            return;

        Move(path.get(0).GetPosition());
        path.remove(0);

        if(TargetObject.GetCurrentPlaceType() == PlaceType.NONE){
            GetMap().GetGrassList().remove(TargetObject);
            TargetObject = null;
            path.clear();
        }
    }

    @Override
    public void SetDamage() {
        for(StaticObject target: GetMap().GetGrassList()){
            if(target.GetPosition().equals(TargetObject.GetPosition())){
                target.GetDamage(Damage);
            }
        }
        super.SetDamage();
    }

    @Override
    public void GetDamage(int value) {
        super.GetDamage(value);
        HP -= value;
        if (HP <= 0){
            Destroy();
            path.clear();
            TargetObject = null;
        }
    }

    @Override
    public void FindTargetObject() {
        super.FindTargetObject();
    }
}
