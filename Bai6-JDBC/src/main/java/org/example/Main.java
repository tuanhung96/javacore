package org.example;

import org.example.dao.BillDAO;
import org.example.dao.BillDAOImpl;
import org.example.dao.ProductDAO;
import org.example.dao.ProductDAOImpl;
import org.example.model.Bill;
import org.example.model.Product;

import java.sql.Date;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAOImpl();
        BillDAO billDAO = new BillDAOImpl();

        while(true) {
            System.out.println("------Product Management------");
            System.out.println("1. Add product");
            System.out.println("2. Get product");
            System.out.println("3. Update product");
            System.out.println("4. Delete product");
            System.out.println("5. Add Bill");
            System.out.println("0. Exit");
            System.out.print("Choose command: ");

            String command = sc.nextLine();

            if(command.equals("0")) break;

            try{
                switch (command) {
                    case "1":
                        Product newProduct = createProduct();
                        productDAO.saveToDatabase(newProduct);
                        break;
                    case "2":
                        System.out.print("Enter ID to get: ");
                        int idGet = sc.nextInt();
                        sc.nextLine();
                        Product product = productDAO.getProductById(idGet);
                        if(product != null) System.out.println(product.toString());
                        else System.out.println("Invalid Id!");
                        break;
                    case "3":
                        System.out.print("Enter ID to update: ");
                        int idUpdate = sc.nextInt();
                        sc.nextLine();
                        if(!productDAO.checkValidId(idUpdate)) {
                            System.out.println("Product id " + idUpdate + " doesn't exist");
                            break;
                        }
                        while (true) {
                            System.out.println("Field: ");
                            System.out.println("1. Name");
                            System.out.println("2. quantity");
                            System.out.println("3. price");
                            System.out.println("4. category");
                            System.out.println("0. Exit");
                            System.out.print("Choose field to update: ");
                            String field = sc.nextLine();
                            if(field.equals("0")) break;
                            switch (field) {
                                case "1":
                                    System.out.print("1. New Name: ");
                                    String name = sc.nextLine();
                                    productDAO.updateProduct(idUpdate, "name", name);
                                    break;
                                case "2":
                                    System.out.print("2. New quantity: ");
                                    String quantity = sc.nextLine();
                                    productDAO.updateProduct(idUpdate, "quantity", quantity);
                                    break;
                                case "3":
                                    System.out.print("2. New price: ");
                                    String price = sc.nextLine();
                                    productDAO.updateProduct(idUpdate, "price", price);
                                    break;
                                case "4":
                                    System.out.print("2. New category id: ");
                                    String category_id = sc.nextLine();
                                    productDAO.updateProduct(idUpdate, "category_id", category_id);
                                    break;
                                default:
                                    System.out.println("Please enter reasonable field");
                                    break;
                            }
                        }
                        break;

                    case "4":
                        System.out.print("Enter ID to delete: ");
                        int idDelete = sc.nextInt();
                        sc.nextLine();
                        boolean deleted = productDAO.deleteProductById(idDelete);
                        if(deleted) System.out.println("Delete product id " + idDelete + " successfully!");
                        else System.out.println("Invalid Id!");
                        break;

                    case "5":
                        System.out.print("Enter product ID: ");
                        int productId = sc.nextInt();
                        System.out.print("Enter quantity: ");
                        int quantity = sc.nextInt();
                        sc.nextLine();
                        Product prod = productDAO.getProductById(productId);
                        int price = prod.getPrice();

                        if(quantity > prod.getQuantity()) {
                            System.out.println("Khong du so luong");
                        } else {
                            Bill bill = new Bill(quantity, price, new Date(System.currentTimeMillis()), productId);
                            billDAO.saveToDatabase(bill);
                            productDAO.updateProduct(productId, "quantity", String.valueOf(prod.getQuantity()-quantity));
                        }
                        break;

                    default:
                        System.out.println("Please enter reasonable number");
                        break;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
                System.out.println("Vui long nhap dung dinh dang du lieu");
            }

        }
    }

    public static Product createProduct() {
        System.out.println("Add Product");
        System.out.print("1. Name: ");
        String name = sc.nextLine();
        System.out.print("2. Quantity: ");
        int quantity = sc.nextInt();
        System.out.print("3. Price: ");
        int price = sc.nextInt();
        System.out.print("4. Category ID: ");
        int category_id = sc.nextInt();
        sc.nextLine();
        Product product = new Product(name, quantity, price, category_id);
        return product;
    }

}