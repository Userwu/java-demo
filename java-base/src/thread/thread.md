# Java中的多线程有三种实现方式：
1.   继承Thread类，重写run方法。Thread本质上也是一个实现了Runnable的实例，他代表一个线程的实例，并且启动线程的唯一方法就是通过Thread类的start方法。
2.   实现Runnable接口，并实现该接口的run()方法.创建一个Thread对象，用实现的Runnable接口的对象作为参数实例化Thread对象，调用此对象的start方法。
3.   实现Callable接口，重写call方法。Callable接口与Runnable接口的功能类似，但提供了比Runnable更强大的功能。有以下三点

> 1）. Callable可以在任务结束后提供一个返回值，Runnable没有提供这个功能。

> 2）. Callable中的call方法可以抛出异常，而Runnable的run方法不能抛出异常。

> 3）. 运行Callable可以拿到一个Future对象，表示异步计算的结果，提供了检查计算是否完成的方法。

_需要注意的是，无论用那种方式实现了多线程，调用start方法并不意味着立即执行多线程代码，而是使得线程变为可运行状态。_