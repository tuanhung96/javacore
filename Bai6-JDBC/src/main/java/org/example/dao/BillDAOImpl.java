package org.example.dao;

import org.example.ConnectJDBC;
import org.example.model.Bill;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BillDAOImpl implements BillDAO{
    public BillDAOImpl() {
    }

    @Override
    public void saveToDatabase(Bill bill) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection conn = connectJDBC.connect();

        String query = "INSERT INTO bill(id, quantity, price, buy_date, product_id) " +
                "VALUES (null, ?,?,?,?)";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);

            pstm.setInt(1, bill.getQuantity());
            pstm.setInt(2, bill.getPrice());
            System.out.println(bill.getBuy_date());
            pstm.setDate(3, (Date) bill.getBuy_date());
            pstm.setInt(4, bill.getProduct_id());

            //Khi thực hiện các lệnh insert/update/delete sử dụng executeUpdate, nó sẽ trả về số hàng bị tác động
            int row = pstm.executeUpdate();
            if(row != 0) System.out.println("Add bill successfully!");

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
