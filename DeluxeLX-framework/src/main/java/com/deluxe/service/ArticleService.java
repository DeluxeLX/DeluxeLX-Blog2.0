package com.deluxe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.deluxe.common.ResponseResult;
import com.deluxe.domain.entity.Article;
import com.deluxe.domain.vo.HotArticleVo;

import java.util.List;

public interface ArticleService extends IService<Article> {

    // 获取热点文章，最多十条
    ResponseResult hotArticleList();

}
