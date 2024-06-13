package Actions;

import Creature.DynamicObject;
import Main.Map;
import Main.MapPlace;

public class ActionGenerateDynamicObjects extends Action {

    public ActionGenerateDynamicObjects(Map map) {
        super(map);
    }

    public DynamicObject Generate(DynamicObject obj){
        boolean findPlace = true;
        while(findPlace) {
            int x = (int) (Math.random() * (map.GetSizeMap()[1]));
            int y = (int) (Math.random() * (map.GetSizeMap()[0]));
            obj.GetPosition().SetPosition(x, y);
            MapPlace pl = map.GetMapPlace(obj);
            if (pl.GetCurrentPlaceType() != MapPlace.PlaceType.NONE) {
                continue;
            }
            map.GetFullMap().replace(obj.GetPosition(), obj);
            findPlace = false;
        }
        return obj;
    }
}
