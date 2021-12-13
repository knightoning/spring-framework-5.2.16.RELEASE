
## 说明
基于spring-framework-5.2.16.RELEASE版本的一种学习，在次版本基础上新增
spring-kt 模块 用于对spring内容的学习

## IoC容器启动过程简析及XmlBeanFactory初始化
flowchat
st=>start: 开始
e=>end: 结束
op1=>operation: 初始化AbstractBeanFactory
op2=>operation: 初始化AbstractAutowireCapableBeanFactory
op3=>operation: 初始化DefaultListableBeanFactory
op4=>operation: 初始化XmlBeanFactory 
st->op1->op2->op3->op4->e

