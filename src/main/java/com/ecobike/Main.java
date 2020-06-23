package com.ecobike;

import com.ecobike.controller.IndexController;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Ecobike test task!");
        IndexController indexController = new IndexController();
        indexController.init();
        indexController.service();
    }
}
