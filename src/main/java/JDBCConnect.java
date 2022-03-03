import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class JDBCConnect {

    public static void main(String[] args) throws ClassNotFoundException {

		// https://docs.oracle.com/javase/8/docs/api/java/sql/package-summary.html#package.description
        // auto java.sql.Driver discovery -- no longer need to load a java.sql.Driver class via Class.forName

        // register JDBC driver, optional, since java 1.6
        /*try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
		
        // auto close connection
//    	 Class.forName("org.postgresql.Driver");
//        try (Connection conn = DriverManager.getConnection(
//                "jdbc:postgresql://127.0.0.1:5432/biddingsystem", "postgres", "dbproject")) {
//
//            if (conn != null) {
//                System.out.println("Connected to the database!");
//                String query = "select username,password from public.login where username='" + "subu" + "' AND "
//                		+ "'" + "subu" + "'";
//                System.out.println(query);
//            } else {
//                System.out.println("Failed to make connection!");
//            }
//
//        } catch (SQLException e) {
//            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    	String s=new String("subu");
//    	if(s.indexOf("subu") >= 0) {
//    		System.out.println("yes");
//    	}else {
//    		System.out.println("no");
//    	}
    	String query = "select * FROM public.car where CarID='C0004'";
    	System.out.println(query);
    	System.out.println("INSERT INTO public.seller VALUES(" + 541414 + ",'S000" + 1 + "'," + "subu" +"'," +144555 + ",'"+ "asdasds" + "','"+ "sdsdf" +")");
    	Document htmlFile = null;
        try {
            htmlFile = Jsoup.parse(new File("biddingsystem/src/main/webapp/WEB-INF/bidder.html"), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element div = htmlFile.getElementById("model");
    }
}
