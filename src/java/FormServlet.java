import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentName = request.getParameter("name");
        String rollNo = request.getParameter("roll-no");
        String branch = request.getParameter("branch");
        int year = Integer.parseInt(request.getParameter("year"));
        int semester = Integer.parseInt(request.getParameter("semester"));
        String teacher = request.getParameter("teacher");
        String feedbackDate = request.getParameter("feedback-date");
        int q1 = Integer.parseInt(request.getParameter("q1"));
        int q2 = Integer.parseInt(request.getParameter("q2"));
        int q3 = Integer.parseInt(request.getParameter("q3"));
        int q4 = Integer.parseInt(request.getParameter("q4"));        
        int q5 = Integer.parseInt(request.getParameter("q5"));        
        int q6 = Integer.parseInt(request.getParameter("q6"));
        int q7 = Integer.parseInt(request.getParameter("q7"));
        int q8 = Integer.parseInt(request.getParameter("q8"));


// Get other ratings similarly

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/niet", "root", "server");
            String sql = "INSERT INTO teacherevaluation (student_name, roll_no, branch, year, semester, teacher, feedback_date, q1, q2, q3, q4, q5, q6, q7, q8) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, studentName);
            statement.setString(2, rollNo);
            statement.setString(3, branch);
            statement.setInt(4, year);
            statement.setInt(5, semester);
            statement.setString(6, teacher);
            statement.setString(7, feedbackDate);
            statement.setInt(8, q1);
            statement.setInt(9, q2);
            statement.setInt(10, q3); 
            statement.setInt(11, q4); 
            statement.setInt(12, q5); 
            statement.setInt(13, q6); 
            statement.setInt(14, q7); 
            statement.setInt(15, q8);             


// Set other parameters similarly
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new evaluation form was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
