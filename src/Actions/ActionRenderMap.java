package Actions;

import Main.Map;
import Main.MapPlace;
import Main.Position;


public class ActionRenderMap extends Action{

    public ActionRenderMap(Map map) {
        super(map);
    }

    @Override
    public Action StartAction() {
        return super.StartAction();
    }

    @Override
    public Action UpdateAction() {
        RenderMap();
        return super.UpdateAction();
    }

    private void RenderMap(){
        for(int y = 0; y < map.GetSizeMap()[0]; y++){
            for(int x = 0; x < map.GetSizeMap()[1]; x++){
                Position newPos = new MapPlace().GetPosition();
                newPos.SetPosition(x,y);
                MapPlace place = map.GetMapPlace(newPos);
                System.out.print(place.GetMapSymbol());
            }
            System.out.println();
        }
        System.out.println("============================================================================================");
    }
}
