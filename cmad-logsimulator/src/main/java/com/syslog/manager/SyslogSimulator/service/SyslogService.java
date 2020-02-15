package com.syslog.manager.SyslogSimulator.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syslog.manager.SyslogSimulator.api.ResourceNotFoundException;
import com.syslog.manager.SyslogSimulator.api.Syslog;
import com.syslog.manager.SyslogSimulator.api.Syslog.SEVERITY;
import com.syslog.manager.SyslogSimulator.api.SyslogException;
import com.syslog.manager.SyslogSimulator.api.Syslogs;
import com.syslog.manager.SyslogSimulator.data.SyslogRepository;


@Service
public class SyslogService implements Syslogs{
	@Autowired
	private SyslogRepository syslogRepo;
	static boolean isSimulatorStopped = true;
	
	@Override
	public void generateSyslog(int interval, int count) throws ResourceNotFoundException, SyslogException{
		// TODO Auto-generated method stub
		if(!isSimulatorStopped) {
			System.out.println("Simulator already running");
			return;
		}
		isSimulatorStopped = false;
		List<Syslog> syslogList = new ArrayList<>();
		syslogList.add(new Syslog("Too many connections open to DB",SEVERITY.ERROR));
		syslogList.add(new Syslog("Interface gig0/0 is down",SEVERITY.WARNING));
		syslogList.add(new Syslog("User john logged in successfully",SEVERITY.NOTICE));
		syslogList.add(new Syslog("High availability connection to device is down",SEVERITY.WARNING));
		syslogList.add(new Syslog("Invalid credentials",SEVERITY.WARNING));
		syslogList.add(new Syslog("Too many connections open to DB",SEVERITY.ERROR));
		syslogList.add(new Syslog("Use admin looged in",SEVERITY.ALERT));
		syslogList.add(new Syslog("DB service is down",SEVERITY.CRITICAL));
		syslogList.add(new Syslog("Port already in use",SEVERITY.DEBUG));
		syslogList.add(new Syslog("Unable to receive connection events",SEVERITY.WARNING));
		syslogList.add(new Syslog("New module added successfully",SEVERITY.NOTICE));
		syslogList.add(new Syslog("User logged out",SEVERITY.NOTICE));
		syslogList.add(new Syslog("SSH connection is down",SEVERITY.CRITICAL));
		syslogList.add(new Syslog("CDP connectivity down",SEVERITY.ERROR));
		syslogList.add(new Syslog("New neighbour detected",SEVERITY.ALERT));
		syslogList.add(new Syslog("vPC1 is inconsistent",SEVERITY.WARNING));
		List<String> ipList = new ArrayList<>();
		ipList.add("10.124.111.12");
		ipList.add("10.124.111.1");
		ipList.add("10.124.111.2");
		ipList.add("10.124.111.13");
		ipList.add("10.124.111.4");
		ipList.add("10.124.111.52");
		ipList.add("10.124.111.77");
		ipList.add("10.124.111.34");
		ipList.add("10.124.111.33");
		ipList.add("10.124.111.65");
		ipList.add("10.124.111.16");
		ipList.add("10.124.111.45");
		ipList.add("10.124.111.36");
		ipList.add("10.124.111.73");
		ipList.add("10.124.111.74");
		ipList.add("10.124.111.78");
		ipList.add("10.124.111.82");
		ipList.add("10.124.111.95");
		ipList.add("10.124.111.89");
		ipList.add("10.124.111.55");
		ipList.add("10.124.111.62");
		System.out.println("Running Simulator");
		while(!isSimulatorStopped) {
			//List<Syslog> persistList = new ArrayList<>();
			boolean bException = false;
			for(int i=0;i<count;i++) {
				try {
				int syslogSample = (int) ((Math.random()*1000))%syslogList.size();
				int sourceSample = (int) ((Math.random()*1000))%ipList.size();
				Syslog syslogListEntry = syslogList.get(syslogSample);
				Syslog tempSyslog = new Syslog(syslogListEntry);
				String source = ipList.get(sourceSample);
				tempSyslog.setSource(source);
				tempSyslog.setSyslog_time(new Timestamp(System.currentTimeMillis()));
				//persistList.add(tempSyslog);
				System.out.println("Persisting "+tempSyslog.getDescription());
				syslogRepo.save(tempSyslog);
				bException = false;
				}catch(Exception ex) {
					System.out.println(ex);
					bException=true;
				}
			}
			//syslogRepo.saveAll(persistList.iterator());
			try {
				if(!bException)
					Thread.sleep(interval*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void stopSyslogGeneration() throws ResourceNotFoundException, SyslogException{
		// TODO Auto-generated method stub
		isSimulatorStopped = true;
		
	}
        
	@Override
	public List<Syslog> findSyslogs() throws ResourceNotFoundException, SyslogException{
		// TODO Auto-generated method stub
		List<Syslog> syslogs = new ArrayList<>();
		syslogRepo.findAll().forEach(syslogs::add);
		return syslogs;
		
	}
} 