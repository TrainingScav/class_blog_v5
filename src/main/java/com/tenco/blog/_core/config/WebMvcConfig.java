package com.tenco.blog._core.config;

import com.tenco.blog._core.interceptor.LoginInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@Configuration // IoC 처리 (싱글톤 패턴 관리)
public class WebMvcConfig implements WebMvcConfigurer {

    private final LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/board/**", "/user/**") // 인터셉터가 동작할 URI 패턴을 지정
                .excludePathPatterns("/board/{id:\\d+}"); // 인터셉터에서 제외할 URI 패턴 설정
                // \\d+는 정규표현식으로 1개 이상의 숫자를 의미
                // /board/1, /board/22
    }
}
