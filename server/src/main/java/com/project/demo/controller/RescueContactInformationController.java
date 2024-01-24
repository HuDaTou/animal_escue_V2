package com.project.demo.controller;

import com.project.demo.entity.RescueContactInformation;
import com.project.demo.service.RescueContactInformationService;
import com.project.demo.controller.base.BaseController;
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
 * 救助联系方式：(RescueContactInformation)表控制层
 *
 */
@RestController
@RequestMapping("/rescue_contact_information")
public class RescueContactInformationController extends BaseController<RescueContactInformation, RescueContactInformationService> {

    /**
     * 救助联系方式对象
     */
    @Autowired
    public RescueContactInformationController(RescueContactInformationService service) {
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
