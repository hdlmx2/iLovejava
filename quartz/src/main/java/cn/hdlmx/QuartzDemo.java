package cn.hdlmx;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzDemo implements Job {
    private String EXPRESSION="";
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("hello");
    }

    public static void main(String[] args) throws JobExecutionException {
        new QuartzDemo().execute(null);
    }
}
