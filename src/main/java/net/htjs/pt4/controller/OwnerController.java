package net.htjs.pt4.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import net.htjs.pt4.dto.CommonResultDTO;
import net.htjs.pt4.model.Owner;
import net.htjs.pt4.model.Property;
import net.htjs.pt4.service.OwnerService;
import net.htjs.pt4.util.CommonResponse;
import net.htjs.pt4.util.MessageEnum;
import net.htjs.pt4.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
@RequestMapping("/owner/")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("list")
    public String selectList(Model model) {

        PageInfo<Owner> pageInfo = ownerService.selectPageList(1);
        model.addAttribute("owner", new Owner());
        model.addAttribute("property", new Property());
        model.addAttribute("list", pageInfo);
        return "index";
    }

    @GetMapping("list/{pageNum}")
    @ResponseBody
    public CommonResultDTO selectList(@PathVariable("pageNum") Integer pageNum) {
        PageInfo<Owner> pageInfo = ownerService.selectPageList(pageNum);
        System.out.println(JSON.toJSONString(pageInfo));
        return CommonResponse.createCommons("0", JSON.toJSONString(pageInfo, SerializerFeature.WriteNullStringAsEmpty));
    }

    @PostMapping("insertOrUpdate")
    @ResponseBody
    public CommonResultDTO insertOrUpdateOwner(@ModelAttribute(value = "owner") Owner owner) {
        if(owner.getPropertyFeeDate() == null || owner.getPropertyFeeDate().equals("")){
            owner.setPropertyFeeDate(new Date());
        }
        MessageEnum result = ownerService.insertOrUpdateOwner(owner);
        return CommonResponse.createCommons(result.getCode(), JSON.toJSONString(owner, SerializerFeature.WriteNullStringAsEmpty));
    }

    @PostMapping("del")
    @ResponseBody
    public CommonResultDTO deleteOwner(Integer id) {
        MessageEnum result = ownerService.deleteOwner(id);
        return CommonResponse.createCommons(result.getCode(), result.getMsg());
    }
}
