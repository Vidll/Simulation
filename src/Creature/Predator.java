package Creature;
import Main.Map;

import java.util.ArrayList;

public class Predator extends DynamicObject {
    protected ArrayList<Node> path = new ArrayList<>();

    public Predator(int speed, int hp, int damage,Map map) {
        super(speed, hp, damage, map);
        _mapSymbol = 'P';
        _currentPlaceType = PlaceType.Predator;
    }

    @Override
    public void MakeMove() {
        super.MakeMove();
        if(TargetObject == null){
            TargetObject = FindNearestPlace(GetListMapPlaceFromDynamicObjectList(GetMap().GetHerbivoresList()));
        }
        if(TargetObject != null && path.isEmpty()){
            path = aStar.astar(new Node(this,null),new Node(TargetObject,null));
            path.remove(0);
        }
        if (path.isEmpty())
            return;

        Move(path.get(0).GetPosition());
        path.clear();

        if(TargetObject.GetCurrentPlaceType() == PlaceType.NONE){
            GetMap().GetHerbivoresList().remove(TargetObject);
            TargetObject = null;
        }
    }

    @Override
    public void SetDamage() {
        super.SetDamage();
        for(DynamicObject target: GetMap().GetHerbivoresList()){
            if (target.GetPosition().equals(TargetObject.GetPosition())){
                target.GetDamage(Damage);
            }
        }
    }

    @Override
    public void FindTargetObject() {
        super.FindTargetObject();
    }
}