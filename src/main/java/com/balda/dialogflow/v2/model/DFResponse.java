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

package com.balda.dialogflow.v2.model;

import java.util.List;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DFResponse {

	@SerializedName("fulfillmentText")
	@Expose
	private String fulfillmentText;
	@SerializedName("source")
	@Expose
	private String source;
	@SerializedName("outputContexts")
	@Expose
	private List<Context> outputContexts = null;
	@SerializedName("payload")
	@Expose
	private Map<String, JsonElement> payload;
	@SerializedName("followupEventInput")
	@Expose
	private EventInput followupEventInput;

	public String getFulfillmentText() {
		return fulfillmentText;
	}

	public void setFulfillmentText(String fulfillmentText) {
		this.fulfillmentText = fulfillmentText;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public List<Context> getOutputContexts() {
		return outputContexts;
	}

	public void setOutputContexts(List<Context> outputContexts) {
		this.outputContexts = outputContexts;
	}

	public Map<String, JsonElement> getPayload() {
		return payload;
	}

	public void setPayload(Map<String, JsonElement> payload) {
		this.payload = payload;
	}

	public EventInput getFollowupEventInput() {
		return followupEventInput;
	}

	public void setFollowupEventInput(EventInput followupEventInput) {
		this.followupEventInput = followupEventInput;
	}
}
