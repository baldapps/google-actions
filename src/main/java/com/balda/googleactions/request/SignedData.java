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

public class SignedData {

	@SerializedName("inAppPurchaseData")
	@Expose
	private PurchaseInfo inAppPurchaseData;
	@SerializedName("inAppDataSignature")
	@Expose
	private String inAppDataSignature;

	public PurchaseInfo getInAppPurchaseData() {
		return inAppPurchaseData;
	}

	public void setInAppPurchaseData(PurchaseInfo inAppPurchaseData) {
		this.inAppPurchaseData = inAppPurchaseData;
	}

	public String getInAppDataSignature() {
		return inAppDataSignature;
	}

	public void setInAppDataSignature(String inAppDataSignature) {
		this.inAppDataSignature = inAppDataSignature;
	}
}
