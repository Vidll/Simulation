package Main;

import java.util.Objects;

public class Position{

    public Position(){
        x = 0;
        y = 0;
    }

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    private int x;
    private int y;

    public int GetPositionX() {return x;}
    public int GetPositionY() {return y;}

    public void SetPositionX(int x) { this.x = x;}
    public void SetPositionY(int y) {this.y = y;}

    public void SetPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Position SetPositition(int x, int y){
        this.x = x;
        this.y = y;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass()!= obj.getClass())
            return false;
        Position position = (Position) obj;
        return x == position.x && y == position.y;
    }
}