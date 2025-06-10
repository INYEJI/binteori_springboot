package com.example.fristproject.repository;

import com.example.fristproject.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository  extends CrudRepository<Article, Long> {

    List<Article>  findAll();
}
