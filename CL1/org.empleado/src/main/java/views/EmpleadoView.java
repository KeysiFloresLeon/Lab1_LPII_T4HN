package views;

import controllers.EmpleadoController;

public class EmpleadoView {

	public static void main(String[] args) {
		//Crear un empleado
		//String empleado = new EmpleadoController().createEmpleado("Carmona Díaz", "Luisa", "30", "Femenino", "4500");
		//String empleado = new EmpleadoController().createEmpleado("Ruiz Fernandez", "Camila", "21", "Femenino", "5500");
		//String empleado = new EmpleadoController().createEmpleado("Reyes Reyes", "Gabriela", "24", "Femenino", "4500");
		
		//Actualizar empleado
		//String empleado = new EmpleadoController().updateEmpleado(1, "Carmona", "Luisa", "31", "Femenino", "5000");
		
		//Eliminar empleado
		String empleado = new EmpleadoController().deleteEmpleado(3);
		
		System.out.println(empleado);
	}

}
