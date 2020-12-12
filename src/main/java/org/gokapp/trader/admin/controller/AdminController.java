package org.gokapp.trader.admin.controller;

import org.gokapp.trader.admin.services.CacheService;
import org.gokapp.trader.common.domain.AppInfo;
import org.gokapp.trader.common.domain.KVPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

	@Autowired
	private AppInfo appInfo;

	@Autowired
	private CacheService cacheService;

	@GetMapping(path = "/info")
	public AppInfo info() {

		return appInfo;
	}

	@GetMapping(path = "/")
	public AppInfo root() {
		return info();
	}

	@GetMapping(path = "/cachetest")
	public KVPair<String, String> testRedis() {
		
		return getValue("token");
	}

	@PostMapping(path = "/add")
	public void putValue(@RequestParam String key, @RequestParam String value) {
		this.cacheService.putValue(key, value);
	}

	@GetMapping(path = "/get/{key}")
	public KVPair<String, String> getValue(@PathVariable("key")String key){
		KVPair<String, String> response = new KVPair<>();
		response.setKey(key);
		String result = this.cacheService.getValue(response.getKey());
		response.setValue(result);
		return response;
	}

}
