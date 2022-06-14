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
