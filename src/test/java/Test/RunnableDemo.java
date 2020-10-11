package Test;

/*class MyThread implements Runnable { // 实现Runnable接口,作为线程的实现类

  private String name; // 表示线程名称

  public MyThread(String name) {
    this.name = name; // 通过构造方法配置name属性
  }

  @Override
  public void run() { // 覆写run()方法,作为线程的操作主体
    for (int i = 0; i < 10; i++) {
      System.out.println(name + "运行,i = " + i);
    }
  }
}

public class RunnableDemo{
  public static void main(String[] args) {
    MyThread m1 = new MyThread("线程A "); //实例化对象
    MyThread m2 = new MyThread("线程B "); //实例化对象
    Thread t1 = new Thread(m1); //实例化Thread类对象
    Thread t2 = new Thread(m2); //实例化Thread类对象
    t1.start();//启动多线程
    t2.start();//启动多线程
  }
}*/
class MyThread extends Thread { // 继承Thread类,作为线程的实现类

  private String name; // 表示线程名称

  public MyThread(String name) {
    this.name = name; // 通过构造方法配置name属性
  }

  public void run() { // 覆写run()方法,作为线程的操作主体
    for (int i = 0; i < 10; i++) {
      System.out.println(name + "运行,i = " + i);
    }
  }
}

public class RunnableDemo{
  public static void main(String[] args) {
    MyThread m1 = new MyThread("线程A "); //实例化对象
    MyThread m2 = new MyThread("线程B "); //实例化对象
    m1.start();//启动多线程
    m2.start();//启动多线程
  }
}