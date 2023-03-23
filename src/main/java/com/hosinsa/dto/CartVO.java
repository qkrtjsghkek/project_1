package com.hosinsa.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartVO {
	private int cartnum; //카트 번호
	private String id; //유저 아이디
	private int pronum; //제품 번호
	private int quantity; //제품 수량
}
