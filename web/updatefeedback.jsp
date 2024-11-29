<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// Database connection parameters
String url = "jdbc:mysql://localhost:3306/niet";
String username = "root";
String password = "server";

// Get form data from request
int feedbackId = Integer.parseInt(request.getParameter("id"));
String name = request.getParameter("name");
String rollNo = request.getParameter("roll-no");
// Get other form data as needed

Connection conn = null;
PreparedStatement pstmt = null;
try {
    // Load the MySQL JDBC driver
    Class.forName("com.mysql.jdbc.Driver");

    // Establish a connection to the database
    conn = DriverManager.getConnection(url, username, password);

    // SQL query to update feedback data
    String sql = "UPDATE teacherevaluation SET student_name=?, roll_no=? WHERE id=?"; // Update query as needed
    
    // Create a PreparedStatement object to execute the SQL query
    pstmt = conn.prepareStatement(sql);

    // Set parameters for the PreparedStatement
    pstmt.setString(1, name);
    pstmt.setString(2, rollNo);
    // Set other parameters as needed
    pstmt.setInt(3, feedbackId);

    // Execute the query
    int rowsUpdated = pstmt.executeUpdate();

    // Redirect to feedback dashboard
    response.sendRedirect("feedbackdashboard.jsp");
} catch (ClassNotFoundException | SQLException e) {
    // Handle exception
    e.printStackTrace();
} finally {
    // Close the PreparedStatement and Connection objects in a finally block
    try {
        if (pstmt != null) {
            pstmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    } catch (SQLException e) {
        // Handle SQLException in closing resources
        e.printStackTrace();
    }
}
%>
