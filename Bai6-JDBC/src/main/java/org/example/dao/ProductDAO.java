package org.example.dao;

import org.example.model.Product;

public interface ProductDAO {
    boolean checkValidId(int id);
    void saveToDatabase(Product product);
    Product getProductById(int productId);
    boolean deleteProductById(int productId);
    void updateProduct(int id, String key, String value);
}
