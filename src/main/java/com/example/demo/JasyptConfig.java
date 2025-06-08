package com.example.demo;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@Configuration
@EnableEncryptableProperties // 이 어노테이션을 추가합니다.
public class JasyptConfig {

    // 암호화/복호화에 사용할 StringEncryptor Bean을 정의합니다.
    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();

        // **중요**: 이 비밀번호는 암호화할 때 사용한 비밀번호와 일치해야 하며,
        // 실제 애플리케이션에서는 환경 변수 등으로 관리해야 합니다.
        // 여기서는 예시를 위해 직접 입력합니다.
        config.setPassword(System.getProperty("jasypt.encryptor.password")); // 환경 변수에서 읽어오는 것을 권장
        // config.setPassword("mySecretEncryptionKey"); // 직접 키를 설정하는 경우 (보안상 좋지 않음)

        config.setAlgorithm("PBEWithMD5AndDES"); // 암호화 알고리즘 (기본값 PBEWITHHMACSHA512ANDAES_256)
        config.setKeyObtentionIterations("1000"); // 키 생성 반복 횟수 (보안 강화)
        config.setPoolSize("1"); // 암호화 인스턴스 풀 크기
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator"); // 솔트 생성 클래스
        config.setStringOutputType("base64"); // 결과 문자열 인코딩 방식

        encryptor.setConfig(config);
        return encryptor;
    }
}