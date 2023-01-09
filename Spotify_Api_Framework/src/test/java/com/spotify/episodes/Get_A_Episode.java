package com.spotify.episodes;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

public class Get_A_Episode extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from SpotifyData where SINO ='6)episode'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void shows(String SINO, String id,String ids,String savedAlbums ,String queryparamkey,String pathParam) {

		HashMap<String, String> path_Param_Map = new HashMap<String, String>();
		path_Param_Map.put("id", id);
		
		Response response = ApiActionUtil.getMethodWithPathParam(path_Param_Map, Endpoints.Episode,
				prop_constants.getProperty("status_code_200"), prop_constants.getProperty("content_type_json"));
		System.out.println(response);
		
		String episodeName = ApiActionUtil.getResponseBodyValue(response, "name");
		System.out.println(episodeName);
		Assert.assertEquals(episodeName, prop_constants.getProperty("episodeName"));
		
	}
}
