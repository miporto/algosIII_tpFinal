package fiuba.algo3.view;

import fiuba.algo3.game.AlgoCraftModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.InvocationTargetException;

public class AlgoCraftView extends JFrame{

	private SideMenu sideMenu;
	private MapView mapView;

	public AlgoCraftView(AlgoCraftModel algoCraftModel)
			throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);
		sideMenu = new SideMenu(0, 0, (int) (getWidth() * 0.2), getHeight());
		mapView = new MapView((int) (getWidth() * 0.2), 0, (int) (getWidth() * 0.8), getHeight(), algoCraftModel.getAlgoCraftMap(), sideMenu.getActionButtons());
		getContentPane().add(sideMenu);
		getContentPane().add(mapView);
	}
}