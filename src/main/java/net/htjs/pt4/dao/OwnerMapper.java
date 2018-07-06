package net.htjs.pt4.dao;

import java.util.List;
import net.htjs.pt4.model.Owner;
import net.htjs.pt4.model.OwnerExample;
import org.apache.ibatis.annotations.Param;

public interface OwnerMapper {
    int countByExample(OwnerExample example);

    int deleteByExample(OwnerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Owner record);

    int insertSelective(Owner record);

    List<Owner> selectByExample(OwnerExample example);

    Owner selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Owner record, @Param("example") OwnerExample example);

    int updateByExample(@Param("record") Owner record, @Param("example") OwnerExample example);

    int updateByPrimaryKeySelective(Owner record);

    int updateByPrimaryKey(Owner record);
}