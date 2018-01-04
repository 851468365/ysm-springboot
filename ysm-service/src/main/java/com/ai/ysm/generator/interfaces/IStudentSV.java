package com.ai.ysm.generator.interfaces;

import java.util.List;
import com.ai.ysm.generator.entity.Student;
import com.ai.ysm.generator.entity.StudentExample;

/**
 * 	学生管理
 */
public interface IStudentSV {
	/**
	 * 根据ID查询学生信息
	 * @param id 学生ID
	 * @return 学生实体
	 */
	public Student getStudentById(Long id);

	/**
	 * 查询学生信息
	 * @param StudentExample 查询条件
	 * @return 学生列表
	 */
	public List<Student> getStudents(StudentExample StudentExample);

	/**
	 * 根据ID更新学生信息
	 * @param Student 学生信息
	 * @return 更新数量
	 */
	public int updateStudentById(Student Student); 
	
	/**
	 * 根据条件更新学生信息
	 * @param Student  学生信息
	 * @param StudentExample  查询条件
	 * @return 更新数量
	 */
	public int updateStudent(Student Student, StudentExample StudentExample); 
	
	/**
	 * 根据ID删除学生信息
	 * @param id 学生ID
	 * @return 删除数量
	 */
	public int deleteStudentById(Long id);
	
	/**
	 * 根据条件删除学生信息
	 * @param StudentExample 查询条件
	 * @return 删除数量
	 */
	public int deleteStudent(StudentExample StudentExample);
	
	/**
	 * 新增学生信息
	 * @param Student 学生信息
	 * @return 新增数量
	 */
	public int insertStudent(Student Student);
	
}


