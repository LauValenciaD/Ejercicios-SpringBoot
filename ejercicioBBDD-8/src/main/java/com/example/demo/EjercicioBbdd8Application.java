package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.models.Perfil;
import com.example.demo.models.Usuario;
import com.example.demo.service.ServiceInterface;

@SpringBootApplication
public class EjercicioBbdd8Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EjercicioBbdd8Application.class, args);
	}

		@Autowired
		ServiceInterface usuarioService;

		@Override
		public void run(String... args) throws Exception {

			
			
			// 1.	Insertar el usuario con nombre Pepe Ruiz y correo ppruiz@gmail.com.
			//Con biografia ‘perfildepepe’ y estado DISPONIBLE.
			System.out.println("*****************1************************");

			Perfil perf1= new Perfil("perfildepepe","DISPONIBLE");
			Usuario usu1 = new Usuario("Pepe Ruiz", "ppruiz@gmail.com", perf1);
			
			usuarioService.insertaUsuario(usu1);
			
			//2.	Insertar el usuario con nombre Andrés Ramírez y correo aramirez@gmail.com. 
			//Con biografia ‘perfildeandres’ y estado NO DISPONIBLE
			System.out.println("*****************2************************");
			Perfil perf2= new Perfil("perfildeandres","NO DISPONIBLE");
			Usuario usu2 = new Usuario("Andrés Ramírez", "aramirez@gmail.com", perf2);
			
			usuarioService.insertaUsuario(usu2);
			//3.	Mostrar la lista de todos los usuarios 	
			System.out.println("*****************3************************");
			mostrarUsuarios();
			//4.	Obtener los datos del usuario con el id de Andrés.
			System.out.println("*****************4************************");
			Usuario usu = usuarioService.getUsuario(usu2.getId());
			System.out.println(usu);
			
			//5.	Dado el id de Pepe Ruiz, actualizar sus datos: correo ppruiz2@gmail.com y estado NO DISPONIBLE
			
			
			
			usu = usuarioService.getUsuario(usu1.getId());
			usu.setEmail("ppruiz2@gmail.com");
			usu.getPerfil().setEstado("NO DISPONIBLE");
			usuarioService.patchUsuario(usu, usu1.getId());		
			
			//6.	Mostrar la lista de todos los usuarios y comprobar la actualización.
			System.out.println("*****************6************************");
			mostrarUsuarios();
			
			//7.	Obtener el perfil de Andrés.
			System.out.println("*****************7************************");
			usu = usuarioService.getUsuario(usu2.getId());
			System.out.println(usu.getPerfil());
			
			//8.	Mostrar la lista de todos los usuarios cuya biografía contenga la palabra ‘perfil’.
			System.out.println("*****************8************************");
			List<Usuario> lista = usuarioService.usuariosBiografia("perfil");
			for (Usuario usuario : lista) {
				System.out.println(usuario);
			}
			
			//9.	Mostrar el primer usuario disponible.
			System.out.println("*****************9************************");
			System.out.println(usuarioService.obtenerDisponible());
			
			//10.	Mostrar todos los usuarios no disponibles
			System.out.println("*****************10************************");
			
			lista = usuarioService.obtenerNoDisponible();
			for (Usuario usuario : lista) {
				System.out.println(usuario);
			}
			
			//11.	Actualizar todos los usuarios a disponibles.
			//System.out.println("*****************11************************");
			//usuarioService.actualizarUsuariosTodosDisponibles();
			//mostrarUsuarios();
			
			//12.	Eliminar el usuario de Pepe.
			
			System.out.println("*****************12************************");
			usuarioService.deleteUsuario(usu1.getId());
			mostrarUsuarios();
			//13 Modificar el perfil de Andrés: Con biografia ‘perfildeandresModificado’ y estado NO DISPONIBLE.
			Perfil p = new Perfil();
			p.setBio("perfildeandresModificado");
			p.setEstado("NO DISPONIBLE");
			usuarioService.actualizarPerfil(usu2.getId(), p);
			mostrarUsuarios();
			
		}

		private void mostrarUsuarios() {

			List<Usuario> usuarios = usuarioService.getUsuarios();
			for (Usuario usu : usuarios) {
				System.out.println(usu);
			}
		}

	}

