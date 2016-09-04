package diplomski.thop.thopmobileclient.controller.requests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import diplomski.thop.thopmobileclient.controller.implementation.Urls;
import diplomski.thop.thopmobileclient.model.Item;

public class GetItemList {
	OkHttpClient client;

	public GetItemList() {
		client = new OkHttpClient();
	}

	public List<Item> getItemList() {
		Gson gson = new GsonBuilder().create();
		Request request = new Request.Builder().url(Urls.GET_ALL_ITEMS).build();
		try (Response response = client.newCall(request).execute()) {
			String responseJson = response.body().string();
			//System.out.println(responseJson);
			Item[] pArray = gson.fromJson(responseJson, Item[].class);
			List<Item> itemList = new ArrayList<Item>();
			for(Item p : pArray){
				itemList.add(p);
			}
			return itemList;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
