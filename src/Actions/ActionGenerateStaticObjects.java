package Actions;

import Main.Map;
import Main.MapPlace;

public class ActionGenerateStaticObjects extends Action {

    public ActionGenerateStaticObjects(Map map) {
        super(map);
    }

    public void Generate(MapPlace obj){
        boolean act = true;
        while(act){
            int x = (int) (Math.random() * (map.GetSizeMap()[1]));
            int y = (int) (Math.random() * (map.GetSizeMap()[0]));
            obj.GetPosition().SetPosition(x,y);
            MapPlace pl = map.GetMapPlace(obj);
            if(pl.GetCurrentPlaceType() != MapPlace.PlaceType.NONE){
                continue;
            }
            map.GetFullMap().replace(obj.GetPosition(),obj);
            act = false;
        }
    }
}
