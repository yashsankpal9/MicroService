package com.micro.user.service.UserSerivce.Exceptions;

public class ResourceNotFoundExecption extends RuntimeException{

    public  ResourceNotFoundExecption(){
        super("Resource not found on server !!");
    }
    public ResourceNotFoundExecption(String msg){
        super(msg);
    }

}
