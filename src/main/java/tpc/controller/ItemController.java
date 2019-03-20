package tpc.controller;

import tpc.entity.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 实现HttpRequestHandler接口，Controller接口，还有注解
 * 注解：类上加上@Controller
 *       类上或方法上加上@RequestMapping
 */
@Controller
public class ItemController {

    //RequestMapping此时填写url
    //ModelAndView:model表示的是数据模型，view表示最终展示的用户视图
    @RequestMapping("queryItem")
    public ModelAndView queryItem(){
        //查询数据库，用静态数据
        List<Item> itemList = new ArrayList<>();

        //商品列表
        Item item_1 = new Item();
        item_1.setName("联想笔记本");
        item_1.setPrice(6000f);
        item_1.setDetail("ThinkPad T430 联想笔记本电脑！");

        Item item_2 = new Item();
        item_2.setName("苹果手机");
        item_2.setPrice(5000f);
        item_2.setDetail("iphone6苹果手机！");
        itemList.add(item_1);
        itemList.add(item_2);


        ModelAndView modelAndView = new ModelAndView();
        //设置数据模型,相当于request的setAttribute方法,实际上，底层确实也是转成了request
        modelAndView.addObject("itemList",itemList);
        //设置视图
        modelAndView.setViewName("item/item-list");
        return modelAndView;
    }

}
