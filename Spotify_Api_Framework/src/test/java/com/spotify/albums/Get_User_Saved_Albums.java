package com.spotify.albums;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

public class Get_User_Saved_Albums extends BaseTest{

	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from SpotifyData where SINO ='1)Albums'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void album(String SINO, String id,String albumids,String savedAlbums,String queryparamkey,String pathParam ) {

		HashMap<String, String> query_Param_Map = new HashMap<String, String>();
		query_Param_Map.put("ids", savedAlbums);
		
		ApiActionUtil.getMethodWithQueryParam(query_Param_Map, Endpoints.UsersavedAlbum,prop_constants.getProperty("status_code_200"), prop_constants.getProperty("content_type_json"));

	}
}
