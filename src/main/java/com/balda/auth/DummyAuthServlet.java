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

package com.balda.auth;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.balda.keys.TokenGenerator;
import com.balda.tokens.TokenPayload;
import com.balda.tokens.TokenType;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

/**
 * Dummy auth servlet
 */
public class DummyAuthServlet extends AuthServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4469084418717861895L;
	private static final Logger log = Logger.getLogger(DummyAuthServlet.class.getName());

	@Override
	protected void performImplictFlow(Oauth2Request oauth2, HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		HttpSession ses = req.getSession();

		// Check if the user is signed in to your service. If the user
		// isn't signed in, complete service's sign-in or sign-up
		// flow.
		if (user == null) {
			ses.setAttribute(SESSION_OAUTH2, oauth2);
			resp.sendRedirect(userService.createLoginURL(req.getRequestURI()));
		} else {
			try {
				ses.invalidate();
			} catch (Exception e1) {
			}
			TokenPayload t = new TokenPayload();
			t.setType(TokenType.ACCESS_TOKEN);
			t.setUserId(user.getUserId());
			String token;
			try {
				/*
				 * TODO: we need to genereta a token here, we need to manage a
				 * key or generete a random numer. We use "null" as third
				 * parameter just to avoid compiler errors, but you need to
				 * change this code.
				 */
				token = TokenGenerator.generate(gson, t, null);
			} catch (Exception e) {
				sendError(resp, Oauth2Error.INVALID_GRANT);
				log.log(Level.SEVERE, "Token generation error: " + e.getMessage(), e);
				return;
			}
			resp.sendRedirect(oauth2.getResponseUri(token));
		}
	}

	@Override
	protected void performAuthFlow(Oauth2Request oauth2, HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		HttpSession ses = req.getSession();

		// Check if the user is signed in to your service. If the user
		// isn't signed in, complete service's sign-in or sign-up
		// flow.
		if (user == null) {
			ses.setAttribute(SESSION_OAUTH2, oauth2);
			resp.sendRedirect(userService.createLoginURL(req.getRequestURI()));
		} else {
			try {
				ses.invalidate();
			} catch (Exception e1) {
			}
			TokenPayload t = new TokenPayload();
			t.setType(TokenType.AUTH_TOKEN);
			t.setExpirationTime(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10));
			t.setUserId(user.getUserId());
			String token;
			try {
				/*
				 * TODO: we need to genereta a token here, we need to manage a
				 * key or generete a random numer. We use "null" as third
				 * parameter just to avoid compiler errors, but you need to
				 * change this code.
				 */
				token = TokenGenerator.generate(gson, t, null);
			} catch (Exception e) {
				sendError(resp, Oauth2Error.INVALID_GRANT);
				log.log(Level.SEVERE, "Token generation error: " + e.getMessage(), e);
				return;
			}
			resp.sendRedirect(oauth2.getResponseUri(token));
		}
	}

}
