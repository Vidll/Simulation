package Creature;

import Main.Map;
import Main.MapPlace;
import Main.Position;

import java.util.*;

public class AStar {
    private Map map;
    private int[] size = new int[2]; //y,x
    private DynamicObject dynamicObject;

    public AStar(Map map, DynamicObject dynamicObject) {
        this.map = map;
        this.dynamicObject = dynamicObject;
        size = map.GetSizeMap();
    }

    private int heuristic(Node node, Node goal) {
        return Math.abs(node.GetPosition().GetPositionX() - goal.GetPosition().GetPositionX()) +
                Math.abs(node.GetPosition().GetPositionY() - goal.GetPosition().GetPositionY());
    }

    private ArrayList<Node> reconstructPath(Node currentNode) {
        ArrayList<Node> path = new ArrayList<>();
        while (currentNode != null) {
            path.add(currentNode);
            currentNode = currentNode.parent;
        }
        Collections.reverse(path);
        return path;
    }

    private boolean isWalkable(int x,int y, Node goal){
        Position newPos = new Position();
        newPos.SetPosition(x,y);

        if(map.GetFullMap().get(newPos)== null){
            return false;
        }

        boolean answer = newPos.GetPositionX() <= map.GetSizeMap()[1] &&
                newPos.GetPositionX() >= 0 &&
                newPos.GetPositionY() <= map.GetSizeMap()[0] &&
                newPos.GetPositionY() >= 0 &&
                (map.GetFullMap().get(newPos).GetCurrentPlaceType() == MapPlace.PlaceType.NONE ||
                map.GetFullMap().get(newPos).GetCurrentPlaceType() == goal.GetMapPlace().GetCurrentPlaceType());
        return answer;
    }

   public ArrayList<Node> astar(Node start, Node goal){
        Queue<Node> openSet = new PriorityQueue<>(Comparator.comparing(node -> node.h));
        Set<Node> closeSet = new HashSet<>();
        Node currentNode;
        start.g = 0;
        start.h = heuristic(start, goal);
        openSet.add(start);

        while(!openSet.isEmpty()){
            currentNode = openSet.poll();

            if(currentNode.equals(goal)){
                return reconstructPath(currentNode);
            }
            closeSet.add(currentNode);

            int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
            for(int[] dir: direction){
                int newX = currentNode.GetPosition().GetPositionX() + dir[0];
                int newY = currentNode.GetPosition().GetPositionY() + dir[1];

                if(!isWalkable(newX,newY, goal)){
                    continue;
                }

                MapPlace newPlace = map.GetFullMap().get(new Position().SetPositition(newX,newY));
                Node newNode = new Node(newPlace,currentNode);
                if(closeSet.contains(newNode)){
                    continue;
                }
                newNode.g = currentNode.g + 1;
                newNode.h = heuristic(newNode,goal);

                boolean inOpenSet = openSet.stream().anyMatch(n -> n.GetPosition().GetPositionX() == newNode.GetPosition().GetPositionX() &&
                        n.GetPosition().GetPositionY() == newNode.GetPosition().GetPositionY() &&
                        n.g == newNode.g);
                if(!inOpenSet){
                    openSet.add(newNode);
                }
            }
        }
        return null;
   }
}

