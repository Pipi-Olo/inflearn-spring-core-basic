# inflearn-spring-core-basic

# 🤔 좋은 객체 지향❔
객체 지향 프로그램밍은 컴퓨터 프로그램을 객체들의 모임으로 해석한다. 각 객체들은 서로 협력하여 데이터를 처리한다. 객체 지향 프로그래밍은 **유연하고 변경이 용이**하게 만들어 대규모 소프트웨어 개발에 많이 사용된다.

## 객체 지향 특징
* 추상화
* 캡슐화
* 상속
* **다형성**
  👉 **역할**과 **구현**으로 세상을 구분한다.
  
### 다형성 ❔
![](https://velog.velcdn.com/images/pipiolo/post/2ce8446c-c976-4674-ad80-d048a40b1f20/image.png)

* 역할과 구현으로 세상을 구분한다.
* `자동차`를 변경해도 `운전`할 수 있다.
  * `운전자`는 별도로 무언가를 할 필요가 없다.
  * 자동차 `역할`만 수행한다면, 새로운 `자동차`를 무한히 만들 수 있다.
* `구현체`를 변경해도 `클라이언트`는 정상 동작한다.
  * `클라이언트`는 코드의 수정없이 `구현체`를 변경할 수 있다.
  * `인터페이스`만 지킨다면, `구현체`를 무한히 만들 수 있다.


![](https://velog.velcdn.com/images/pipiolo/post/f498f755-0f9b-4af9-8e89-43e0a91ab24b/image.png)

* 역할과 구현으로 세상을 구분한다.
* 배우들이 변경되어도 연극은 문제없이 진행된다.
* 구현체가 변경되어도 프로그램은 정상 작동한다.

### 역할과 구현
* 역할과 구현으로 구분하면, 세상이 단순해지고 유연하고 변경에 유리하다.
* 자바의 다형성
  * 역할 👉 인터페이스
  * 구현 👉 인터페이스를 구현한 객체, 구현체
* 장점
  * 클라이언트는 인터페이스만 알면 된다.
  * 클라이언트는 구현체의 내부 구조를 몰라도 된다.
  * 클라이언트는 내부 구조가 변경되어도 영향을 받지 않는다.
  * 클라이언트는 구현체가 변경되어도 영향을 받지 않는다.
* 객체를 설계할 때, 역할과 구현을 명확히 분리한다.

### 오버라이딩
![](https://velog.velcdn.com/images/pipiolo/post/5129b878-abe0-4962-b003-55516bd3d8b5/image.png)

* 오버라이딩은 자바의 다형성을 담당한다.
* 인터페이스 메소드를 실행하면, 각 구현체들의 오버라이딩된 메소드가 실행된다.
* 인터페이스를 구현한 객체를 실행 시점에 유연하게 변경할 수 있다.
* 클아이언트는 인터페이스에 의존하면 된다.

### 다형성❗️
* 실세계의 역할과 구현을 다형성을 통해 객체 세상에 가져온다.
* 인터페이스를 잘 설계하는 것이 중요하다.
  * 인터페이스가 변하면, 클라이언트∙서버에 큰 변경이 발생한다.
* 구현체를 실행 시점에 유연하게 변경할 수 있다.
* 확장 가능한 설계로 유연하고 변경에 용이한 애플리케이션을 개발한다.
* **클라이언트를 변경하지 않고, 서버의 구현 기능을 유연하게 변경할 수 있다.**

## 좋은 객체 지향 설계 5원칙 (SOLID)
클린 코드로 유명한 로버트 마틴의 좋은 객체 지향 설계 5가지 원칙이다.
* SRP (Single Responsibility Principle) 👉 단일 책임 원칙
* **OCP** (Open / Closed Principle) 👉 개방∙폐쇄 원칙
* LSP (Liskov Substitution Principle) 👉 리스코프 치환 원칙
* ISP (Interface Segregation Principle) 👉 인터페이스 분리 원칙 
* **DIP** (Dependency Inversion Principle) 👉 의존관계 역전 원칙

### 단일 책임 원칙 (SRP)
* 하나의 클래스는 하나의 책임만 가져야 한다.
* 중요한 기준은 `변경`이다. 변경이 있을 때 파급 효과가 적으면, 단일 책임 원칙을 잘 따른 것이다.

### 개방∙폐쇄 원칙 (OCP)
```java
public class MemberService {
//	private MemberRepository memberRepository = new MemoryMemberRepository();
    private MemberRepository memberRepository = new JdbcMemberRepository();
}
```
* 확장에는 열려있으나 변경에는 닫혀 있어야 한다.
* 다형성을 사용하자.
  * 인터페이스를 구현한 새로운 클래스를 만들어서 구현체를 변경해보자.
* 구현체를 변경하려면, 클라이언트 코드를 변경해야 한다.
  * `= new xxxMemberRepository`
* 다형성을 사용해도 OCP 원칙을 지킬 수 없다.
* 객체를 생성하고 연관관계를 맺어주는 별도의 설정자가 필요하다.
  👉 `Spring` 🌿

### 리스코프 치환 원칙 (LSP)
* 객체는 정확성을 깨트리지 않고 하위 타입의 인스턴스로 바꿀 수 있어야 한다.
* 다형성에서 구현체는 인터페이스 규약을 다 지켜야 한다는 것이다.
  * 인터페이스를 구현한 구현체를 믿을려면, 이 원칙이 필요하다.
* 단순 컴파일러 성공을 넘어서, 인터페이스가 원하는 동작을 구현체가 실행해야 한다.

### 인터페이스 분리 원칙 (ISP)
* 특정 클라이언트를 위한 하나의 범용 인터페이스보다 여러 개의 인터페이스가 낫다.
* 분리할 수록 인터페이스가 변해도 클라이언트에 영향을 주지 않는다.
* 자동차 인터페이스 👉 운전 인터페이스, 정비 인터페이스
* 인터페이스가 명확해지고 변경에 용이해진다.

### 의존관계 역전 원칙 (DIP)
* 구현체에 의존하지 않고 추상화에 의존해야 한다.
* 구현 클래스에 의존하지 않고 인터페이스에 의존해야 한다.
* `MemberService`는 `MemberRepository` 인터페이스에 의존하지만, 동시에 구현체에도 의존하고 있다.

### 한계
* 객체 지향의 핵심은 다형성이다.
* 다형성만으로 OCP, DIP를 지킬 수 없다.
* 무언가 더 필요하다.
  👉 `Spring` 🌿
  
## 객체 지향과 스프링 🌿
* 스프링은 DI(Dependency Injection) 컨테이너를 통한 의존 관계 주입을 통해 `다형성`과 `OCP`, `DIP`를 보장한다.
* `OCP`, `DIP` 원칙을 지키면서 개발을 하면, 결국 `DI 컨테이너`, 스프링 프레임워크를 만들게 된다.
* 클라이언트 코드의 변경없이 기능을 확장한다.
* 스프링은 **좋은 객체 지향** 애플리케이션을 개발할 수 있게 도와주는 프레임워크이다.

---

# 스프링 핵심 원리 이해 🌿
## 예제 이해
```java
public class OrderServiceImpl implements OrderService {
    // private final DiscountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy = new RateDiscountPolicy();
}
```

![](https://velog.velcdn.com/images/pipiolo/post/6f9850e4-1cbf-44d6-ada1-7238faf2b62c/image.png)

* `OrderServiceImpl` 클래스는 `DiscountPolicy` 인터페이스에 의존하면서, 동시에 `FixCountPolicy` 클래스에도 의존하고 있다. 👉 **DIP** 위반
* 할인 정책을 `RateDiscountPolicy`로 변경하면 클라이언트인 `OrderServiceImpl` 코드를 변경해야 한다. 👉 **OCP** 위반
  * 유연하게 동작하지 않는다. 변경이 용이하지 않다.
* 인터페이스에만 의존하면 구현체가 없어 NPE(Null Pointer Exception)가 발생한다.
* **누군가**가 `DiscountPolicy`를 구현한 객체를 대신 생성하고 주입해 주어야한다.
  👉 `Spring` 🌿
  
## AppConfig 등장
```java
public class AppConfig {
    public OrderService orderService() {
        return new OrderServiceImpl(discountPolicy());
    }
    
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}

public class OrderServiceImpl implements OrderService {

    private final DiscountPolicy DiscountPolicy;
    
    public OrderServiceImpl(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
}
```

![](https://velog.velcdn.com/images/pipiolo/post/f0e14107-2a61-41eb-8a6b-2cf4c538f40f/image.png)

* `OrderServiceImpl` 클래스는 `DiscountPolicy` 인터페이스에만 의존하고 구현체는 생성자를 통해서 외부에서 얻는다. 👉 **DIP** 완성
* 할인 정책을 `RateDiscountPolicy`로 변경해도 `OrderServiceImpl` 코드는 유지된다. 👉 **OCP** 완성
* `AppConfig` 클래스는 구현 객체를 생성하고 연결을 책임진다.
  * `OrderServiceImpl`, `RateDiscountPolicy` 객체를 생성한다.
  * 생성한 객체 인스턴스를 `OrderServiceImpl` 생성자를 통해서 주입(연결)한다.
* 클라이언트인 `OrderServiceImpl` 외부에서 의존 관계를 주입해서 **의존관계 주입**(`Depdendency Injection`)이라 한다.
  * 클라이언트는 생성자를 통해서 어떤 구현 객체가 주입될지 알 수 없다.
* 생성자를 통해서 어떤 구현 객체를 주입할지는 오직 외부(`AppConfig`)에서 결정한다.
* 애플리케이션을 사용 영역과 객체를 생성하고 구성하는 영역으로 분리한다.
  * 구성 영역만 영향을 받고 **사용 영역은 전혀 영향을 받지 않는다.**
  
## IoC 그리고 DI
### 좋은 객체 지향 설계 5원칙
* SRP 👉 한 클래스는 하나의 책임만 가진다.
  * 클라이언트 객체는 실행을 담당한다.
  * AppConfig는 구현 객체를 생성 및 연결을 담당한다. 
* DIP 👉 구현체에 의존하지 않고 추상화에 의존한다.
  * 쿨라이언트는 인터페이스에만 의존하고 구현체는 생성자를 통해서 받는다.
  * AppConfig는 클라이언트 대신 객체 인스턴스를 생성해서 의존관계를 주입한다.
* OCP 👉 확장에는 열려 있으나 변경에는 닫혀있다.
  * 애플리케이션을 사용 영역과 구성 영역으로 구분한다.
  * 구성 영역인 AppConfig가 의존관계를 사용 영역에 주입하므로 사용 영역은 변경하지 않는다.
  * 소프트웨어를 새롭게 확장해도 사용 영역의 변경은 닫혀있다.
  
### 제어의 역전 (Inversion of Controll)
* 기존에는 클라이언트가 객체를 생성, 연결 및 실행했다. 구현 객체가 프로그램의 제어 흐름을 스스로 조종했다.
* 프로그램 제어 흐름에 대한 모든 권한은 `AppConfig`가 가진다. 클라이언트는 묵묵히 자신의 로직을 실행할 뿐이다.
* 프로그램의 제어 흐름을 직접 제어하는 것이 아니라, 외부에서 관리하는 것을 **제어의 역전**이라 한다.
* 프레임워크 vs 라이브러리
  * 프레임워크가 내가 작성한 코드를 제어하고 대신 실행한다.
  * 내가 필요한 곳에 라이브러리를 가져다 사용한다.
  
### 의존관계 주입 (Dependency Injection)
* 의존 관계는 정적인 클래스 의존 관계와 동적인 객체 인스턴스 의존 관게로 분리된다.
* 정적인 클래스 의존 관계
  ![](https://velog.velcdn.com/images/pipiolo/post/926fb278-8f4e-46af-afbf-1b01686933bb/image.png)
  * import 코드만 보고 의존 관계를 쉽게 알 수 있다.
  * 애플리케이션을 실행하지 않아도 분석할 수 있다.
  * 클래스 의존 관계만으로는 실제 어떤 객체가 주입될지 알 수 없다.
* 동적인 객체 인스턴스 의존 관계
  ![](https://velog.velcdn.com/images/pipiolo/post/659f2748-fc36-417e-84d6-0c6e8fdcf012/image.png)
  * 애플리케이션 실행 시점(런타임)에 의부에서 구현 객체를 생성하고 의존관계를 연결한다.
  * 정적인 클래스 의존관계를 변경하지 않고 동적인 객체 인스턴스 의존관계를 변경할 수 있다.
* 객체를 생성, 연결 및 관리하는 `AppConfig`를 **IoC 컨테이너** 또는 **DI 컨테이너**라 한다.

### 스프링으로 전환
```java
@Configuration
public class AppConfig {

    @Bean
    public OrderService orderService(DiscountPolicy discountPolicy) {
        return new OrderServiceImpl(discountPolicy);
    }
    
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
```

* `ApplicationContext`를 **스프링 컨테이너**라 한다.
* 기존에는 개발자가 `AppConfig`를 통해서 직접 관리했다면, 이제는 스프링 컨테이너가 관리한다.
* 스프링 컨테이너는 `@Configuration`이 붙은 `AppConfig`를 설정(구성) 정보로 사용한다.
  * `@Bean`이 붙은 메소드가 반환하는 객체를 스프링 컨테이너에 등록한다.
  * 스프링 컨테이너에 등록된 객체를 **스프링 빈**이라 한다.
* 기존에는 개발자가 직접 자바 코드로 모든 것을 했다면, 이제는 스프링 컨테이너에 객체를 등록하고 스프링 컨테이너를 통해서 스프링 빈을 찾아 사용한다.

---

# 스프링 컨테이너와 스프링 빈
## 스프링 컨테이너
```java
ApplicationContext applicationContext
		= new AnnotationConfigApplicationContext(AppConfig.class);
```

* `ApplicationContext`를 스프링 컨테이너라 한다.
* 스프링 컨테이너는 XML 기반으로 만들 수 있고 애노테이션 기반의 자바 설정 클래스로도 만들 수 있다.
  * `ApplicationContext`는 인터페이스이다.
  * 자바 설정 클래스 기반으로 만드는 스프링 컨테이너 구현체가 `AnnotationConfigApplicationContext`이다.
  
> **참고**
> `BeanFactory`, `ApplicationContext` 모두 스프링 컨테이너라 한다. 일반적으로 스프링 컨테이너는 `ApplicationContext`을 말한다.
  
![](https://velog.velcdn.com/images/pipiolo/post/7709c338-fe2c-4b7f-946d-46ffd3103789/image.png)

![](https://velog.velcdn.com/images/pipiolo/post/f8528f02-87f7-46a9-9904-239cad69f1f8/image.png)

* `new AnnotationConfigApplicationContext(AppConfig.class)`
* `AppConfig.class` 구성 정보를 통해 스프링 컨테이너를 생성한다.
* 스프링 컨테이너는 설정 클래스 정보를 바탕으로 스프링 빈을 등록한다.
  * 스프링 빈 이름은 메서드 이름을 사용한다.
  * `@Bean(name = "discountPolicy2")`로 빈 이름을 지정할 수 있다.
* 스프링 컨테이너는 설정 정보를 참고해서 의존관계를 주입한다.

> **참고**
> 스프링 빈 이름은 항상 다름 이름을 부여해야 한다. 같은 이름을 부여하면, 기존 빈을 덮어쓰거나 오류가 발생한다.

> **참고**
> 스프링 빈은 생성하고 의존관계를 주입하는 단계로 나뉘어져 있다. 하지만, 자바 코드로 스프링 빈을 등록하면 생성자를 호출하면서 의존관계 주입도 한 번에 처리된다.

## BeanFactory와 ApplicationContext
### BeanFactory
![](https://velog.velcdn.com/images/pipiolo/post/bfde0e7f-0c45-425d-84de-185333a9c735/image.png)

* `BeanFactory`는 스프링 컨테이너의 최상위 인터페이스이다.
* 스프링 빈을 조회하고 관리하는 역할을 한다.
  * 스프링 빈을 조회하는 `getBean()`을 제공한다.

### ApplicationContext
![](https://velog.velcdn.com/images/pipiolo/post/ab7944ae-068d-4d42-b84a-fb59841d3f9c/image.png)

* `ApplicationContext`는 `BeanFactory`를 상속한다.
  * `ApplicationContext`는 스프링 빈 관리와 편리한 부가 기능을 제공한다.
  * `BeanFactory`를 직접 사용할 일은 없다. 
* `MessageSource`를 활용한 국제화 기능
  * 한국 👉 한국어, 미국 👉 영어를 출력한다.
* 환경 변수, `EnvironmentCapable`
  * 로컬, 개발, 운영 등 다양한 환경을 분리해서 만들 수 있다.
* 애플리케이션 이벤트, `ApplicationEventPublisher`
  * 이벤트를 발행하고 구독하는 모델을 지원한다.
* 편리한 리소스 조회, `ResourceLoader`
  * 파일, 클래스 패스 등 리소스를 편리하게 조회한다.
  
![](https://velog.velcdn.com/images/pipiolo/post/2889880d-e946-4210-a448-acf1dd6fa644/image.png)

* 스프링 컨테이너는 다양한 형식의 설정 정보를 받을 수 있다.
* `AnnotationConfigApplicationContext` 클래스는 자바 코드 설정 정보를 받는다.
* `ApplicationContext` 인터페이스의 구현체를 `GenericXmlApplicationContext`로 선택하고 `appConfig.xml` 설정 정보를 넘기면, XML 설정 기반 스프링 컨테이너를 생성할 수 있다.
  
## 스프링 빈
### 스프링 빈 설정 메타 정보 (BeanDefinition)
![](https://velog.velcdn.com/images/pipiolo/post/f3e243e3-8fba-44b4-925c-e333ffc082c0/image.png)

![](https://velog.velcdn.com/images/pipiolo/post/921d77ff-63f6-4090-bfbd-b2bc42964c22/image.png)

* `BeanDefinition`을 빈 설정 메타 정보라 한다.
* 역할과 구현의 분리
  * 스프링 컨테이너는 자바 코드인지, XML인지 몰라도 된다. 오직 `BeanDefinition`만 알면 된다.
  * 덕분에 다양한 설정 형식을 지원한다.
* 스프링 컨테이너는 `BeanDefinition`을 기반으로 스프링 빈을 생성한다.
* `xxxBeanDefinitionReader`를 통해 새로운 설정 형식이 추가되어도, 클아이언트의 코드 변경없이 `BeanDefinition`을 기반으로 스프링 빈을 생성할 수 있다.

> **참고**
> `BeanDefinition`을 직접 생성해서 스프링 컨테이너에 등록할 수 있다. 하지만, `BeanDefinition`을 직접 정의하거나 사용할 일은 없다.

---

# 싱글톤 컨테이너
## 웹 애플리케이션 이해
![](https://velog.velcdn.com/images/pipiolo/post/e20124b1-bfa1-47a4-96f9-a96ba9e79a33/image.png)

* 웹 애플리케이션은 여러 고객이 동시에 요청한다.
* 스프링이 없는 DI 컨테이너는 요청이 들어올 때 마다 객체를 생성한다. 
  👉 메모리 낭비 및 심각한 오류 발생
* 객체가 딱 1번만 생성되고 공휴하도록 설계한다. 👉 **싱글톤 패턴**

## 싱글톤 패턴
```java
public class Singleton {

    private static final Singleton instance = new Singleton();
    
    private Singleton() {
    }
    
    public static Singleton getInstance() {
        return this.instance;
    }
}
```

* 클래스의 인스턴스가 딱 1개만 생성되는 것을 보장한다.
  * private 생성자를 통해 외부에서 임의로 new 키워드를 사용하지 못 한다.
* 오직 `getInstance()`를 통해서만 인스턴스를 조회할 수 있다. 항상 같은 인스턴스를 보장한다.

### 문제점
* 구현 코드 자체가 많다.
* DIP, OCP 위반이다.
* 테스트 하기 어렵다.
* 자식 클래스를 만들기 어렵다.
* 유연성이 떨어진다.

## 싱글톤 컨테이너
![](https://velog.velcdn.com/images/pipiolo/post/75959149-c69e-4f1d-950c-8e279425c475/image.png)

* 스프링 컨테이너는 싱글톤 컨테이너 역할을 한다.
  * 싱글톤 객체를 생성하고 관리하는 기능을 싱글톤 레지스트리라 한다.
* 싱글톤 패턴의 모든 단점을 해결하고 객체 인스턴스를 1개만 보장한다.
* 고객이 요청이 들어올 때 마다 이미 만들어진 객체를 공유해서 효율적으로 재사용한다.

### 무상태 설계
* 여러 클라이언트가 하나의 객체 인스턴스를 공유하기 때문에 상태를 유지(`stateful`)하게 설계하면 안 된다.
* 무상태(`stateless`)로 설계해야 한다.
  * 특정 클라이언트에 의존적인 필드가 있으면 안 된다.
  * 특정 클라이언트가 값을 변경하면 안 된다.
    * 읽기만 지원해야 한다.
  * 공유되지 않는 지역변수, 파라미터, `ThreadLocal`을 사용해야 한다.
* 스프링 빈은 <span style="color: #FF8C00">항상 무상태(`stateless`)로 설계하자.</span>

> **참고**
> 스프링의 기본 빈 등록 방식은 싱글톤이지만, 싱글톤 방식만 지원하는 것은 아니다.

### 스프링의 싱글톤
```java
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl();
    }
}
```

![](https://velog.velcdn.com/images/pipiolo/post/b4a9e857-0abd-403e-b425-ac01983ccb0a/image.png)

* 스프링은 싱글톤을 보장하기 위해 클래스의 바이트코드를 조작하는 라이브러리 `CGLIB`를 사용한다.
  * `@Configuration`이 붙은 `AppConfig` 클래스를 조작한다.
* `AppConfig` 스프링 빈의 클래스 정보를 출력하면, `class hello.spring.AppConfig`가 아니다.
  * `class hello.spring.AppConfig$$EnhancerBySpringCGLIB$$bd479d70`
  * `CGLIB` 바이트코드 조작 라이브러리를 통해 `AppConfig` 클래스를 상속한 임의의 다른 클래스를 스프링 빈으로 등록했다.

#### AppConfig@CGLIB
```java
@Bean
public MemberService memberService() {
    
    if (memberService가 이미 스프링 컨테이너에 등록되어 있으면) {
        return 스프링 컨테이너에서 반환;
    }
    else {
        memberService를 생성하고 스프링 컨테이너 등록
        return 스프링 빈 반환;
    }
}
```

* 스프링 빈이 존재하면 스프링 빈을 반환하고, 없으면 객체를 생성해서 스프링 빈으로 등록 및 반환한다.
* 싱글톤이 보장된다.

> **참고**
> `@Bean`만 사용하면 스프링 빈으로 등록되지만, 싱글톤을 보장하지 않는다. 스프링의 싱글톤은 `@Configuration`이 담당한다. 스프링 설정 정보는 <span style="color: #FF8C00">항상 `@Configuration` 사용하자.</span>

---

# 컴포넌트 스캔
## 자동 스프링 빈 등록
```java
@ComponentScan
@Configuration
public class AutoAppConfig {
}

@Component
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;
    
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
    	this.memberRepository = memberRepository;
    }
}
```

* 스프링은 설정 정보가 없어도 자동으로 스프링 빈으로 등록하는 컴포넌트 스캔 기능(`@ComponentScan`)을 제공한다.
  * 의존관계를 자동으로 주입하는 `@Autowired` 기능도 제공한다.
* 컴포넌트 스캔은 `@Componet` 애노테이션이 붙은 클래스를 찾아서 스프링 빈으로 등록한다.
  * 설정 정보가 없기 때문에 클래스 안에서 의존관계 주입을 해결해야 한다.
  * `@Autowired`는 의존관계를 자동으로 주입해준다.
 
## 컴포넌트 스캔 시작 위치
```java
@ComponentScan(
		basePackages = "hello.spring"
)
```

* `basePackages` 👉 탐색할 패키지 시작 위치를 지정한다. 해당 패키지를 포함한 하위 패키지를 모두 탐색한다.
  * 지정하지 않으면, `@ComponentScan`이 붙은 클래스의 패키지가 시작 위치가 된다.
* 설정 정보 클래스의 위치를 프로젝트 최상단에 두는 것이 좋다.

> **참고**
> 스프링 부트의 `@SpringBootApllication`안에 `@ComponentScan`이 있다. `@SpringBootApllication`는 프로젝트 시작 루트에 위치하는 것이 기본이다.

## 컴포넌트 스캔 대상

* `@Component` 👉 컴포넌트 스캔 대상이 된다. 사실 다른 애노테이션들은 `@Component`를 포함하고 있기 때문에 컴포넌트 스캔의 대상이 되는 것이다.
* `@Configuration` 👉 스프링 설정 정보로 인식하고 스프링 빈이 싱글톤으로 유지하도록 한다.
* `@Controller` 👉 스프링 MVC 컨트롤러로 인식한다.
* `@Service` 👉 특별한 처리를 하지 않는다.
* `@Repository` 👉 스프링 데이터 접근 계층으로 인식하고 데이터 계층 에외를 스프링 예외로 변환한다.

> **참고**
> 사실 자바 애노테이션은 상속 관계가 없다. 스프링이 지원하는 기능이다.

## 빈 중복 등록

### 자동 빈 등록 vs 자동 빈 등록
* 컴포넌트 스캔에 의한 자동 등록 스프링 빈의 이름이 중복되면, `ConflictBeanDefinitionExcepion` 예외를 발생한다.

### 자동 빈 등록 vs 수동 빈 등록
* 수동 빈 등록이 우선권을 가진다.
  * 수동 빈이 자동 빈을 오버라이딩 한다.
  * 개발자가 의도적으로 이름을 중복시키는 경우는 거의 없다.
* 개발자의 의도와 다르게 이름이 중복되는 경우가 대부분이다.
  * 정말 잡기 어려운 버그가 만들어진다.
  * 이를 방지하고자 **스프링 부트는 예외를 발생시킨다.**
  
---

# 의존관계 자동 주입
* 필드 주입
* 수정자 주입 (setter 주입)
* 일반 메서드 주입
* 생성자 주입

## 필드 주입
```java
@Component
public class MemberServiceImpl implements MemberService {

	@Autowired
	private final MemberRepository memberRepository;
}
```

* 필드에 바로 의존 관계를 주입한다.
* 외부에서 변경이 불가능해서 테스트 하기 어렵다.
  * DI 프레임워크가 없는 순수 자바 코드 테스트는 불가능하다.
* <span style="color: #FF8C00">사용하지 말자.</span>

> **참고**
> 순수한 자바 테스트는 `@Autowired`가 동작하지 않는다. `@SpringBootTest` 스프링 컨테이너를 테스트에 통합한 경우에만 가능하다.
  
## 수정자 주입
```java
@Component
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;
    
    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
    	this.memberRepository = memberRepository;
    }
}
```

* setter 수정자 메서드를 통해서 의존 관계를 주입한다.
* 선택, 변경 가능성이 있는 의존 관계에서 사용한다.
* `@Autowired` 키워드가 필수이다.
  * `@Autowired`의 기본 동작은 주입할 대상이 없으면 오류가 발생한다. 
    * 주입할 대상이 스프링 빈으로 등록되어 있지 않다는 것이다.
  * `@Autowired(required = false)`로 지정하면 주입할 대상이 없어도 동작한다.

> **참고**
> 의존 관계 자동 주입은 스프링 컨테이너가 관리하는 스프링 빈이어야 한다. 스프링 빈이 아니면 동작하지 않는다.

## 일반 메서드 주입
* 일반 메서드를 통해서 의존 관계를 주입한다.
  * 사실 수정자 주입과 다르지 않다.
* 한 번에 여러 필드를 주입할 수 있다.
* 잘 사용하지 않는다.

## 생성자 주입
```java
@Component
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;
    
    // @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
    	this.memberRepository = memberRepository;
    }
}
```

* 생성자를 통해서 의존 관계를 주입받는다.
  * 딱 1번만 호출되는 것이 보장된다.
  * **생성자가 딱 1개만 있으면, 스프링 빈은 `@Autowired`를 생략해도 자동 주입된다. **
* 불변, 필수 의존 관계에서 사용한다.
  * `final` 키워드를 사용한다.
* <span style="color: #FF8C00">항상 생성자 주입을 사용하자.</span>

### 불변
* 대부분의 의존 관계는 변경할 일이 없다. 오히려 변하면 안 된다. 불변해야 한다.
* 수정자 주입은 `setXXX()` 메서드를 `public`으로 열어두어야 한다.
  * 누군가 실수로 변경할 수 있다. 좋은 설계가 아니다.
  
### 누락
* 생성자를 사용하기 때문에 의존 관계가 누락된 경우 컴파일 오류가 발생한다.
  * `IDE`에서 어떤 값을 주입해야 하는지 바로 알 수 있다.
* 수정자 주입은 의존관계 주입 메서드를 누락한 경우, 런타임 오류가 발생한다.

### final 키워드
* 필드에 `final` 키워드를 사용할 수 있다.
* 생성자에서 값이 누락되는 오류를 컴파일 시점에 막아준다.
  * 나머지 주입 방식은 모두 생성자 이후에 호출되므로 `final` 키워드를 사용할 수 없다. 

> **참고**
> 세상에서 제일 좋은 오류는 컴파일 오류이다.
> 애플리케이션 실행 시점(런타임)에 알려주는 오류가 그나마 낫다.
> 사용자가 직접 실행하는 시점(런타임)에 알려주는 오류는 최악이다.

> **참고**
> 기본으로 생성자 주입을 선택한다. 선택이나 변경이 필요한 경우에만 수정자 주입을 옵션으로 제공한다.

## @Autowired
### 빈이 2개 이상 조회될 때 - 문제점
```java
@Autowired
private DiscountPolicy discountPolicy
```

* `@Autowired`는 타입으로 조회한다.
  * `getBean(DiscountPolicy.class)`와 유사하게 동작한다. 실제로는 더 많은 기능을 제공한다.
* 조회되는 빈이 2개 이상일 때 문제가 발생한다.
  * `NoUniqueBeanDefinitionException` 예외가 발생한다.
  * `FixDiscountPolicy`, `RateDiscountPolicy` 중 어떤 구현체를 선택해야할지 정해야 한다.


### 해결책
* `@Autowired` 필드 명 매칭
* `@Qualifier` 
* `@Primary`

#### @Autowired 필드 명 매칭
```java
@Autowired
private DiscountPolicy rateDiscountPolicy
```
* `@Autowired` 매칭
  * 타입 매칭으로 조회한다.
  * 결과가 2개 이상일 때, 필드 명∙파라미터 명으로 스프링 빈 이름을 조회한다.
* 필드 명 매칭은 먼저 타입 매칭을 시도하고 그 결과에 따라 추가 동작하는 기능이다.

#### @Qualifier
```java
@Component
@Qualifier("mainDiscountPolicy")
public class RateDiscountPolicy implements DiscountPolicy{}

@Component
@Qualifier("fixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy{}

@Component
public class OrderServieImpl implements OrderServie {

	private final DiscountPolicy discountPolicy;
    
    @Autowired
	public OrderServieImpl(@Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
    	this.discountPolicy = discountPolicy;
    }
}
```

* `@Qualifier` 매핑
  * `@Qualifier`끼리 매칭
  * 스프링 빈 이름 매칭
  * `NoSuchBeanDefinitionException` 예외 발생
* `@Qualifier` 추가 구분자를 붙여준다. 스프링 빈 이름을 변경하는 것이 아니다.
* `@Qualifier`는 `@Qualifier`를 찾는 용도로만 사용하자.
  * `@Qualifier`의 이름을 못 찾는 경우 스프링 빈 이름을 조회하지만, <span style="color: #FF8C00">사용하지 말자.</span>

```java
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy{}

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{}
```

```java
@Autowired
public OrderServiceImpl(@MainDiscountPolicy DiscountPolicy discountPolicy) {
	this.discountPolicy = discountPolicy;
}
```

* `@Qualifier()`에 문자를 적으면 컴파일시 타입 체크가 안 된다.
  * 애노테이션을 만들어서 사용하자.
* 자바 애노테이션은 상속 개념이 없다. 여러 애노테이션을 모아서 사용하는 기능은 스프링이 지원한다.
  
#### @Primary
```java
@Component
@Primary
public class RateDiscountPolicy implements DiscountPolicy{}

@Component
public class FixDiscountPolicy implements DiscountPolicy{}
```
* `@Primary`는 우선권을 부여한다.

#### @Qualifier vs @Primary

* `@Primary`는 메인 스프링 빈에 사용하자.
* `@Qualifier`는 서브 스프링 빈에 지정해서 명시적으로 획득하자.
  * `@Primary`보다 `@Qualifier`가 우선 순위가 높다.

### 여러 빈을 조회할 때
```java
@Component
public class OrderServiceImpl implements OrderService {

	private List<DiscountPolicy> discountList;
	private final Map<String, DiscountPolicy> discountMap;
    
    public OrderServiceImpl(List<DiscountPolicy> discountList,
                            Map<String, DiscountPolicy> discountMap
    ) {
    	this.discountList = discountList;
    	this.discountMap = discountMap;
    }
}
```

* `Map<String, DiscountPolicy>` 
   👉 `Key`에 스프링 빈 이름을 넣는다.
   👉 `Value`에 스프링 빈을 넣는다.
* `List<DiscountPolicy>`
   👉 `DiscountPolicy` 타입으로 조회한 모든 스프링 빈을 넣는다.
   
## 자동∙수동 빈 등록
* 애플리케이션은 업무 로직과 기술 지원 로직으로 나뉜다.
* 업무 로직 👉 자동 빈 등록
  * 컨트롤러, 서비스 (비지니스 로직), 데이터 계층 등 비지니스 요구사항을 개발하는 기술들이다.
  * 등록되는 빈 숫자도 많고 유사한 패턴을 가지고 있다. 문제 원인이 명확하다.
    👉 자동 기능을 적극 사용하자.
* 기술 지원 로직 👉 수동 빈 등록
  * 기술적인 문제나 공통 관심사(`AOP`)를 처리할 때 사용된다.
  * 데이터베이스 연결, 공통 로그 처리 등 업무 로직을 지원하기 위한 공통 기술들이다.
  * 빈 숫자도 매우 적고 광범위하게 영향을 미친다. 문제 원인을 찾기가 어렵다.
    👉 명시적으로 수동 빈 등록을 사용하자.

> **정리**
> 애플리케이션에 광범위하게 영향을 주는 기술 지원 객체는 수동 빈 등록으로 설정 정보를 명확하게 하는 것이 좋다. 다형성을 적극 활용하는 비지니스 로직일 경우, 수동 등록도 고민해보자. 그 외에는 자동 빈 등록을 사용하자.

---


# 빈 생명주기 콜백

## 스프링 빈 라이프사이클
* 스프링 컨테이너 생성 → 스프링 빈 생성 → 의존관계 주입 → 초기화 콜백 → 사용 → 소멸전 콜백 → 스프링 종료
  * 초기화 콜백 👉 빈 생성 및 의존관계 주입 완료 후, 호출
  * 소멸전 콜백 👉 빈이 소멸되기 직전에 호출
* 스프링 빈 생명주기 콜백
  * 인터페이스 (InitializingBean, DisposableBean)
  * 설정 정보에 초기화, 종료 메서드 지정
  * `@PostConstruct`, `@PreDestroy`

> **참고**
> 객체의 생성과 초기화를 분리하자. 생성자는 파라미터를 받고 메모리를 할당해서 객체를 생성하는 책임을 가진다. 초기화는 생성된 값들을 활용해서 외부 커넥션 연결 등 무거운 동작을 수행한다. 객체 생성과 초기화를 명확하게 나누는 것이 유지보수 관점에서 좋다.

> **참고**
> 스프링 컨테이너의 시작과 종료까지 생존하는 빈도 있지만, 생명 주기가 짧은 빈들도 있다. 해당 빈은 종료되기 직전에 소멸전 콜백이 일어난다.

## 인터페이스 (InitializingBean, DisposableBean)
```java
public class Network implements InitializingBean, DisposableBean {
 	
    private String url;
    
    @Override
    public void afterPropertieswSet() throws Exception{
    	// 초기화 콜백
    }
    
    @Override
    public void destroy() throws Exception {
        // 소멸전 콜백
    }
}
```

* `InitializingBean`은 `afterPropertieswSet()` 메서드로 초기화한다.
* `DisposableBean`은 `destroy()` 메서드로 소멸을 지원한다.
* 초기화, 소멸 인퍼테이스 단점
  * 스프링 전용 인터페이스이다. 해당 클래스는 스프링 전용 인터페이스에 의존한다.
  * 초기화, 소멸 메소드의 이름을 변경할 수 없다.
  * 코드를 고칠 수 없는 외부 라이브러리에 적용할 수 없다.
* 현재는 사용되지 않는다. 사용하지 말자.

## 빈 등록 초기화, 소멸 메서드 지정
```java
@Configuration
public class NetworkConfig {

	@Bean(initMethod = "init", destroyMethod = "close")
	public Network network() {
    	return new Network();
    }
}

public class Network {
 	
    private String url;
    
    public void init() {
    	// 초기화 콜백
    }
    
    public void close() {
        // 소멸전 콜백
    }
}
```

* 메서드 이름을 자유롭게 줄 수 있다.
* 스프링 전용 인터페이스에 의존하지 않는다.
* 외부 라이브러리에도 초기화, 종료 메서드를 적용할 수 있다.

> **참고**
> `@Bean`의 `destroyMethod`속성은 종료 메서드 추론 기능을 제공한다. `@Bean`의 `destroyMethod`속성은 기본 값이 추론(`inferred`)이다. 대부분의 라이브러리는 `close`, `shutdown`이라는 이름의 종료 메소드를 사용한다. 이 추론 기능은 소멸전 콜백 시점에 `close`, `shutdown`라는 이름의 메소드를 자동으로 호출해준다. 스프링 빈으로 등록하면 종료 메서드는 따로 지정하지 않아도 잘 동작한다.
> `destroyMethod = ""`을 하면, 추론 기능이 동작하지 않는다.
 
 ## @PostConstruct, @PreDestroy
 ```java
 public class Network {
 	
    private String url;
    
    @PostConstruct
    public void init() {
    	// 초기화 콜백
    }
    
    @PreDestroy
    public void close() {
        // 소멸전 콜백
    }
}
```

* 스프링 종속적인 기술이 아닌, 자바 표준 기술이다.
  * 스프링에서 권장하는 방법이다.
  * 애노테이션 하나로 매우 편리하게 동작한다.
* 외부 라이브러리에는 적용되지 않는다.
  * 외부 라이브러리에 적용할 때는 `@Bean`의 기능을 사용하자.
  
---

# 빈 스코프
```java
@Scope("prototype")
@Component
public class Bean {}
```

```java
@Configuration
public class AppConfig {

	@Scope("prototype")
	@Bean
	PrototypeBean Bean() {
    	return new Bean();
	}
}
```

* 빈 스코프란 빈이 존재할 수 있는 범위를 말한다.
* 싱글톤 👉 기본 스코프로 스프링 컨테이너의 시작과 종료까지 유지되는 가장 넓은 범위의 스코프이다.
* 프로토 타입 👉 스프링 컨테이너는 빈의 생성과 의존관계 주입까지만 관여한다. 그 이후는 관리하지 않는다.
  * 초기화 메소드까지 호출해준다. 종료 메소드는 호출되지 않는다.
* 웹 관련 스코프
  * request 👉 웹 요청이 들어오고 나갈 때까지 유지되는 스코프이다.
  * session 👉 웹 세션이 생성되고 종료될 때까지 유지되는 스코프이다.
  * application 👉 웹의 서블릿 컨텍스트와 같은 범위로 유지되는 스코프이다.
  
## 프로토 타입 스코프
![](https://velog.velcdn.com/images/pipiolo/post/0a06fd19-4a1a-4496-b549-36dd00728673/image.png)

* 프로토 타입 스프링 빈을 조회하면, 스프링 컨테이너는 항상 새로운 인스턴스를 생성해서 반환한다.
* 스프링 컨테이너는 프로토 타입 빈 생성, 의존관계 주입 및 초기화까지만 처리한다. 그 이후는 관리하지 않는다.
  * 프로토 타입 빈을 관리할 책임은 클라이언트에 있다.
  * `@PreDestory` 등 종료 메서드가 호출되지 않는다. 클라이언트가 종료 메서드를 실행해야 한다.
  
### 싱글톤과 프로토 타입
* 싱글톤
  * 스프링 컨테이너 생성 시점에 초기화 메서드가 실행된다
  * 하나의 인스턴스를 공유해서 사용한다.
  * 스프링 컨테이너가 종료될 때 종료 메서드가 실행된다
* 프로토 타입
  * 스프링 컨테이너에서 빈을 조회할 때 생성 및 초기화 메서드가 실된다.  
  * 스프링 컨테이너에 요청할 때 마다 새로 생성된다.
  * 스프링 컨테이너는 빈 생생, 의존관계 주입 및 초기화까지만 관여한다. 그 이후는 관리하지 않는다.
  
### 싱글톤 빈에서 프로토 타입 빈 사용 - 문제점
![](https://velog.velcdn.com/images/pipiolo/post/50f368ef-8b9e-4103-82c5-073f1b12f6c8/image.png)

* `ClientBean` 싱글톤 빈이 의존관계 주입으로 `PrototypeBean` 프로토 타입 빈을 주입받는다.
* 개발자의 의도와 다르게 `PrototypeBean`이 **싱글톤 빈과 함께 계속 유지된다.**

> **참고**
> `ClientBean` 내부에 가지고 있는 `PrototypeBean`은 이미 주입이 끝난 빈이다. 스프링 컨테이너에 요청을 해서 새로운 빈이 생성되는 것이지, 프로토 타입 빈을 사용할 때마다 생성되는 것이 아니다. `PrototypeBean` 관리는 클라이언트인 `ClientBean`이 담당한다.

### Provider - 해결책
* 싱글톤 빈이 프로토 타입 빈을 사용할 때 마다 스프링 컨테이너에 요청하면 된다.
  * 사용할 때 마다 항상 새로운 프로토 타입 빈을 받을 수 있다.
* 의존 관계를 주입 받는 것(`DI`)이 아니라, 직접 필요한 의존 관계를 찾는 것을 Dependency Lookup(`DL`) 의존관계 조회라 한다.

#### ObjectFactory, ObjectProvider
```java
@Autowired
private ObjectProvider<PrototypeBean> prototypeBeanProvider;

public void logic() {
	PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
}
```

* `prototypeBeanProvider.getObject()` 항상 새로운 프로토 타입이 빈을 반환한다.
  * 내부에서 스프링 컨테이너를 통해 빈을 찾아서 반환한다. (`DL`) 
* `ObjectFactory`을 상속해서 편의 기능을 추가한 `ObjectProvider` 사용하자

#### JSR-330 Provider
```java
@Autowired
private Provider<PrototypeBean> provider;

public void logic() {
	PrototypeBean prototypeBean = provider.get();
}
```

* `provider.get()` 항상 새로운 프로토 타입이 빈을 반환한다.
  * 내부에서 스프링 컨테이너를 통해 빈을 찾아서 반환한다. (`DL`)
  * `get()` 메서드 하나로 기능이 매우 단순하다.
* 자바 표준이다.
  * 단위 테스트를 하기 쉽다.
  
> **정리**
> 매번 사용할 때 마다 의존관계 주입이 완료된 새로운 객체가 필요할 때 프로토 타입 빈을 사용한다. 프로토 타입 빈을 직접 사용하는 일은 매우 드물다. 대부분 싱글톤 빈으로 다 해결 가능하다.
> `ObjectProvider`, `Provider`는 `DL`이 필요한 경우 언제든지 사용할 수 있다.

> **참고**
> 자바 표준과 스프링 기능이 겹칠 때가 많다. 스프링이 더 다양하고 편리한 기능을 제공하기 때문에 다른 프레임워크를 사용할 계획이 없다면, 스프링이 제공하는 기능을 사용하자.

## 웹 스코프
* 웹 환경에서만 동작한다.
* 스프링 컨테이너가 해당 스코프의 종료시점까지 관리한다.
  * 종료 메서드가 호출된다.
* 종류
  * request 
    👉 HTTP 요청이 들어오고 나갈 때까지 유지되는 스코프이다. 
    👉 각각의 HTTP 요청마다 별도의 빈이 생성되고 관리된다.
  * session 👉 HTTP Session과 동일한 생명주기를 지닌 스코프이다.
  * application 👉 서블릿 컨텍스트와 동일한 생명주기를 지닌 스코프이다.
  * websocket 👉 웹 소켓과 동일한 생명주기를 지닌 스코프이다.

### Request 스코프
```java
@Scope(value = "request")
@Component
public class MyLogger {

	private String uuid;
    private String requestURL;
    
    @PostConstruct
    public void init() {
    	uuid = UUID.randomUUID().toString();
    }
    
    @PreDestroy
    public void close() {
    	
    }
}
```

![](https://velog.velcdn.com/images/pipiolo/post/c8cfa0f2-fcb7-492d-8e21-6398c7d430e3/image.png)

* `@Scope(value = "request")` 👉 `request` 스코프 스프링 빈을 생성한다.
  * HTTP 요청 당 하나씩 생성되고 요청이 끝나면 종료된다.
* 오류가 발생한다❗️
  * 애플리케이션 실행시점에 싱글톤 빈은 생성 및 주입이 가능하지만, `request` 스코프 빈은 아직 생성되지 않는다.
    * `@Component`는 애플리케이션 실행시점에 자동으로 빈을 생성하고 의존관계를 주입한다.
  * `request` 스코프 빈은 HTTP 요청이 들어와야 생성된다.
  * HTTP 요청이 들어올 때 까지 빈의 생성을 지연시켜야 한다.

> **참고**
> 만약 `request` 스코프를 사용하지 않으면 `uuid`, `request` 정보를 매개변수로 넘겨야만 한다. 그 이유는 웹은 동시에 여러 사용자의 요청을 처리하므로 무상태 설계를 해야하기 때문이다.
>
> 웹과 관련된 정보가 매개변수로 서비스 계층까지 넘어가게 된다. **서비스 계층은 순수 비지니스 로직으로 특정 기술에 종속되면 안 된다.** 웹 관련 기술들은 컨트롤러 계층에서 끝나야 한다. 데이터 접근 기술은 리포지토리 계층에서 끝나야 한다.

#### ObjectProvider - 해결책 1
```java
@Controller
public class Controller {

	private final ObjectProvider<MyLogger> myLoggerProvider;
    
    public void logic() {
    	MyLogger myLogger = myLoggerProvider.getObject();
    }
}
```

* `ObjectProvider.getObject()` 호출하는 시점까지 `Request` 스코프 빈 생성을 지연시킨다.
  * `ObjectProvider.getObject()` 호출하는 시점은 HTTP 요청이 진행 중이므로 `Request` 스코프 빈 생성이 정상 처리된다.
* `Controller`, `Service` 에서 각각 `ObjectProvider.getObject()`를 호출해도 같은 HTTP 요청이면 같은 스프링 빈이 반환된다.

#### 프록시 - 해결책 2
```java
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class MyLogger {
}
```

* `proxyMode = ScopedProxyMode.TARGET_CLASS)`
*  HTTP Request와 상관없이 `MyLogger` 프록시 객체를 만들어 스프링 빈으로 등록한다.
* 프록시 객체는 요청이 오면 내부에서 진짜 해당 빈을 요청하는 로직이 있다.
  * 바이트코드 조작 라이브러리 `CGLIB`를 이용해 `MyLogger`를 상속받은 프록시 객체를 생성한다.
  * 클라이언트는 프록시 객체인지 원본 객체인지 구별할 수 없다. 👉 상속, 다형성
* 프록시 객체는 `Request` 스코프와 관계가 없다. 마치 싱글톤 빈처럼 동작한다.
  * 싱글톤을 사용하는 것 같지만 실제로는 다르게 동작한다.
  
---