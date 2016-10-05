package services;

import Repositories.DummyEmployeeRepo;
import Repositories.IEmployeeRepo;
import app.Employee;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 * Created by Sander on 21-9-2016.
 */
@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {
    IEmployeeRepo employeeRepo = DummyEmployeeRepo.getInstance();

    @Context
    UriInfo uriInfo;

    @GET
    public Response getEmployee() {
        return Response.ok(employeeRepo.getEmployees()).build();
    }

    @GET
    @Path("/{id}")
    public Response getEmployee(@PathParam("id") String id) {
        return Response.ok(employeeRepo.getEmployee(id)).build();
    }

    @POST
    @Consumes("application/json")
    public Response addEmployee(Employee employee) {
        employeeRepo.addEmployee(employee);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(employee.getCode());
        return Response.created(builder.build()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEmployee(@PathParam("id") String id) {
        employeeRepo.deleteEmployee(id);
        return Response.ok().build();

    }
}
