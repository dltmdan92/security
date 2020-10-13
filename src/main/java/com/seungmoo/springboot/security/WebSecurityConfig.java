package com.seungmoo.springboot.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
/*
* WebSecurityConfigurerAdapter로 Config설정하면
* SpringBootWebSecurityConfiguration에서 디폴트로 셋팅한 것이 아닌
* 프로젝트 특화된 web security 설정 가능
*
* SpringBootWebSecurityConfiguration --> spring boot security는 거의 하는 거 없음, spring-security의 기능을 그대로 갖다씀
* */

}
