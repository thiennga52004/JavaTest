package Repository;

import JDBC.DBConnection;
import Models.ITRequest;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ITRepository {
    public void addRequest (String name, String date, String email, String type, String details) throws SQLException {
//        Connection connection= DBConnection.getConnection();
//        ITRequest request = new ITRequest(name, date, email, type, details);
//        String sql = "INSERT INTO ITRequest (reqName, reqDate, reqEmail, reqType, reqDetails)" +
//                " VALUES (?, ?, ?, ?, ?)";
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setString(1, name);
//        try{
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//            LocalDate parsedDate = LocalDate.parse(request.getReqDate(), formatter);
//            statement.setDate(2, Date.valueOf(parsedDate));
//        } catch (DateTimeParseException e) {
//            System.out.println("Sai định dạng ngày, vui lòng nhập theo: dd-mm-yyyy.");
//        }
////        statement.setDate(2, date);
//        statement.setString(3, email);
//        statement.setString(4, type);
//        statement.setString(5, details);
//        int rs= statement.executeUpdate();
//        if(rs>0)
//        {
//            System.out.println("Ok");
//        }
        Connection connection = DBConnection.getConnection();
        java.sql.Date sqlDate;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate parsedDate = LocalDate.parse(date, formatter);
            sqlDate = java.sql.Date.valueOf(parsedDate);
        } catch (DateTimeParseException e) {
            System.out.println("Sai định dạng ngày, vui lòng nhập theo: dd-MM-yyyy.");
            return;
        }
        String sql = "INSERT INTO ITRequest (reqName, reqDate, reqEmail, reqType, reqDetails) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setDate(2, sqlDate);
        statement.setString(3, email);
        statement.setString(4, type);
        statement.setString(5, details);

        int rs = statement.executeUpdate();
        if (rs > 0) {
            System.out.println("Request added successfully.");
        }
    }
    public ITRequest findById (String id) throws  SQLException{
        Connection connection=DBConnection.getConnection();
        String query="SELECT * FROM ITRequest WHERE reqId="+id;
        PreparedStatement statement=connection.prepareStatement(query);
        ResultSet rs=statement.executeQuery();
        ITRequest request =new ITRequest();
        while(rs.next()){
            request.setReqId(rs.getInt("reqId"));
            request.setReqName(rs.getString("reqName"));
            request.setReqDate(rs.getDate("reqDate"));
            request.setReqEmail(rs.getString("reqEmail"));
            request.setReqType(rs.getString("reqType"));
            request.setReqDetails(rs.getString("reqDetails"));
        }
        return request;
    }
}
