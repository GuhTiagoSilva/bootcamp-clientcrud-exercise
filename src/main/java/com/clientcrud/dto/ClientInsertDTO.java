package com.clientcrud.dto;

import java.io.Serializable;

public class ClientInsertDTO extends ClientDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String password;

    public ClientInsertDTO(){
        super();
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }


}
