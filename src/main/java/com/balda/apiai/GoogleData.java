package com.balda.apiai;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class GoogleData implements ApiAiPlugData {

	private GoogleApiAiBridge rootResponse;

	public GoogleApiAiBridge getRootResponse() {
		return rootResponse;
	}

	public void setRootResponse(GoogleApiAiBridge rootResponse) {
		this.rootResponse = rootResponse;
	}

	@Override
	public void toJson(Gson json, Map<String, JsonElement> m) {
		m.put("google", json.toJsonTree(rootResponse));
	}
}
