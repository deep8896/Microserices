package com.lcwd.user.service.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name= "micro_users")
public class User {

	@Id
	@Column(name="ID")
	private String userId;
	@Column(name="NAME",length =20 )
	private String name;
	@Column(name="Email")
	private String email;
	@Column(name="ABOUT")
	private String about;
	//other user properties that ypu want
	@Transient
	private List<Rating> rating = new ArrayList<>(); 
}
