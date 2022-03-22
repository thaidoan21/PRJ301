/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Account;
import controller.Bill;
import controller.Product;
import controller.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Hung Trinh
 */
public class ProductDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String xSql = null;

    public ProductDAO() {
        createConnection();
    }

    public void finalize() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createConnection() {
        DBContext u = new DBContext();
        try {
            con = u.getConnection();
        } catch (Exception e) {
            System.out.println("Connect database Fail");
            e.printStackTrace();
        }
    }

    public List<Product> getAllProduct() {
        if (con == null) {
            createConnection();
        }
        List<Product> list = new ArrayList<Product>();
        xSql = "select * from Products";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getString("pid"), rs.getString("name"), rs.getString("description"), rs.getFloat("price"), rs.getInt("quantity"), rs.getString("catid"), rs.getString("image"));
                list.add(p);
            }
            ps.close();
            rs.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getProductByCategory(String category) {
        if (con == null) {
            createConnection();
        }
        List<Product> list = new ArrayList<Product>();
        xSql = "select * from Products where catid = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, category);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getString("pid"), rs.getString("name"), rs.getString("description"), rs.getFloat("price"), rs.getInt("quantity"), rs.getString("catid"), rs.getString("image"));
                list.add(p);
            }
            ps.close();
            rs.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Category> getAllCategory() {
        if (con == null) {
            createConnection();
        }
        List<Category> list = new ArrayList<Category>();
        xSql = "select * from Categories ";
        try {
            ps = con.prepareStatement(xSql);

            rs = ps.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getString("catid"), rs.getString("name"));
                list.add(c);
            }
            ps.close();
            rs.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getProductBySerch(String search) {
        if (con == null) {
            createConnection();
        }
        List<Product> list = new ArrayList<Product>();
        xSql = "select * from Products where name like ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, search + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getString("pid"), rs.getString("name"), rs.getString("description"), rs.getFloat("price"), rs.getInt("quantity"), rs.getString("catid"), rs.getString("image"));
                list.add(p);
            }
            ps.close();
            rs.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Product getProductById(String pid) {
        if (con == null) {
            createConnection();
        }
        xSql = "select * from Products where pid = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getString("pid"), rs.getString("name"), rs.getString("description"), rs.getFloat("price"), rs.getInt("quantity"), rs.getString("catid"), rs.getString("image"));
                ps.close();
                rs.close();
                return p;
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addToCart(String username, String pid, int amount) {
        if (con == null) {
            createConnection();
        }
        xSql = "insert into Carts(username, pid, amount) values (?, ?, ?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, username);
            ps.setString(2, pid);
            ps.setInt(3, amount);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCart(String username, String pid, int amount) {
        if (con == null) {
            createConnection();
        }
        xSql = "update Carts set amount=? where username=? and pid=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, amount);
            ps.setString(2, username);
            ps.setString(3, pid);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, Integer> getCart(String username) {
        if (con == null) {
            createConnection();
        }
        HashMap<String, Integer> hashCart = new HashMap<>();
        xSql = "select * from Carts where username = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                hashCart.put(rs.getString("pid"), rs.getInt("amount"));
            }
            ps.close();
            rs.close();
            return hashCart;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashCart;
    }

    public void removeProductCart(String username, String pid) {
        if (con == null) {
            createConnection();
        }
        xSql = "DELETE FROM Carts WHERE username=? and pid=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, username);
            ps.setString(2, pid);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeAllCart(String username) {
        if (con == null) {
            createConnection();
        }
        xSql = "DELETE FROM Carts WHERE username=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, username);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addToBill(String username, String pid, int amount, float total) {
        if (con == null) {
            createConnection();
        }
        xSql = "insert into Bills(bid, username, pid, date, amount, total) values (?, ?, ?, GETDATE(), ?, ?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, UUID.randomUUID().toString());
            ps.setString(2, username);
            ps.setString(3, pid);
            ps.setInt(4, amount);
            ps.setFloat(5, total);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Bill> getAllBillByUser(String username) {
        if (con == null) {
            createConnection();
        }
        List<Bill> listB = new ArrayList<>();
        xSql = "select * from Bills b JOIN Products p ON b.pid = p.pid WHERE b.username=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                Bill b = new Bill(rs.getString("bid"), rs.getString("username"), rs.getString("pid"), rs.getDate("date"), rs.getInt("amount"), rs.getFloat("total"), rs.getString("name"), rs.getString("description"), rs.getFloat("price"), rs.getString("catid"), rs.getString("image"));
                listB.add(b);
            }
            ps.close();
            rs.close();
            return listB;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void DeleteProduct(String pid) {
        xSql = "delete from products where pid = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, pid);
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void InsertProduct(String id, String name, String description, String price, String quantity, String category, String image) {
        xSql = "INSERT [dbo].[Products] ([pid],[name], [description], [price], [quantity], [catid], [image]) VALUES (?,?,?,?,?,?,?);";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, description);
            ps.setString(4, price);
            ps.setString(5, quantity);
            ps.setString(6, category);
            ps.setString(7, image);
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void editProduct( String name, String description, String price, String quantity, String category, String image, String id) {
        xSql = "update Products set [name] = ?, [description] = ?, [price]= ?, [quantity]= ?, [catid]= ?,  [image] = ? where pid = ?";
        try {
            ps = con.prepareStatement(xSql);
            
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setString(3, price);
            ps.setString(4, quantity);
            ps.setString(5, category);
            ps.setString(6, image);
            ps.setString(7, id);
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        dao.InsertProduct("p120", "haha", "jjajajajajaaj", "10", "10", "con cac", "hihi");

    }
}
