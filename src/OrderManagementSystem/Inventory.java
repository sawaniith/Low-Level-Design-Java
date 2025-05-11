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
    public void addProduct(Product product, int productCategoryId){

        //take out the respective productCategory Object
        ProductCategory categoryObject = null;
        for(ProductCategory category : productCategoryList)
        {
            if(category.productCategoryId == productCategoryId){
                categoryObject = category;
            }
        }

        if(categoryObject !=null) {
            categoryObject.addProduct(product);
        }
    }

    //remove product from the category
    public void removeItems(Map<Integer, Integer> productCategoryAndCountMap){

        for(Map.Entry<Integer, Integer> entry : productCategoryAndCountMap.entrySet())
        {
            ProductCategory category = getProductCategoryFromID(entry.getKey());
            category.removeProduct(entry.getValue());
        }

    }

    private ProductCategory getProductCategoryFromID(int productCategoryId){

        for(ProductCategory productCategory : productCategoryList){

            if(productCategory.productCategoryId == productCategoryId){
                return productCategory;
            }
        }

        return null;
    }
}
