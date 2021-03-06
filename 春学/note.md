## 简介

spring理念：是现有的技术更加容易使用，本身是一个大杂烩。

- SSH：Struct2 + Spring + Hibernate
- SSM: SpringMVC + Spring + Mybatis

官网： https://spring.io/projects/spring-framework#overview

官方下载： https://repo.spring.io/release/org/springframework/spring/

GitHub： https://github.com/spring-projects/spring-framework

[Spring Web MVC](https://mvnrepository.com/artifact/org.springframework/spring-webmvc) **»** [5.2.5.RELEASE](https://mvnrepository.com/artifact/org.springframework/spring-webmvc/5.2.5.RELEASE)

```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.5.RELEASE</version>
</dependency>

<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.2.3.RELEASE</version>
</dependency>
```

- spring是开源的免费的容器。
- spring是一个轻量级的，非入侵式的。
- 控制反转（IOC），面向切面编程 (AOP)。
- 支持事务处理，对框架整合的支持。

总结：spring是一个轻量级的控制反转(IOC)和面向切面编程(AOP)的框架。

## IOC理论

1. UserDao
2. UserDaoImp
3. UserSevice
4. UserServiceImp

在之前，用户的需求可能会影响原来的代码。

使用一个set。

```java
public void setUserDao(UserDao userDao){
    this.userDao = userDao;
}
```

- 之前是主动创建对象，控制权在程序员手上。
- 使用set之后，是被动接受对象。

## Hello Spring

pojo中

```java
package com.hou.pojo;

public class Hello {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

resource种

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--bean = 对象-->
    <!--id = 变量名-->
    <!--class = new的对象-->
    <!--property 相当于给对象中的属性设值-->
    
    <bean id="hello" class="com.hou.pojo.Hello">
        <property name="name" value="Spring"/>
    </bean>
</beans>
```

test

```java
import com.hou.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {

    public static void main(String[] args) {
        //获取spring上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //我们的对象下能在都在spring·中管理了，我们要使用，直接取出来就可以了
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());
    }
}
```

bean = 对象
id = 变量名
class = new的对象
property 相当于给对象中的属性设值

核心用set注入

第一个文件中

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="userdaomysql" class="com.hou.dao.UserDaoMysqlImpl"></bean>

    <bean id="userServiceImpl" class="com.hou.service.UserServiceImp">
        <!--ref引用spring中已经创建很好的对象-->
        <!--value是一个具体的值-->
        <property name="userDao" ref="userdaomysql"/>
    </bean>

</beans>
```

## IOC创建对象的方式

1. 使用无参构造创建对象，默认。
2. 使用有参构造

下标赋值

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="user" class="com.hou.pojo.User">
        <constructor-arg index="0" value="hou"/>
    </bean>
</beans>
```

类型赋值（不建议使用）

```xml
<bean id="user" class="com.hou.pojo.User">
    <constructor-arg type="java.lang.String" value="dong"/>
</bean>
```

直接通过参数名

```xml
<bean id="user" class="com.hou.pojo.User">
    <constructor-arg name="name" value="hou"></constructor-arg>
</bean>
```

Spring类似于婚介网站！

你想不想要，对象都在里面。注册bean之后用不用被实例化。

## Spring配置

**别名**

```xml
<bean id="user" class="com.hou.pojo.User">
    <constructor-arg name="name" value="hou"></constructor-arg>
</bean>

<alias name="user" alias="user2aaa"/>
```

**Bean的配置**

- id：bean的id标识符
- class：bean对象所对应的类型
- name：别名，更高级，可以同时取多个别名。

**import**

一般用于团队开发，它可以将多个配置文件，导入合并为一个

```xml
<import resource="beans.xml"/>
```


## 常用依赖

```xml

<dependencies>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.2.9.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## 注解说明

- @Autowired : 自动装配通过类型。名字 如果Autowired不能唯一自动装配上属性,则需要通过@Qualifier(value="xxx")
- @Nullable 字段标记了这个注解,说明这个字段可以为null;
- @Resource : 自动装配通过名字。类型


- @Component = 组件,放在类上,说明这个类被Spring管理了,就是Bean.
- @Component 有几个衍生注解, 我们在Web开发中,会按照MVC三层架构分层{
- dao[@Repository : 贮藏库,仓库；知识库;智囊库 ]
- service[@Service]
- controller[@Controller]
- 这四个注解功能都是一样的,都是代表将某个类注册到Spring中,装配Bean }


- @Value注解 相当于<property name="name" value="xxx"/>的简写,简单的可以走注解,比较难的还是走配置文件

## 小结

### xml与注解:

- xml更加万能,是由于任何场合,维护更加方便
- 注解 不是自己类使用不了,维护相对复杂<br/>
  xml与注解最佳实践:
- xml用来管理Bean
- 注解只负责完成属性的注入
- 我们在使用的过程中,只需要注意一个问题,必须让注解生效,就需要开启注解的支持

```
<!--指定要扫描的包,这个包下的注解就会生效-->
<context:component-scan base-package="com.kuang"/>
<!--        开启注解的支持-->
      <context:annotation-config/>
```

## 使用Java的方式配置Spring

- 我们现在要完全不使用Spring的xml配置,全权交给Java来做
- JavaConfig是Spring一个子项目,在Spring4之后,它成为了一个核心功能

## Spring三大素

- Spring所有的类,都需要装配到bean标签里面
- 所有的bean都需要通过容器去取
- 容器里取得的bean拿出来的这个对象,然后去调用这个对象就好了

## 动态代理

- 代码都是死的 要修改的地方只有target 方法很简单 理解清楚就行了

```java
//等我们会使用这个类,自动生成代理类.
public class ProxyInvocationHandler implements InvocationHandler {

    //    被代理的接口
    private Object target;


    public void setTarget(Object target) {
        this.target = target;
    }

    //    生成得到代理类
    public Object getproxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    //    处理代理实例,并返回结果 :
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        动态代理的本质,就是使用反射机制实现
        log(method.getName());
        Object result = method.invoke(target, args);
        return result;
    }

    public void log(String msg) {
        System.out.println("xxx" + msg + "xxx");
    }
}
```

### 动态代理的好处

- 可以使真实角色的操作更加纯粹,不用去关注一些公用的业务
- 公共的就交给代理角色,实现了业务的分工
- 公共业务发生扩展的时候,方便集中管理
- 一个动态代理类代理的是一个接口,一般就是对应的一类业务
- 一个动态代理类可以代理多个类,只要是实现了同一个接口即可

## AOP代理模式

Dao-Service-Controller-前端已经传输到前端实现结果,正常程序跑完之后,没问题,代码已经上线了<br/>
达到了用户的需求,如果还需要修改东西,在不破坏代码的前提下<br/>
需要修改,这时候就可以用到 代理模式 去修改就行了。

### AOP在Spring中的作用

#### 提供声明式事务:允许用户自定义切面

- 横切关注点:跨越应用程序多个模块的方法或功能,即是 与我们业务逻辑无关的,但是我们需要关注的部分,就是横切关注点,如日志 安全 缓存 事务等等
- 切面(ASPECT) : 横切关注点被模块化的特殊对象 即 它是一个类
- 通知(Advice) : 切面必须要完成的工作 即 它是类中的一个方法
- 目标(Target) : 被通知的对象
- 代理(Proxy)  : 向目标对象应用通知之后创建的对象
- 切入点(PointCut) : 切面通知 执行的"地点"的定义
- 连接点(JoinPoint) : 与切入点匹配的行点

```xml
        <!--    方式一:使用原生Spring API接口[主要Spring API接口实现]-->
<!--    配置AOP:需要导入AOP的约束-->
<aop:config>
    <!--        切入点:expression 表达式:execution(要执行的配置 ***)-->
    <aop:pointcut id="poincut" expression="execution(* com.kuang.service.UserServiceImpl.*(..))"/>
    <!--        执行环绕增加-->
    <aop:advisor advice-ref="log" pointcut-ref="poincut"/>
    <aop:advisor advice-ref="afterlog" pointcut-ref="poincut"/>
</aop:config>
```
```html
        <!--    方式二:自定义类[主要是切面定义]-->
<bean id="diy" class="com.kuang.diy.DiyPointCut"/>
<aop:config>
<!--        自定义切面, ref 要引用的类-->
<aop:aspect ref="diy">
    <!--            切入点-->
    <!--            第一个*号代表的是任意访问修饰符的方法,第二个*号是指定类下的所有方法,..代表任意参数-->
    <aop:pointcut id="point" expression="execution(* com.kuang.service.UserServiceImpl.*(..))"/>
    <!--            通知-->
    <aop:before method="before" pointcut-ref="point"/>
    <aop:after method="after" pointcut-ref="point"/>
</aop:aspect>
</aop:config>
```
