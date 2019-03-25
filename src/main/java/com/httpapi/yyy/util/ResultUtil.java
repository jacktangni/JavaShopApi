package com.httpapi.yyy.util;

import com.httpapi.yyy.bean.Result;

public class ResultUtil {
    public static Result success(Object par){
      Result result=new Result();
      result.setStatus(200);
      result.setMessage("null");
      result.setData(par);
      return result;
    }

    public static Result error(String message){
        Result result=new Result();
        result.setStatus(404);
        result.setMessage(message);
        result.setData(null);
        return result;
    }
}
