package model;

import java.io.Serializable;

public class Goods implements Serializable{
	//编号，名称，类别，状态，发布人，借用者，简介
    private String id,name,kind,mode,publisher,synopsis,borrower;

    public Goods(String id, String name, String kind, String mode, String publisher, String synopsis,String borrower) {
		super();
		this.id = id;
		this.name = name;
		this.kind = kind;
		this.mode = mode;
		this.publisher = publisher;
		this.synopsis = synopsis;
        this.borrower=borrower;
	}

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public Goods() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
