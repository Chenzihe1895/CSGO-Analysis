package com.example.demo.controller;

import java.util.List;

import com.example.demo.service.ConnectKylinService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/csgo")
@CrossOrigin
public class ConnectKylinController {

	@Autowired
	private ConnectKylinService connectKylinService;



	@GetMapping(value = "/query")
	@ResponseBody
	public String query(@ApiParam(value = "SQL", required = true) @RequestParam(value = "SQL") String SQL) throws Exception {
		return connectKylinService.query(SQL);
	}

}
