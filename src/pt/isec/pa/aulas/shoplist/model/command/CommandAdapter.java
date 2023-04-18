package pt.isec.pa.aulas.shoplist.model.command;

import pt.isec.pa.aulas.shoplist.model.data.ShoppingList;

abstract class CommandAdapter implements ICommand {
    protected ShoppingList receiver;
    protected CommandAdapter(ShoppingList receiver) {
        this.receiver = receiver;
    }
}
