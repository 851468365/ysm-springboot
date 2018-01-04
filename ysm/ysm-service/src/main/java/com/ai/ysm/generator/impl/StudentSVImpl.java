package com.ai.ysm.generator.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ai.ysm.generator.dao.StudentMapper;
import com.ai.ysm.generator.entity.Student;
import com.ai.ysm.generator.entity.StudentExample;
import com.ai.ysm.generator.interfaces.IStudentSV;

@Service
public class StudentSVImpl implements IStudentSV{
	@Resource
	private StudentMapper StudentMapper;

	@Override
	public Student getStudentById(Long id) {
		return StudentMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Student> getStudents(StudentExample StudentExample) {
		return StudentMapper.selectByExample(StudentExample);
	}

	@Override
	public int updateStudentById(Student Student) {
		return StudentMapper.updateByPrimaryKeySelective(Student);
	}
	
	@Override
	public int updateStudent(Student Student, StudentExample StudentExample) {
		return StudentMapper.updateByExampleSelective(Student, StudentExample);
	}

	@Override
	public int insertStudent(Student Student) {
		return StudentMapper.insertSelective(Student);
	}

	@Override
	public int deleteStudentById(Long id) {
		return StudentMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public int deleteStudent(StudentExample StudentExample) {
		return StudentMapper.deleteByExample(StudentExample);
	}
}
