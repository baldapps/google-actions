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

package com.balda.googleactions.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PurchaseInfo {

	@SerializedName("orderId")
	@Expose
	private String orderId;
	@SerializedName("packageName")
	@Expose
	private String packageName;
	@SerializedName("purchaseTime")
	@Expose
	private Long purchaseTime;
	@SerializedName("purchaseState")
	@Expose
	private Long purchaseState;
	@SerializedName("developerPayload")
	@Expose
	private String developerPayload;
	@SerializedName(value = "name", alternate = { "purchaseToken", "token" })
	@Expose
	private String token;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Long getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(Long purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	public int getPurchaseState() {
		if (purchaseState == null)
			return 1;
		return purchaseState.intValue();
	}

	public void setPurchaseState(Long purchaseState) {
		this.purchaseState = purchaseState;
	}

	public String getDeveloperPayload() {
		return developerPayload;
	}

	public void setDeveloperPayload(String developerPayload) {
		this.developerPayload = developerPayload;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
