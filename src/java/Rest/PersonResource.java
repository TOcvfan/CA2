/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Entity.Address;
import Entity.CityInfo;
import Entity.Hobby;
import Entity.InfoEntity;
import Entity.Person;
import Entity.Phone;
import Facade.Facade;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
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
@Path("person")
public class PersonResource {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    JsonParser parser = new JsonParser();
    Facade facade = new Facade();
    private static List<Person> personList;
    Person p = new Person();
    Address a = new Address();
    CityInfo ci = new CityInfo();
    Phone ph = new Phone();
    private static JsonArray list = new JsonArray();
    Person person = new Person();
    Hobby hobby = new Hobby();
    Phone phone = new Phone();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PersonResource
     */
    public PersonResource() {
    }

    /**
     * Retrieves representation of an instance of Rest.PersonResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    @Path("{id}")
    public String getPerson(@PathParam("id") int id)  {
        person = facade.getPerson(id);

        Gson gson = new Gson();
        JsonObject response = new JsonObject();

        response.addProperty("FIRSTNAME", person.getFirstname());
        response.addProperty("LASTNAME", person.getLastname());
        return gson.toJson(response);

    }

    @GET
    @Produces("application/json")
    @Path("/all")
    public String getAllPersons() {

        personList = facade.getPersons();

        Gson gson = new Gson();

        JsonObject response = new JsonObject();

        for (int i = 1; i < personList.size(); i++) {
            JsonObject main = new JsonObject();

            try {
                person = facade.getPerson(i);

                main.addProperty("FIRSTNAME", person.getFirstname());
                main.addProperty("LASTNAME", person.getLastname());
                main.addProperty("PHONE", phone.getPnumber());
                list.add(main);

            } catch (Exception e) {
            }
        }
        return gson.toJson(list);
    }

    @GET
    @Produces("application/json")
    @Path("/phone/{num}")
    public String getPerson(@PathParam("num") String phone) {
        person = facade.getPersonByPhone(phone);

        Gson gson = new Gson();
        JsonObject response = new JsonObject();

        response.addProperty("FIRSTNAME", person.getFirstname());
        response.addProperty("LASTNAME", person.getLastname());

        return gson.toJson(response);

    }

    @GET
    @Produces("application/json")
    @Path("/zip/{num}")
    public String getPersonByZip(@PathParam("num") String zip) {
        personList = facade.getPersonsByZip(zip);

        Gson gson = new Gson();
        JsonObject response = new JsonObject();

        response.addProperty("FIRSTNAME", person.getFirstname());
        response.addProperty("LASTNAME", person.getLastname());

        return gson.toJson(response);

    }

    /**
     * PUT method for updating or creating an instance of PersonResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
    @POST
    public String createPerson(String content){
        JsonElement element = parser.parse(content);
        JsonArray jArray = element.getAsJsonArray();
        
        
        
        String fName = jArray.get(0).getAsString();
        String lName = jArray.get(1).getAsString();
        String eMail =  jArray.get(2).getAsString();
        String phone =  jArray.get(3).getAsString();
        String address =  jArray.get(4).getAsString();
        String zip =  jArray.get(5).getAsString();
        String additionalInfo = jArray.get(6).getAsString();
       // String description =  jArray.get(7).getAsString();
        
        
        ci.setZip(zip);
        a = new Address(address, ci, additionalInfo);
        facade.CreateAdress(a);
        
        a.setId(a.getId());
        
        InfoEntity ie;
        ie = new InfoEntity(eMail, a);
        facade.createInfo(ie);
        
        ie.setId(ie.getId());
        
        p.setPId(ie.getId());
        p = new Person(p.getPId(), fName, lName);
        facade.createPerson(p);
        
        ph.setIe(ie);
        ph = new Phone(phone, null, ph.getIe());
        facade.CreatePhone(ph);
       
        System.out.println(content);
        JsonObject response = new JsonObject();
        response.addProperty("FIRSTNAME", person.getFirstname());
        response.addProperty("LASTNAME", person.getLastname());
        return gson.toJson("");
    }
    

}
