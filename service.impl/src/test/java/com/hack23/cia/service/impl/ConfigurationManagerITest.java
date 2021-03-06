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
package com.hack23.cia.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hack23.cia.service.api.ConfigurationManager;
import com.hack23.cia.service.api.UserConfiguration;

/**
 * The Class ConfigurationManagerITest.
 */
public final class ConfigurationManagerITest extends AbstractServiceFunctionalIntegrationTest {

	/** The Constant WWW_HACK23_COM. */
	private static final String WWW_HACK23_COM = "www.hack23.com";

	/** The configuration manager. */
	@Autowired
	private ConfigurationManager configurationManager;

	/**
	 * Gets the user configuration success test.
	 *
	 * @return the user configuration success test
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void getUserConfigurationSuccessTest() throws Exception {
		setAuthenticatedAnonymousUser();

		final UserConfiguration userConfiguration = configurationManager.getUserConfiguration(WWW_HACK23_COM,"en");
		assertNotNull(EXPECT_A_RESULT, userConfiguration);
		assertNotNull(EXPECT_A_RESULT, userConfiguration.getAgency());
		assertNotNull(EXPECT_A_RESULT, userConfiguration.getPortal());
		assertNotNull(EXPECT_A_RESULT, userConfiguration.getLanguage());



	}

}