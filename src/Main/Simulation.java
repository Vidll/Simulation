package Main;

import Actions.*;
import Creature.DynamicObject;

import java.util.ArrayList;

public class Simulation {
    private static int turns = 0;
    private static Map map;
    public static boolean Play = false;
    private static ArrayList<Action> startActions = new ArrayList<>();
    private static ArrayList<Action> updateActions = new ArrayList<>();
    //private static ArrayList<DynamicObject> dynamicObjects = new ArrayList<>();

    public static void main(String[] args) {
        InitSimulation();
        StartSimulation();
        while(Play){
            UpdateSimulation();
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {}
        }
    }

    private static void StartSimulation(){
        if ((long) startActions.size() <= 0) {
            return;
        }
        for(Action action : startActions){
            action.StartAction();
        }
        PauseSimulation();
    }

    private static void UpdateSimulation(){
        if((long) updateActions.size() <= 0 || !Play){
            return;
        }
        for (Action action : updateActions){
            action.UpdateAction();
        }
        turns++;
    }

    private static void PauseSimulation(){
        Play = !Play;
    }

    public Map GetMap(){ return map;}

    private static void InitSimulation(){
        CreateMap();

        startActions.add(new ActionGenerateMap(map));
        startActions.add(new ActionCreateRockOnMap(map));
        startActions.add(new ActionCreateGrassOnMap(map));
        startActions.add(new ActionCreateHerbivore(map));
        startActions.add(new ActionCreatePredator(map));

        updateActions.add(new ActionRenderMap(map));
        updateActions.add(new ActionManageDynamicObjects(map, map.GetHerbivoresList()));
        updateActions.add(new ActionManageDynamicObjects(map, map.GetPredatorsList()));
    }

    private static void CreateMap(){
        int[] size = {10,20}; //y ,x
        map = new Map();
        map.SetSizeMap(size);
        map.SetCountStaticObjects(5);
        map.SetCountDynamicObjects(2);
    }
}

