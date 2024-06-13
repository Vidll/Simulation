package Creature;

public abstract class Entity {

    protected char _mapSymbol = '.';
    protected void Destroy(){}

    public char GetMapSymbol() { return _mapSymbol; }
    public void SetMapSymbol(char c) { _mapSymbol = c;}
}