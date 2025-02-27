package com.project.demo.controller;

import com.project.demo.entity.AnimalRescueInformation;
import com.project.demo.service.AnimalRescueInformationService;
import com.project.demo.controller.base.BaseController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 救助动物信息：(AnimalRescueInformation)表控制层
 *
 */
@Api(tags = "救助动物信息")
@RestController
@RequestMapping("/animal_rescue_information")
public class AnimalRescueInformationController extends BaseController<AnimalRescueInformation, AnimalRescueInformationService> {

    /**
     * 救助动物信息对象
     */
    @Autowired
    public AnimalRescueInformationController(AnimalRescueInformationService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
//        将animal_no从request中读取出来
//将animal_no作为参数传入service.readBody(request.getReader())，并将返回值赋给paramMap
//将paramMap作为参数传入this.addMap(paramMap)，并将返回值赋给result
//将result作为返回值返回
        String animal_no = request.getParameter("animal_no");
        Map<String,Object> paramMap = service.readBody(request.getReader());
        paramMap.put("animal_no",animal_no);

        this.addMap(paramMap);
        return success(1);
    }

}
