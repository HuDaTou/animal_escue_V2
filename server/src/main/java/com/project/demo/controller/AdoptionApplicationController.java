package com.project.demo.controller;

import com.project.demo.entity.AdoptionApplication;
import com.project.demo.service.AdoptionApplicationService;
import com.project.demo.controller.base.BaseController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;


/**
 * 领养申请：(AdoptionApplication)表控制层
 *
 */
@Api(tags = "领养申请")
@RestController
@RequestMapping("/adoption_application")
public class AdoptionApplicationController extends BaseController<AdoptionApplication, AdoptionApplicationService> {

    /**
     * 领养申请对象
     */
    @Autowired
    public AdoptionApplicationController(AdoptionApplicationService service) {
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
