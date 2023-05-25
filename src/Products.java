import java.util.ArrayList;

public class Products {
    private String title;
    private int price;

    public Products(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public Products() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void showcase(ArrayList<Products> products){
        int count = 1;
        for(Products product : products){
            System.out.println(count + " " + product.getTitle() + " " + product.getPrice());
            count++;
        }
    }

    public void deleteProduct (int index){

    }
}
