package com.scanbuy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringServiceController {

	@RequestMapping(value = "/addBook", method = { RequestMethod.GET,
			RequestMethod.POST }, headers = "Accept=application/json")
	public void addBook(@RequestParam("id") int id,
			@RequestParam("name") String name,
			@RequestParam("author") String author,
			@RequestParam("pageNum") int pageNum,
			@RequestParam("read") String read) {
		System.out.println(id + ":" + name + ":" + author + ":" + pageNum + ":"
				+ read);

	}

}