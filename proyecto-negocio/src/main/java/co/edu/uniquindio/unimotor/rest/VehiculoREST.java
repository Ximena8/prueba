package co.edu.uniquindio.unimotor.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.edu.uniquindio.unimotor.ejb.UnimotorEJB;
import co.edu.uniquindio.unimotor.entidades.Vehiculo;

@Path("/vehiculos")
public class VehiculoREST {
	
	@EJB
	private UnimotorEJB unimotorEJB;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response obtenerVehiculos(){
		return Response.status(200).entity(unimotorEJB.obtenerListaVehiculos()).build();

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response obtenerVehiculo( @PathParam("id") Integer id) {
		try {
			Vehiculo vehiculo =  unimotorEJB.obtenerVediculo(id);
			return Response.status(200).entity(vehiculo).build();
		} catch (Exception e) {
			return Response.status(500).entity("{ \"mensaje\" :	\""+e.getMessage()+"\" }").type(MediaType.APPLICATION_JSON).build();
		}
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response registrarVehiculo(Vehiculo vehiculo) {
		try {
			unimotorEJB.guardarVehiculo(vehiculo);
			return Response.status(200).entity("{ \"mensaje\" : \"El vehiculo se registr� correctamente\" }").type(MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			return Response.status(500).entity("{ \"mensaje\" :	\""+e.getMessage()+"\" }").type(MediaType.APPLICATION_JSON).build();
		}

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response acutalizarVehiculo(Vehiculo vehiculo) {
		try {
			unimotorEJB.actualizarVehiculo(vehiculo);
			return Response.status(200).entity("{ \"mensaje\" : \"El veh�culo se actualiz� correctamente\" }").type(MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			return Response.status(500).entity("{ \"mensaje\" :	\""+e.getMessage()+"\" }").type(MediaType.APPLICATION_JSON).build();
		}

	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response eliminarVehiculo(@PathParam("id") Integer idVehiculo) {
		try {
			unimotorEJB.eliminarVehiculo( idVehiculo);
			return Response.status(200).entity("{ \"mensaje\" : \"El vehiculo se elimin� correctamente\" }").type(MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			return Response.status(500).entity("{ \"mensaje\" :	\""+e.getMessage()+"\" }").type(MediaType.APPLICATION_JSON).build();
		}

	}

}
