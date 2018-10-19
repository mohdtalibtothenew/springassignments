package com.ttn.spring.event;
// Question  Create a class Database with 2 instance variables port and name.
public class Database {
    private String name;
    private  Integer port;
    public Database(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "Database{" +
                "name='" + name + '\'' +
                ", port=" + port +
                '}';
    }
//Question Create a method in the Database class connect()
   public String connect(){
      return   "Connected ........";

    }
}
