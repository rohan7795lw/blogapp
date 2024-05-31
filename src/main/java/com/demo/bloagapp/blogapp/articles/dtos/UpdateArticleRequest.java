package com.demo.bloagapp.blogapp.articles.dtos;

import org.springframework.lang.Nullable;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class UpdateArticleRequest {
	
	@Nullable
	private String title;
	
	@Nullable
	private String subtitle;
	
	@Nullable
	private String body;

}
