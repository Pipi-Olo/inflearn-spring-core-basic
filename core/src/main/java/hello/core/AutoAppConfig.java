package hello.core;

import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // 기존 예제 유지 위해, 실무에서는 잘 사용하지 않음
)
public class AutoAppConfig {

/*    @Bean(name = "memoryMemberRepository")
    public MemoryMemberRepository memoryMemberRepository() {
        return new MemoryMemberRepository();
    }*/
}
