package com.ll.sb20231114;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class ArticleController
{
    private List<Article> articles = new ArrayList<>();
    private int articlesLastIndex = -1;

    @GetMapping("/article/write")
    String showWrite()
    {
        return "article/write";
    }

    @PostMapping("/article/write")
    @ResponseBody
    RsData<Article> write(String title, String body)
    {
        Article article= new Article(articles.size() + 1,title, body);
        articles.add(article);

        RsData<Article> rs = new RsData<Article>(
                "S-1",
                "%d번 게시물이 작성되었습니다.".formatted(article.getId()),
                article);

        return rs;
    }

    @GetMapping("/article/getLastArticle")
    @ResponseBody
    Article getLastArticle()
    {
        return articles.getLast();
    }

    @GetMapping("/article/getArticles")
    @ResponseBody
    List<Article> getArticles()
    {
        return articles;
    }
}

@AllArgsConstructor
@Getter
class RsData<T>
{
    private String resultCode;
    private String msg;
    private T data;
}

@AllArgsConstructor
@Getter
class Article
{
    private long id;
    private String title;
    private String body;
}
