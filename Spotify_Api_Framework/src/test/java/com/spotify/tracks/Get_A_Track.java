package com.spotify.tracks;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

public class Get_A_Track extends BaseTest {
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from SpotifyData where SINO ='7)tracks'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void tracks(String SINO, String id,String ids,String savedAlbums ,String queryparamkey,String pathParam) {

//		HashMap<String, String> path_Param_Map = new HashMap<String, String>();
//		path_Param_Map.put("id", id);
//		
//		Response response = ApiActionUtil.getMethodWithPathParam(path_Param_Map, Endpoints.Track,
//				prop_constants.getProperty("status_code_200"), prop_constants.getProperty("content_type_json"));
//      
//		String actualSongName = ApiActionUtil.getResponseBodyValue(response, "name");
//		Assert.assertEquals(actualSongName, prop_constants.getProperty("songName"));
		
		String queryParm = null;
		String pathParm = null;
//		ApiActionUtil.getRequest( queryParm,  pathParm,Endpoints.Tracks,
	//			prop_constants.getProperty("status_code_200"));
	}
}
