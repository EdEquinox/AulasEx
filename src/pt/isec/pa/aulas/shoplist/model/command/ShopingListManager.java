package pt.isec.pa.aulas.shoplist.model.command;

import pt.isec.pa.aulas.shoplist.model.data.ShoppingList;

public class ShopingListManager {
    ShoppingList rc;
    CommandManager cm;
    public ShopingListManager() {
        rc = new ShoppingList();
        cm = new CommandManager();
    }
    public boolean addProduct(String name, double qnt) {
        return cm.invokeCommand(new AddProductCommand(rc,name,qnt));
    }
    public boolean removeProduct(String name, double qnt) {
        return cm.invokeCommand(new RemoveProductCommand(rc, name, qnt ));
    }
    // ...
    public boolean hasUndo() { return cm.hasUndo(); }
    public boolean undo() { return cm.undo(); }
    public boolean hasRedo() { return cm.hasRedo(); }
    public boolean redo() { return cm.redo(); }
// ...

    @Override
    public String toString() {
        return rc.toString();
    }
}
