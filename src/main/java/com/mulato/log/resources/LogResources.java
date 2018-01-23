package com.mulato.log.resources;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mulato.log.model.Log;
import com.mulato.log.service.LogService;

@RestController
@RequestMapping("/rest")
public class LogResources {
	
	@Autowired
	ResourceLoader loader;
	
	@Autowired
	LogService logService;
	
	@RequestMapping(value = "file", method = RequestMethod.GET)
	public String index() {
		String result = "false";
		Resource resource = loader.getResource("classpath:static/access.log");
		try {
			List<String> lines = Files.readAllLines(Paths.get(resource.getURI()), StandardCharsets.UTF_8);
			int count = 2;
			for (String line : lines) {
				line = line.replace('"',' ');
				String[] info = line.split("\\|");
				int total = info.length;
				if ((info != null) && total > 4) {
					count = count + 1;
					Log log = new Log();
					log.setId(Long.valueOf(count));
					log.setStartDate(info[0]);
					log.setIp(info[1]);
					log.setGetHttp(info[2]);
					log.setState(Integer.valueOf(info[3]).intValue());
					log.setClient(info[4]);
					logService.save(log);
				}
			} 
			result = "true";
        } catch (Exception e) {
            e.printStackTrace();
        }
		return result;
	}

}
