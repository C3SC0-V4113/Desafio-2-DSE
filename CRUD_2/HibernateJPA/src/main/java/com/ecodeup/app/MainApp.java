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
			System.out.println("1. Crear Producto");
			System.out.println("2. Buscar Producto");
			System.out.println("3. Actualizar Producto");
			System.out.println("4. Eliminar Producto");
			System.out.println("5. Salir");
			System.out.println("Elija una opción:");

			opcion = scanner.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Digite el nombre del producto:");
				videojuego = new Videojuego();
				videojuego.setId(0);
				scanner.nextLine();
				videojuego.setNombre(scanner.nextLine());

				System.out.println(videojuego);
				entity.getTransaction().begin();
				entity.persist(videojuego);
				entity.getTransaction().commit();
				System.out.println("Producto registrado..");
				System.out.println();
				break;

			case 2:
				System.out.println("Digite el id del producto a buscar:");
				videojuego = new Videojuego();
				videojuego = entity.find(Videojuego.class, scanner.nextLong());
				if (videojuego != null) {
					System.out.println(videojuego);
					System.out.println();
				} else {
					System.out.println();
					System.out.println("Producto no encontrado... Lista de productos completa");
					List<Videojuego> listaVideojuegos= new ArrayList<>();
					Query query=entity.createQuery("SELECT p FROM Producto p");
					listaVideojuegos=query.getResultList();
					for (Videojuego v : listaVideojuegos) {
						System.out.println(v);
					}
					
					System.out.println();
				}

				break;
			case 3:
				System.out.println("Digite el id del producto a actualizar:");
				videojuego = new Videojuego();

				videojuego = entity.find(Videojuego.class, scanner.nextLong());
				if (videojuego != null) {
					System.out.println(videojuego);
					System.out.println("Digite el nombre del producto:");
					scanner.nextLine();
					videojuego.setNombre(scanner.nextLine());
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

				videojuego = entity.find(Videojuego.class, scanner.nextLong());
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
