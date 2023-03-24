package hello.itemservice.project.config;


import hello.itemservice.project.repository.item.SpringDataJpaItemRepository;
import hello.itemservice.project.service.item.ItemService;
import hello.itemservice.project.service.item.ItemServiceV1;
import hello.itemservice.project.web.intercepter.LoginInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class Config implements WebMvcConfigurer {

    private final SpringDataJpaItemRepository repository;


    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(repository);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/*.ico", "/error","/", "/member/add", "/login", "/logout");

    }
}
