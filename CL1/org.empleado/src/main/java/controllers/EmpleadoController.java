package controllers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Empleado;

public class EmpleadoController{

	public String createEmpleado(String apellidos, String nombres, String edad, String sexo, String salario) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		try {
			Empleado empleado = new Empleado(apellidos, nombres, edad, sexo, salario);
			session.beginTransaction();
			session.save(empleado);
			session.getTransaction().commit();
			sessionFactory.close();
			return "Empleado creado";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Error al registrar empleado";
	}
	
	public String deleteEmpleado(int idempleado) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Empleado empleado = session.get(Empleado.class, idempleado);
			session.delete(empleado);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Empleado eliminado correctamente";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error al eliminar el empleado";
	}
	
	public String updateEmpleado(int idempleado, String apellidos, String nombres, String edad, String sexo, String salario) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Empleado empleado = session.get(Empleado.class, idempleado);
			empleado.setApellidos(apellidos);
			empleado.setNombres(nombres);
			empleado.setEdad(edad);
			empleado.setSexo(sexo);
			empleado.setSalario(salario);
			session.update(empleado);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Empleado actualizado correctamente";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error al actualizar empleado";
	}
	
}
