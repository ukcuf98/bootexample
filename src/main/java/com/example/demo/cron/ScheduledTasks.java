package com.example.demo.cron;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Title: </p>
 * <p>
 * <p>Description:com.example.demo.controller</p>
 * <p>
 * <p>
 * @author lucifer
 * @version 1.0
 * @date 2018/10/10 10:07
 */
@Component
@Configurable
@EnableScheduling
public class ScheduledTasks {

	//每1分钟执行一次
	@Scheduled(cron = "0 */1 *  * * * ")
	public void reportCurrentByCron(){
		System.out.println ("Scheduling Tasks Examples By Cron: The time is now " + dateFormat ().format (new Date()));
	}

	private SimpleDateFormat dateFormat(){
		return new SimpleDateFormat ("HH:mm:ss");
	}
}
