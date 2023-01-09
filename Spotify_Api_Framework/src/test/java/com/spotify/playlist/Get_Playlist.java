package com.spotify.playlist;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

public class Get_Playlist extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from SpotifyData where SINO ='3)PlayList'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void playlists(String SINO, String id,String ids,String savedAlbums ,String queryparamkey,String pathParam) {

		HashMap<String, String> path_Param_Map = new HashMap<String, String>();
		path_Param_Map.put("playlist_id", id);
		
		Response response = ApiActionUtil.getMethodWithPathParam(path_Param_Map, Endpoints.Playlist,prop_constants.getProperty("status_code_200"), prop_constants.getProperty("content_type_json"));
		
		/* Validate json data */
		String actualName = ApiActionUtil.getResponseBodyValue(response, "tracks.items[0].track.album.artists[0].name");
		System.out.println(actualName);
		Assert.assertEquals("All Ok", actualName,"List is created with given name");

	}
	
}
