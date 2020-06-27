package ETF_principales;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class modificamos {
	
	public static void main(String[] args) {

	//obj sessionfactory
	SessionFactory miFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(fondos.class).buildSessionFactory();

	//obj session
	Session miSession=miFactory.openSession();

	try{

	//obj clientes
//	fondos fondo2=new fondos("IMAE", "Europa", 9.0); //Gracias al mapeo orm que hicimos, hibernate sabe donde tiene que ir cada uno 
	//Recuerda quitar las comillas cuando no es String. Fallo muy repetitivo
	//La gracia de Hibernate es que no vamos a tener que escribir una instrucción SQL 
	


	miSession.beginTransaction(); //Comienza la transacción

//	miSession.save(fondo2); // Guardar obj en BBDD
	
// QUERY DELETE	miSession.createQuery("delete fondos where Nombre='ZPRV'").executeUpdate();
	
	//HACEMOS CONSULTAS DE ETFS DE BAJO COSTE
/*	
	List<fondos> losfondos=miSession.createQuery("from fondos fo where fo.TER<0.15").getResultList();
	
	//mostrar
	
	recorreResultados(losfondos);
	
	losfondos=miSession.createQuery("from fondos fo where fo.TER<0.1").getResultList();
	
	recorreResultados(losfondos);
*/	
	//ACTUALIZAMOS
	
//	miSession.createQuery("update fondos set Geografia='Europa: Reino Unido, Francia, Suiza' where Nombre LIKE 'IMAE'").executeUpdate();

	//ELIMINAMOS
	
	miSession.createQuery("delete fondos where TER>0.9").executeUpdate();
	
	//Ahora podemos hacer un commit (para que todo esto se haga)
	//O un rollback 
	//En nuestro caso hacemos un commit

	miSession.getTransaction().commit(); // commit

	
	System.out.println("Registro eliminado correctamente en BBDD");

	miSession.close();

	}finally{     //Queremos que esto lo realice siempre

	miFactory.close(); // Hay que cerrarlo

	}
	
	}

	private static void recorreResultados(List<fondos> losfondos) {
		for (fondos elfondo:losfondos) {
			
			System.out.println(elfondo);
			
		}
	}
	
}
