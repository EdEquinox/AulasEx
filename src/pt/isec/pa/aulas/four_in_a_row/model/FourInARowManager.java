package pt.isec.pa.aulas.four_in_a_row.model;

import pt.isec.pa.aulas.four_in_a_row.model.data.version2.FourInARowData;
import pt.isec.pa.aulas.four_in_a_row.model.data.Piece;
import pt.isec.pa.aulas.four_in_a_row.model.data.memento.CareTaker;

import java.io.*;

public class FourInARowManager {
    private static final String FILE = "files/game.dat";
    FourInARowData data;
    CareTaker car;

    public FourInARowManager() {
        load();
        car = new CareTaker(data);
    }
    public FourInARowManager(FourInARowData data) {
        this.data = data;
    }

    public void init() {
        data.init();
    }

    public Piece getCurrentPlayer() {
        return data.getCurrentPlayer();
    }

    public boolean play(int column) {
        car.save();
        return data.play(column);
    }

    @Override
    public String toString() {
        return data.toString();
    }
    public boolean isFull() {
        return data.isFull();
    }

    public Piece checkWinner() {
        return data.checkWinner();
    }

    public char [][] getBoard() {
        return data.getBoard();
    }

    public int getHeight() {
        return data.getHeight();
    }

    public int getWidth() {
        return data.getWidth();
    }

    public void save() {
        try(FileOutputStream fs = new FileOutputStream(FILE);
            ObjectOutputStream os = new ObjectOutputStream(fs)){
            os.writeObject(data);


        } catch (IOException e) {
            e.printStackTrace();
            ModelLog.getInstance().add("erro a gravar");
        }
    }

    private void load(){
        File file = new File(FILE);
        try(FileInputStream fs = new FileInputStream(file);
            ObjectInputStream ds = new ObjectInputStream(fs);){

            data = (FourInARowData) ds.readObject();

        }catch (Exception e){
            e.printStackTrace();
            ModelLog.getInstance().add("erro a loadar"
                    + "A criar um jogo novo");
            data = new FourInARowData();
        } finally {
            file.delete();
        }
    }

    public void undo() {
        car.undo();
    }

    public void redo() {
        car.redo();
    }
}
