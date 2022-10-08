package com.deluxe.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deluxe.common.ResponseResult;
import com.deluxe.constants.SystemConstants;
import com.deluxe.domain.entity.Article;
import com.deluxe.domain.vo.HotArticleVo;
import com.deluxe.mapper.ArticleMapper;
import com.deluxe.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public ResponseResult hotArticleList() {
        // 查询热门文章，封装成 ResponseResult 返回
        // LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();

        // 1. 必须是正式文章, 不能是草稿
        // queryWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        // 2. 按照浏览量进行排序
        // queryWrapper.orderByDesc(Article::getViewCount);
        // 3. 最多只查询十条
        // Page<Article> page = new Page<>(1, 10);
        // page(page, queryWrapper);

        // List<Article> articles = page.getRecords();

        // SQL语句：select id, title, view_count from sg_article where status = 0 and del_flag = 0 order by view_count desc limit 0, 10;
        // 因为操作的是 HotArticleVo 对象，article 的 mapper 无法封装成 HotArticleVo。需要用工具类复制才行，导致效率有损耗
        List<HotArticleVo> articleVos = articleMapper.getHotArticleVoList();
        log.info("查询到的articleVos为：" + articleVos);

        return ResponseResult.okResult(articleVos);
    }

}
