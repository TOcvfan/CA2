/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Entity.Address;
import Entity.CityInfo;
import Entity.Company;
import Entity.InfoEntity;
import Entity.Phone;
import Facade.Facade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    Company co = new Company();
    Address a = new Address();
    CityInfo ci = new CityInfo();
    Phone ph = new Phone();
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
    public String getCompany(@PathParam("id") String cvr) {
        company = facade.getCompany(cvr);
        
        Gson gson = new Gson();
        JsonObject response = new JsonObject();
        
        response.addProperty("CVR", company.getCvr());
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
    
    @POST
    public String createCompany(String content){
        JsonObject request = parser.parse(content).getAsJsonObject();
        String eMail = request.get("eMail").getAsString();
        String street = request.get("street").getAsString();
        String zip = request.get("zip").getAsString();
        String additionalInfo = request.get("additionalInfo").getAsString();
        String name = request.get("name").getAsString();
        String descrip = request.get("description").getAsString();
        String cvr = request.get("cvr").getAsString();
        String numEmployees = request.get("description").getAsString();
        String marketValue = request.get("description").getAsString();
        String phone = request.get("phone").getAsString();
        String description = request.get("description").getAsString();
        
        ci.setZip(zip);
        a = new Address(street, ci, additionalInfo);
        facade.CreateAdress(a);
        
        a.setId(a.getId());
        
        InfoEntity ie;
        ie = new InfoEntity(eMail, a);
        facade.createInfo(ie);
        
        ie.setId(ie.getId());
        
        int numOfEmployees = Integer.parseInt(numEmployees);
        int markVal = Integer.parseInt(marketValue);
        co.setIe(ie.getId());
        co = new Company(co.getIe(), name, descrip, cvr, numOfEmployees, markVal);
        facade.CreateCompany(co);
        
        ph.setIe(ie);
        ph = new Phone(phone, description, ph.getIe());
        facade.CreatePhone(ph);
        
        JsonObject response = new JsonObject();
        response.addProperty("NAME", co.getName());
        response.addProperty("cvr", co.getCvr());
        return gson.toJson(response);
    }
}
