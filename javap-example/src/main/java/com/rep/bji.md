### StackTraceElement 

堆栈跟踪中的元素，由Throwable.getStackTrace()返回。 每个元素代表一个堆栈帧。 除堆栈顶部的堆栈帧之外的所有堆栈帧表示方法调用。 堆栈顶部的框架表示生成堆栈跟踪的执行点。 通常，这是创建与堆栈跟踪相对应的throwable的点。

### LinkedBlockingQueue

基于链接节点的可选有界blocking queue 。 此队列命令元素FIFO（先进先出）。 队列的头部是队列中最长时间的元素。 队列的尾部是队列中最短时间的元素。 在队列的尾部插入新元素，队列检索操作获取队列头部的元素。 链接队列通常具有比基于阵列的队列更高的吞吐量，但在大多数并发应用程序中具有较低的可预测性能。
可选的容量绑定构造函数参数用作防止过多队列扩展的方法。 如果未指定，容量等于Integer.MAX_VALUE 。 每次插入时都会动态创建链接节点，除非这会使队列超出容量。

该类及其迭代器实现了Collection和Iterator接口的所有可选方法。

此类是Java Collections Framework的成员。

### Exception 异常 
```java
catch (IOException ex) {
     logger.error(ex);
     throw new MyException(ex.getMessage());
catch (SQLException ex) {
     logger.error(ex);
     throw new MyException(ex.getMessage());
}catch (Exception ex) {
     logger.error(ex);
     throw new MyException(ex.getMessage());
}
 在Java 7中，我们可以用一个catch块捕获所有这些异常：

catch(IOException | SQLException | Exception ex){
     logger.error(ex);
     throw new MyException(ex.getMessage());
}

// 异常创建输入的错误信息
exception.getMessage());
// 异常的错误堆栈信息
exception.printStackTrace();
// 堆栈帧集合
StackTraceElement[] traceElements = exception.getStackTrace();
```