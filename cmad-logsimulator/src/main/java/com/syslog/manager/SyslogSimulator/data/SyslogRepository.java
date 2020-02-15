package com.syslog.manager.SyslogSimulator.data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.syslog.manager.SyslogSimulator.api.Syslog;


@Repository
public interface SyslogRepository extends JpaRepository<Syslog, Integer> {

}