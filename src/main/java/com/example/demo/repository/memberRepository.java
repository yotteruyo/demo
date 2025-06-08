// src/main/java/com/example/demo/repository/memberRepository.java
package com.example.demo.repository; // 패키지 선언이 정확해야 합니다.

import com.example.demo.entity.member; // member 엔티티를 임포트

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface memberRepository extends JpaRepository<member, Long> {
    // JpaRepository를 상속하면 기본적인 CRUD(Create, Read, Update, Delete) 메서드가 자동으로 제공됩니다.
}