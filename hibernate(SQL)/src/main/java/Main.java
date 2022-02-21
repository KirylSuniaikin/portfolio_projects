import javax.persistence.*;
import javax.persistence.EntityManager;
import java.util.List;

public class Main {

    //private static final EntityManagerFactory MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    public static void main(String[] args) {
        //addItems("Minecraft", 100, "Microsoft");
      //  addItems("Яблоко", 10, "Нужно подкрепиться");
      //  addItems("Малина", 15, "Вкусно и полезно!");
      //  addItems("Смородина", 13, "Кайф");
        //getItem(2);
       // getItems();
       // deleteItem(1);
       // editItem(2, 500, "Изменные значения");
        //MANAGER_FACTORY.close();


       // item item = new item("Coffee", 25, " Tasty coffee");
       // int id= ItemService.add(item);


      //  item item = new item("Coffee", 25, " Cold coffee");
      //  ItemService.adit(6, item);


       // ItemService.delete(6);

        ItemService.getItems();

        ItemService.getItem(3);
    }

  //  private static void editItem(int id, int price, String info){
  //      EntityManager entityManager = MANAGER_FACTORY.createEntityManager();
  //      EntityTransaction entityTransaction=null;//для команд без получения данных, т.е.(добавление удаление и изменению)
  //      item item= null;
//
  //      try{
  //          entityTransaction= entityManager.getTransaction();
  //          entityTransaction.begin();
//
  //          item= entityManager.find(item.class, id);//ищет объект в определенном калссе
  //          item.setInfo(info);//изменение значений в найденом объекте
  //          item.setPrice(price);
  //          entityManager.persist(item);//помогает не только добавить новую запись, но также и обновить
  //          // (если существует запись с таким id,то обновит, если нет, то создаст)
  //          entityTransaction.commit();
//
  //      }catch (Exception ex){
  //          ex.printStackTrace();//вывод ошибки на экран
  //          if(entityTransaction != null)
  //              entityTransaction.rollback();
  //      }finally {
  //          entityManager.close();
  //      }
//
  //  }
//



  //  private static void deleteItem(int id){
  //      EntityManager entityManager = MANAGER_FACTORY.createEntityManager();
  //      EntityTransaction entityTransaction=null;//для команд без получения данных, т.е.(добавление удаление и изменению)
  //      item item= null;
//
  //      try{
  //      entityTransaction= entityManager.getTransaction();
  //      entityTransaction.begin();
//
  //      item= entityManager.find(item.class, id);//ищет объект в определенном калссе
  //      entityManager.remove(item);//удаление объекта
  //          entityTransaction.commit();
//
  //      }catch (Exception ex){
  //          ex.printStackTrace();//вывод ошибки на экран
  //          if(entityTransaction != null)
  //              entityTransaction.rollback();
  //      }finally {
  //          entityManager.close();
  //      }
//
  //  }




  //  private static void getItem(int id){
  //      EntityManager entityManager = MANAGER_FACTORY.createEntityManager();
//
  //      String query = "SELECT i FROM item i WHERE i.id= :id1";//выбираем все объкты из класса  item и они будут доступны под псевдонимом i
  //      // ":id1" -- заглушки, то есть не четкие значения в запросе.  Их после будет задавать пользователь
  //      TypedQuery<item> typedQuery= entityManager.createQuery(query, item.class);// строчка для выполнения по строчке выше sql команды
  //      typedQuery.setParameter("id1", id);//подставляем значения в заглушки
  //      item item=null;
  //      try{
  //          item= typedQuery.getSingleResult();//позволяет получить результат запроса в виде одной записи
  //         System.out.println("Name: " + item.getName() +
  //                 ", price: " + item.getPrice() +
  //                 ", info: " + item.getInfo());
  //      }catch (Exception ex){
  //          ex.printStackTrace();
  //      }finally {
  //          entityManager.close();
  //      }
  //  }




  //  private static void getItems(){
  //      EntityManager entityManager = MANAGER_FACTORY.createEntityManager();
//
  //      String query = "SELECT i FROM item i WHERE i.id> :id1 AND i.id< :id2";//выбираем все объкты из класса  item и они будут доступны под псевдонимом i
  //                                                                              // ":id1" -- заглушки, то есть не четкие значения в запросе.  Их после будет задавать пользователь
  //      TypedQuery<item> typedQuery= entityManager.createQuery(query, item.class);// строчка для выполнения по строчке выше sql команды
  //      typedQuery.setParameter("id1", 1);//подставляем значения в заглушки
  //      typedQuery.setParameter("id2", 4);
  //      List<item> items;
  //      try{
  //          items= typedQuery.getResultList();//позволяет получить результат запроса в виде листа
  //          for(item item: items) System.out.println("Name: " + item.getName() +
  //                  ", price: " + item.getPrice() +
  //                  ", info: " + item.getInfo());
  //      }catch (Exception ex){
  //          ex.printStackTrace();
  //      }finally {
  //          entityManager.close();
  //      }
  //  }



  //  public static void addItems(String name, int price, String info) {
  //      EntityManager entityManager = MANAGER_FACTORY.createEntityManager();
//
  //      EntityTransaction entityTransaction = null;
//
  //      try {
  //          entityTransaction = entityManager.getTransaction();
  //          entityTransaction.begin();
//
  //          item item = new item (name, price, info);
  //          entityManager.persist(item);
  //          entityTransaction.commit();
  //      } catch (Exception e) {
  //          if(entityTransaction != null)
  //              entityTransaction.rollback();
//
  //          e.printStackTrace();
  //      } finally {
  //          entityManager.close();
  //      }
  //  }



}
