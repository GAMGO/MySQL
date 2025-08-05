package dbcp;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBConnectionPool {
    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:oracle:thin:@//localhost:1521/xe");
        config.setUsername("c##idev");
        config.setPassword("1234");

        // 선택적 성능 설정
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(600000); // 10분
        config.setMaxLifetime(1800000); // 30분
        config.setConnectionTimeout(30000); // 30초

        dataSource = new HikariDataSource(config);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
/*
 * ✅필요한 라이브러리
 * : HikariCP 6.21.(com.zaxxer.hikari)
 * : HikariCP가 사용하는(의존성) 추가 기능 라이브러리 slf4j-api 2.0.16 slf4j-simple-2.0.16
 * 
 * ✅ 설정값 설명
 * config.setMaximumPoolSize(10);
 * 풀의 최대 커넥션 수를 설정합니다.
 * 동시에 사용할 수 있는 최대 DB 커넥션 수입니다.
 * 값이 작으면 대기 시간이 증가하고,
 * 너무 크면 DB 부하 증가로 성능 저하 또는 DB 연결 제한 초과 발생 가능.
 * 
 * 
 * config.setMinimumIdle(5);
 * 유휴 상태로 유지할 최소 커넥션 수
 * 커넥션이 사용되지 않더라도 최소 5개는 유지합니다.
 * 사용량이 줄어들어도 일정 수의 커넥션은 미리 확보 → 속도 향상
 * - minimumIdle이 maximumPoolSize보다 크면 무시되고 maximumPoolSize가 우선 적용됨
 * 
 * config.setIdleTimeout(600000); → 10분
 * 커넥션이 유휴(idle) 상태로 지정된 시간(밀리초) 이상 유지되면 풀에서 제거됩니다.
 * 이 예시에서는 10분(600,000ms) 이상 아무도 사용하지 않으면 해당 커넥션을 제거함.
 * 단, minimumIdle 이상은 항상 유지됨.
 * 유휴 커넥션이 많아지면 자원 낭비, 적으면 재연결 지연
 * 
 * config.setMaxLifetime(1800000); → 30분
 * 커넥션 객체의 최대 생명주기입니다.
 * 연결 상태가 정상이어도 30분이 지나면 재생성됨.
 * 일부 DB (예: MySQL, Oracle)는 오래된 커넥션을 강제로 끊는 경우가 있으므로 적당히 짧게 유지하면 안정적입니다.
 * - HikariCP 기본값: 30분
 * 
 * 
 * config.setConnectionTimeout(30000); → 30초
 * 커넥션을 얻기 위해 기다릴 최대 대기 시간 (ms)
 * 풀에 사용 가능한 커넥션이 없을 때 최대 30초까지 대기, 이후 예외 발생
 */