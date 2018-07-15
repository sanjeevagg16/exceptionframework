package TaskExecutorService;

public class WorkingThreadImpl implements Runnable  {
	
	private String command;
	public String className;
    
    public WorkingThreadImpl(String className, String executionTask){
        this.command=executionTask;
        this.className = className;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
        //processCommand(command);
        System.out.println(Thread.currentThread().getName()+" End.");
    }

    private void processCommand() {
        try {
        	//class & method to be started
        	//className.executionTask();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.command;
    }

}
