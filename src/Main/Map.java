package Main;

import Creature.DynamicObject;
import Creature.Grass;
import Creature.StaticObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Map {
    private HashMap<Position,MapPlace> map = new HashMap<>();
    private ArrayList<StaticObject> grass = new ArrayList<>();
    private ArrayList<DynamicObject> herbivores = new ArrayList<>();
    private ArrayList<DynamicObject> predators = new ArrayList<>();

    private int[] sizeMap = new int[2];
    private int countStaticObjects;
    private int countDynamicObjects;

    public void SetSizeMap(int[] size){ sizeMap = size;}
    public int[] GetSizeMap(){ return sizeMap;}

    public void SetCountStaticObjects(int val){countStaticObjects = val;}
    public void SetCountDynamicObjects(int val){countDynamicObjects = val;}

    public int GetCountStaticObjects() {return countStaticObjects;}
    public int getCountDynamicObjects() {return countDynamicObjects;}

    public MapPlace GetMapPlace(MapPlace place){ return map.get(place.GetPosition()); }
    public MapPlace GetMapPlace(Position pos){ return map.get(pos); }

    public HashMap<Position,MapPlace> GetFullMap() {return map;}

    public ArrayList<StaticObject> GetGrassList() { return grass;}
    public ArrayList<DynamicObject> GetHerbivoresList() {return herbivores;}
    public ArrayList<DynamicObject> GetPredatorsList() {return predators;}
}
