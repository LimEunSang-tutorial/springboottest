package com.example.demo;

import java.util.HashMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

//command + shift + o
@CrossOrigin("*")
@RestController // java 객체를 json 형태로 바꿔준다
@RequestMapping(value="") // value로 시작되는 경로는 해당 controller가 처리
public class HelloController {
	@GetMapping("/getUserInfo")
	public HashMap<String, String> getUserInfo() {
		HashMap<String, String> map = new HashMap<String, String>();
		// java-HashMap = json
		// 키와 값 쌍으로 구성되는 데이터를 저장해서
		// 데이터를 읽고 쓸 때 키값을 찾아서 읽고 쓴다
		
		map.put("name", "홍길동");
		map.put("phone", "010-0000-0000");
		map.put("address", "서울시 관악구");
		
		return map;
	}
	
	@GetMapping("/add1")
	public HashMap<String, Object> add1(HttpServletRequest request, @RequestParam("x") int x, @RequestParam("y") int y) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("x", x);
		map.put("y", y);
		map.put("result", x + y);
		
		return map;
	}
	
	@GetMapping("/add2/{x}/{y}")
	public HashMap<String, Object> add2(HttpServletRequest request, @PathVariable("x") int x, @PathVariable("y") int y) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("x", x);
		map.put("y", y);
		map.put("result", x + y);
		
		return map;
	}
	
	@PostMapping("/add3")
	public HashMap<String, Object> add3(HttpServletRequest request, @RequestParam("x") int x, @RequestParam("y") int y) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("x", x);
		map.put("y", y);
		map.put("result", x + y);
		
		return map;
	}
	
	@PostMapping("/add4")
	public HashMap<String, Object> add4(@RequestBody HashMap<String, String> map) {
		// @RequestBody: json request 받기
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		int x = Integer.parseInt(map.get("x").toString());
		int y = Integer.parseInt(map.get("y").toString());
		
		resultMap.put("x", x);
		resultMap.put("y", y);
		resultMap.put("result", x + y);
		
		return resultMap;
	}
	
	@PostMapping("/calculate")
	public HashMap<String, Object> calculate(@RequestBody HashMap<String, String> map) {
		// @RequestBody: json request 받기
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		int time = Integer.parseInt(map.get("time"));
		int pay = Integer.parseInt(map.get("pay"));
		
		resultMap.put("result", time * pay);
		
		return resultMap;
	}
}

// http://localhost:8080/getUserInfo
// cf. Oracle express version도 8080 port 사용