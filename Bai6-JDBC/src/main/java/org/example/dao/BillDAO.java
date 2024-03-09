package org.example.dao;

import org.example.model.Bill;

public interface BillDAO {
    void saveToDatabase(Bill bill);
}
