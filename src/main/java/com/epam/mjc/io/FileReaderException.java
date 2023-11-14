package com.epam.mjc.io;


public class FileReaderException extends RuntimeException {
    public FileReaderException(String msg){
        super(msg);
    }
    public FileReaderException(String msg, Exception ex){
        super(msg, ex);
    }
}
