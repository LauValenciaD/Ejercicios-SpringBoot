package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.models.Cliente;
import com.example.demo.models.Direccion;
import com.example.demo.service.ServiceInterface;

@SpringBootApplication
public class EjercicioBbdd6Application implements CommandLineRunner {
	@Autowired
	private ServiceInterface clienteService;
	
	public static void main(String[] args) {
		SpringApplication.run(EjercicioBbdd6Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        Direccion d1 = new Direccion("Calle Mayor 1", "Madrid");
        Direccion d2 = new Direccion("Gran Via 22", "Barcelona");
        Direccion d3 = new Direccion("Avenida del Sol 45", "Sevilla");
        Direccion d4 = new Direccion("Calle Luna 8", "Valencia");
        Direccion d5 = new Direccion("Paseo Marítimo 12", "Málaga");
        
        Cliente c1 = new Cliente("Juan Pérez", d1);
        Cliente c2 = new Cliente("Ana López", d2);
        Cliente c3 = new Cliente("Carlos Martínez", d3);
        Cliente c4 = new Cliente("Marta Sánchez", d4);
        Cliente c5 = new Cliente("Pedro Gómez", d5);
        
        clienteService.insertaCliente(c1);
        clienteService.insertaCliente(c2);
        clienteService.insertaCliente(c3);
        clienteService.insertaCliente(c4);
        clienteService.insertaCliente(c5);
		
	}

}
