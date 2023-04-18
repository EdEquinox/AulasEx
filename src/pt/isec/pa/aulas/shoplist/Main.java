package pt.isec.pa.aulas.shoplist;

import pt.isec.pa.aulas.shoplist.model.command.ShopingListManager;
import pt.isec.pa.aulas.shoplist.ui.ShoppingListUI;

public class Main {
    public static void main(String[] args) {
        ShopingListManager shoppingListManager = new ShopingListManager();
        ShoppingListUI shoppingListUI = new ShoppingListUI(shoppingListManager);
        shoppingListUI.start();
    }
}
