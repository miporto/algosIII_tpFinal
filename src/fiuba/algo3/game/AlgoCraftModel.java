package fiuba.algo3.game;

import fiuba.algo3.exceptions.*;
import fiuba.algo3.map.AlgoCraftMap;
import fiuba.algo3.occupant.buildings.Building;
import fiuba.algo3.player.Player;

/**
 * Created by montag on 6/17/15.
 */
public class AlgoCraftModel implements TurnAware{

    private Player player1, player2;
    private AlgoCraftMap algoCraftMap;
    private Player activePlayer, inactivePlayer;

    public AlgoCraftModel(){
        algoCraftMap = new AlgoCraftMap(5);
        player1 = new Player(algoCraftMap);
        player2 = new Player(algoCraftMap);
        activePlayer = player1;
        inactivePlayer = player2;
    }

    @Override
    public void passTurn() {
        activePlayer.passTurn();
    }

    public void build(Building building) throws InsufficientResourcesException, CannotOccupyTileException, MissingRequiredBuildingsException, DestinationIsOccupiedException, KeyDoesNotExistsException {
        activePlayer.build(building);
    }

    public void endTurn(){
        Player playerAux = activePlayer;
        activePlayer = inactivePlayer;
        activePlayer.passTurn();
        inactivePlayer = playerAux;
    }

    public Player getActivePlayer(){
        return activePlayer;
    }

    public AlgoCraftMap getAlgoCraftMap() {
        return this.algoCraftMap;
    }
}