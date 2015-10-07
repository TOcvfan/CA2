/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Entity.Company;
import Entity.InfoEntity;
import Entity.Person;
import Facade.Facade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.List;
import javax.persistence.metamodel.SingularAttribute;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author TOcvfan
 */
@Path("company")
public class CompanyResource {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    JsonParser parser = new JsonParser();
    Facade facade = new Facade();
    List<Company> companyList;
    Company company = new Company();
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PersonResource
     */
    public CompanyResource() {
    }

    /**
     * Retrieves representation of an instance of Rest.PersonResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    @Path("{id}")
    public String getPerson(@PathParam("id") String cvr) {
        company = facade.getCompany(cvr);
        
        Gson gson = new Gson();
        JsonObject response = new JsonObject();

        response.addProperty("NAME", company.getName());
        
        return gson.toJson(response);
        
    }
    

    /**
     * PUT method for updating or creating an instance of PersonResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
