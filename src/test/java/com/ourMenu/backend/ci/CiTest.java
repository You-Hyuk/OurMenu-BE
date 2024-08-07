package com.ourMenu.backend.ci;

import com.ourMenu.backend.domain.test.domain.TestEntity;
import com.ourMenu.backend.domain.test.dao.TestRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CiTest {

    @Autowired
    TestRepository testRepository;

    @Test
    @DisplayName("db와의 연결되어야 한다.")
    public void test1(){
        //given
        TestEntity testEntity=new TestEntity(1L,"name");
        testRepository.save(testEntity);
        //when
        TestEntity findEntity = testRepository.findById(1L).get();
        //then
        Assertions.assertThat(testEntity).isEqualTo(findEntity);
    }
}
