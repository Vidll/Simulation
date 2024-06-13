package Actions;

import Main.Map;

public class Action {
    Map map;

    public Action(Map map){
        this.map = map;
    }

    public Action StartAction(){
        return this;
    }

    public Action UpdateAction(){
        return this;
    }

}
