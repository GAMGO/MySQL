package mybatis.test;

import mybatis.mapper.StudentMapperDao;
import mybatis.vo.StudentVo;

public class StudentMapperTEST {
    public static void main(String[] args) {
        StudentMapperDao dao = new StudentMapperDao();
        System.out.println(dao.selectAll());

    }
}
