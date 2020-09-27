package com.huanletao.huanletao.controller;

import com.huanletao.huanletao.dto.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Api 这个注解分模块的,记得要用tags
 * @author dumingwei
 *
 */
@Api(tags="个人业务")
@RestController
@RequestMapping("/person")
public class PersonController {
    /**
     * @ApiOperation 这个注解是指该方法是用来做什么的,一定要加上httpMethod,否则会出现一堆
     * @param userVo
     * @return
     */
    @RequestMapping(value="/getPerson",method= RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "个人信息", produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseBody
    public Person getPersons() {
        Person person = new Person();
        person.setFirstName("fname");
        person.setLastName("lname");
        person.setAge(37);
        person.setDeptName("dept");
        return person;
    }
}
