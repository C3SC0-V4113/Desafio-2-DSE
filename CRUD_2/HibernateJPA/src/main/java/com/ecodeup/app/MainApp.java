package com.ecodeup.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ecodeup.model.Videojuego;


public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion = 0;
		Scanner scanner = new Scanner(System.in);
		Videojuego videojuego;

		EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
		while (opcion!=5) {
			System.out.println("1. Añadir Videojuego");
			System.out.println("2. Buscar Videojuego");
			System.out.println("3. Actualizar Videojuego");
			System.out.println("4. Eliminar Videojuego");
			System.out.println("5. Salir");
			System.out.println("Elija una opción:");

			opcion = scanner.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Digite el nombre del videojuego:");
				videojuego = new Videojuego();
				videojuego.setId(0);
				scanner.nextLine();
				videojuego.setNombre(scanner.nextLine());
				
				System.out.println("Digite el director del videojuego:");
				videojuego.setDirector(scanner.nextLine());

				System.out.println("Digite el nombre del estudio desarrollador:");
				videojuego.setEstudio(scanner.nextLine());
				
				System.out.println("Digite el genero del videojuego:");
				videojuego.setGenero(scanner.nextLine());
				
				System.out.println("Digite el año de salida del videojuego:");
				videojuego.setAño(scanner.nextInt());
				
				
				System.out.println("Digite la nota en Metacritic del videojuego:");
				videojuego.setMetacritic(scanner.nextInt());

				
				System.out.println(videojuego);
				entity.getTransaction().begin();
				entity.persist(videojuego);
				entity.getTransaction().commit();
				System.out.println("Producto registrado..");
				System.out.println();
				break;

			case 2:
				System.out.println("Digite el id del videojuego a buscar:");
				videojuego = new Videojuego();
				videojuego = entity.find(Videojuego.class, scanner.nextInt());
				if (videojuego != null) {
					System.out.println(videojuego);
					System.out.println();
				} else {
					System.out.println();
					System.out.println("Videojuego no encontrado... Lista de videojuegos completa");
					List<Videojuego> listaVideojuegos= new ArrayList<>();
					Query query=entity.createQuery("SELECT v FROM videojuegos v");
					listaVideojuegos=query.getResultList();
					for (Videojuego v : listaVideojuegos) {
						System.out.println(v);
					}
					
					System.out.println();
				}

				break;
			case 3:
				System.out.println("Digite el id del videojuego a actualizar:");
				videojuego = new Videojuego();

				videojuego = entity.find(Videojuego.class, scanner.nextInt());
				if (videojuego != null) {
					System.out.println(videojuego);
					System.out.println("Digite el nombre del producto:");
					scanner.nextLine();
					videojuego.setNombre(scanner.nextLine());
					System.out.println("Digite el director del videojuego:");
					videojuego.setDirector(scanner.nextLine());

					System.out.println("Digite el nombre del estudio desarrollador:");
					videojuego.setEstudio(scanner.nextLine());
					
					System.out.println("Digite el genero del videojuego:");
					videojuego.setGenero(scanner.nextLine());
					
					System.out.println("Digite el año de salida del videojuego:");
					videojuego.setAño(scanner.nextInt());
					
					System.out.println("Digite la nota en Metacritic del videojuego:");
					videojuego.setMetacritic(scanner.nextInt());
					
					entity.getTransaction().begin();
					entity.merge(videojuego);
					entity.getTransaction().commit();
					System.out.println("Producto actualizado..");
					System.out.println();
				} else {
					System.out.println("Producto no encontrado....");
					System.out.println();
				}
				break;
			case 4:
				System.out.println("Digite el id del producto a eliminar:");
				videojuego = new Videojuego();

				videojuego = entity.find(Videojuego.class, scanner.nextInt());
				if (videojuego != null) {
					System.out.println(videojuego);
					entity.getTransaction().begin();
					entity.remove(videojuego);
					entity.getTransaction().commit();
					System.out.println("Producto eliminado...");
				} else {
					System.out.println("Producto no encontrado...");
				}
				break;
			case 5:entity.close();JPAUtil.shutdown();
			break;

			default:
				System.out.println("Opción no válida\n");
				break;
			}
	}

}}
