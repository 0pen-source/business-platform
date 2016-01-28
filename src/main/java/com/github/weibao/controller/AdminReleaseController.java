package com.github.weibao.controller;

import com.github.weibao.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by dongzhukai on 16/1/12.
 */
@Controller
@RequestMapping("admin")
public class AdminReleaseController {
  private org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(AdminReleaseController.class);
  @Autowired
  private CompanyService companyService;

  @RequestMapping("release")
  public ModelAndView releasHome() {

    return new ModelAndView("redirect:/company/query");
  }


}
