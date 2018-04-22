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

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balda.dialogflow.ApiAiPlugData;
import com.balda.keys.TokenException;
import com.google.gson.Gson;

import ai.api.GsonFactory;

/**
 * Base class to be extended to create an dialogflow v2 webhook
 *
 * @param <T>
 *            The class for custom data, RootResponse for Google, EmptyPlugData
 *            for none
 */
public abstract class DFWebhookServletV2<T extends ApiAiPlugData> extends HttpServlet {
	private static final Logger log = Logger.getLogger(DFWebhookServletV2.class.getName());
	private static final String RESPONSE_CONTENT_TYPE = "application/json";

	private static final String RESPONSE_CHARACTER_ENCODING = "utf-8";

	private static final long serialVersionUID = 1L;

	protected final Gson gson = GsonFactory.getDefaultFactory().getGson();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!verifyIdentity(request)) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return;
		}
		DFWebhookResponseV2<T> output = new DFWebhookResponseV2<>();
		try {
			doWebhook(gson.fromJson(request.getReader(), DFWebhookRequestV2.class), output);
		} catch (TokenException e) {
			log.log(Level.WARNING, "exception in doWebhook", e);
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		} catch (Exception e) {
			log.log(Level.SEVERE, "exception in doWebhook", e);
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		}
		response.setCharacterEncoding(RESPONSE_CHARACTER_ENCODING);
		response.setContentType(RESPONSE_CONTENT_TYPE);
		String json = output.toJson(gson);
		response.getWriter().write(json);
		response.getWriter().flush();
	}

	/**
	 * Web-hook verify identity
	 * 
	 * @param input
	 *            Received request object
	 * @return True request ok, false abort with 403 code
	 */
	protected abstract boolean verifyIdentity(HttpServletRequest request);

	/**
	 * Web-hook processing method.
	 * 
	 * @param input
	 *            Received request object
	 * @param output
	 *            Response object. Should be filled in the method.
	 */
	protected abstract void doWebhook(DFWebhookRequestV2 input, DFWebhookResponseV2<T> output);
}
