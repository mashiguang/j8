# lambda

BiFunction有什么用？虽然可以声明一个BiFunction对象，但这个对象怎么用呢？

```java
BiFunction<String, String, Integer> comp = (first, second) -> Integer.compare(first.length(), second.length());
```

**方法引用等同于lambda表达式**

`System.out::println`等同于`System.out.println(x)`，`Math::pow`等同于`(x, y) -> Math.pow(x, y)`。

**Thread()可以接收一个方法引用**

see Lambda4

**1.5没明白**

lambda内，可以使用自由变量，但自由变量必须是final的，即不可改变的。
什么是自由变量，见1.6。
但这个限制也可以规避掉，如自由变量是一个`int a`，这个`a`是显然不能在lambda内改变；但是可以把这个`a`放到一个`array`里，
`arr\[0\]++`却是可以在lambda内执行。注意：这样线程不安全。

**类优先**, 当父类和父接口中 有同名方法时，父类中的方法优先被继承，父接口中的同名default method会被忽略。



    
