package com.demo.bloagapp.blogapp.articles.dtos;

import org.springframework.lang.NonNull;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class CreateArticleRequest {
	
	@NonNull
	private String title;
	@NonNull
	private String subtitle;
	@NonNull
	private String body;

}
