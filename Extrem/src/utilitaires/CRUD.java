package utilitaires;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class CRUD
{
	public static <T> void save(T item)
	{
		Session session = DBConnector.getSession();
		session.save(item);
		session.beginTransaction().commit();
		session.close();
	}

	public static void delete(Object item)
	{
		Session session = DBConnector.getSession();
		session.delete(item);
		session.beginTransaction().commit();
		session.close();
	}

	public static <T> T get(Class<T> type, Long id)
	{
		Session session = DBConnector.getSession();

		T toReturn = session.get(type, id);
		session.close();
		return toReturn;
	}

	public static <T> void merge(T item)
	{
		Session session = DBConnector.getSession();
		session.merge(item);
		session.beginTransaction().commit();
		session.close();
	}

	public static <T> void update(T item)
	{
		Session session = DBConnector.getSession();
		session.update(item);
		session.beginTransaction().commit();
		session.close();
	}

	public static <T> void saveOrUpdate(T item)
	{
		Session session = DBConnector.getSession();
		session.saveOrUpdate(item);
		session.beginTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> getAll(Class<T> type)
	{
		Session session = DBConnector.getSession();
		List<T> toReturn = session.createCriteria(type).list();
		session.close();
		return toReturn;
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> getWhere(Class<T> type, List<String> clauses)
	{
		Session session = DBConnector.getSession();
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