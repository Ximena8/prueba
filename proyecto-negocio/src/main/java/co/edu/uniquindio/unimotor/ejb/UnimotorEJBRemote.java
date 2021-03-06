package co.edu.uniquindio.unimotor.ejb;

import java.util.List;

import javax.ejb.Remote;

import co.edu.uniquindio.unimotor.entidades.Caracteristicas;
import co.edu.uniquindio.unimotor.entidades.Ciudad;
import co.edu.uniquindio.unimotor.entidades.Marca;
import co.edu.uniquindio.unimotor.entidades.Modelo;
import co.edu.uniquindio.unimotor.entidades.Persona;
import co.edu.uniquindio.unimotor.entidades.Pregunta;
import co.edu.uniquindio.unimotor.entidades.TipoCombustible;
import co.edu.uniquindio.unimotor.entidades.TipoVehiculo;
import co.edu.uniquindio.unimotor.entidades.Transmision;
import co.edu.uniquindio.unimotor.entidades.Vehiculo;
import co.edu.uniquindio.unimotor.excepcion.VehiculoInexistenteException;

@Remote
public interface UnimotorEJBRemote {


	void registrarPersona(Persona persona) throws Exception;

	Persona iniciarSesion(String email, String clave) throws Exception;

	void registrarVehiculo(Vehiculo vehiculo) throws Exception;

	List<Vehiculo> obtenerListaVehiculos();

	void modificarVehiculo(Vehiculo vehiculo) throws VehiculoInexistenteException;

	void eliminarVehiculo(Vehiculo vehiculo) throws VehiculoInexistenteException;

	List<Caracteristicas> obtenerListaCaracteristicas();

	List<Ciudad> obtenerListaCidades();

	List<Modelo> obtenerListaModelos();

	void enviarEmail(String asunto, String mensaje, String destinatario)throws Exception;

	Ciudad obtenerCiudad(Integer id);

	List<TipoVehiculo>  obtenerListaTiposVehiculos();

	List<TipoCombustible> obtenerListaTiposCombustible();

	List<Transmision> obtenerListaTransmision();

	Persona obtenerPersona(Integer id) throws Exception;

	Modelo obtenerModelo(Integer id);

	List<Vehiculo> buscarVehiculos(String busqueda);

	Caracteristicas obtenerCaracteristica(Integer id);

	Vehiculo obtenerVediculo(Integer id) throws Exception;

	void guardarFavorito(Persona persona, Vehiculo vehiculo);

	void eliminarFavorito(Persona persona, Vehiculo vehiculo);

	Pregunta hacerPregunta(Persona persona, Vehiculo vehiculo,String textoPregunta) throws Exception;

	List<Pregunta> obtenerPreguntasVehiculo(Integer codigoV);

	List<Caracteristicas> obtenerCaracteristicasVehiculo(Integer codigoV);

	List<Vehiculo> obtenerListaVehiculosPersona(Integer codigoP);

	Marca  obtenerMarca(Integer id) throws Exception;

	List<Marca> obtenerListaMarcas();

	List<Marca> obtenerListaMarcas(String nombre, Integer id);

	void guardarMarca(Marca marca) throws Exception;

	void eliminarMarca(Integer id) throws Exception;

	void actualizarMarca(Marca marca) throws Exception;

	boolean buscarNombreMarca(String nombreMarca);

	void guardarVehiculo(Vehiculo vehiculo) throws Exception;

	void eliminarVehiculo(Integer id) throws Exception;

	void actualizarVehiculo(Vehiculo vehiculo) throws Exception;
	
	boolean buscarNombreVehiculo(String nombreVehiculo);
	
	List<Persona> obtenerListaPersonas();
	
	List<Persona> obtenerListaPersonas(String nombre, Integer id);
	
	boolean buscarNombrePersona(String nombrePersona);
	
	void guardarPersona(Persona persona) throws Exception;

	void eliminarPersona(Integer id) throws Exception;

	void actualizarPersona(Persona persona) throws Exception;
	
	
	
	
	

}
