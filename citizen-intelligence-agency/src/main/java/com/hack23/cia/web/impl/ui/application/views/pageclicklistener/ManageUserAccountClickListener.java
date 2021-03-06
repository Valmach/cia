/*
 * Copyright 2014 James Pether Sörling
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *	$Id$
 *  $HeadURL$
*/
package com.hack23.cia.web.impl.ui.application.views.pageclicklistener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hack23.cia.service.api.action.admin.ManageUserAccountRequest;
import com.hack23.cia.service.api.action.common.ServiceResponse;
import com.hack23.cia.service.api.action.common.ServiceResponse.ServiceResult;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;

/**
 * The Class ManageUserAccountClickListener.
 */
public final class ManageUserAccountClickListener implements ClickListener {

	/** The Constant EMAIL_SENT. */
	private static final String OPERATION_COMPLETED = "Operation completed";

	/** The Constant SEND_EMAIL_FAILURE. */
	private static final String OPERATION_FAILURE = "Operation {} failure";

	/** The Constant SEND_EMAIL_FAILEDFAILED. */
	private static final String OPERATION_FAILED = "Operation failed";

	/** The Constant LOG_MSG_SEND_EMAIL. */
	private static final String LOG_MSG = "Operation {}";

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ManageUserAccountClickListener.class);

	/** The reqister request. */
	private final ManageUserAccountRequest manageUserAccountRequest;

	/**
	 * Instantiates a new manage user account click listener.
	 *
	 * @param manageUserAccountRequest
	 *            the manage user account request
	 */
	public ManageUserAccountClickListener(final ManageUserAccountRequest manageUserAccountRequest) {
		this.manageUserAccountRequest = manageUserAccountRequest;
	}

	@Override
	public void buttonClick(final ClickEvent event) {
		final ServiceResponse response = ApplicationMangerAccess.getApplicationManager().service(manageUserAccountRequest);
		if (ServiceResult.SUCCESS == response.getResult()) {
			LOGGER.info(LOG_MSG,manageUserAccountRequest.getUserAcountId());
			Notification.show(OPERATION_COMPLETED);
		} else {
			Notification.show(OPERATION_FAILED,
	                  response.getErrorMessage(),
	                  Notification.Type.WARNING_MESSAGE);
			LOGGER.info(OPERATION_FAILURE,manageUserAccountRequest.getUserAcountId());
		}
	}
}