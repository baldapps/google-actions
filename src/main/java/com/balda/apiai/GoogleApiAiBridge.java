/*
 * Copyright 2017 Marco Stornelli <playappassistance@gmail.com>
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

package com.balda.apiai;

import java.util.List;

import com.balda.googleactions.response.ExpectedInput;
import com.balda.googleactions.response.ExpectedIntent;
import com.balda.googleactions.response.FinalResponse;
import com.balda.googleactions.response.InputPrompt;
import com.balda.googleactions.response.RichResponse;
import com.balda.googleactions.response.RootResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * When we use Api.Ai the webhook format is "nearly" the same but we can use the
 * fields: isSsml, speech, systemIntent, richResponse and finalResponse. Other
 * fields are don't care.
 */
public class GoogleApiAiBridge {
	@SerializedName("expectUserResponse")
	@Expose
	private Boolean expectUserResponse;
	@SerializedName("isSsml")
	@Expose
	private Boolean ssml;
	@SerializedName("speech")
	@Expose
	private String textTospeech;
	@SerializedName("systemIntent")
	@Expose
	private SystemIntent systemIntent;
	@SerializedName("richResponse")
	@Expose
	private RichResponse richResponse;
	@SerializedName("finalResponse")
	@Expose
	private FinalResponse finalResponse;

	public Boolean getExpectUserResponse() {
		return expectUserResponse;
	}

	public void setExpectUserResponse(Boolean expectUserResponse) {
		this.expectUserResponse = expectUserResponse;
	}

	public Boolean getSsml() {
		return ssml;
	}

	public void setSsml(Boolean ssml) {
		this.ssml = ssml;
	}

	public String getTextTospeech() {
		return textTospeech;
	}

	public void setTextTospeech(String textTospeech) {
		this.textTospeech = textTospeech;
	}

	public SystemIntent getSystemIntent() {
		return systemIntent;
	}

	public void setSystemIntent(SystemIntent systemIntent) {
		this.systemIntent = systemIntent;
	}

	public RichResponse getRichResponse() {
		return richResponse;
	}

	public void setRichResponse(RichResponse richResponse) {
		this.richResponse = richResponse;
	}

	public FinalResponse getFinalResponse() {
		return finalResponse;
	}

	public void setFinalResponse(FinalResponse finalResponse) {
		this.finalResponse = finalResponse;
	}

	public static GoogleApiAiBridge convert(RootResponse r) {
		GoogleApiAiBridge b = new GoogleApiAiBridge();
		b.setFinalResponse(r.getFinalResponse());
		b.setExpectUserResponse(r.getExpectUserResponse());
		List<ExpectedInput> l = r.getExpectedInputs();
		if (l != null && !l.isEmpty()) {
			ExpectedInput el = l.get(0);
			if (el != null) {
				List<ExpectedIntent> li = el.getPossibleIntents();
				if (li != null && !li.isEmpty()) {
					SystemIntent si = new SystemIntent();
					si.setIntent(li.get(0).getIntent());
					si.setInputValueSpec(li.get(0).getInputValueSpec());
					b.setSystemIntent(si);
				}
				InputPrompt ip = el.getInputPrompt();
				if (ip != null) {
					RichResponse richRespose = ip.getRichInitialPrompt();
					b.setRichResponse(richRespose);
				}
			}
		}
		return b;
	}
}
