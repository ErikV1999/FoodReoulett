package com.foodroulett.Models;

import java.util.ArrayList;

import org.hibernate.annotations.Type;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "_user")
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String displayName;
	private String email;
	private String password;
	@Type(JsonType.class)
	@Column(columnDefinition = "jsonb")
	private ArrayList<Business> favorites;
	private String role;
	
}
