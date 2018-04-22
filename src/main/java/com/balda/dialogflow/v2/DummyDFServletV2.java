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

package com.balda.dialogflow.v2;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.balda.AppConfiguration;
import com.balda.dialogflow.GoogleApiAiBridge;
import com.balda.dialogflow.GoogleData;
import com.balda.googleactions.response.ResponseBuilder;
import com.balda.googleactions.response.ResponseBuilder.SpeechElement;
import com.balda.googleactions.response.RootResponse;
import com.google.api.client.util.Base64;

/**
 * Example of a dialog flow v2 endpoint. This webhook does nothing, it just
 * replies with the user words.
 *
 */
public class DummyDFServletV2 extends DFWebhookServletV2<GoogleData> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6605861416817955323L;
	private static final Logger log = Logger.getLogger(DummyDFServletV2.class.getName());

	@Override
	protected void doWebhook(DFWebhookRequestV2 request, DFWebhookResponseV2<GoogleData> response) {
		Random r = new Random();
		if (r.nextBoolean()) {
			response.getFulfillment().setFulfillmentText("you said " + request.getQueryResult().getQueryText());
		} else {
			replyWithGoogleData(request, response);
		}
	}

	/**
	 * Example of how to send Google data via Api.Ai
	 * 
	 * @param request
	 * @param response
	 */
	private void replyWithGoogleData(DFWebhookRequestV2 request, DFWebhookResponseV2<GoogleData> response) {
		response.getFulfillment().setFulfillmentText("how are you?");
		RootResponse r = ResponseBuilder.ask(new SpeechElement("how are you?"));
		GoogleData data = new GoogleData();
		data.setRootResponse(GoogleApiAiBridge.convert(r));
		response.setCustomData(data);
		response.getFulfillment().setSource("google");
	}

	@Override
	protected boolean verifyIdentity(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		if (authHeader != null) {
			StringTokenizer st = new StringTokenizer(authHeader);
			if (st.hasMoreTokens()) {
				String basic = st.nextToken();
				if (basic.equalsIgnoreCase("Basic")) {
					try {
						String credentials = new String(Base64.decodeBase64(st.nextToken()), "UTF-8");
						log.finest("Credentials: " + credentials);
						int p = credentials.indexOf(":");
						if (p != -1) {
							String login = credentials.substring(0, p).trim();
							String password = credentials.substring(p + 1).trim();
							if (AppConfiguration.USERNAME.equals(login) && AppConfiguration.PASSWORD.equals(password))
								return true;
							return false;
						} else {
							log.warning("Invalid authentication token from: " + request.getRemoteAddr());
							return false;
						}
					} catch (UnsupportedEncodingException e) {
						log.log(Level.WARNING, "Couldn't retrieve authentication", e);
						return false;
					}
				} else
					log.finest("Not basic auth " + basic + " from " + request.getRemoteAddr());
			} else
				log.finest("No tokens from: " + request.getRemoteAddr());
		} else
			log.finest("No auth header found from: " + request.getRemoteAddr());
		return false;
	}
}
