package pt.isec.pa.aulas.shoplist.model.command;

import pt.isec.pa.aulas.shoplist.model.data.ShoppingList;

public class AddProductCommand extends CommandAdapter {
    private String name;
    private double qnt;
    public AddProductCommand(ShoppingList receiver, String name, double qnt) {
        super(receiver);
        this.qnt = qnt;
        this.name = name;
    }
    @Override
    public boolean execute() {
        return receiver.addProduct(name, qnt);
    }
    @Override
    public boolean undo() {
        return receiver.removeProduct(name,qnt);
    }
}
