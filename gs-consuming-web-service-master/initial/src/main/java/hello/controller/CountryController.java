package hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hello.CountryClient;
import hello.wsdl.Country;
import hello.wsdl.ExistsCountryResponse;
import hello.wsdl.GetCountryResponse;

@RestController
@RequestMapping(value = "/country")
public class CountryController {

	@Autowired
	private CountryClient countryClient;

	@RequestMapping(value = "/countries/{country}", method = RequestMethod.GET)
	public GetCountryResponse findCountry(@PathVariable String country) {

		return countryClient.getCountry(country);
	}

	@RequestMapping(value = "/existsCountry/{country}", method = RequestMethod.GET)
	public ExistsCountryResponse existsCountry(@PathVariable String country) {
		return countryClient.existsCountry(country);
	}

}
