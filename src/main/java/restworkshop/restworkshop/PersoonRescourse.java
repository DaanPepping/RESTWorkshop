package restworkshop.restworkshop;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.json.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/personen")
public class PersoonRescourse {
	PersoonService service = ServiceProvider.getPersoonService();
	
	@GET
	@Produces("application/json")
	public String geefPersonen() {
		PersoonService service = ServiceProvider.getPersoonService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Persoon p : service.geefAllePersonen()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("voornaam", p.getVoornaam());
			job.add("achternaam", p.getAchternaam());
			job.add("leeftijd", p.getLeeftijd());
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@DELETE
	@Path("{voornaam}")
	@Produces("application/json")
	public Response deletePersoon(@PathParam("voornaam") String voornaam) {
		if (!service.deletePersoon(voornaam)) {
			return Response.status(404).build();
		} else {
			return null;
		}
		
		
	}
	
	@POST
	@Produces("application/json")
	public Response addPersoon(@FormParam("firstname") String voornaam,
								@FormParam("lastname") String achternaam,
								@FormParam("dateofbirth") int leeftijd){
			Boolean persoon = service.addPersoon(voornaam, achternaam, leeftijd);
			return Response.ok().build();
	}
	
	@PUT
	@Path("{voornaam}")
	@Produces("application/json")
	public Response updatePersoon(@FormParam("firstname") String voornaam,
								@FormParam("lastname") String achternaam,
								@FormParam("dateofbirth") int leeftijd){
		
			Boolean persoon = service.updatePersoon(voornaam, achternaam, leeftijd);
			return Response.ok().build();
	}
}