# 设计模式
>***推荐学习网站：https://refactoringguru.cn/design-patterns***

## 创建型模式
### 1. 工厂方法模式
>工厂方法模式是一种创建型设计模式， 其在父类中提供一个创建对象的方法， 允许子类决定实例化对象的类型。

![image](https://refactoringguru.cn/images/patterns/diagrams/factory-method/structure.png)

### 2. 抽象工厂模式
>抽象工厂模式是一种创建型设计模式， 它能创建一系列相关的对象， 而无需指定其具体类。

![image](https://refactoringguru.cn/images/patterns/diagrams/abstract-factory/structure.png)

### 3. 生成器模式（建造者模式）
>生成器模式是一种创建型设计模式， 使你能够分步骤创建复杂对象。 该模式允许你使用相同的创建代码生成不同类型和形式的对象。  
使用生成器模式可避免 “重叠构造函数 （telescopic constructor）” 的出现。

![image](https://refactoringguru.cn/images/patterns/diagrams/builder/structure.png)
