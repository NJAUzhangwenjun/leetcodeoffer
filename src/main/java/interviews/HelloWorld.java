package interviews;

class HelloWorld {

  public volatile boolean flag = true;

  private static volatile HelloWorld helloWorld = new HelloWorld();


  public void hello(int n) throws InterruptedException {

    for (int i = 0; i < n && flag; i++) {

      System.out.print("Hello");
      if (flag) {
          this.notify();
          flag = false;
      }
        this.wait();
    }
  }

  public void world(int n) throws InterruptedException {
    for (int i = 0; i < n && !flag; i++) {
      while (!flag) {
        this.wait();
      }
      System.out.println("World");
      flag = true;
      this.notify();
    }
  }

  public static void main(String[] args) {
    new Thread(
            () -> {
              // TODO:
              HelloWorld helloWorld = new HelloWorld();
              try {
                helloWorld.hello(10);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            },
            "HelloWorld-1")
        .start();
    new Thread(
            () -> {
              // TODO:
              HelloWorld helloWorld = new HelloWorld();
              try {
                helloWorld.world(10);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            },
            "HelloWorld-2")
        .start();
  }
}
