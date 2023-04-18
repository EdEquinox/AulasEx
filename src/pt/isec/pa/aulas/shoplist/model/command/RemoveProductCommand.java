package pt.isec.pa.aulas.shoplist.model.command;

import pt.isec.pa.aulas.shoplist.model.data.ShoppingList;

public class RemoveProductCommand extends CommandAdapter {
    private String name;
    private double qnt;
    public RemoveProductCommand(ShoppingList receiver, String name, double qnt) {
        super(receiver);
        this.qnt = qnt;
        this.name = name;
    }
    @Override
    public boolean execute() {
        return receiver.removeProduct(name, qnt);
    }
    @Override
    public boolean undo() {
        return receiver.addProduct(name, qnt);
    }
}
