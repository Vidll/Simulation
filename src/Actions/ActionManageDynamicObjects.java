package Actions;

import Creature.DynamicObject;
import Main.Map;

import java.util.ArrayList;

public class ActionManageDynamicObjects extends Action{

    private ArrayList<DynamicObject> dynamicObjects = new ArrayList<>();

    public ActionManageDynamicObjects(Map map) {
        super(map);
    }

    public ActionManageDynamicObjects(Map map, ArrayList<DynamicObject> objects) {
        super(map);
        dynamicObjects = objects;
    }

    @Override
    public Action UpdateAction() {
        System.out.println("Update DynamicObjects:" + dynamicObjects);
        if(dynamicObjects.isEmpty())
            return super.UpdateAction();

        for(DynamicObject obj: dynamicObjects){
            obj.MakeMove();
        }
        return super.UpdateAction();
    }
}
