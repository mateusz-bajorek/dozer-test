package com.example.dozertest;

import org.dozer.Mapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DozerTestApplication.class})
@ActiveProfiles("test")
public class Test {

    @Autowired
    private Mapper mapper;

    @org.junit.Test
    public void test() {
        // mock content
        MyEntity myEntity = new MyEntity();
        myEntity.setId(10L);
        // mock PageImpl
        Page<MyEntity> page = new PageImpl<>(Arrays.asList(myEntity), new PageRequest(0, 10), 1);

        // will throw an exception
        // Caused by: java.lang.NoSuchMethodException: Unable to determine read method for Field: 'number' in Class: class org.springframework.data.domain.PageImpl
        mapper.map(page, MyDtoPage.class);
    }

    private static class MyEntity {
        private long id;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
    }

    private static class MyDtoPage {
        private long totalPages;
        private long totalElements;
        private long number;
        private long size;
        private long numberOfElements;
        private List<MyDto> content;

        public long getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(long totalPages) {
            this.totalPages = totalPages;
        }

        public long getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(long totalElements) {
            this.totalElements = totalElements;
        }

        public long getNumber() {
            return number;
        }

        public void setNumber(long number) {
            this.number = number;
        }

        public long getSize() {
            return size;
        }

        public void setSize(long size) {
            this.size = size;
        }

        public long getNumberOfElements() {
            return numberOfElements;
        }

        public void setNumberOfElements(long numberOfElements) {
            this.numberOfElements = numberOfElements;
        }

        public List<MyDto> getContent() {
            return content;
        }

        public void setContent(List<MyDto> content) {
            this.content = content;
        }
    }

    private static class MyDto {
        private long id;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
    }
}
