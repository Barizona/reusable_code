<?php


/**
 * \brief This class manages direct Database operations 
 * \details Classes which inherit this class will have database functionality available
 * \author Vincent De Coen
 * 
 */

abstract class Database {
    /** 
     * This is the host the database will connect to
     */
    private $host = "127.0.0.1";
     /** 
      * This is the database that the application will use
     */
    private $dbname = "mediaconn";
    /** 
     * This is the username of the database
    */
    private $user = "root";
    /** 
     * This is the password of the database
     */
    private $pass = "";
    /**
     * This is the connection which will be used in any location in spacetime.
     */
    public $connection;

    public function __construct() {
        $this->connection = $this->get_connection();
        if (!$this->connection) {
            print("connection has failed... please try again");
            return;
        }else{
            return $this->connection;
        }
    }
    
    public function __destruct() {
        $this->connection = null;
    }
    
    
    /**
     *   Create a connection to the Application database
     */
    public function get_connection() {
        try {
            return new PDO(
                    "mysql:host=$this->host;dbname=$this->dbname", $this->user, $this->pass
            );
        } catch (PDOException $ex) {
            return false;
        }
    }
    
    /**
     *   Prepares the MySQL syntax based on an array containing the items to insert and the tablename
     */
    private function prepare_insert_query($table_name, $columns){
        $query = "insert into " . $table_name . " (";
        $query = $query . implode(', ', $columns) .  
                ") values(:" . 
                implode(', :', $columns)
                ;
        
        $query = $query . ");";

        return $query;
    }
    
    /**
     * Executes a insert statement on the Application database, using the prepare_insert_query(); statement
     * \param $table_name The name of the table to insert the data in
     * \param $items An array of items for the database
     * 
     */
    public function insert($table_name, $items){
        if(count($items) <= 0 || !is_array($items)){
            return false;
        }
    
        $columns = array_keys($items);
        
        $sql = $this->prepare_insert_query($table_name, $columns);
        $statement = $this->connection->prepare($sql);
       
        for($i = 0; $i < count($items); $i++){
            $statement->bindParam($columns[$i], $items[$columns[$i]]);
        }
        
        if($statement->execute()){
            return true;
        }else{
            return false;
        }
    }
    private function prepare_delete_query($table_name){
        return "delete from $table_name where id = :id";
    }
    public function delete($table_name, $id){
        $sql = $this->prepare_delete_query($table_name);
        $statement = $this->connection->prepare($sql);
        
        $statement->bindParam("id", $id);
        if($statement->execute()){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * \brief this function will one day generate a database
     */
    //abstract function create_table();

}
