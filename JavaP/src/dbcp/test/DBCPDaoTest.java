package dbcp.test;

import dbcp.DBCPTBLStudentDao;

public class DBCPDaoTest {
    public static void main(String[] args) {
        DBCPTBLStudentDao dao = new DBCPTBLStudentDao();
        dao.insert("2025999", "김구구", "20", "서울시 구로구");
    }
}
