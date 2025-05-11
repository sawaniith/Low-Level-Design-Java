package OrderManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventory {
    private List<Product> productList;
    private List<ProductCategory> productCategories;

    public Inventory() {
        productList = new ArrayList<>();
        productCategories = new ArrayList<>();
    }

    //add new category
    public void addCategory(int categoryId, String name, String description){
        ProductCategory productCategory = new ProductCategory(categoryId, name, description);
        productCategories.add(productCategory);
    }


    //add product to the particular category
    public void addProduct(Product product){
        productList.add(product);
    }

    //remove product count from the product post checkout
    public void removeItems(Map<Integer, Integer> productAndCountMap){

        //

    }

    private ProductCategory getProductCategoryFromID(int productCategoryId){

        for(ProductCategory productCategory : productCategories){

            if(productCategory.getId() == productCategoryId){
                return productCategory;
            }
        }

        return null;
    }
}
