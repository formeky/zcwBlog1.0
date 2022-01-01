package xyz.formeky.zcwblog.service;

import xyz.formeky.zcwblog.pojo.entity.Essay;
import xyz.formeky.zcwblog.pojo.query.EssayQuery;

import java.util.List;

/**
 * @author ASUS
 */
public interface EssayService {

    public List<Essay> listEssay(EssayQuery query);

    public Essay getEssay(Integer essayId);

    public Boolean removeEssay(Integer essayId);

    public Boolean saveEssay(Essay essay);

    public Boolean update(Essay essay);

    public List<Essay> archive();
}
