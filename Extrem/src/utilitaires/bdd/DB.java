package utilitaires.bdd;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Projections;

import utilitaires.ExtremError;

public class DB
{
	static SessionFactory sessionFactory;

	static
	{
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("utilitaires/bdd/hibernate.cfg.xml").build();
		try
		{
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}
		catch (Exception e)
		{
			StandardServiceRegistryBuilder.destroy(registry);
			new ExtremError(e);
		}
	}

	public static <T> void create(T item)
	{
		Session session = sessionFactory.openSession();
		session.save(item);
		session.beginTransaction().commit();
		session.close();
	}

	public static <T> T read(Class<T> type, Long id)
	{
		Session session = sessionFactory.openSession();
		T toReturn = session.get(type, id);
		session.close();
		return toReturn;
	}

	public static <T> void update(T item)
	{
		Session session = sessionFactory.openSession();
		session.update(item);
		session.beginTransaction().commit();
		session.close();
	}

	public static void delete(Object item)
	{
		Session session = sessionFactory.openSession();
		session.delete(item);
		session.beginTransaction().commit();
		session.close();
	}

	public static <T> void createOrUpdate(T item)
	{
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(item);
		session.beginTransaction().commit();
		session.close();
	}

	public static <T> long count(Class<T> type)
	{
		Session session = sessionFactory.openSession();
		long count = 0;
		try
		{
			count = ((Number) session.createCriteria(type).setProjection(Projections.rowCount()).uniqueResult()).longValue();
		}
		catch (Exception e)
		{
			count = -1;
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> readAll(Class<T> type)
	{
		Session session = sessionFactory.openSession();
		List<T> toReturn = session.createCriteria(type).list();
		session.close();
		return toReturn;
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> readWhere(Class<T> type, List<String> clauses)
	{
		Session session = sessionFactory.openSession();
		String hql = "FROM " + type.getName();
		if (clauses.size() >= 0)
			hql += " WHERE ";

		String clausesString = "";
		for (String clause : clauses)
		{
			if (!clausesString.equals(""))
				clausesString += " AND ";
			clausesString += clause;
		}
		hql += clausesString;
		Query query = session.createQuery(hql);
		List<T> toReturn = query.list();
		session.close();
		return toReturn;
	}
}