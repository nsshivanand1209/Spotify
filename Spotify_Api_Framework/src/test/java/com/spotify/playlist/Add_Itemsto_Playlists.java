package com.spotify.playlist;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

public class Add_Itemsto_Playlists extends BaseTest{
	

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from SpotifyData where SINO ='3)PlayList'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void playlists(String SINO, String id,String ids,String savedAlbums ,String queryparamkey,String pathParam) {
        String [] uris= {"spotify:track:4iV5W9uYEdYUVa79Axb7Rh"};
		HashMap<String, String> path_Param_Map = new HashMap<String, String>();
		path_Param_Map.put("playlist_id", id);
		JSONObject jobj = new JSONObject();
		jobj.put("uris", uris);
        jobj.put("position", 0);
		ApiActionUtil.postMethodWithPathParamBody(path_Param_Map, Endpoints.PlaylistItems, prop_constants.getProperty("status_code_201"), prop_constants.getProperty("content_type_json"), jobj);
	}
}
