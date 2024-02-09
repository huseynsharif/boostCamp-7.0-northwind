package com.huseynsharif.northwind.core.utilities.results;

public class SuccesDataResult<T> extends DataResult<T>{

    public SuccesDataResult(String message, T data) {
        super(true, message, data);
    }

    public SuccesDataResult(T data) {
        super(true, data);
    }

    public SuccesDataResult(String message){
        super(true, message, null);
    }
}
