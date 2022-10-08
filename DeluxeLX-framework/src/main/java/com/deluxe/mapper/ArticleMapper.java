package com.deluxe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deluxe.domain.entity.Article;
import com.deluxe.domain.vo.HotArticleVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    // 获取热点文章VO实体类
    List<HotArticleVo> getHotArticleVoList();

}
