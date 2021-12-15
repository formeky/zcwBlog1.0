package xyz.formeky.zcwblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.formeky.zcwblog.mapper.EssayMapper;
import xyz.formeky.zcwblog.pojo.entity.Essay;
import xyz.formeky.zcwblog.pojo.query.EssayQuery;
import xyz.formeky.zcwblog.service.EssayService;

import java.util.List;

/**
 * @author ASUS
 */
@Service
public class EssayServiceImpl implements EssayService {

    @Autowired
    private EssayMapper mapper;

    @Override
    public List<Essay> listEssay(EssayQuery query) {
        return mapper.listEssay(query);
    }

    @Override
    public Essay getEssay(Integer essayId) {
        return mapper.selectByPrimaryKey(essayId);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Boolean removeEssay(Integer essayId) {
        if (mapper.selectByPrimaryKey(essayId)==null) {
            return false;
        }
        mapper.deleteByPrimaryKey(essayId);
        return true;
    }

    @Override
    public Boolean saveEssay(Essay essay) {
        if (mapper.selectByPrimaryKey(essay.getId())==null) {
            mapper.insertSelective(essay);
            return true;
        }
        return false;
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Boolean update(Essay essay) {
        if (mapper.selectByPrimaryKey(essay.getId())==null) {
            return false;
        }
        mapper.updateByPrimaryKeySelective(essay);
        return true;
    }
}
