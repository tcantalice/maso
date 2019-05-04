package com.nipsters.view;

public abstract class BaseView implements View {
    protected String title;
    protected String message;

    public BaseView(String title){
    	super();
        this.title = title;
    }

    public BaseView(String title, String message){
    	this(title);
    	this.message = message;
    }

    public void showView(){
        System.out.print(String.format("####\n%s\n####\n%s\n####\n", this.title, this.message));
    }

    public void updateView(){}
}
