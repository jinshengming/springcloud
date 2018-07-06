package net.htjs.pt4.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import net.htjs.pt4.dto.CommonResultDTO;
import net.htjs.pt4.model.Property;
import net.htjs.pt4.service.PropertyService;
import net.htjs.pt4.util.CommonResponse;
import net.htjs.pt4.util.MessageEnum;

@RestController
@RequestMapping("/prop/")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("selectProp")
    public CommonResultDTO selectProp(@ModelAttribute(value = "property") Property property, Model model) {
        Property prop = propertyService.selectProp();
        if (prop == null) {
            return CommonResponse.createCommons("1", JSON.toJSONString(new Property()));
        }
        return CommonResponse.createCommons("0", JSON.toJSONString(prop));
    }

    @PostMapping("setProp")
    public CommonResultDTO setProp(Property property) {
        Property prop = propertyService.selectProp();
        MessageEnum result = null;
        if (prop == null) {
            result = propertyService.insertProperty(property);
        } else {
            result = propertyService.setPropertyPrice(property);
        }
        return CommonResponse.createCommons(result.getCode(), result.getMsg());
    }

}
