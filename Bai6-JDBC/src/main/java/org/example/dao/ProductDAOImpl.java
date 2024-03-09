package org.example.dao;

import org.example.ConnectJDBC;
import org.example.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAOImpl implements ProductDAO{
    public ProductDAOImpl() {
    }

    @Override
    public boolean checkValidId(int id) {
        return (getProductById(id) != null);
    }
    @Override
    public void saveToDatabase(Product product) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection conn = connectJDBC.connect();

        String query = "INSERT INTO product(id, name, quantity, price, category_id) " +
                "VALUES (null, ?,?,?,?)";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);

            pstm.setString(1, product.getName());
            pstm.setInt(2, product.getQuantity());
            pstm.setInt(3, product.getPrice());
            pstm.setInt(4, product.getCategory_id());

            //Khi thực hiện các lệnh insert/update/delete sử dụng executeUpdate, nó sẽ trả về số hàng bị tác động
            int row = pstm.executeUpdate();
            if(row != 0) System.out.println("Add product successfully!");

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Product getProductById(int productId) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection conn = connectJDBC.connect();

        String query = "SELECT * FROM product WHERE id = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, productId);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                int price = rs.getInt("price");
                int category_id = rs.getInt("category_id");
                Product product = new Product(id,name,quantity,price,category_id);
                return product;
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    @Override
    public boolean deleteProductById(int productId) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection conn = connectJDBC.connect();

        String query = "DELETE FROM product WHERE id = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);

            pstm.setInt(1, productId);

            int row = pstm.executeUpdate();
            if(row != 0) return true;

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
    @Override
    public void updateProduct(int id, String key, String value) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection conn = connectJDBC.connect();

        String query = "UPDATE product SET " + key + " = ? WHERE id = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);
            if(key.equals("name")) pstm.setString(1, value);
            else pstm.setInt(1, Integer.parseInt(value));
            pstm.setInt(2, id);

            int row = pstm.executeUpdate();
            if(row != 0){
                System.out.println("Update successfully!");
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
