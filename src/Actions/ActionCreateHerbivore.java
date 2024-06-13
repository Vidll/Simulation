package Actions;

import Creature.Herbivore;
import Main.Map;
import Main.Simulation;

public class ActionCreateHerbivore extends Action{
    public ActionCreateHerbivore(Map map) {
        super(map);
    }

    @Override
    public Action StartAction() {
        Create();
        return super.StartAction();
    }

    private void Create(){
        ActionGenerateDynamicObjects generator = new ActionGenerateDynamicObjects(map);
        for(int i = 0; i < map.getCountDynamicObjects(); i++){
            Herbivore herbivore = new Herbivore(1,2,10, map);
            map.GetHerbivoresList().add(herbivore);
            generator.Generate(herbivore);
        }
    }
}
