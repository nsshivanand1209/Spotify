package com.spotify.shows;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

public class Get_Several_Shows extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from SpotifyData where SINO ='5)shows'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void shows(String SINO, String id,String ids,String savedAlbums ) {

		HashMap<String, String> query_Param_Map = new HashMap<String, String>();
		query_Param_Map.put("ids", ids);
		
		ApiActionUtil.getMethodWithQueryParam(query_Param_Map, Endpoints.Shows,
				prop_constants.getProperty("status_code_200"), prop_constants.getProperty("content_type_json"));
	}

}
