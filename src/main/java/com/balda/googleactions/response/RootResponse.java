/*
 * Copyright 2017 Marco Stornelli <playappassistance@gmail.com>
 * 
 * This file is part of Google Actions project
 *
 * AirTask Desktop is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AirTask Desktop is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AirTask Desktop.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.balda.googleactions.response;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RootResponse {

	@SerializedName("conversationToken")
	@Expose
	private String conversationToken;
	@SerializedName("expectUserResponse")
	@Expose
	private Boolean expectUserResponse;
	@SerializedName("expectedInputs")
	@Expose
	private List<ExpectedInput> expectedInputs = null;
	@SerializedName("finalResponse")
	@Expose
	private FinalResponse finalResponse;
	@SerializedName("customPushMessage")
	@Expose
	private CustomPushMessage customPushMessage;
	@SerializedName("responseMetadata")
	@Expose
	private ResponseMetadata resposeMetadata;

	public String getConversationToken() {
		return conversationToken;
	}

	public void setConversationToken(String conversationToken) {
		this.conversationToken = conversationToken;
	}

	public Boolean getExpectUserResponse() {
		return expectUserResponse;
	}

	public void setExpectUserResponse(Boolean expectUserResponse) {
		this.expectUserResponse = expectUserResponse;
	}

	public List<ExpectedInput> getExpectedInputs() {
		return expectedInputs;
	}

	public void setExpectedInputs(List<ExpectedInput> expectedInputs) {
		this.expectedInputs = expectedInputs;
	}

	public FinalResponse getFinalResponse() {
		return finalResponse;
	}

	public void setFinalResponse(FinalResponse finalResponse) {
		this.finalResponse = finalResponse;
	}
}
