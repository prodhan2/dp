package LAbCODE;


// AbstractLogger: চেইনের মূল অংশ
abstract class AbstractLogger {
   public static int INFO = 1;
   public static int DEBUG = 2;
   public static int ERROR = 3;

   protected int level;

   // পরের লগার চেইনে
   protected AbstractLogger nextLogger;

   public void setNextLogger(AbstractLogger nextLogger){
      this.nextLogger = nextLogger;
   }

   public void logMessage(int level, String message){
      if(this.level <= level){
         write(message);
      }
      if(nextLogger != null){
         nextLogger.logMessage(level, message);
      }
   }

   abstract protected void write(String message);
}

// ConsoleLogger ক্লাস
class ConsoleLogger extends AbstractLogger {

   public ConsoleLogger(int level){
      this.level = level;
   }

   @Override
   protected void write(String message) {
      System.out.println("Console Logger: " + message);
   }
}

// ErrorLogger ক্লাস
class ErrorLogger extends AbstractLogger {

   public ErrorLogger(int level){
      this.level = level;
   }

   @Override
   protected void write(String message) {
      System.out.println("Error Logger: " + message);
   }
}

// FileLogger ক্লাস
class FileLogger extends AbstractLogger {

   public FileLogger(int level){
      this.level = level;
   }

   @Override
   protected void write(String message) {
      System.out.println("File Logger: " + message);
   }
}

// Main ক্লাস
public class ChainPatternDemo {

   private static AbstractLogger getChainOfLoggers(){

      AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
      AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
      AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

      // চেইন তৈরি করা হচ্ছে
      errorLogger.setNextLogger(fileLogger);
      fileLogger.setNextLogger(consoleLogger);

      return errorLogger; // চেইনের শুরু
   }

   public static void main(String[] args) {
      AbstractLogger loggerChain = getChainOfLoggers();

      System.out.println("Sending INFO level message:");
      loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");

      System.out.println("\nSending DEBUG level message:");
      loggerChain.logMessage(AbstractLogger.DEBUG, "This is a debug level information.");

      System.out.println("\nSending ERROR level message:");
      loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");
   }
}
