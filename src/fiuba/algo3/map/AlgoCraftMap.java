package fiuba.algo3.map;

import fiuba.algo3.exceptions.CannotOccupyTileException;
import fiuba.algo3.exceptions.EmptyTileException;
import fiuba.algo3.exceptions.KeyDoesNotExistsException;
import fiuba.algo3.occupant.Occupant;
import fiuba.algo3.occupant.units.Unit;

import java.util.HashMap;
import java.util.Map;

public class AlgoCraftMap{

	private Map<Coordinates,Tile> tiles;
	private int dimention;
	private int posXPlayer1;
	private int posYPlayer1;
	private int posXPlayer2;
	private int posYPlayer2;

	public AlgoCraftMap(int dim){
		tiles = new HashMap<Coordinates,Tile>();
		dimention = dim;
		generateEarthAndSpace();
		/*placeBases();
		placeMineralAndGas(posXPlayer1, posYPlayer1);
		placeMineralAndGas(posXPlayer2, posYPlayer2);
		*///showMap();
	}

	private void generateEarthAndSpace(){
		Tile earth;
		for(int i = 0; i < dimention; i++){
			for(int j = 0; j < dimention; j++){
				Coordinates coord = new Coordinates(i,j);
				earth = new Earth();
				tiles.put(coord,earth);
			}
		}
		generateFixedMineralAndGas();
	}

	private void generateFixedMineralAndGas() {
		Tile gas = new Gas();
		Tile mineral = new Mineral();
		Coordinates coord1 = new Coordinates(98,98);
		Coordinates coord2 = new Coordinates(99,99);
		this.tiles.put(coord1, gas);
		this.tiles.put(coord2, mineral);
	}

	public void put(Occupant occupant, Coordinates coord) throws CannotOccupyTileException, KeyDoesNotExistsException{
		if (tiles.containsKey(coord)){
			Tile tile = tiles.get(coord);
			tile.put(occupant);
		} else {
			throw new KeyDoesNotExistsException();
		}
	}

	public void locate(Unit unit, Coordinates coord) {
		boolean located = false;
		int coordX = coord.getX();
		int coordY = coord.getY();
		int dim = 1;
		while(!located){
			int i = -dim;
			while(i <= dim && !located){
				int j = -dim;
				while(j <= dim && !located){
					try{
						located = true;
						unit.setPosition(coordX+j,coordY+i,this);
					} catch(KeyDoesNotExistsException | CannotOccupyTileException ex){
						located = false;
					}
					j++;
				}
				i++;
			}
			dim++;
		}
	}

	public void clearTile (Coordinates coord) {
		Tile current = tiles.get(coord);
		current.clear();
	}

	public void move(Coordinates origin, Coordinates destination) throws EmptyTileException, CannotOccupyTileException,
			KeyDoesNotExistsException{
		Occupant current = tiles.get(origin).getOccupant();
		this.put(current, destination);
		this.clearTile(origin);
	}

	public boolean isOccupied(Coordinates coord) {
		return tiles.get(coord).isOccupied();
	}

	public Occupant getOccupant(Coordinates coordinate) throws EmptyTileException {
		try {
			return this.tiles.get(coordinate).getOccupant();
		} catch (EmptyTileException ex) {
			return null;
		}
	}
	/*private void placeBases(){
		Random random = new Random();
		int randomRow = random.nextInt(dimention);
		int randomCol;
		if(randomRow < (dimention / 4) || randomRow >= (dimention * 3 / 4)){
			randomCol = random.nextInt(dimention);
		} else{
			randomCol = random.nextInt(dimention / 2);
			if(randomCol >= (dimention / 4)){
				randomCol += dimention / 2;
			}
		}
		posXPlayer1 = randomCol;
		posYPlayer1 = randomRow;
		posXPlayer2 = dimention - randomCol - 1;
		posYPlayer2 = dimention - randomRow - 1;
	}

	private void placeMineralAndGas(int posX, int posY){
		Random rand = new Random();
		int randColGas = -dimention;
		int randRowGas = -dimention;
		int randColMineral = -dimention;
		int randRowMineral = -dimention;
		while(isNotValid(posX, randColGas, posY, randRowGas)){
			randColGas = rand.nextInt(5) - 2;
			randRowGas = rand.nextInt(5) - 2;
		}
		while(isNotValid(posX, randColMineral, posY, randRowMineral) ||
				isOverGas(randColMineral, randColGas, randRowMineral, randRowGas)){
			randColMineral = rand.nextInt(5) - 2;
			randRowMineral = rand.nextInt(5) - 2;
		}
		Coordinates gasCoord = new Coordinates(posX + randColGas, posY + randRowGas);
		Coordinates mineralCoord = new Coordinates(posX + randColMineral, posY + randRowMineral);
		Tile gas = new Gas();
		Tile mineral = new Mineral();
		tiles.put(gasCoord,gas);
		tiles.put(mineralCoord,mineral);
	}

	private boolean isNotValid(int x, int offsetX, int y, int offsetY){
		return ((x+offsetX < 0) ||
				(x+offsetX >= dimention) ||
				(y+offsetY < 0) ||
				(y+offsetY >= dimention) ||
				(offsetX == 0 && offsetY == 0));
	}

	private boolean isOverGas(int x1, int x2, int y1, int y2){
		return ((x1 == x2) && (y1 == y2));
	}*/

/*	private void showMap(){
		for(int i = 0; i < dimention; i++){
			String line = "";
			for(int j = 0; j < dimention; j++){
				line += writeTile(j,i);
			}
			System.out.println(line);
		}
	}

	private boolean isBase(int col, int row){
		return ((posXPlayer1 == col && posYPlayer1 == row) || (posXPlayer2 == col && posYPlayer2 == row));
	}

	private String writeTile(int col, int row){
		if (isBase(col,row)){
			return "o";
		} else if (tiles[col][row] instanceof Earth){
			return ".";
		} else{
			return "*";
		}
	}
*/
}
