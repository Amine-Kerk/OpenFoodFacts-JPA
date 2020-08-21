package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CnxBdd {

	public static EntityManager getConnection() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("connection");

		EntityManager em = factory.createEntityManager();

		return em;

	}

}