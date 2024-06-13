package Actions;

import Main.Map;
import Main.MapPlace;

public class ActionGenerateMap extends Action{


    public ActionGenerateMap(Map map) {
        super(map);
    }

    @Override
    public Action StartAction() {
        GenerateEmptyMap();
        return super.StartAction();
    }

    private void GenerateEmptyMap(){
        for(int y = 0; y < map.GetSizeMap()[0]; y++){
            for(int x = 0; x < map.GetSizeMap()[1]; x++){
                MapPlace place = new MapPlace();
                place.GetPosition().SetPosition(x,y);
                map.GetFullMap().put(place.GetPosition(),place);
            }
        }
    }
}
