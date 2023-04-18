package pt.isec.pa.aulas.shoplist.model.command;

public interface ICommand {
    boolean execute();
    boolean undo();
}
