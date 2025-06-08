package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table; // Table 어노테이션 추가

import java.time.LocalDateTime;

@Entity // 이 클래스가 JPA 엔티티임을 나타냅니다.
@Table(name = "member") // 매핑할 데이터베이스 테이블 이름을 지정합니다. (테이블 이름과 클래스 이름이 다를 경우 필요)
public class member {

    @Id // 기본 키(Primary Key)임을 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성 전략을 자동 증가로 설정합니다. (MariaDB의 경우 IDENTITY가 적합)
    private Long id;

    private String name;
    private String email;
    private LocalDateTime created_at;

    // 기본 생성자 (JPA 필수)
    public member() {
    }

    // 모든 필드를 포함하는 생성자 (선택 사항, 편의를 위해)
    public member(String name, String email, LocalDateTime times) {
        this.name = name;
        this.email = email;
        this.created_at = times;
    }

    // Getter 및 Setter (필수)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime times) {
        this.created_at = times;
    }

    @Override
    public String toString() {
        return "member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", created_at='" + created_at +
                '}';
    }
}