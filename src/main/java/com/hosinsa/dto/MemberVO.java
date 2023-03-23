package com.hosinsa.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
CREATE TABLE HOSINSA_MEMBER(
    ID          VARCHAR2(30),
    PW          VARCHAR2(30),
    NAME        VARCHAR2(15),
    GENDER      VARCHAR2(6),
    BIRTHDAY    DATE,
    EMAIL       VARCHAR2(50),
    PHONE       CHAR(13),
    ZIPCODE     NUMBER(5),
    ADDRESS     VARCHAR2(100),
    INTRODUCER  VARCHAR2(30),
    GRADE       CHAR(1),
    POINT       NUMBER(8),      
    PRIMARY KEY(ID)
);
*/


@Getter
@Setter
@ToString
public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private String gender;
	private Date birthday;
	private String email;
	private String phone;
	private int zipcode;
	private String address;
	private String introducer;
	private String grade;
	private int point;
	
}
