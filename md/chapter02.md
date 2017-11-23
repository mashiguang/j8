# stream

**终止操作**

**java7 try-with-resources**

## 流转换方法

**Stream<T> filter(Predicate<? super T> predicate);**
- Predicate 是一个从T到boolean的函数。
- Predicate 是一个接受一个参数，并返回boolean的函数。

**<R> Stream<R> map(Function<? super T, ? extends R> mapper);**
- map对流中每一个元素应用一个函数，并将返回结果收集到一个新的流中。
- Function 是一个接受`T类型参数`，并返回`R类型对象`的函数。

**<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);**
- 这里的Function是一个函数，它接受T类型参数，并返回`Stream<? extends R>`。
- flatMap会把所有的`Stream<? extends R>`平铺合并，最终返回

## 流聚合方法

`Stream`中返回值不是`Stream<T>`的方法，都是聚合方法?

**long count();**

**Optional<T> max(Comparator<? super T> comparator);**

**Optional<T> min(Comparator<? super T> comparator);**

**Optional<T> findAny();**

**boolean anyMatch(Predicate<? super T> predicate);**
- Predicate 是一个接受一个参数，并返回boolean的函数。

**boolean allMatch(Predicate<? super T> predicate);**

**boolean noneMatch(Predicate<? super T> predicate);**

## Optional

**public boolean isPresent()**

**public void ifPresent(Consumer<? super T> consumer)**
- if a value is present, invokde the specified consumer with the value, 
  otherwise do nothing.

**public T orElse(T other)**
- return the value if present, otherwise return other.

**public T orElse(T other)**

**public T orElseGet(Supplier<? extends T> other)**
- return the value if present, otherwise invoke other and return
  the result of that invocation.
- Supplier 是一个FunctionalInterface，无参数，返回T类型对象，如：
```java
String result = optionalString.orElseGet(() -> "other string");
```
**2.7.3 使用flatMap来组合可选值函数。这一节没看明白**

## 流终止操作 terminal operation

**void forEach(Consumer<? super T> var1);**
- 在并行流中，forEach不保证元素被遍历到的顺序
- 非并行流中，forEach遍历的顺序即是流中元素原有的顺序

**void forEachOrdered(Consumer<? super T> var1);**
- 即使在并行流中，forEachOrdered遍历的顺序还是流中元素原有的顺序
