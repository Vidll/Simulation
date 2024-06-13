package Creature;

import Main.MapPlace;
import Main.Position;

public class Node implements Comparable<Node>{
    private MapPlace mapPlace;
    public Node parent;
    public int g; // Cost from start to current node
    public int h; // Heuristic cost to goal

    public Node(MapPlace place, Node parent){
        this.mapPlace = place;
        this.parent = parent;
        this.g = 0;
        this.h = 0;
    }

    public MapPlace GetMapPlace(){ return mapPlace; }

    public Position GetPosition() { return mapPlace.GetPosition(); }

    public Node GetParent() { return parent; }

    public int GetF() { return g + h; }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.GetF(), other.GetF());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Node node = (Node) obj;
        return mapPlace.GetPosition().GetPositionX() == node.GetPosition().GetPositionX() &&
                mapPlace.GetPosition().GetPositionY() == node.GetPosition().GetPositionY();
    }
}
