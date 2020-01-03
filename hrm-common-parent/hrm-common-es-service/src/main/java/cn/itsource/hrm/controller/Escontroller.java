package cn.itsource.hrm.controller;

import cn.itsource.hrm.document.CourseDoucment;
import cn.itsource.hrm.repository.CourseRepository;
import cn.itsource.hrm.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: TODO
 * @Date: 2020/1/1 20:11
 * @Author: yjz
 * @Version:1.0
 */
@RestController
@RequestMapping("/es")
public class Escontroller {

    @Autowired
    private CourseRepository repository;

    @PostMapping("/create")
    public AjaxResult createIndexes(@RequestBody List<CourseDoucment> courses) {
        try {
            repository.saveAll(courses);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("失败!");
        }
    }

    @PostMapping("/delete")
    public AjaxResult deleteIndexes(@RequestBody List<Long> ids) {
        try {
            for (Long id : ids) {
                repository.deleteById(id);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("失败!");
        }
    }

}
