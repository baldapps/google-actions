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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.appengine.repackaged.org.apache.http.util.TextUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class ResponseBuilder {

	private ResponseBuilder() {
	}

	/**
	 * @param message
	 *            - speech response for Google Actions request
	 * @return {@link RootResponse} object that contains speech response for
	 *         Google Actions request
	 */
	public static RootResponse reply(SpeechElement message) {
		RootResponse rootResponse = new RootResponse();
		rootResponse.setExpectUserResponse(false);
		rootResponse.setFinalResponse(new FinalResponse());
		SpeechResponse speech = new SpeechResponse();
		if (message.isSsml())
			speech.setSsml(message.getPrompt());
		else
			speech.setTextToSpeech(message.getPrompt());
		rootResponse.getFinalResponse().setSpeechResponse(speech);
		return rootResponse;
	}

	/**
	 * @param message
	 *            - speech response for Google Actions request
	 * @return {@link RootResponse} object that uses speech response to ask user
	 *         for additional data
	 */
	public static RootResponse tell(SpeechElement message) {
		return tell(message, null);
	}

	/**
	 * @param message
	 *            - speech response for Google Actions request
	 * @param conversationToken
	 * @return {@link RootResponse} object that uses speech response to ask user
	 *         for additional data
	 */
	public static RootResponse tell(SpeechElement message, String conversationToken) {
		RootResponse rootResponse = new RootResponse();
		rootResponse.setExpectUserResponse(true);
		rootResponse.setConversationToken(conversationToken);
		List<ExpectedInput> expectedInputs = new ArrayList<>();
		rootResponse.setExpectedInputs(expectedInputs);

		ExpectedInput expectedInput = new ExpectedInput();
		expectedInput.setInputPrompt(new InputPrompt());
		expectedInput.getInputPrompt().setRichInitialPrompt(new RichResponse());
		Item i = new Item();
		SimpleRespose s = new SimpleRespose();
		if (!message.isSsml())
			s.setTextToSpeech(message.getTts());
		else
			s.setSsml(message.getTts());
		s.setDisplayText(message.getPrompt());
		i.setSimpleRespose(s);
		expectedInput.getInputPrompt().getRichInitialPrompt().setItems(Collections.singletonList(new Item()));

		expectedInput.setPossibleIntents(new ArrayList<ExpectedIntent>());
		expectedInput.getPossibleIntents().add(new ExpectedIntent(Intent.TEXT.getAction()));

		rootResponse.getExpectedInputs().add(expectedInput);
		return rootResponse;
	}

	/**
	 * @param message
	 *            - speech response for Google Actions request
	 * @return {@link RootResponse} object that uses speech response to ask user
	 *         for additional data
	 */
	public static RootResponse askSignIn(SpeechElement message) {
		return askSignIn(message, null);
	}

	/**
	 * @param message
	 *            - speech response for Google Actions request
	 * @param conversationToken
	 * @return {@link RootResponse} object that uses speech response to ask user
	 *         for additional data
	 */
	public static RootResponse askSignIn(SpeechElement message, String conversationToken) {
		RootResponse rootResponse = new RootResponse();
		rootResponse.setExpectUserResponse(true);
		rootResponse.setConversationToken(conversationToken);
		List<ExpectedInput> expectedInputs = new ArrayList<>();
		rootResponse.setExpectedInputs(expectedInputs);

		ExpectedInput expectedInput = new ExpectedInput();
		expectedInput.setInputPrompt(new InputPrompt());
		expectedInput.getInputPrompt().setRichInitialPrompt(new RichResponse());
		Item i = new Item();
		SimpleRespose s = new SimpleRespose();
		if (!message.isSsml())
			s.setTextToSpeech(message.getTts());
		else
			s.setSsml(message.getTts());
		s.setDisplayText(message.getPrompt());
		i.setSimpleRespose(s);
		expectedInput.getInputPrompt().getRichInitialPrompt().setItems(Collections.singletonList(i));

		expectedInput.setPossibleIntents(new ArrayList<ExpectedIntent>());
		expectedInput.getPossibleIntents().add(new ExpectedIntent(Intent.SIGN_IN.getAction()));

		rootResponse.getExpectedInputs().add(expectedInput);
		return rootResponse;
	}

	/**
	 * @param message
	 *            - speech response for Google Actions request
	 * @return {@link RootResponse} object that uses speech response to ask user
	 *         for additional data
	 */
	public static RootResponse askDateTime(String requestDatetimeText, String requestDateText, String requestTimeText) {
		return askDateTime(requestDatetimeText, requestDateText, requestTimeText, null);
	}

	/**
	 * @param message
	 *            - speech response for Google Actions request
	 * @param conversationToken
	 * @return {@link RootResponse} object that uses speech response to ask user
	 *         for additional data
	 */
	public static RootResponse askDateTime(String requestDatetimeText, String requestDateText, String requestTimeText,
			String conversationToken) {
		RootResponse rootResponse = new RootResponse();
		rootResponse.setExpectUserResponse(true);
		rootResponse.setConversationToken(conversationToken);
		List<ExpectedInput> expectedInputs = new ArrayList<>();
		rootResponse.setExpectedInputs(expectedInputs);

		ExpectedInput expectedInput = new ExpectedInput();
		expectedInput.setInputPrompt(new InputPrompt());
		expectedInput.getInputPrompt().setRichInitialPrompt(new RichResponse());
		Item i = new Item();
		SimpleRespose s = new SimpleRespose();
		s.setTextToSpeech("");
		i.setSimpleRespose(s);
		expectedInput.getInputPrompt().getRichInitialPrompt().setItems(Collections.singletonList(i));

		expectedInput.setPossibleIntents(new ArrayList<ExpectedIntent>());
		ExpectedIntent expectedIntent = new ExpectedIntent(Intent.DATETIME.getAction());
		Map<String, JsonElement> map = new HashMap<>();

		JsonPrimitive jp = new JsonPrimitive(Intent.DATETIME.getType());
		map.put("@type", jp);
		JsonObject children = new JsonObject();
		children.addProperty("requestDatetimeText", requestDatetimeText);
		children.addProperty("requestDateText", requestDateText);
		children.addProperty("requestTimeText", requestTimeText);
		map.put("dialogSpec", children);
		expectedIntent.setInputValueSpec(map);

		expectedInput.getPossibleIntents().add(expectedIntent);

		rootResponse.getExpectedInputs().add(expectedInput);
		return rootResponse;
	}

	/**
	 * @param permissionContext
	 *            - Context why the permission is being asked; it's the TTS
	 *            prompt prefix (action phrase) we ask the user.
	 * @param permissions
	 *            - Array of permissions Assistant supports, each of which comes
	 *            from Assistant.SupportedPermissions.
	 * @return {@link RootResponse} object that is sent to Assistant to ask for
	 *         the user's permission
	 * @throws IllegalArgumentException
	 *             when permissionContext or permissions are null or empty.
	 *             Exception is also thrown when any of given permission isn't
	 *             one of: [NAME, DEVICE_PRECISE_LOCATION,
	 *             DEVICE_COARSE_LOCATION]
	 */
	public static RootResponse askPermission(String permissionContext, Permission permission) {
		return askPermissions(permissionContext, Collections.singletonList(permission));
	}

	/**
	 * @param permissionContext
	 *            - Context why the permission is being asked; it's the TTS
	 *            prompt prefix (action phrase) we ask the user.
	 * @param permissions
	 *            - Array of permissions Assistant supports, each of which comes
	 *            from Assistant.SupportedPermissions.
	 * @return {@link RootResponse} object that is sent to Assistant to ask for
	 *         the user's permission
	 * @throws IllegalArgumentException
	 *             when permissionContext or permissions are null or empty.
	 *             Exception is also thrown when any of given permission isn't
	 *             one of: [NAME, DEVICE_PRECISE_LOCATION,
	 *             DEVICE_COARSE_LOCATION]
	 */
	public static RootResponse askPermissions(String permissionContext, List<Permission> permissions)
			throws IllegalArgumentException {
		if (TextUtils.isEmpty(permissionContext)) {
			throw new IllegalArgumentException("context cannot be null");
		}

		if (permissions == null || permissions.isEmpty()) {
			throw new IllegalArgumentException("at least one permission needed.");
		}

		RootResponse rootResponse = new RootResponse();
		rootResponse.setExpectUserResponse(true);

		ExpectedIntent expectedIntent = new ExpectedIntent(Intent.PERMISSION.getAction());
		Map<String, JsonElement> map = new HashMap<>();

		map.put("@type", new JsonPrimitive(Intent.DATETIME.getType()));
		map.put("optContext", new JsonPrimitive(permissionContext));
		JsonArray jarr = new JsonArray();
		for (Permission p : permissions) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("permissions", p.name());
			jarr.add(jobj);
		}
		map.put("permissions", jarr);
		expectedIntent.setInputValueSpec(map);

		ExpectedInput expectedInput = new ExpectedInput();
		expectedInput.setPossibleIntents(new ArrayList<ExpectedIntent>());
		expectedInput.getPossibleIntents().add(expectedIntent);

		rootResponse.setExpectedInputs(new ArrayList<ExpectedInput>());
		rootResponse.getExpectedInputs().add(expectedInput);

		return rootResponse;
	}

	public static class SpeechElement {
		private String prompt;
		private String tts;
		private boolean isSsml;

		/**
		 * Build a Speech Element
		 * 
		 * @param p
		 *            Display text
		 * @param tts
		 *            Text-to-speech
		 * @param ssml
		 *            True if tts contains SSML, false otherwise
		 */
		public SpeechElement(String p, String tts, boolean ssml) {
			prompt = p;
			isSsml = ssml;
			this.tts = tts;
		}

		/**
		 * Simple voice element
		 * 
		 * @param p
		 *            String used both for display text and TTS, no SSML
		 */
		public SpeechElement(String p) {
			prompt = p;
			isSsml = false;
			tts = p;
		}

		public String getTts() {
			return tts;
		}

		public void setTts(String tts) {
			this.tts = tts;
		}

		public String getPrompt() {
			return prompt;
		}

		public void setPrompt(String prompt) {
			this.prompt = prompt;
		}

		public boolean isSsml() {
			return isSsml;
		}

		public void setSsml(boolean isSsml) {
			this.isSsml = isSsml;
		}
	}
}
