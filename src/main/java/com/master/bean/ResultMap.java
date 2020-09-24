package com.master.bean;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/9/24 12:34
 */
@Component
public class ResultMap extends HashMap<String,Object> {

    public ResultMap success(){
        this.put("result","success");
        return this;
    }

    public ResultMap error(){
        this.put("result","error");
        return this;
    }

    public ResultMap message(Object message){
        this.put("message",message);
        return this;
    }
}
