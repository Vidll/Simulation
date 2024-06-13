package Actions;

import Creature.Rock;
import Main.Map;

public class ActionCreateRockOnMap extends Action{

    public ActionCreateRockOnMap(Map map) {
        super(map);
    }

    @Override
    public Action StartAction() {
        GenerateStaticObjects();
        return super.StartAction();
    }

    private void GenerateStaticObjects(){
        ActionGenerateStaticObjects generator = new ActionGenerateStaticObjects(map);
        for(int i = 0; i < map.GetCountStaticObjects(); i++ ){
            generator.Generate(new Rock());
        }
    }
}
