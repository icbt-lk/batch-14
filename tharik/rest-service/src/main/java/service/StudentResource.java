/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.google.gson.Gson;
import icbt.Student;
import icbt.Utils;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {

    private final Gson gson = new Gson();

    // =========================
    // GET all students
    // GET /students
    // =========================
    @GET
    public Response getAllStudents() {
        List<Student> students = Utils.getStudents();
        return Response
                .status(Response.Status.OK)
                .entity(gson.toJson(students))
                .build();
    }

    // =========================
    // GET student by ID
    // GET /students/{id}
    // =========================
    @GET
    @Path("/{id}")
    public Response getStudent(@PathParam("id") int id) {
        Student st = Utils.getStudent(id);

        if (st == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("{\"message\":\"Student not found\"}")
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(gson.toJson(st))
                .build();
    }

    // =========================
    // ADD student
    // POST /students
    // =========================
    @POST
    public Response addStudent(String json) {
        Student st = gson.fromJson(json, Student.class);

        boolean added = Utils.addStudent(st);

        if (!added) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("{\"message\":\"Student not added\"}")
                    .build();
        }

        return Response
                .status(Response.Status.CREATED)
                .entity("{\"message\":\"Student added successfully\"}")
                .build();
    }

    // =========================
    // UPDATE student
    // PUT /students/{id}
    // =========================
    @PUT
    @Path("/{id}")
    public Response updateStudent(@PathParam("id") int id, String json) {
        Student st = gson.fromJson(json, Student.class);
        st.setId(id); // ensure path ID is used

        boolean updated = Utils.updateStudent(st);

        if (!updated) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("{\"message\":\"Student not found or not updated\"}")
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity("{\"message\":\"Student updated successfully\"}")
                .build();
    }

    // =========================
    // DELETE student
    // DELETE /students/{id}
    // =========================
    @DELETE
    @Path("/{id}")
    public Response deleteStudent(@PathParam("id") int id) {
        boolean deleted = Utils.deleteStudent(id);

        if (!deleted) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("{\"message\":\"Student not found\"}")
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity("{\"message\":\"Student deleted successfully\"}")
                .build();
    }
}
