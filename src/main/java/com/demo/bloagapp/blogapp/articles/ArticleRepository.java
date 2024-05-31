package com.demo.bloagapp.blogapp.articles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

	ArticleEntity findBySlug(String slug);
	

	


}
