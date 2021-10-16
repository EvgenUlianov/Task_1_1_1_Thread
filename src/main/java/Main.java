import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Main {
     public static void main(String[] args) {
          final int timeOut15 = 15_000;
          final int timeOut5 = 5_000;
          System.out.println("Задача 1. Межпоточный диалог");

          ThreadGroup threadGroup = new ThreadGroup("MyGroup");
          Thread treads[] = {
                  new MyThread(threadGroup),
                  new MyThread(threadGroup),
                  new MyThread(threadGroup),
                  new MyThread(threadGroup)};
          for (Thread tread: treads)
               tread.start();

          try {
               Thread.sleep(timeOut5);
          } catch (InterruptedException e) {
               e.printStackTrace();
          }

          ThreadsBuffer buffer = ThreadsBuffer.get();
          buffer.setSleepComand(treads[0].getName(), Boolean.TRUE);

          try {
               Thread.sleep(timeOut5 + timeOut15);
          } catch (InterruptedException e) {
               e.printStackTrace();
          }

          threadGroup.interrupt();
     }
}
