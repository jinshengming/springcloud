package net.htjs.pt4.dao;

import java.util.List;
import net.htjs.pt4.model.Property;
import net.htjs.pt4.model.PropertyExample;
import org.apache.ibatis.annotations.Param;

public interface PropertyMapper {
    int countByExample(PropertyExample example);

    int deleteByExample(PropertyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Property record);

    int insertSelective(Property record);

    List<Property> selectByExample(PropertyExample example);

    Property selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Property record, @Param("example") PropertyExample example);

    int updateByExample(@Param("record") Property record, @Param("example") PropertyExample example);

    int updateByPrimaryKeySelective(Property record);

    int updateByPrimaryKey(Property record);
}