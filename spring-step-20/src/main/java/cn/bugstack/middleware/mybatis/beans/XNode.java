package cn.bugstack.middleware.mybatis.beans;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 *
 * @author naixixu
 * @description XNode
 * @date 2022/3/18
 *
 *
 */
@Getter
@Setter
public class XNode {

    private String namespace;
    private String id;
    private String parameterType;
    private String resultType;
    private String sql;
    private Map<Integer, String> parameter;

}
