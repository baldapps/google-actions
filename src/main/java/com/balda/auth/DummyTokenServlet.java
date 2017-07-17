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

package com.balda.auth;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balda.keys.TokenGenerator;
import com.balda.tokens.AccessToken;
import com.balda.tokens.RefreshToken;
import com.balda.tokens.TokenPayload;
import com.balda.tokens.TokenType;

public class DummyTokenServlet extends TokenServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 901197260949658813L;

	@Override
	protected void manageAuthToken(Oauth2Request oauth2, HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		/*
		 * TODO: we need to genereta a token here, we need to manage a key or
		 * generete a random numer. We use "null" as third parameter just to
		 * avoid compiler errors, but you need to change this code.
		 */
		TokenPayload payload = TokenGenerator.revert(gson, oauth2.getCode(), null);
		if (payload.getExpirationTime() < System.currentTimeMillis()) {
			sendError(resp, Oauth2Error.INVALID_GRANT);
			return;
		}
		AccessToken accessToken = new AccessToken();
		payload.setExpirationTime(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(1));
		payload.setType(TokenType.ACCESS_TOKEN);
		/*
		 * TODO: we need to genereta a token here, we need to manage a key or
		 * generete a random numer. We use "null" as third parameter just to
		 * avoid compiler errors, but you need to change this code.
		 */
		accessToken.setAccessToken(TokenGenerator.generate(gson, payload, null));
		accessToken.setExpirationTime(TimeUnit.HOURS.toSeconds(1));
		payload.setType(TokenType.REFRESH_TOKEN);
		/*
		 * TODO: we need to genereta a token here, we need to manage a key or
		 * generete a random numer. We use "null" as third parameter just to
		 * avoid compiler errors, but you need to change this code.
		 */
		accessToken.setRefreshToken(TokenGenerator.generate(gson, payload, null));
		resp.setCharacterEncoding(RESPONSE_CHARACTER_ENCODING);
		resp.setContentType(RESPONSE_CONTENT_TYPE);
		String json = gson.toJson(accessToken);
		resp.getWriter().write(json);
		resp.getWriter().flush();
	}

	@Override
	protected void manageRefreshToken(Oauth2Request oauth2, HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		/*
		 * TODO: we need to genereta a token here, we need to manage a key or
		 * generete a random numer. We use "null" as third parameter just to
		 * avoid compiler errors, but you need to change this code.
		 */
		TokenPayload payload = TokenGenerator.revert(gson, oauth2.getCode(), null);
		if (payload.getType() != TokenType.REFRESH_TOKEN) {
			sendError(resp, Oauth2Error.INVALID_GRANT);
			return;
		}
		RefreshToken refreshToken = new RefreshToken();
		payload.setExpirationTime(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(1));
		payload.setType(TokenType.ACCESS_TOKEN);
		/*
		 * TODO: we need to genereta a token here, we need to manage a key or
		 * generete a random numer. We use "null" as third parameter just to
		 * avoid compiler errors, but you need to change this code.
		 */
		refreshToken.setAccessToken(TokenGenerator.generate(gson, payload, null));
		refreshToken.setExpirationTime(TimeUnit.HOURS.toSeconds(1));
		resp.setCharacterEncoding(RESPONSE_CHARACTER_ENCODING);
		resp.setContentType(RESPONSE_CONTENT_TYPE);
		String json = gson.toJson(refreshToken);
		resp.getWriter().write(json);
		resp.getWriter().flush();
	}
}
