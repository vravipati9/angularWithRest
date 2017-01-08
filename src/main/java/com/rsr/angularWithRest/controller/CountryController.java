package com.rsr.angularWithRest.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rsr.angularWithRest.bean.Country;
import com.rsr.angularWithRest.service.CountryService;


@Path("/countries")
public class CountryController {
	
	CountryService countryService=new CountryService();

	private int count = 0;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/testSingleton")
	public String getMessage() {
		count++;
		return "{ "+count+" }";
	}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<Country> getCountries()
	{
		
		List<Country> listOfCountries=countryService.getAllCountries();
		return listOfCountries;
	}

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Country getCountryById(@PathParam("id") int id)
	{
		return countryService.getCountry(id);
	}
   
    @POST
    @Produces(MediaType.APPLICATION_JSON)
	public Country addCountry(Country country)
	{
		return countryService.addCountry(country);
	}

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
	public Country updateCountry(Country country)
	{
		return countryService.updateCountry(country);
		
	}
	
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public void deleteCountry(@PathParam("id") int id)
	{
		 countryService.deleteCountry(id);
		
	}
	
}
