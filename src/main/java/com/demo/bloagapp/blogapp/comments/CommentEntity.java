package com.demo.bloagapp.blogapp.comments;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import com.demo.bloagapp.blogapp.articles.ArticleEntity;
import com.demo.bloagapp.blogapp.users.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "comments")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(nullable = false)
	private Long id;

	@Nullable
	private String title;

	@NonNull
	private String body;

	@CreatedDate
	private Date createdAt;

	@ManyToOne
	@JoinColumn(name = "articleId", nullable = false)
	private ArticleEntity article;

	@ManyToOne
	@JoinColumn(name = "authorId", nullable = false)
	private UserEntity user;

}
