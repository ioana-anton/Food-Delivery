package businesslayer;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends MenuItem{
    private List<BaseProduct> compositeProducts= new ArrayList<>();

    public List<BaseProduct> getCompositeProducts() {
        return compositeProducts;
    }

    public void setCompositeProducts(List<BaseProduct> compositeProducts) {
        this.compositeProducts = compositeProducts;
    }

    public void addProduct(BaseProduct b){
        compositeProducts.add(b);
    }


    @Override
    public int computePrice() {
        int price=0;
        for(BaseProduct it:compositeProducts)
            price+=it.computePrice();
        return price;
    }

    @Override
    public String[] toStringArray() {
        return new String[0];
    }
}
