package Actions;

import Creature.Predator;
import Main.Map;
import Main.Simulation;

public class ActionCreatePredator extends Action{
    public ActionCreatePredator(Map map) {
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
            Predator predator = new Predator(1,2,5, map);
            map.GetPredatorsList().add(predator);
            generator.Generate(predator);
        }
    }
}
