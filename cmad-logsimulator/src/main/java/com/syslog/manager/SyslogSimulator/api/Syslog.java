package com.syslog.manager.SyslogSimulator.api;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQuery(name= "Syslog.findBySeverity", query = "select s from Syslog s where s.syslogSeverity=?1")
@NamedQuery(name= "Syslog.countBySeverity", query = "select count(s) from Syslog s where s.syslogSeverity=?1")
public class Syslog {
	@Id
	@GeneratedValue
	private int id;
	private String description;
	public enum SEVERITY {EMERGENCY,ALERT,CRITICAL,ERROR,WARNING,NOTICE,INFORMATION,DEBUG};
	private SEVERITY syslogSeverity;
	private String source;
	private Timestamp syslog_time;
	public Syslog() {
		
	}
	public Syslog(String desc,SEVERITY sev) {
		this.description = desc;
		this.syslogSeverity = sev;
	}
	public Syslog(Syslog syslogListEntry) {
		this.description = syslogListEntry.getDescription();
		this.syslogSeverity = syslogListEntry.getSyslogSeverity();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public SEVERITY getSyslogSeverity() {
		return syslogSeverity;
	}
	public void setSyslogSeverity(SEVERITY syslogSeverity) {
		this.syslogSeverity = syslogSeverity;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Timestamp getSyslog_time() {
		return syslog_time;
	}
	public void setSyslog_time(Timestamp syslog_time) {
		this.syslog_time = syslog_time;
	}
	
	
}
