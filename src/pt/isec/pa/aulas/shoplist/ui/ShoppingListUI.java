package pt.isec.pa.aulas.shoplist.ui;

import pt.isec.pa.aulas.shoplist.model.command.ShopingListManager;
import pt.isec.pa.aulas.utils.PAInput;

public class ShoppingListUI {
    ShopingListManager sm;
    public ShoppingListUI(ShopingListManager sm) { this.sm = sm; }
    public void start() {
        boolean finish = false;
        do {
            System.out.println("\n\n"+sm+"\n");
            int op = PAInput.chooseOption("Shopping List",
                    "Add product","Remove product","Undo"+(sm.hasUndo()?"(sim)":"(não)"),"Redo"+(sm.hasRedo()?"(sim)":"(não)"),"Quit");
            switch (op) {
                case 1 -> sm.addProduct(
                        PAInput.readString("Product name: ",false),
                        PAInput.readNumber("Quantity: ") );
                case 2 -> sm.removeProduct(
                        PAInput.readString("Product name: ",false),
                        PAInput.readNumber("Quantity: ") );
                case 3 -> sm.undo();
                case 4 -> sm.redo();
                case 5 -> finish = true;
            }
        } while (!finish);
    }
}
