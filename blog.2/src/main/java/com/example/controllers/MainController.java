package com.example.controllers;


import com.example.models.Reviews;
import com.example.models.Role;
import com.example.models.Users;
import com.example.repo.ReviewRepository;
import com.example.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Map;


@Controller//создание именно контроллера
public class MainController {

    @Autowired// переменная, ссыляаемая на модель Reviews
    private ReviewRepository reviewRepository;

    @Autowired// переменная, ссыляаемая на модель User
    private UserRepository userRepository;

    @GetMapping("/")//для отслеживания перехода на главную страницу
    public String home(Map<String, Object> model)    //(@RequestParam(name= "userName", required = false, defaultValue = "World") String userName, Model model)
    // @RequestParam-- получаем параметры из url адресса
    {
        model.put("name", "world"); //??в name передаем значение полученое в userName выше
        return "home";// вернет html страницу
    }

    @GetMapping("/about") //отслеживание перезода на главную страницу
    public String about(Map<String, Object> model) {//Map<String, Object> model--для передачи данных в шаблон
        model.put("title", "Page about us "); //??в name передаем значение полученое в userName выше
        return "about";// вернет html страницу
    }

    @GetMapping("/reviews") //отслеживание перезода на главную страницу
    public String reviews(Map<String, Object> model) {//Map<String, Object> model--для передачи данных в шаблон
        Iterable<Reviews> reviews = reviewRepository.findAll();//Iterable создан для списка, в котором может быть множество записей
        model.put("title", "Page with reviews "); //??в name передаем значение полученое в userName выше
        model.put("reviews", reviews);
        return "reviews";// вернет html страницу
    }

    @PostMapping("/reviews-add")//метод предачи post
    public String reviewAdd(@RequestParam String title, @RequestParam String text, Map<String, Object> model) {
        Reviews reviews = new Reviews(title, text);
        reviewRepository.save(reviews); //добавляет запись
        return "redirect:/reviews";//переодресация
    }

    @GetMapping("reviews/{id}")
    public String reviewInfo(@PathVariable(value = "id") long reviewId, Map<String, Object> model) {//@PathVariable-- получение параметра из url адреса
        // Map<String, Object> model--для передачи данных в шаблон
        Optional<Reviews> review = reviewRepository.findById(reviewId);//возвращает запись по id. Optional- для одной записи
        ArrayList<Reviews> result = new ArrayList<>();
        review.ifPresent(result::add);// помещаем review в массив
        model.put("review", result);//передаем значение в шаблон
        return "review-info";
    }

    @GetMapping("/reviews/{id}/update")
    public String reviewUpdate(@PathVariable(value = "id") long reviewId, Map<String, Object> model) {//@PathVariable-- получение параметра из url адреса
        Optional<Reviews> review = reviewRepository.findById(reviewId);//возвращает запись по id. Optional- для одной записи
        ArrayList<Reviews> result = new ArrayList<>();
        review.ifPresent(result::add);// помещаем review в массив
        model.put("review", result);//передаем значение в шаблон
        return "review-update";
    }

    @PostMapping("/reviews/{id}/update")//метод получения данных из формы
    public String reviewUpdateForm(@PathVariable(value = "id") long reviewId, @RequestParam String title,  @RequestParam String text, Map<String, Object> model) throws ClassNotFoundException{
      Reviews reviews= reviewRepository.findById(reviewId).orElseThrow(()-> new ClassNotFoundException());//вызывает ошибку из класса если запись будет не найдена
        reviews.setTitle(title);
       reviews.setText(text);
        reviewRepository.save(reviews); //обновляет запись
        return "redirect:/reviews/" + reviewId;//переодресация
    }

    @PostMapping("/reviews/{id}/delete")//метод получения данных из формы
    public String reviewDelete(@PathVariable(value = "id") long reviewId, Map<String, Object> model) throws ClassNotFoundException{
        Reviews reviews= reviewRepository.findById(reviewId).orElseThrow(()-> new ClassNotFoundException());//вызывает ошибку из класса если запись будет не найдена

        reviewRepository.delete(reviews);

        return "redirect:/reviews";//переодресация
    }

    @GetMapping("/reg")
    public  String reg() {
        return "reg";
    }

    @PostMapping("/reg")
    public String addUser(Users user, Map<String, Object> model){
        user.setEnabled(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        return "redirect:/login";//переодресация
    }
}