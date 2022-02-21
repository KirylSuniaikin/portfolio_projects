package com.example.repo;


import com.example.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long>  {//тоже что и CrudRepository, только функции зотечены под авторизацию/регистрацию

     Users findByUsername(String userName);

}
