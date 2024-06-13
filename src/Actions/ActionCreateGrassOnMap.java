package Actions;

import Creature.Grass;
import Main.Map;

public class ActionCreateGrassOnMap extends Action{

    public ActionCreateGrassOnMap(Map map) {
        super(map);
    }

    @Override
    public Action StartAction() {
        GenerateStaticobjects();
        return super.StartAction();
    }

    private void GenerateStaticobjects(){
        ActionGenerateStaticObjects generator = new ActionGenerateStaticObjects(map);
        for(int i = 0; i < map.GetCountStaticObjects(); i++ ){
            Grass newGrass = new Grass();
            generator.Generate(newGrass);
            map.GetGrassList().add(newGrass);
        }
    }

}
