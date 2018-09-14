package cn.hdlmx.customerAndProducter;

import java.util.ArrayList;

public class Warehouse {
    /*
     * 仓库
     * */
    private final static int MAX_SIZE = 10;
    private ArrayList<Product> productList = new ArrayList<>();


    //仓库是否已满
    public boolean isFull() {
        if (productList.size()<MAX_SIZE) {
            //最后
            return false;
        }
        return true;
    }

    public boolean isEmpty() {
        if (productList.size()==0) {
            return true;
        }
        return false;
    }

    public Product getProduct() {
        int size = productList.size();
        Product product = productList.get(0);
        productList.remove(0);
        return product;
    }

    public void push(Product product) {
        productList.add(product);
    }
}
