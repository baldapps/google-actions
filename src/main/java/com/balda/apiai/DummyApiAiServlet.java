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

package com.balda.apiai;

import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.balda.AppConfiguration;
import com.balda.googleactions.response.RootResponse;
import com.google.api.client.util.Base64;

/**
 * Example of Api ai endpoint. This webhook does nothing, it just replies with
 * the user words.
 *
 */
public class DummyApiAiServlet extends AIWebhookServlet<RootResponse> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6605861416817955323L;
	private static final Logger log = Logger.getLogger(DummyApiAiServlet.class.getName());

	@Override
	protected void doWebhook(AIWebhookRequest request, AIWebhookResponse<RootResponse> response) {
		response.getFulfillment().setSpeech("you said " + request.getResult().getResolvedQuery());
		response.getFulfillment().setDisplayText("you said " + request.getResult().getResolvedQuery());
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
