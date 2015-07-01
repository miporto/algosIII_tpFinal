package fiuba.algo3.model.occupant.buildings;

import fiuba.algo3.model.exceptions.InsufficientAvailablePopulationException;
import fiuba.algo3.model.exceptions.InsufficientResourcesException;
import fiuba.algo3.model.exceptions.SubtractedResourcesGreaterThanStoragedException;
import fiuba.algo3.model.gameVariables.Cost;
import fiuba.algo3.model.gameVariables.Life;
import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.occupant.units.TerranTransportVessel;
import fiuba.algo3.model.occupant.units.UnitInTraining;
import fiuba.algo3.model.player.Player;

/**
 * Created by nsueiro on 01/06/15.
 */
public class StarPort extends UnitCreator {
    

    public StarPort(Player player, Coordinates coordinate){
        super(player, coordinate);
        this.requiredBuildings.add(TerranFactory.class);
        this.constructionCost = new Cost(150, 100);
        this.life = new Life(1300, 0);
        this.constructionTime = 10;
		this.info = "Tierra: en estos paramos se pueden construir todo tipo de edificios,\nexceptuando los de recoleccion de recursos, \ntodas las unidades pueden caminar sobre ellos.";
    }

    @Override
    public void trainUnit() throws InsufficientAvailablePopulationException, InsufficientResourcesException,
            SubtractedResourcesGreaterThanStoragedException {
        TerranTransportVessel aTerranTransportVessel = new TerranTransportVessel();
        this.chargeUnitRequirementsToOwner(aTerranTransportVessel);
        UnitInTraining aMarineInTraining = new UnitInTraining(aTerranTransportVessel);
        this.trainingQueue.add(aMarineInTraining);
    }
}
