## spring 生命周期

- 通过main（）方法找到配置文件/扫描注解
- 通过反射机制创建创建Bean实例
- 通过set方法为各种属性设置默认值
- 实现各种XXXWire接口的setXXX方法

- 实现BeanPostProcess的前置处理方法postProcessBeforeInitialization()
- 实现InitialingBean接口的 afterPropertiesSet()
- 执行自定义的init-method 方法
- 实现后置处理Bean的方法 postProcessAfterInitializingBean()方法
- 使用Bean
- 实现DisposableBean接口，执行destroy方法
- 执行自定义的 destroy-method方法


