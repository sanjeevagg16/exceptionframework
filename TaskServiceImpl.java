package TaskExecutorService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.mkyong.config.AppConfig;

public class TaskServiceImpl {
	public static ThreadPoolTaskExecutor executor;
	static {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		executor = (ThreadPoolTaskExecutor) context
				.getBean("taskExecutor");
	}
	
	public void processTask(){
		for (int i = 1; i <= 6; i++) {
			executor.execute(getRunnable(i));
		    }
	}
	
	private Runnable getRunnable(final int i) {
	    Runnable runnable = new Runnable() {
	      @Override
	      public void run() {
	    	  //TMService to be called
	        String randomString = WorkingSerice.getRandomString(i);
	        String randomString2 = new WorkingSerice().getNSRandomString(i);
	        System.out.println("String returned is :" + randomString + "=randomString2:="+randomString2);
	      }
	    };
	    return runnable;
	  }

}
