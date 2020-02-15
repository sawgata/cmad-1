package com.syslog.manager.SyslogSimulator.api;

import java.util.List;

public interface Syslogs {

	void generateSyslog(int interval, int count) throws ResourceNotFoundException, SyslogException;

	void stopSyslogGeneration() throws ResourceNotFoundException, SyslogException;

	List<Syslog> findSyslogs() throws ResourceNotFoundException, SyslogException;
	
}
