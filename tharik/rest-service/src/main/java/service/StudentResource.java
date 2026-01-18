/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.google.gson.Gson;
import icbt.Student;
import icbt.Utils;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author hd
 */
@Path("students")
public class StudentResource {
    @GET
    public Response ping(){
        List<Student> students = Utils.getStudents();
        Gson gson = new Gson();
        return Response
               .status(200)
               .entity(gson.toJson(students))
               .build();  
    }
}
