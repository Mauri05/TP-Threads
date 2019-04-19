package classes;

import java.sql.*;

public class Connect {

    static String driver = "com.mysql.cj.jdbc.Driver";
    static Connection conn = null;
    static String url = "jdbc:mysql://localhost:3306/";
    static String dbName = "ahorcado";
    static String user = "root";
    static String pass = "";

    public Connect(){

    }

    public static void showWords(){
        try {
            conn = DriverManager.getConnection(url + dbName, user, pass);
            Class.forName(driver);
            PreparedStatement ps = null;
            ps = conn.prepareStatement("select * from words");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("Word: "+rs.getString("word"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int getWordQuantity(){
        int quantity = 0;
        try {
            conn = DriverManager.getConnection(url + dbName, user, pass);
            Class.forName(driver);
            PreparedStatement ps = null;
            ps = conn.prepareStatement("select count(*) as quantity from words");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                quantity = rs.getInt("quantity");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return quantity;
    }

    public static String getWord(int index){
        String word = null;
        try{
            conn = DriverManager.getConnection(url + dbName, user, pass);
            Class.forName(driver);
            PreparedStatement ps = null;
            ps = conn.prepareStatement("select * from words where id_word = "+index);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                word = rs.getString("word");
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return word;
    }

    public static void setWord(String word){
        String aux = word.toLowerCase();
        String query = "insert into words (word) values ('"+aux+"');";
        try{
            conn = DriverManager.getConnection(url + dbName, user, pass);
            Class.forName(driver);
            Statement st = null;
            st = conn.createStatement();
            st.executeUpdate(query);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
