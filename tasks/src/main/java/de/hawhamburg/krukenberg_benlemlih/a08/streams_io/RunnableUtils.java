package de.hawhamburg.krukenberg_benlemlih.a08.streams_io;

/**
 * @author Youssef Benlehmlih
 * @author Jonas Krukenberg
 */
public class RunnableUtils {
  private RunnableUtils(){}

  public static void outputDuration(Runnable runnable,String functionName) {
    System.out.println(functionName + " took " + (countDuration(runnable)) + "ms");
  }

  public static long countDuration(Runnable runnable) {
    long runtime = System.currentTimeMillis();
    runnable.run();
    return System.currentTimeMillis() - runtime;
  }
}
