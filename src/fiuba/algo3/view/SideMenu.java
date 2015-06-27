package fiuba.algo3.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import fiuba.algo3.game.AlgoCraftModel;

public class SideMenu extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<ActionButton> actionButtons;
	List<PlayerData> playerData;
	PassTurnButton passTurnButton;

	public SideMenu(int x, int y, int width, int height, AlgoCraftModel algoCraftModel) {
		setBounds(x, y, width, height);
		setAlignmentY(Component.TOP_ALIGNMENT);
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setLayout(new GridLayout(20, 2));
		actionButtons = new ArrayList<ActionButton>();
		playerData = new ArrayList<PlayerData>();
		createLabels(algoCraftModel);
		createButtons(algoCraftModel);
		addButtonsAndLabels();
	}

	private void createButtons(AlgoCraftModel algoCraftModel){
		ActionButton moveButton = new MoveButton(algoCraftModel);
		ActionButton attackButton = new AttackButton(algoCraftModel);
		ActionButton buildButton = new BuildButton(algoCraftModel, playerData);
		ActionButton createUnitButton = new CreateUnitButton(algoCraftModel, playerData);
		passTurnButton = new PassTurnButton(algoCraftModel, playerData);
		actionButtons.add(moveButton);
		actionButtons.add(attackButton);
		actionButtons.add(buildButton);
		actionButtons.add(createUnitButton);
	}

	private void createLabels(AlgoCraftModel algoCraftModel){
		PlayerData actualPlayerName = new PlayerName(algoCraftModel);
		PlayerData actualPlayerGas = new PlayerGas(algoCraftModel);
		PlayerData actualPlayerMineral = new PlayerMineral(algoCraftModel);
		playerData.add(actualPlayerName);
		playerData.add(actualPlayerGas);
		playerData.add(actualPlayerMineral);
	}

	private void addButtonsAndLabels(){
		for(ActionButton button : actionButtons){
			add(button);
		}
		for(PlayerData label : playerData){
			add(label);
		}
		add(passTurnButton);
	}

	public void setMap(MapView map){
		for(ActionButton actionButton : actionButtons){
            actionButton.setMap(map);
        }
        passTurnButton.setMap(map);
	}

	public List<ActionButton> getActionButtons(){
		return actionButtons;
	}

	public List<PlayerData> getPlayerData(){
		return playerData;
	}

}