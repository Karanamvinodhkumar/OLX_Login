package com.user;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "bug-fix")
public class BugFixes {
	
static Map<String,List<String>> bugfixmap = new HashMap<>();
	
	@PostConstruct
	public void init()
	{
		bugfixmap.put("v1", Arrays.asList("Invalid status issue", "Application closing not working"));
		bugfixmap.put("v2", Arrays.asList("Window size change not working", "Window minimizing not working"));

	}
	
	
	@ReadOperation
	public Map<String,List<String>> getBugFixes()
	{
		return bugfixmap;
	}
	
	@ReadOperation
	public List<String> getBugFix(@Selector String version)
	{
		return bugfixmap.get(version);
	}
	
	@WriteOperation
	public void addBugFixes(@Selector String version,String bugs)
	{
		bugfixmap.put(version, Arrays.asList(bugs.split(",")));
	}
	
	@DeleteOperation
	public void removeBugFix(@Selector String version)
	{
		bugfixmap.remove(version);
	}


}
