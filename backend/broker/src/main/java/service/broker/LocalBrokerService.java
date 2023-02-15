package service.broker;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import service.core.ClientApplication;
import service.core.ClientInfo;
import service.core.Quotation;

import java.net.URISyntaxException;
import java.util.*;

/**
 * Implementation of the broker service.
 * 
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LocalBrokerService {
	final static List<String> serviceURIs = new ArrayList<String>() {
		{
			add("http://auldfellas:10001/quotations");
			add("http://girlpower:10002/quotations");
			add("http://dodgydrivers:10003/quotations");
		}
	};

	public HashMap<Integer, ClientApplication> cache = new HashMap<>();
	public ClientInfo currentUser;

	@PostMapping("/user")
	public ResponseEntity<?> saveUser(@RequestBody ClientInfo user) {
		this.currentUser = user;
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@PostMapping("/quotes")
	public ResponseEntity<?> getAllQuotations(@RequestBody ClientInfo user) {
		if (this.currentUser.equals(user)) {
			RestTemplate restTemplate = new RestTemplate();
            HttpEntity<ClientInfo> request = new HttpEntity<>(this.currentUser);
            ClientApplication quotations = restTemplate.postForObject("http://broker:8080/applications",request, ClientApplication.class);
			return new ResponseEntity<>(quotations, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/applications", method = RequestMethod.POST)
	public ResponseEntity<ClientApplication> getQuotations(@RequestBody ClientInfo info) {
		List<Quotation> quotations = new LinkedList<Quotation>();
		for (String url : serviceURIs) {
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<ClientInfo> request = new HttpEntity<>(info);
			quotations.add(restTemplate.postForObject(url, request, Quotation.class));
		}
		ClientApplication clientApplication = new ClientApplication(info, quotations);
		cache.put(clientApplication.getApplicationNumber(), clientApplication);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(clientApplication, headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/applications/{appId}", method = RequestMethod.GET)
	public ClientApplication getApplication(@PathVariable("appId") int appId) throws URISyntaxException {
		return cache.get(appId);
	}

	@RequestMapping(value = "/applications", method = RequestMethod.GET)
	public Map<Integer, ClientApplication> getApplication() throws URISyntaxException {
		return cache;
	}

}
