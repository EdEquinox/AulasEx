package pt.isec.pa.aulas.shoplist.model.data;

import pt.isec.pa.aulas.shoplist.model.data.Product;

import java.util.ArrayList;

public class ShoppingList {
    private ArrayList<Product> list;

    public ShoppingList() {
        list = new ArrayList<>();
    }

    public boolean addProduct(String name, double qt) {
        if (name != null && !name.isBlank() && qt > 0) {
            list.add(new Product(name, qt));
            return true;
        }
        return false;
    }

    public boolean removeProduct(String name, double qt) {
        return list.remove(new Product(name, qt));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Shopping List:\n");
        for (Product p : list)
            sb.append("\t- ").append(p).append("\n");
        return sb.toString();
    }


}
