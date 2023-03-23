package com.hosinsa.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
CREATE TABLE HOSINSA_PRODUCT(
	CATEGORY      VARCHAR2(20),
	PRONAME       VARCHAR2(100),
	PROIMG_S      VARCHAR2(100),
	PROIMG_B      VARCHAR2(500),
	BRAND         VARCHAR2(50),
	PRONUM        NUMBER(8),
	PRICE         NUMBER(8),
	STOCK         NUMBER(8),
	PROVIEW       NUMBER(8),
	PRIMARY KEY(PRONUM)
);
*/

@Getter
@Setter
@ToString
public class ProductVO {
	private String category; //카테고리 
	private String proname; //제품명
	private String proimgSmall;
	private String proimgBig;
	private String brand; //브랜드
	private int pronum; //품번
	private int price; //가격
	private int stock; //재고
	private int proview; //조회수
	//private String description; //상품설명
	
}