package com.appWeb.myApp.exception;

public class ProdutoException extends  Exception {

   private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ProdutoException(String message, String url) {
        super(message);
        this.url = url;
    }
}
