package com.example.sevletsql;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

//DAO---помогает получить доступ к данным из базы данных
@Transactional//значит что в нутри класса будут происходить различные транзакции
public class ItemDAO {

    //подключаемся к верной базе данных
    private static final EntityManagerFactory MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    @PersistenceContext//говорит что данный объект это контекст для работы с базой данных
    private EntityManager entityManager;

    //метод добавления элементов в бд
    public int add(item item){
      entityManager = MANAGER_FACTORY.createEntityManager();//устанавливаем подключение к бд
        EntityTransaction entityTransaction=entityManager.getTransaction();//для команд без получения данных, т.е.(добавление удаление и изменению)
        entityTransaction.begin();

        entityManager.persist(item);
        entityTransaction.commit();

        return item.getId();
    }

    public void  edit(int id,item item){
        entityManager = MANAGER_FACTORY.createEntityManager();//устанавливаем подключение к бд
        EntityTransaction entityTransaction=entityManager.getTransaction();//для команд без получения данных, т.е.(добавление удаление и изменению)
        entityTransaction.begin();

        item newItem =entityManager.find(item.class, id);

        newItem.setInfo(item.getInfo());
        newItem.setPrice(item.getPrice());
        newItem.setName(item.getName());

        entityManager.persist(newItem);
        entityTransaction.commit();
    }

    public void  delete(int id){
        entityManager = MANAGER_FACTORY.createEntityManager();//устанавливаем подключение к бд
        EntityTransaction entityTransaction=entityManager.getTransaction();//для команд без получения данных, т.е.(добавление удаление и изменению)
        entityTransaction.begin();

        item newItem =entityManager.find(item.class, id);

        entityManager.remove(newItem);
        entityTransaction.commit();
    }

    public List<item> getItems(){
        entityManager = MANAGER_FACTORY.createEntityManager();//устанавливаем подключение к бд

        String query = "SELECT i FROM item i";

        TypedQuery<item> typedQuery= entityManager.createQuery(query,item.class);

        List<item> items= typedQuery.getResultList();

        return items;
    }

    public item  getItem(int id){
        entityManager = MANAGER_FACTORY.createEntityManager();//устанавливаем подключение к бд
        String query = "SELECT i FROM item i WHERE i.id= :id1";

        TypedQuery<item> typedQuery= entityManager.createQuery(query,item.class);

        typedQuery.setParameter("id1", id);

        item item = typedQuery.getSingleResult();
        System.out.println("Name: " + item.getName() +
                ", price: " + item.getPrice() +
                ", info: " + item.getInfo());

        return item;
    }

}
