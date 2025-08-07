package mybatis.mapper;

import java.util.List;

import mybatis.vo.StudentVo;

public interface StudentMapper {
    StudentVo selectByPk(String stuno);

    List<StudentVo> selectAll();

    int insert(StudentVo vo);

    int update(StudentVo vo);

    int delete(String stuno);
}
