package com.project.demo.controller;

import com.project.demo.entity.ClassificationOfRescueAnimals;
import com.project.demo.service.ClassificationOfRescueAnimalsService;
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
 * 救助动物分类：(ClassificationOfRescueAnimals)表控制层
 *
 */
@Api(tags = "救助动物分类")
@RestController
@RequestMapping("/classification_of_rescue_animals")
public class ClassificationOfRescueAnimalsController extends BaseController<ClassificationOfRescueAnimals, ClassificationOfRescueAnimalsService> {

    /**
     * 救助动物分类对象
     */
    @Autowired
    public ClassificationOfRescueAnimalsController(ClassificationOfRescueAnimalsService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
