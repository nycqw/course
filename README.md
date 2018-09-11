## 该文件用来存放spring 整合过程中涉及到的注意事项，比如jar包依赖，属性配置，编程配置等

## 集成SpringMVC
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>


## 集成lombok
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>
    说明：用来简化类，常用注解有：
    @Data 注解在类上；提供类所有属性的 getting 和 setting 方法，此外还提供了equals、canEqual、hashCode、toString 方法
    @Setter ：注解在属性上；为属性提供 setting 方法
    @Setter ：注解在属性上；为属性提供 getting 方法
    @Log4j/@Slf4j ：注解在类上；为类提供一个 属性名为log 的 log4j 日志对象
    @NoArgsConstructor ：注解在类上；为类提供一个无参的构造方法
    @AllArgsConstructor ：注解在类上；为类提供一个全参的构造方法
    @Cleanup : 可以关闭流
    @Builder ： 被注解的类加个构造者模式
    @Synchronized ： 加个同步锁
    @SneakyThrows : 等同于try/catch 捕获异常
    @NonNull : 如果给参数加个这个注解 参数为null会抛出空指针异常
    @Value : 注解和@Data类似，区别在于它会把所有成员变量默认定义为private final修饰，并且不会生成set方法。


## logback配置
    SpringBoot已经集成logback，只需配置logback-spring.xml 文件即可
    logback详细配置见配置文件，需要注意的是要在文件中指定一下日志存放根路径logging.path
    若配置文件在resources 根目录下则无需在application.properties 文件中指定，否则需要做如下配置：
    logging.config=classpath:logback-spring.xml
    logback 可以与lombok 配合使用，使用@Slf4j 注解可以使用log 对象进行日志输出


## 集成MyBatis 以及配置代码自动生成
    1、引入依赖
    <!-- MyBatis及自动代码生成 -->
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>1.3.1</version>
    </dependency>
    <dependency><!-- alibaba 的druid数据库连接池，若报错检查版本是否有问题 -->
        <groupId>com.alibaba</groupId>
        <artifactId>druid-spring-boot-starter</artifactId>
        <version>1.1.9</version>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
    <dependency><!--mybatis 自动生成插件-->
        <groupId>org.mybatis.generator</groupId>
        <artifactId>mybatis-generator-core</artifactId>
        <version>1.3.5</version>
    </dependency>

    <!-- mybatis generator 自动生成代码插件 -->
    <!-- 在项目根目录下cmd运行命令: mvn mybatis-generator:generate -e -->
    <plugin>
        <groupId>org.mybatis.generator</groupId>
        <artifactId>mybatis-generator-maven-plugin</artifactId>
        <version>1.3.2</version>
        <configuration>
            <configurationFile>${basedir}/src/main/resources/mybatis/mybatis-generator-config.xml</configurationFile>
            <overwrite>true</overwrite>
            <verbose>true</verbose>
        </configuration>
    </plugin>

    2、编辑generator文件
       mybatis/mybatis-generator-config.xml
       设置启动命令（Idea）：
       Run -> Edit Configurations -> + -> Maven -> Command line -> mybatis-generator:generate -e

    3、数据库配置
        spring:
            datasource:
                name: epay
                type: com.alibaba.druid.pool.DruidDataSource
                druid:
                  driver-class-name: com.mysql.jdbc.Driver
                  url: jdbc:mysql://127.0.0.1:3306/epay
                  username: root
                  password: root

    4、mybatis配置
        ## 该配置节点为独立的节点，有很多同学容易将这个配置放在spring的节点下，导致配置无法被识别
        mybatis:
            # 注意：一定要对应mapper映射xml文件的所在路径
            mapper-locations: classpath:mybatis/mapper/*.xml
            # 注意：对应实体类的路径
            type-aliases-package: com.example.demo.dao.entity

    5、在启动类上添加 @MapperScan("com.example.demo.dao.mapper")