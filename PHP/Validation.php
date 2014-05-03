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

class Validation {

    public static function valid_email($email) {
        $valid = false;
        $at = strpos($email, '@');
        if ($at != false) {
            $valid = true;
        }
        return $valid;
    }

    public static function valid_input($input) {
        $valid = true;
        if(is_array($input)){
            foreach($input as $item){
                if(!Validation::check_empty($item)){
                    return false;
                }
            }
        }else{
            $valid = Validation::check_empty($input);
        }
        return $valid;
    }
    
    private static function check_empty($input){
        if(!empty($input)){
            return true;
        }
        return false;
    }

}
