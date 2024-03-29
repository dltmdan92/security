package com.seungmoo.springboot.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class) // WebMvc slicing test (웹 계층에 관련된 bean만 등록)
public class HomeControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @WithMockUser // 가라유저 통해서 spring security 인증 통과시키는 방법
    public void hello() throws Exception {
        mockMvc.perform(get("/hello").accept(MediaType.TEXT_HTML))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("hello"));

    }

    @Test
    public void hello_without_user() throws Exception {
        mockMvc.perform(get("/hello").accept(MediaType.TEXT_HTML))
                .andDo(print())
                .andExpect(status().isUnauthorized())
                .andExpect(view().name("hello"));

    }

    @Test
    @WithMockUser
    public void my() throws Exception {
        mockMvc.perform(get("/my"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("my"));
    }

    @Test
    public void my_without_user() throws Exception {
        mockMvc.perform(get("/my"))
                .andDo(print())
                .andExpect(status().isUnauthorized())
                .andExpect(view().name("my"));
    }
}