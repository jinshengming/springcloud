package net.htjs.pt4.service;

import com.github.pagehelper.PageHelper;
import net.htjs.pt4.dao.OwnerMapper;
import net.htjs.pt4.model.Owner;
import net.htjs.pt4.model.OwnerExample;
import net.htjs.pt4.util.MessageEnum;
import net.htjs.pt4.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerMapper ownerMapper;

    public PageInfo<Owner> selectPageList(int pageNum) {
        PageHelper.startPage(pageNum, new PageInfo<Owner>().getPageSize());
        List<Owner> list = ownerMapper.selectByExample(new OwnerExample());
        PageInfo<Owner> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRED)
    public MessageEnum insertOrUpdateOwner(Owner owner) {
        int result = 0;
        if (owner.getId() != null) {
            if (ownerMapper.selectByPrimaryKey(owner.getId()) != null) {
                result = ownerMapper.updateByPrimaryKey(owner);
            }
        } else {
            result = ownerMapper.insert(owner);
        }
        if (result == 0) {
            return MessageEnum.FAILD;
        }
        return MessageEnum.SUCCESS;
    }

    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRED)
    public MessageEnum deleteOwner(Integer id) {

        if (id == null) {
            return MessageEnum.FAILD;
        }
        int result = ownerMapper.deleteByPrimaryKey(id);
        if (result == 0) {
            return MessageEnum.FAILD;
        }
        return MessageEnum.SUCCESS;
    }
}
