package fiuba.algo3.buildings;

import fiuba.algo3.player.Player;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mporto on 31/05/15.
 */
public class PylonTest {

    @Test
    public void testNewPylonRaisesPlayerAvailablePopulation() throws Exception {
        Player aPlayer = new Player();
        int startingAvailablePopulation = aPlayer.getAvailablePopulation();
        Pylon aPylon = new Pylon(aPlayer);

        assertEquals(startingAvailablePopulation + 5, aPlayer.getAvailablePopulation());
    }
}