package com.spotify.playlist;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

public class Get_Playlist_Details extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from SpotifyData where SINO ='3)PlayList'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void playlists(String SINO, String id,String ids,String savedAlbums ,String queryparamkey,String pathParam) {

		HashMap<String, String> path_Param_Map = new HashMap<String, String>();
		path_Param_Map.put("playlist_id", id);
		
		JSONObject jobj=new JSONObject();
		jobj.put("name", prop_constants.getProperty("name"));
		jobj.put("description", prop_constants.getProperty("description"));
	//	jobj.put("public", prop_constants.getProperty("public"));
		
		ApiActionUtil.putMethodWithPathParamBody(path_Param_Map, Endpoints.Playlist, prop_constants.getProperty("status_code_200"),  jobj);

	}
}
