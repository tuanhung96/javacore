package utils;

import entity.Customer;
import entity.Item;
import entity.Order;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {

    public static int getLastCustomerId() {
        try (Scanner scanner = new Scanner(new FileReader("KH.txt"))) {
            int customerId = 0;
            while(scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] data = input.split(",");
                customerId = Integer.parseInt(data[0]);
            }
            return customerId;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean checkValidCustomerId(int customerId) {
        try (Scanner scanner = new Scanner(new FileReader("KH.txt"))) {
            while(scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] data = input.split(",");
                if(customerId == Integer.parseInt(data[0])) return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getCustomerNameById(int customerId) {
        try (Scanner scanner = new Scanner(new FileReader("KH.txt"))) {
            while(scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] data = input.split(",");
                if(customerId == Integer.parseInt(data[0])) return data[1];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Customer> getCustomerList() {
        try (Scanner scanner = new Scanner(new FileReader("KH.txt"))) {
            List<Customer> customerList = new ArrayList<>();
            while(scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] data = input.split(",");
                int customerId = Integer.parseInt(data[0]);
                String fullName = data[1];
                String address = data[2];
                String phoneNumber = data[3];
                customerList.add(new Customer(customerId, fullName, address, phoneNumber));
            }
            return customerList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeCustomerToFile(Customer customer) {
        try(FileWriter file = new FileWriter("KH.txt", true)) {
            file.write(customer.getCustomerId() + "," + customer.getFullName() + "," + customer.getAddress() + "," + customer.getPhoneNumber() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getLastItemId() {
        try (Scanner scanner = new Scanner(new FileReader("MH.txt"))) {
            int itemId = 0;
            while(scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] data = input.split(",");
                itemId = Integer.parseInt(data[0]);
            }
            return itemId;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String[] getItemNameAndPriceById(int itemId) {
        try (Scanner scanner = new Scanner(new FileReader("MH.txt"))) {
            while(scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] data = input.split(",");
                if(itemId == Integer.parseInt(data[0])) return new String[] {data[1], data[3]};
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean checkValidItemId(int itemId) {
        try (Scanner scanner = new Scanner(new FileReader("MH.txt"))) {
            while(scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] data = input.split(",");
                if(itemId == Integer.parseInt(data[0])) return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Item> getItemList() {
        try (Scanner scanner = new Scanner(new FileReader("MH.txt"))) {
            List<Item> itemList = new ArrayList<>();
            while(scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] data = input.split(",");
                int itemId = Integer.parseInt(data[0]);
                String name = data[1];
                String category = data[2];
                String price = data[3];
                itemList.add(new Item(itemId, name, category, price));
            }
            return itemList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeItemToFile(Item item) {
        try(FileWriter file = new FileWriter("MH.txt", true)) {
            file.write(item.getItemId() + "," + item.getName() + "," + item.getCategory() + "," + item.getPrice() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /////// ORDER

    public static boolean checkCustomerAndItemExistInFile(int customerId, int itemId) {
        try (Scanner scanner = new Scanner(new FileReader("QLBH.txt"))) {
            while(scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] data = input.split(",");
                if(customerId == Integer.parseInt(data[0]) && itemId == Integer.parseInt(data[2])) return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean checkCustomerExistInFile(int customerId) {
        try (Scanner scanner = new Scanner(new FileReader("QLBH.txt"))) {
            while(scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] data = input.split(",");
                if(customerId == Integer.parseInt(data[0])) return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void updateOrderInFile(int customerId, int itemId, int quantity) {
        try (Scanner scanner = new Scanner(new FileReader("QLBH.txt"))) {
            String line;
            // Add the data file contents to a List interface...
            List<String> dataList = new ArrayList<>();
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                dataList.add(line);
            }

            for (int i = 0; i < dataList.size(); i++) {
                line = dataList.get(i).trim();
                // Skip Blank lines
                if (line.equals("")) {
                    continue;
                }

                String[] data = line.split(",");

                if (customerId == Integer.parseInt(data[0]) && itemId == Integer.parseInt(data[2])) {
                    // If we reach this point then we know that we are currently on
                    // the data line we need and want to make changes to.
                    String newLine = "";
                    // Iterate through the current data line fields
                    for (int j = 0; j < data.length; j++) {
                        // If we reach data with index 2 (quantity)
                        if (j == 4) {
                            int newQuantity = Integer.parseInt(data[j]) + quantity;
                            data[j] = String.valueOf(newQuantity);
                        }
                        // Build the new data line.
                        newLine += newLine.equals("") ? data[j] : "," + data[j];
                    }
                    // Replace the current List element with the modified data.
                    dataList.set(i, newLine);
                } else continue;


            }
            // Rewrite the Data File.
            try (FileWriter file = new FileWriter("QLBH.txt")) {
                for (int i = 0; i < dataList.size(); i++) {
                    file.write(dataList.get(i) + System.lineSeparator());
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void rewriteOrderListToFile(List<Order> orderList) {
        try (FileWriter file = new FileWriter("QLBH.txt")) {
            for (int i = 0; i < orderList.size(); i++) {
                file.write(orderList.get(i).getCustomerId() + "," + orderList.get(i).getCustomerName() + "," + orderList.get(i).getItemId() + "," + orderList.get(i).getItemName() + "," + orderList.get(i).getQuantity() + "," + orderList.get(i).getPrice() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeOrderToFile(Order order) {
        try(FileWriter file = new FileWriter("QLBH.txt", true)) {
            file.write(order.getCustomerId() + "," + order.getCustomerName() + "," + order.getItemId() + "," + order.getItemName() + "," + order.getQuantity() + "," + order.getPrice() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Order> getOrderList() {
        try (Scanner scanner = new Scanner(new FileReader("QLBH.txt"))) {
            List<Order> orderList = new ArrayList<>();
            while(scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] data = input.split(",");
                int customerId = Integer.parseInt(data[0]);
                String customerName = data[1];
                int itemId = Integer.parseInt(data[2]);
                String itemName = data[3];
                int quantity = Integer.parseInt(data[4]);
                String price = data[5];
                orderList.add(new Order(customerId, customerName, itemId, itemName, quantity, price));
            }
            return orderList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static List<Order> getOrdersOfCustomerById(int cusId) {
        try (Scanner scanner = new Scanner(new FileReader("QLBH.txt"))) {
            List<Order> orderList = new ArrayList<>();
            while(scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] data = input.split(",");
                int customerId = Integer.parseInt(data[0]);
                if(cusId == customerId) {
                    String customerName = data[1];
                    int itemId = Integer.parseInt(data[2]);
                    String itemName = data[3];
                    int quantity = Integer.parseInt(data[4]);
                    String price = data[5];
                    orderList.add(new Order(customerId, customerName, itemId, itemName, quantity, price));
                }
            }
            return orderList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
