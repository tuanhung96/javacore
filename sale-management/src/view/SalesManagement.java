package view;

import entity.Customer;
import entity.Item;
import entity.Order;
import utils.FileUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

public class SalesManagement {
    private JPanel rootPanel;
    private JLabel SalesManagementLabel;
    private JButton newItemButton;
    private JButton newCustomerButton;
    private JButton orderListButton;
    private JTextField itemName;
    private JRadioButton fashionRadioButton;
    private JRadioButton householdRadioButton;
    private JRadioButton consumptionRadioButton;
    private JRadioButton electricRadioButton;
    private JTextField price;
    private JTextField fullName;
    private JTextField address;
    private JTextField phoneNumber;
    private JButton addItemButton;
    private JButton addCustomerButton;
    private JPanel addItemPanel;
    private JPanel addCustomerPanel;
    private JPanel orderListPanel;
    private JButton addOrderButton;
    private JTextField customerId;
    private JTextField itemId;
    private JTextField quantity;
    private JButton billButton;
    private JButton orderByCustomerNameButton;
    private JButton orderByItemNameButton;
    private JPanel customerBillPanel;
    private JTextField billCustomerId;
    private JButton getBillButton;

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public SalesManagement() {
        addCustomerPanel.setVisible(false);
        orderListPanel.setVisible(false);
        customerBillPanel.setVisible(false);
        ButtonGroup buttonGroup= new ButtonGroup();
        buttonGroup.add(fashionRadioButton);
        buttonGroup.add(householdRadioButton);
        buttonGroup.add(consumptionRadioButton);
        buttonGroup.add(electricRadioButton);

        newCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCustomerPanel.setVisible(true);
                addItemPanel.setVisible(false);
                orderListPanel.setVisible(false);
                customerBillPanel.setVisible(false);
            }
        });

        newItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCustomerPanel.setVisible(false);
                addItemPanel.setVisible(true);
                orderListPanel.setVisible(false);
                customerBillPanel.setVisible(false);
            }
        });

        orderListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCustomerPanel.setVisible(false);
                addItemPanel.setVisible(false);
                orderListPanel.setVisible(true);
                customerBillPanel.setVisible(false);
            }
        });

        billButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCustomerPanel.setVisible(false);
                addItemPanel.setVisible(false);
                orderListPanel.setVisible(false);
                customerBillPanel.setVisible(true);
            }
        });

        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String _itemName = itemName.getText().trim();
                String _price = price.getText().trim();
                if(_itemName.equals("") || _price.equals("") ||
                        (!fashionRadioButton.isSelected()
                        && !householdRadioButton.isSelected()
                        && !consumptionRadioButton.isSelected()
                        && !electricRadioButton.isSelected())) {
                    showError("Vui lòng điền đầy đủ thông tin");
                } else {
                    String category = "";
                    if(fashionRadioButton.isSelected()) category = "Fashion";
                    if(householdRadioButton.isSelected()) category = "Household";
                    if(consumptionRadioButton.isSelected()) category = "Consumption";
                    if(electricRadioButton.isSelected()) category = "Electric";

                    Item newItem = new Item(_itemName, category , _price);

                    // save item to file
                    FileUtils.writeItemToFile(newItem);
                    // show item list on screen
                    showItemList();
                }
            }
        });

        addCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String _fullName = fullName.getText().trim();
                String _address = address.getText().trim();
                String _phoneNumber = phoneNumber.getText().trim();

                if(_fullName.equals("") || _address.equals("") || _phoneNumber.equals("")) {
                    showError("Vui lòng điền đầy đủ thông tin");
                } else {
                    Customer newCustomer = new Customer(_fullName, _address, _phoneNumber);
                    // save customer to file
                    FileUtils.writeCustomerToFile(newCustomer);
                    // show customer list on screen
                    showCustomerList();
                }
            }
        });

        addOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int cusId = Integer.parseInt(customerId.getText().trim());
                    int iteId = Integer.parseInt(itemId.getText().trim());
                    int quan = Integer.parseInt(quantity.getText().trim());

                    if(!FileUtils.checkValidCustomerId(cusId) || !FileUtils.checkValidItemId(iteId)) {
                        showError("CustomerId or ItemId is invalid");
                    } else {
                        // if customerId and itemId existed in QLBH.txt, update file
                        if(FileUtils.checkCustomerAndItemExistInFile(cusId, iteId)) {
                            FileUtils.updateOrderInFile(cusId, iteId, quan);
                        } else {
                            // if not, add to file
                            String cusName = FileUtils.getCustomerNameById(cusId);
                            String[] data = FileUtils.getItemNameAndPriceById(iteId);
                            FileUtils.writeOrderToFile(new Order(cusId, cusName, iteId, data[0], quan, data[1]));
                        }
                        showOrderList();

                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                    showError("Vui lòng điền đầy đủ thông tin");
                }
            }
        });

        orderByCustomerNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Order> orderList = FileUtils.getOrderList();

                if (!orderList.isEmpty()) {
                    Collections.sort(orderList, (order1, order2) -> order1.getCustomerName().compareTo(order2.getCustomerName()));
                }

                FileUtils.rewriteOrderListToFile(orderList);
                showOrderList();
            }
        });

        orderByItemNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Order> orderList = FileUtils.getOrderList();

                if (!orderList.isEmpty()) {
                    Collections.sort(orderList, (order1, order2) -> order1.getItemName().compareTo(order2.getItemName()));
                }

                FileUtils.rewriteOrderListToFile(orderList);
                showOrderList();
            }
        });

        getBillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int cusId = Integer.parseInt(billCustomerId.getText().trim());

                    if(!FileUtils.checkValidCustomerId(cusId)) {
                        showError("CustomerId is invalid");
                    } else {
                        // if customerId existed in QLBH.txt
                        if(!FileUtils.checkCustomerExistInFile(cusId)) {
                            showError("Customer " + cusId + " has no bill");
                        } else {
                            List<Order> orderList = FileUtils.getOrdersOfCustomerById(cusId);
                            showBill(orderList);
                        }
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                    showError("Vui lòng điền đầy đủ thông tin");
                }
            }
        });
    }

    public void showError(String message) {
        JFrame frame = new JFrame("Error");
        frame.setLocationRelativeTo(null); // set frame to be center
        Error error = new Error();
        error.getErrorMessage().setText(message);
        frame.setContentPane(error.getErrorPanel());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

//    public void showInvalidIdError() {
//        JFrame frame = new JFrame("Error");
//        frame.setLocationRelativeTo(null); // set frame to be center
//        Error error = new Error();
//        error.getErrorMessage().setText("CustomerId or ItemId is invalid");
//        frame.setContentPane(error.getErrorPanel());
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    };

    public void showCustomerList() {
        JFrame f = new JFrame("Customer List");
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        List<Customer> customerList = FileUtils.getCustomerList();
        // Data to be displayed in the JTable
        int n = customerList.size();

        String[][] data = new String[n][4];

        for(int i=0; i<n; i++) {
            Customer customer = customerList.get(i);
            data[i][0] = String.valueOf(customer.getCustomerId());
            data[i][1] = customer.getFullName();
            data[i][2] = customer.getAddress();
            data[i][3] = customer.getPhoneNumber();
        }

        // Column Names
        String[] columnNames = { "ID", "Full Name", "Address", "Phone Number" };

        JTable j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);

        f.setSize(500, 200);
        f.setVisible(true);
    }

    public void showItemList() {
        JFrame f = new JFrame("Item List");
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        List<Item> itemList = FileUtils.getItemList();
        // Data to be displayed in the JTable
        int n = itemList.size();

        String[][] data = new String[n][4];

        for(int i=0; i<n; i++) {
            Item item = itemList.get(i);
            data[i][0] = String.valueOf(item.getItemId());
            data[i][1] = item.getName();
            data[i][2] = item.getCategory();
            data[i][3] = item.getPrice();
        }

        // Column Names
        String[] columnNames = { "ID", "Item Name", "Category", "Price" };

        JTable j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);

        f.setSize(500, 200);
        f.setVisible(true);
    }

    public void showOrderList() {
        JFrame f = new JFrame("Order List");
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        List<Order> orderList = FileUtils.getOrderList();
        // Data to be displayed in the JTable
        int n = orderList.size();

        String[][] data = new String[n][6];

        for(int i=0; i<n; i++) {
            Order order = orderList.get(i);
            data[i][0] = String.valueOf(order.getCustomerId());
            data[i][1] = order.getCustomerName();
            data[i][2] = String.valueOf(order.getItemId());
            data[i][3] = order.getItemName();
            data[i][4] = String.valueOf(order.getQuantity());
            data[i][5] = order.getPrice();
        }

        // Column Names
        String[] columnNames = { "Customer ID", "Customer Name", "Item ID", "Item Name", "Quantity", "Price" };

        JTable j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);

        f.setSize(500, 200);
        f.setVisible(true);
    }

    public void showBill(List<Order> orderList) {
        JFrame f = new JFrame("Customer Bill");
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Data to be displayed in the JTable
        int n = orderList.size();

        String[][] data = new String[n][7];
        int sum = 0;

        for(int i=0; i<n; i++) {
            Order order = orderList.get(i);
            data[i][0] = String.valueOf(order.getCustomerId());
            data[i][1] = order.getCustomerName();
            data[i][2] = String.valueOf(order.getItemId());
            data[i][3] = order.getItemName();
            data[i][4] = String.valueOf(order.getQuantity());
            data[i][5] = order.getPrice();
            data[i][6] = String.valueOf(Integer.parseInt(order.getPrice())*order.getQuantity());
            sum += Integer.parseInt(order.getPrice())*order.getQuantity();
        }

        // Column Names
        String[] columnNames = { "Customer ID", "Customer Name", "Item ID", "Item Name", "Quantity", "Price", "VND" };

        JTable j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);

        JLabel label = new JLabel("TOTAL: " + sum);
//        f.add(label);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);

        f.setSize(500, 200);
        f.setVisible(true);
    }

}
