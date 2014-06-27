<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of Router
 *
 * @author Vincent
 */
class Router {

    private $routes = array();

    public function add_routes($routes) {
        $this->routes = $routes;
    }

    public function execute_url() {
        $route_browsed = htmlspecialchars($_GET['route']);
        
        if($this->routes[$route_browsed]){
            call_user_func($this->routes[$route_browsed]);
        }else{
            print "Page not found 404";
        }
     
    }

}
