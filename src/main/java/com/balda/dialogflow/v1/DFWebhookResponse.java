/*
 * Copyright 2017-2018 Marco Stornelli <playappassistance@gmail.com>
 * 
 * This file is part of Google Actions project
 *
 * Google Actions is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Google Actions is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Google Actions.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.balda.dialogflow.v1;

import java.util.HashMap;
import java.util.Map;

import com.balda.dialogflow.ApiAiPlugData;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import ai.api.model.Fulfillment;

public class DFWebhookResponse<T extends ApiAiPlugData> {

	private Fulfillment fulfillment;
	private T customData;

	public DFWebhookResponse() {
		fulfillment = new Fulfillment();
		customData = null;
	}

	public Fulfillment getFulfillment() {
		return fulfillment;
	}

	public T getCustomData() {
		return customData;
	}

	public void setCustomData(T data) {
		customData = data;
	}

	public String toJson(Gson json) {
		if (customData != null) {
			Map<String, JsonElement> map = new HashMap<>();
			customData.toJson(json, map);
			fulfillment.setData(map);
		}
		return json.toJson(fulfillment);
	}
}