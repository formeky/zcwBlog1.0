package xyz.formeky.zcwblog.pojo.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author JirathLiu
 * @date 2020/10/9
 * @description:
 */
@Data
@NoArgsConstructor
public class PageVo<T> {
    protected List<T> list;
    protected Integer onPage;
    protected Integer total;
}
