<?php

/* 
 * Copyright (C) 2014 Vincent.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */

include_once 'Lib/Database.php';

class Security extends Database{

    private static function create_salt(){
        return sha1(openssl_random_pseudo_bytes(rand(10, 15)));
    }
    public static function getSalt($pass){
        return explode(".", $pass)[0];
    }
    public static function encrypt($input){
        $salt = Security::create_salt();
        $encrypted = $salt . "." . sha1($salt . sha1($input));
        return $encrypted;
    }
    public static function generate_from_input($input, $salt){
        $encrypted = $salt . "." . sha1($salt . sha1($input));
        return $encrypted;
    }
    public function get_pass($email){
        $pass_statement = $this->connection->prepare("select pass from users where email = :email");
        $pass_statement->bindParam('email', $email);
        $pass_statement->execute();
        
        $output = $pass_statement->fetchAll();
        foreach($output as $row){
            $pass = (string) $row['pass'];
        }
        if(isset($pass)){
            return $pass;
        }
    }
    public function compare($pass, $email){
        $stored_pass = $this->get_pass($email);

        $salt = Security::getSalt($stored_pass);
        $generated_from_input = Security::generate_from_input($pass, $salt);
        
        if($stored_pass == $generated_from_input){
            return true;
        }else{
            return false;
        }
    }
    
    
}