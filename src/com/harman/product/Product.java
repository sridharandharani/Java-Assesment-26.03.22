package com.harman.product;


import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Product {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option;
        while (true){
            System.out.println("Select an option :");
            System.out.println("1. Add the product ");
            System.out.println("2. View All products ");
            System.out.println("3. Search a product using product  code ");
            System.out.println("4. Update product details using product Code");
            System.out.println("5. Delete a product  using product Code ");
            System.out.println("6. Display all the details of products  whose price  is greater than 50000 ");
            System.out.println("7. Display the count of total number of products  in the company ");
            System.out.println("8. Display all the product details in alphabetical order ");
            System.out.println("9. Exit ");
            option = in.nextInt();
            switch (option){
                case 1 :
                    try {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompanydb?autoReconnect=true&useSSL=false","root","");
                        String productCode, productname, brand , price , model, yearofmanufacturing , expirydate;
                        System.out.println("Enter the product code :");
                        productCode = in.next();
                        System.out.println("Enter the product name :");
                        productname = in.next();
                        System.out.println("Enter the brand :");
                        brand = in.next();
                        System.out.println("Enter the price :");
                        price = in.next();
                        System.out.println("Enter the model :");
                        model = in.next();
                        System.out.println("Enter the year of manufacturing :");
                        yearofmanufacturing = in.next();
                        System.out.println("Enter the expiry date :");
                        expirydate = in.next();
                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("INSERT INTO `products`(`productcode`, `productname`, `brand`, `price`, `model`, `yearofmanufacturing`, `expirydate`)" +
                                "VALUES("+productCode+",'"+productname+"','"+brand+"',"+price+",'"+model+"',"+yearofmanufacturing+","+expirydate+")");
                        System.out.println("Inserted sucessfully");
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 2 :
                    System.out.println("View all product");
                    try {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompanydb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT `productcode`, `productname`, `brand`, `price`, `model`, `yearofmanufacturing`, `expirydate` FROM `products` WHERE 1");
                        while (rs.next()){
                            System.out.println("product code = " + rs.getInt("productcode"));
                            System.out.println("product name = " + rs.getString("productname"));
                            System.out.println("brand = " + rs.getString("brand"));
                            System.out.println("price = " + rs.getInt("price"));
                            System.out.println("model = " + rs.getString("model"));
                            System.out.println("Year of manufacturing = " + rs.getInt("yearofmanufacturing"));
                            System.out.println("Expiry date = " + rs.getInt("expirydate"));
                        }

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 3 :
                    try {
                        int productcode;
                        System.out.println("Enter the product code to be searched :");
                        productcode = in.nextInt();
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompanydb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM `products` WHERE `productcode` = "+productcode);
                        while (rs.next()){
                            System.out.println("product name = " + rs.getString("productname"));
                            System.out.println("brand = " + rs.getString("brand"));
                            System.out.println("price = " + rs.getInt("price"));
                            System.out.println("model = " + rs.getString("model"));
                            System.out.println("Year of manufacturing = " + rs.getInt("yearofmanufacturing"));
                            System.out.println("Expiry date = " + rs.getInt("expirydate"));
                        }



                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 4 :
                    try {
                        int productcode;
                        System.out.println("Enter the product code to be updated :");
                        productcode = in.nextInt();
                        String productname, brand , price , model, yearofmanufacturing , expirydate;
                        System.out.println("Enter the product name :");
                        productname = in.next();
                        System.out.println("Enter the brand :");
                        brand = in.next();
                        System.out.println("Enter the price :");
                        price = in.next();
                        System.out.println("Enter the model :");
                        model = in.next();
                        System.out.println("Enter the year of manufacturing :");
                        yearofmanufacturing = in.next();
                        System.out.println("Enter the expiry date :");
                        expirydate = in.next();

                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompanydb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("UPDATE `products` SET `productname`='"+productname+"',`brand`='"+brand+"',`price`="+price+",`model`='"+model+"',`yearofmanufacturing`="+yearofmanufacturing+",`expirydate`="+expirydate+" WHERE `productcode`="+productcode);
                        System.out.println("Updated sucessfully");

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 5 :
                    try {
                        int productcode;
                        System.out.println("Enter the product code to be deleted ");
                        productcode = in.nextInt();
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompanydb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("DELETE FROM `products` WHERE `productcode`="+productcode);
                        System.out.println("Deleted sucessfully");


                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 6 :
                    try {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompanydb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM `products` WHERE `price` > 50000");
                        while (rs.next()){
                            System.out.println("product code = " + rs.getInt("productcode"));
                            System.out.println("product name = " + rs.getString("productname"));
                            System.out.println("brand = " + rs.getString("brand"));
                            System.out.println("model = " + rs.getString("model"));
                            System.out.println("Year of manufacturing = " + rs.getInt("yearofmanufacturing"));
                            System.out.println("Expiry date = " + rs.getInt("expirydate"));
                        }

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 7 :
                    try {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompanydb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT count(*) FROM `products`");
                        rs.next();
                        int count = rs.getInt(1);
                        System.out.println("The total count = " + count);

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 8 :
                    try {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompanydb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT `productcode`, `productname`, `brand`, `price`, `model`, `yearofmanufacturing`, `expirydate` FROM `products` WHERE 1 order by productname asc ");
                        while (rs.next()){
                            System.out.println("product code = " + rs.getInt("productcode"));
                            System.out.println("product name = " + rs.getString("productname"));
                            System.out.println("brand = " + rs.getString("brand"));
                            System.out.println("price = " + rs.getInt("price"));
                            System.out.println("model = " + rs.getString("model"));
                            System.out.println("Year of manufacturing = " + rs.getInt("yearofmanufacturing"));
                            System.out.println("Expiry date = " + rs.getInt("expirydate"));
                        }


                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Invalid syntax");




            }
        }
    }
}
