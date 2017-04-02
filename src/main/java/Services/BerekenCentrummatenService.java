package Services;

import Resource.BerekenCentrummaten;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Kevin Veld on 31-3-2017.
 */
@Path("/berekenCentrummaten")
public class BerekenCentrummatenService {
    @GET
    @Produces("application/json")
    @Path("{nummers}")
    public Response berekenCentrummaten(@PathParam("nummers") String data) {
        Response response;
        List<Double> list = new ArrayList<Double>();
        JSONObject object = new JSONObject();
        JSONArray multimodaal = new JSONArray();

        //checks if data only contains numeric, dots or commas
        if (data.matches("[0-9,]*")) {
            String[] numbers = data.split(",");
            BerekenCentrummaten berekenCentrummaten = new BerekenCentrummaten(list);

            //String to double
            for (String s : numbers) {
                list.add(Double.parseDouble(s));
            }

            //convert to jsonarray
            for (Double d : berekenCentrummaten.geefModaal()) {
                multimodaal.add(d);
            }

            //set central tendency
            object.put("gemiddelde", berekenCentrummaten.geefGemiddelde());
            object.put("mediaan", berekenCentrummaten.geefMediaan());
            object.put("modaal", multimodaal);

            //set response
            response = Response.status(Response.Status.OK).entity(object.toString()).build();



        } else {//set empty response
            response = Response.status(Response.Status.OK).entity(object.toString()).build();

        }
        return response;
    }
}
