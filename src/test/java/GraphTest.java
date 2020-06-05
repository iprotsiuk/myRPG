import myrpg.effects.IEffect;
import myrpg.items.IItem;
import myrpg.items.gear.armor.ArmorMaterial;
import myrpg.items.gear.armor.body.Body;
import myrpg.items.gear.armor.feet.Boots;
import myrpg.items.gear.armor.head.Helm;
import myrpg.items.gear.weapon.onehanded.Dagger;
import myrpg.items.gear.weapon.onehanded.Sword;
import myrpg.items.gear.weapon.onehanded.Wand;
import myrpg.map.Graph;
import myrpg.map.Map;
import myrpg.units.inventory.IInventory;
import myrpg.units.inventory.Inventory;
import myrpg.units.inventory.InventorySorter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class GraphTest {
    int mapHeight;
    int mapWidth;

    Map map;

    public GraphTest() {
        mapHeight = 10;
        mapWidth = 10;

        map = new Map(mapWidth, mapHeight);

    }

    @Test
    public void buildGraph_hasValidCostsWithNeighbours_nearFirstCell() {
        Graph graph = map.buildGraph();

        Graph.Node start = graph.getFirstNode();
        List<Graph.NodeRelation> relations = start.getNeighbours();

        Assert.assertEquals(2, relations.stream().filter(p -> p.getCost() == 1).count());
        Assert.assertEquals(1, relations.stream().filter(p -> p.getCost() == Math.sqrt(2)).count());
    }

    @Test
    public void buildGraph_hasValidCount_nearFirstCell() {
        Graph graph = map.buildGraph();

        Graph.Node start = graph.getFirstNode();
        List<Graph.NodeRelation> relations = start.getNeighbours();

        Assert.assertEquals(3, relations.size());
    }

    @Test
    public void buildGraph_hasValidNeighbours_nearFirstCell() {
        Graph graph = map.buildGraph();

        Graph.Node start = graph.getFirstNode();
        List<Graph.NodeRelation> relations = start.getNeighbours();

        Assert.assertTrue(relations.stream().filter(nodeRelation -> nodeRelation.getIndex() == 1).count() == 1);
        Assert.assertTrue(relations.stream().filter(p -> p.getIndex() == 10).count() == 1);
        Assert.assertTrue(relations.stream().filter(p -> p.getIndex() == 11).count() == 1);
    }

//    @Test
//    public void buildGraph_hasValidNeighbours_near12Cell() {
//        Graph graph = map.buildGraph();
//
//        Graph.Node start = graph.getFirstNode();
//        List<Graph.NodeRelation> relations = start.getNeighbours();
//
//        Assert.assertTrue(relations.stream().filter(p -> p.getIndex() == 1).count() == 1);
//        Assert.assertTrue(relations.stream().filter(p -> p.getIndex() == 10).count() == 1);
//        Assert.assertTrue(relations.stream().filter(p -> p.getIndex() == 11).count() == 1);
//    }
}
