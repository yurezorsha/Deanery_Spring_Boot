package client;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.vstu.entity.Gr;
import com.vstu.entity.Stud;

public class RestClientUtil {

	public Gr getGrByIdDemo(int idGr) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/gr/{id}";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Gr> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Gr.class, idGr);
		Gr gr = responseEntity.getBody();

		return gr;
	}

	public void getStudByIdDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/stud/{id}";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Stud> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Stud.class,
				10100);
		Stud stud = responseEntity.getBody();
		System.out.println("Id:" + stud.getIdStud() + ", FIO:" + stud.getFIO());

	}

	public void getAllStudsDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/studs";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Stud[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Stud[].class);
		Stud[] studs = responseEntity.getBody();
		for (Stud s : studs) {
			System.out.println("Id:" + s.getIdStud() + ", FIO:" + s.getFIO());
		}
	}

	public void updateStudDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/stud";
		Stud objStud = new Stud();
		objStud.setPatronymic("Markovich");
		objStud.setCourse(1);
		objStud.setGr(getGrByIdDemo(2));
		objStud.setIdStud(12222);
		objStud.setSurName("Zobinho");
		objStud.setFirstName("Michailo");
		HttpEntity<Stud> requestEntity = new HttpEntity<Stud>(objStud, headers);
		restTemplate.put(url, requestEntity);
	}

	public void addStudDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/stud";
		Stud objStud = new Stud();
		objStud.setPatronymic("Markovich");
		objStud.setCourse(1);
		objStud.setGr(getGrByIdDemo(2));
		objStud.setIdStud(12222);
		objStud.setSurName("Zobin");
		objStud.setFirstName("Michail");

		HttpEntity<Stud> requestEntity = new HttpEntity<Stud>(objStud, headers);
		URI uri = restTemplate.postForLocation(url, requestEntity);
		System.out.println(uri.getPath());
	}

	public void deleteStudDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/stud/{id}";
		HttpEntity<Stud> requestEntity = new HttpEntity<Stud>(headers);
		restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);
	}

	public static void main(String args[]) {
		RestClientUtil util = new RestClientUtil();
		util.getStudByIdDemo();
		util.getAllStudsDemo();
		// util.addStudDemo();

		util.updateStudDemo();
		util.getAllStudsDemo();
		// util.deleteArticleDemo();
	}
}
