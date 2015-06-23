package fiuba.algo3.occupant.buildings;

import fiuba.algo3.map.AlgoCraftMap;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.player.Player;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nsueiro on 01/06/15.
 */
public class TerranFactoryTest {
    private TerranFactory f;
    @Before
    public void setUp() {
        f = new TerranFactory(new Player((new AlgoCraftMap(1)).testMap()), new Coordinates(0, 0));
    }

    @Test
    public void testGetConstructionTime() {
        Assert.assertEquals(12, f.getConstructionTime());
    }

    @Test
    public void testGetVitality() {
        Assert.assertEquals(1250, f.getVitality());
    }

    @Test
    public void testGetShield() {
        Assert.assertEquals(0, f.getShield());
    }

    @Test
    public void testGetGasCost() {
        Assert.assertEquals(100, f.getConstructionCost().getGasCost());
    }

    @Test
    public void testGetMineralCost() {
        Assert.assertEquals(200, f.getConstructionCost().getMineralCost());
    }
}