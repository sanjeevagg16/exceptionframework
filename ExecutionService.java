package TaskExecutorService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.mkyong.config.AppConfig;

public class ExecutionService {
	
	public static String workingTaskService;
	public static ThreadPoolTaskExecutor executor;
	public static String methodName;
	
	public ExecutionService (String executionTaskService, String methodName){
		this.workingTaskService = executionTaskService;
		this.methodName = methodName;
	}
	
	static {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		executor = (ThreadPoolTaskExecutor) context
				.getBean("taskExecutor");
	}
	
	
	public static void main (String [] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		ThreadPoolTaskExecutor executor = (ThreadPoolTaskExecutor) context
				.getBean("taskExecutor");
		//for size of thread pool of 5 from appconfig.java
		for (int i = 0; i < 10; i++) {
            //Runnable worker = new WorkingThreadImpl("" + i);
            //executor.execute(worker);
			executeTask();
          }
	}
	
	public void excuteTask (String executionTask) {
		
		executeTask();
		
	}
	static void executeTask() {
		for (int i = 0; i < 10; i++) {
            //Runnable worker = new WorkingThreadImpl("" + i);
			//class name & method with parameters to be provide to get added in run method
			WorkingThreadImpl workingThreadImpl = new WorkingThreadImpl(workingTaskService, methodName);
            //executor.execute(new WorkingThreadImpl(executionTaskService.class, taskName));
			executor.execute(workingThreadImpl);
          }
	}
 
}

/*
public class SomethingThatShouldHappenInAThread {
    private TaskExecutor taskExecutor;
    private ClassWithMethodToFire classWithMethodToFire;

    public SomethingThatShouldHappenInAThread(TaskExecutor taskExecutor,
                                              ClassWithMethodToFire classWithMethodToFire) {
         this.taskExecutor = taskExecutor;
         this.classWithMethodToFire = classWithMethodToFire;
    }

    public void fire(final SomeParameterClass parameter) {
         taskExecutor.execute( new Runnable() {
              public void run() {
                   classWithMethodToFire.doSomething( parameter );
              }
         });
    }
}*/
