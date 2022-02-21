package com.example.sevletsql;

import java.util.List;

public class ItemService  {

    private static final ItemDAO _itemDAO = new ItemDAO();

    public static int add(item item){
        return _itemDAO.add(item);
    }

    public static void adit(int id, item item){
        _itemDAO.edit(id, item);
    }

    public static void delete(int id){
        _itemDAO.delete(id);
    }

    public static List<item> getItems(){
        return _itemDAO.getItems();
    }

    public static item getItem(int id){
        return _itemDAO.getItem(id);
    }
}
