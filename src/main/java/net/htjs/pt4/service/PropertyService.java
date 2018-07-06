package net.htjs.pt4.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.htjs.pt4.dao.PropertyMapper;
import net.htjs.pt4.model.Property;
import net.htjs.pt4.model.PropertyExample;
import net.htjs.pt4.util.MessageEnum;

@Service
public class PropertyService {

    @Autowired
    private PropertyMapper propertyMapper;

    public MessageEnum setPropertyPrice(Property property) {
        PropertyExample example = new PropertyExample();
        int result = propertyMapper.updateByExample(property, example);
        if (result == 0) {
            return MessageEnum.FAILD;
        }
        return MessageEnum.SUCCESS;
    }

    public MessageEnum insertProperty(Property property) {
        int result = propertyMapper.insert(property);
        if (result == 0) {
            return MessageEnum.FAILD;
        }
        return MessageEnum.SUCCESS;
    }

    public Property selectProp() {
        List<Property> list = propertyMapper.selectByExample(new PropertyExample());
        if (list != null) {
            if (list.size() > 0) {
                return list.get(0);
            }
        }
        return null;
    }

}
