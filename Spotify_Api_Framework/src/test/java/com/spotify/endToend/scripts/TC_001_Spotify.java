package com.spotify.endToend.scripts;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

public class TC_001_Spotify extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from SpotifyData where SINO ='2)Artist'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void artist(String SINO, String id,String albumids,String savedAlbums ,String queryparamKey,String pathParam) {

		HashMap<String, String> path_Param_Map = new HashMap<String, String>();
		path_Param_Map.put("id", id);
		
		ApiActionUtil.getMethodWithPathParam(path_Param_Map, Endpoints.Artist,prop_constants.getProperty("status_code_200"), prop_constants.getProperty("content_type_json"));
		
		ApiActionUtil.getMethodWithPathParam(path_Param_Map, Endpoints.ArtistRelatedArists,
				prop_constants.getProperty("status_code_200"), prop_constants.getProperty("content_type_json"));
		
		ApiActionUtil.getMethodWithPathParam(path_Param_Map, Endpoints.ArtistAlbum,
				prop_constants.getProperty("status_code_200"), prop_constants.getProperty("content_type_json"));

		ApiActionUtil.getMethodWithPathParam(path_Param_Map, Endpoints.ArtistTopTracks,
				prop_constants.getProperty("status_code_200"), prop_constants.getProperty("content_type_json"));
	
	

	
	}

}
