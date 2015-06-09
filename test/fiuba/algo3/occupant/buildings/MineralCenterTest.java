package fiuba.algo3.occupant.buildings;

import fiuba.algo3.occupant.buildings.MineralCenter;
import fiuba.algo3.player.Player;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nsueiro on 01/06/15.
 */
public class MineralCenterTest {
    private MineralCenter mc;
    private Player p;
    @Before
    public void setUp(){
        this.p = new Player();
        this.mc = new MineralCenter(p);
    }

    @Test
    public void testGetVitality() {
        Assert.assertEquals(500, mc.getVitality());
    }

    @Test
    public void testGetShield() {
        Assert.assertEquals(0, mc.getShield());
    }

    @Test
    public void testMineralNexusAddsMineralsToOwnersStorage() {
        mc.addToPlayerStorage();
        Assert.assertEquals(210, p.getMineralStorage());
    }

}