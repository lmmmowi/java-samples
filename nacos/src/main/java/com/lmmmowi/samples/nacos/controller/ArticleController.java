package com.lmmmowi.samples.nacos.controller;

import com.lmmmowi.samples.nacos.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RequestMapping("/article")
@RestController
public class ArticleController {

    @Value("${article.title:'default title'}")
    private String title;

    @GetMapping
    public ArticleVO get(Long id) {
        return new ArticleVO(title);
    }
}
