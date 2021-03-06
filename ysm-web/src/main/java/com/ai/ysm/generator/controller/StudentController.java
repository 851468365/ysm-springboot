package com.ai.ysm.generator.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ai.ysm.generator.entity.Student;
import com.ai.ysm.generator.entity.StudentExample;
import com.ai.ysm.generator.interfaces.IStudentSV;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping("/Student")
public class StudentController {
	@Autowired
	private IStudentSV StudentSV;
	
	private static Logger logger = LoggerFactory.getLogger(StudentController.class);  
	
	@ResponseBody
	@RequestMapping(value="getStudentById")
	public Map getStudentById(Long id, HttpServletRequest request, HttpServletResponse response) throws IOException{
		Map map = new HashMap();
		try {
			Student Student = StudentSV.getStudentById(id);
			map.put("Student", Student);
			map.put("result", "success");
			map.put("promptMsg", "查询学生成功!");
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "查询学生失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("查询学生信息失败。", e);
		}
		return map;
	}
	
	
	@ResponseBody
	@RequestMapping(value="getStudentsByPage")
	public Map getStudents(Student Student, HttpServletRequest request, HttpServletResponse response) throws IOException{
		Map map = new HashMap();
		try {
			/**
			 * 如下为两种分页处理方式（注意分页处理一定要在执行sql语句前进行设置！！）：
			 * 分页处理方式一：假设请求参数中包含分页参数pageNum和pageSize
			 * int pageNum = Integer.valueOf(request.getParameter("pageNum"));
			 * int pageSize = Integer.valueOf(request.getParameter("pageSize"));
			 * Page<Object> page = PageHelper.startPage(pageNum, pageSize);
			 */
			
	        /**
			 * 分页处理方式二：这种方式中请求参数名必须为pageNum,pageSize两个参数
			 * Page<Object> page = PageHelper.startPage(request);
			 */
//			Page<Object> page = PageHelper.startPage(1, 2);
			Page<Object> page = PageHelper.startPage(request);
			/**
			 * 自行定制，Where条件！！！！！！！！！！
			 */
			StudentExample StudentExample = new StudentExample();
			/*StudentExample.createCriteria().andNameEqualTo("zhangfei").andCodeEqualTo(Student.getCode());
			StudentExample.setDistinct(true);
			StudentExample.setOrderByClause("id desc");*/
			List<Student> Students = StudentSV.getStudents(StudentExample);
			
			/**
			 * 1、获取分页信息方式：
			 * System.out.println("符合条件的记录总数："+page.getTotal());
			 * System.out.println("每页记录数："+page.getPageSize());
			 * System.out.println("总页数："+page.getPages());
			 * 
			 * 2、如果希望获取更详细的分页信息可以使用PageInfo的方式，PageInfo中会包含更详细的分页相关信息：
			 * PageInfo<Student> pageInfo = new PageInfo<Student>(students);
			 */
			map.put("Students", Students);
			map.put("count", page.getTotal());
			map.put("result", "success");
			map.put("promptMsg", "查询学生成功!");
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "查询学生失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("查询学生信息失败。", e);
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="updateStudentById")
	public Map updateStudentById(Student Student, HttpServletRequest request, HttpServletResponse response) throws IOException{
		//Student对象中封装所有需要update的属性信息。
		Map map = new HashMap();
		int count = 0;
		try {
			count = StudentSV.updateStudentById(Student);
			map.put("result", "success");
			map.put("promptMsg", "更新学生成功!");
			if (count != 1) {
				map.put("result", "failed");
				map.put("promptMsg", "更新学生信息失败!");
			}
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "更新学生信息失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("更新学生信息失败。", e);
		}
		return map;
	}
	

	@ResponseBody
	@RequestMapping(value="updateStudent")
	public Map updateStudent(Student Student, HttpServletRequest request, HttpServletResponse response) throws IOException{
		//Student对象中封装所有需要update的属性信息。
		Map map = new HashMap();
		int count = 0;
		try {
			/**
			 * 自行定制，Where条件！！！！！！！！！！
			 */
			StudentExample StudentExample = new StudentExample();
			/*
			 * StudentExample.createCriteria().andNameEqualTo("zhangfei");
			 */
			count = StudentSV.updateStudent(Student, StudentExample);
			map.put("result", "success");
			map.put("promptMsg", "更新学生成功!");
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "更新学生信息失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("更新学生信息失败。", e);
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="deleteStudentById")
	public Map deleteStudentById(Long id, HttpServletRequest request, HttpServletResponse response) throws IOException{
		Map map = new HashMap();
		int count = 0;
		try {
			count = StudentSV.deleteStudentById(id);
			map.put("result", "success");
			map.put("promptMsg", "删除学生成功!");
			if (count != 1) {
				map.put("result", "failed");
				map.put("promptMsg", "删除学生信息失败!");
			}
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "删除学生信息失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("删除学生信息失败。", e);
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="deleteStudent")
	public Map deleteStudent(Student Student, HttpServletRequest request, HttpServletResponse response) throws IOException{
		Map map = new HashMap();
		int count = 0;
		try {
			/**
			 * 自行定制，Where条件！！！！！！！！！！
			 */
			StudentExample StudentExample = new StudentExample();
			/*
			 * StudentExample.createCriteria().andNameEqualTo("zhangfei");
			 */
			count = StudentSV.deleteStudent(StudentExample);
			map.put("result", "success");
			map.put("promptMsg", "删除学生成功!");
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "删除学生信息失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("删除学生信息失败。", e);
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="insertStudent")
	public Map insertStudent(Student Student, HttpServletRequest request, HttpServletResponse response) throws IOException{
		//Student对象中封装所有需要insert的属性信息。
		Map map = new HashMap();
		int count = 0;
		try {
			count = StudentSV.insertStudent(Student);
			map.put("result", "success");
			map.put("promptMsg", "新增学生成功!");
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "新增学生信息失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("新增学生信息失败。", e);
		}
		return map;
	}
	

}
