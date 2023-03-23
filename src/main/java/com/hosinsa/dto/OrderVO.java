package com.hosinsa.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
CREATE TABLE HOSINSA_ORDER(
	    ORDERNUM NUMBER(30),
	    ID VARCHAR2(30),
	    ORDERDATE DATE DEFAULT SYSDATE,
	    PRICE NUMBER(8),
	    PRIMARY KEY(ORDERNUM)
);
*/

@Getter
@Setter
@ToString
public class OrderVO {
	private int ordernum;
	private String id;
	private String orderdate;
	private int price;
}
