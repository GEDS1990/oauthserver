
package com.simon.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simon.common.config.AppConfig;
import com.simon.mapper.NewsTagMapper;
import com.simon.model.NewsTag;
import com.simon.repository.NewsTagRepository;
import com.simon.service.NewsTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author SimonSun
* @create 2018-08-06 20:56:26
**/
@Service
@Transactional
public class NewsTagServiceImpl implements NewsTagService {
    @Autowired
    private NewsTagMapper newsTagMapper;

    @Autowired
    private NewsTagRepository newsTagRepository;

    @Override
    public NewsTag save(NewsTag newsTag){
        return newsTagRepository.save(newsTag);
    }

    @Override
    public List<NewsTag> save(List<NewsTag> newsTagList) {
        return newsTagRepository.save(newsTagList);
    }

    @Override
    public PageInfo<NewsTag> findAll(int pageNo){
        PageHelper.startPage(pageNo, AppConfig.DEFAULT_PAGE_SIZE);
        List<NewsTag> list = newsTagMapper.selectAll();
        return new PageInfo<>(list);
    }

    @Override
    public Page<NewsTag> findAll(Pageable pageable){
        return newsTagRepository.findAll(pageable);
    }

    @Override
    public List<NewsTag> findAll(){
        return newsTagRepository.findAll();
    }

    @Override
    public void delete(Long id){
        newsTagRepository.delete(id);
    }

    @Override
    public int deleteByIds(String ids){
        return newsTagMapper.deleteByIds(ids);
    }

    @Override
    public NewsTag findById(Long id){
        return newsTagRepository.findOne(id);
    }

    @Override
    public int insertList(List<NewsTag> list){
        return newsTagMapper.insertList(list);
    }

    @Override
    public int insert(NewsTag newsTag){
        return newsTagMapper.insert(newsTag);
    }

    @Override
    public int insertSelective(NewsTag newsTag){
        return newsTagMapper.insertSelective(newsTag);
    }
}