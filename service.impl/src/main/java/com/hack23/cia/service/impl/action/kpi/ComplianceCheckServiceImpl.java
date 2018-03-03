/*
 * Copyright 2010 James Pether Sörling
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
package com.hack23.cia.service.impl.action.kpi;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hack23.cia.model.internal.application.system.impl.ApplicationEventGroup;
import com.hack23.cia.model.internal.application.system.impl.ApplicationOperationType;
import com.hack23.cia.model.internal.application.user.impl.UserAccount;
import com.hack23.cia.service.api.action.application.CreateApplicationEventRequest;
import com.hack23.cia.service.api.action.application.CreateApplicationEventResponse;
import com.hack23.cia.service.api.action.common.ServiceResponse.ServiceResult;
import com.hack23.cia.service.api.action.kpi.ComplianceCheck;
import com.hack23.cia.service.api.action.kpi.ComplianceCheckRequest;
import com.hack23.cia.service.api.action.kpi.ComplianceCheckResponse;
import com.hack23.cia.service.impl.action.common.AbstractBusinessServiceImpl;
import com.hack23.cia.service.impl.action.common.BusinessService;
import com.hack23.cia.service.impl.rules.RulesEngine;

/**
 * The Class ComplianceCheckService.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,timeout=600)
public final class ComplianceCheckServiceImpl extends
		AbstractBusinessServiceImpl<ComplianceCheckRequest, ComplianceCheckResponse>
		implements BusinessService<ComplianceCheckRequest, ComplianceCheckResponse> {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ComplianceCheckServiceImpl.class);

	/** The create application event service. */
	@Autowired
	private BusinessService<CreateApplicationEventRequest, CreateApplicationEventResponse> createApplicationEventService;
	
	@Autowired
	private RulesEngine rulesEngine;

	/**
	 * Instantiates a new compliance check service.
	 */
	public ComplianceCheckServiceImpl() {
		super(ComplianceCheckRequest.class);
	}


	@Secured({ "ROLE_USER", "ROLE_ADMIN", "ROLE_ANONYMOUS" })
	@Override
	public ComplianceCheckResponse processService(
			final ComplianceCheckRequest serviceRequest) {

		LOGGER.info("{}",serviceRequest.getClass().getSimpleName());

		final CreateApplicationEventRequest eventRequest = new CreateApplicationEventRequest();
		eventRequest.setEventGroup(ApplicationEventGroup.USER);
		eventRequest.setApplicationOperation(ApplicationOperationType.READ);
		eventRequest.setActionName(ComplianceCheckRequest.class.getSimpleName());
		eventRequest.setSessionId(serviceRequest.getSessionId());

		final UserAccount userAccount = getUserAccountFromSecurityContext();

		if (userAccount != null) {
			eventRequest.setUserId(userAccount.getUserId());
		}

		final ComplianceCheckResponse response = new ComplianceCheckResponse(ServiceResult.SUCCESS);
		List<ComplianceCheck> list = rulesEngine.checkRulesCompliance();
		
		Collections.sort(list, new Comparator<ComplianceCheck>() {
            @Override
            public int compare(ComplianceCheck o1, ComplianceCheck o2) {
                int status = o2.getStatus().compareTo(o1.getStatus());
                if (status == 0) {
                	return o2.getRuleName().compareTo(o1.getRuleName());
                } else {
                	return status;
                }
                
            }
        });

		response.setList(list);
		response.setStatusMap(list.stream().collect(Collectors.groupingBy(ComplianceCheck::getStatus)));
		response.setResourceTypeMap(list.stream().collect(Collectors.groupingBy(ComplianceCheck::getResourceType)));

		eventRequest.setApplicationMessage(response.getResult().toString());
		createApplicationEventService.processService(eventRequest);

		return response;
	}

}