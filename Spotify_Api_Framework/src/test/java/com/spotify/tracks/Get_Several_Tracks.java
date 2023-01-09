package com.spotify.tracks;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

public class Get_Several_Tracks extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from SpotifyData where SINO ='7)tracks'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void tracks(String SINO, String id,String ids,String savedAlbums ,String queryparamkey,String pathParam) {

		HashMap<String, String> query_Param_Map = new HashMap<String, String>();
		query_Param_Map.put("ids", ids);
		
		ApiActionUtil.getMethodWithQueryParam(query_Param_Map, Endpoints.Tracks,
				prop_constants.getProperty("status_code_200"), prop_constants.getProperty("content_type_json"));
	}

}
