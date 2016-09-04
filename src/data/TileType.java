package data;

/**
 * Created by Liam on 2016-09-03.
 */
public enum TileType {

    Grass("grass", true), Dirt("dirt", false);

    String textureName;
    boolean buildable;

    TileType(String textureName, boolean buildable) {
        this.textureName = textureName;
        this.buildable = buildable;

    }
}
