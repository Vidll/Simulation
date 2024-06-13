package Creature;
import Main.Map;
import Main.MapPlace;
import Main.Position;

import java.util.ArrayList;

public class DynamicObject extends MapPlace {
    private Map map;
    protected int MoveSpeed;
    protected int HP;
    protected int Damage;
    protected AStar aStar;

    protected MapPlace TargetObject;

    public DynamicObject (int speed, int hp, int damage, Map map){
        _makeMove = true;
        MoveSpeed = speed;
        HP = hp;
        Damage = damage;
        this.map = map;
        aStar = new AStar(map,this);
    }

    protected Map GetMap(){return map;}

    public void SetDamage(){}

    public void GetDamage(int value){}

    public void MakeMove(){}

    public void FindTargetObject(){}

    protected void Move(Position newPos){
        if(isWalkable(newPos)) {
            map.GetFullMap().remove(GetPosition());
            map.GetFullMap().remove(newPos);

            MapPlace oldPlace = new MapPlace();
            oldPlace.GetPosition().SetPosition(GetPosition().GetPositionX(), GetPosition().GetPositionY());
            GetPosition().SetPosition(newPos.GetPositionX(), newPos.GetPositionY());

            map.GetFullMap().put(GetPosition(), this);
            map.GetFullMap().put(oldPlace.GetPosition(), oldPlace);
        } else if(GetMap().GetFullMap().get(newPos).GetCurrentPlaceType() == TargetObject.GetCurrentPlaceType()){
            SetDamage();
        }
    }

    protected boolean isWalkable(Position newPos){
        return newPos.GetPositionX() <= GetMap().GetSizeMap()[1] &&
                newPos.GetPositionX() >= 0 &&
                newPos.GetPositionY() <= GetMap().GetSizeMap()[0] &&
                newPos.GetPositionY() >= 0 &&
                GetMap().GetFullMap().get(newPos).GetCurrentPlaceType() == PlaceType.NONE;
    }



    protected boolean isWalkable(int x, int y){
        Position newPos = new Position();
        newPos.SetPosition(x,y);

        if(GetMap().GetFullMap().get(newPos)== null){
            return false;
        }

        return newPos.GetPositionX() <= GetMap().GetSizeMap()[1] &&
                newPos.GetPositionX() >= 0 &&
                newPos.GetPositionY() <= GetMap().GetSizeMap()[0] &&
                newPos.GetPositionY() >= 0 &&
                GetMap().GetFullMap().get(newPos).GetCurrentPlaceType() == PlaceType.NONE;
    }

    protected MapPlace FindNearestPlace(ArrayList<MapPlace> places){
        if(places == null || places.isEmpty()){
            return null;
        }

        MapPlace obj = new MapPlace();
        double minDistance = Double.MAX_VALUE;

        for(MapPlace place : places){
            double distance = calculateDistance(this, place);
            if(distance < minDistance){
                minDistance = distance;
                obj = place;
            }
        }
        return obj;
    }

    protected ArrayList<MapPlace> GetListMapPlaceFromStaticObjectList(ArrayList<StaticObject> objects){
        return new ArrayList<>(objects);
    }

    protected ArrayList<MapPlace> GetListMapPlaceFromDynamicObjectList(ArrayList<DynamicObject> objects){
        return new ArrayList<>(objects);
    }

    private double calculateDistance(MapPlace a, MapPlace b){
        int dx = a.GetPosition().GetPositionX() - b.GetPosition().GetPositionX();
        int dy = a.GetPosition().GetPositionY() - b.GetPosition().GetPositionY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}