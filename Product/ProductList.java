import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductList implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Product> products;

    public ProductList() {
        products = new ArrayList<>();
    }

    public boolean addProduct(Product product) {
        return products.add(product);
    }

    public boolean removeProduct(Product product) {
        return products.remove(product);
    }

    public Product searchProductById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null; // Return null if no product is found with the given ID
    }

    public Iterator<Product> getProducts() {
        return products.iterator();
    }

    @Override
    public String toString() {
        StringBuilder productList = new StringBuilder();
        for (Product product : products) {
            productList.append(product.toString()).append("\n");
        }
        return productList.toString();
    }
}
