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
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderUpdate {

	@SerializedName("orderState")
	@Expose
	private OrderState orderState;
	@SerializedName("orderManagementActions")
	@Expose
	private List<Action> orderManagementActions;
	@SerializedName("updateTime")
	@Expose
	private String updateTime;
	@SerializedName("totalPrice")
	@Expose
	private Price totalPrice;
	@SerializedName("infoExtension")
	@Expose
	private Map<String, JsonElement> extension;
	@SerializedName("userNotification")
	@Expose
	private UserNotification userNotification;
	@SerializedName("googleOrderId")
	@Expose
	private String googleOrderId;
	@SerializedName("actionOrderId")
	@Expose
	private String actionOrderId;
	@SerializedName("rejectionInfo")
	@Expose
	private RejectionInfo rejectionInfo;
	@SerializedName("receipt")
	@Expose
	private Receipt receipt;
	@SerializedName("cancellationInfo")
	@Expose
	private CancellationInfo cancellationInfo;
	@SerializedName("inTransitInfo")
	@Expose
	private InTransitInfo inTransitInfo;
	@SerializedName("fulfillmentInfo")
	@Expose
	private InTransitInfo fulfillmentInfo;
	@SerializedName("returnInfo")
	@Expose
	private InTransitInfo returnInfo;
	@SerializedName("lineItemUpdates")
	@Expose
	private Map<String, LineItemUpdate> lineItemUpdate;

	public OrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

	public List<Action> getOrderManagementActions() {
		return orderManagementActions;
	}

	public void setOrderManagementActions(List<Action> orderManagementActions) {
		this.orderManagementActions = orderManagementActions;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Price getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Price totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Map<String, JsonElement> getExtension() {
		return extension;
	}

	public void setExtension(Map<String, JsonElement> extension) {
		this.extension = extension;
	}

	public UserNotification getUserNotification() {
		return userNotification;
	}

	public void setUserNotification(UserNotification userNotification) {
		this.userNotification = userNotification;
	}

	public String getGoogleOrderId() {
		return googleOrderId;
	}

	public void setGoogleOrderId(String googleOrderId) {
		this.googleOrderId = googleOrderId;
	}

	public String getActionOrderId() {
		return actionOrderId;
	}

	public void setActionOrderId(String actionOrderId) {
		this.actionOrderId = actionOrderId;
	}

	public RejectionInfo getRejectionInfo() {
		return rejectionInfo;
	}

	public void setRejectionInfo(RejectionInfo rejectionInfo) {
		this.rejectionInfo = rejectionInfo;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public CancellationInfo getCancellationInfo() {
		return cancellationInfo;
	}

	public void setCancellationInfo(CancellationInfo cancellationInfo) {
		this.cancellationInfo = cancellationInfo;
	}

	public InTransitInfo getInTransitInfo() {
		return inTransitInfo;
	}

	public void setInTransitInfo(InTransitInfo inTransitInfo) {
		this.inTransitInfo = inTransitInfo;
	}

	public InTransitInfo getFulfillmentInfo() {
		return fulfillmentInfo;
	}

	public void setFulfillmentInfo(InTransitInfo fulfillmentInfo) {
		this.fulfillmentInfo = fulfillmentInfo;
	}

	public InTransitInfo getReturnInfo() {
		return returnInfo;
	}

	public void setReturnInfo(InTransitInfo returnInfo) {
		this.returnInfo = returnInfo;
	}

	public Map<String, LineItemUpdate> getLineItemUpdate() {
		return lineItemUpdate;
	}

	public void setLineItemUpdate(Map<String, LineItemUpdate> lineItemUpdate) {
		this.lineItemUpdate = lineItemUpdate;
	}
}
