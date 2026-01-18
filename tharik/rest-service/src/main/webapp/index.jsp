<%@page import="java.util.List"%>
<%@page import="icbt.Student"%>
<%@page import="icbt.Utils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student List</title>

        <style>
            body {
                font-family: Arial, Helvetica, sans-serif;
                background-color: #f4f6f8;
                padding: 40px;
            }

            .student-table {
                border-collapse: collapse;
                width: 70%;
                margin: auto;
                background-color: #ffffff;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            }

            .student-table caption {
                caption-side: top;
                font-size: 1.4em;
                font-weight: bold;
                margin-bottom: 15px;
            }

            .student-table th,
            .student-table td {
                padding: 12px 16px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }

            .student-table th {
                background-color: #2c3e50;
                color: #ffffff;
                text-transform: uppercase;
                letter-spacing: 0.05em;
            }

            .student-table tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            .student-table tr:hover {
                background-color: #e6f2ff;
            }
        </style>
    </head>

    <body>
        <%
            List<Student> students = Utils.getStudents();

            out.print("<table class='student-table'>");
            out.print("<caption>Student Details</caption>");
            out.print("<tr>");
            out.print("<th>ID</th>");
            out.print("<th>Name</th>");
            out.print("<th>Date of Birth</th>");
            out.print("</tr>");

            for (Student st : students) {
                out.print("<tr>");
                out.print("<td>" + st.getId() + "</td>");
                out.print("<td>" + st.getName() + "</td>");
                out.print("<td>" + st.getDateOfBirth() + "</td>");
                out.print("</tr>");
            }

            out.print("</table>");
        %>
    </body>
</html>
