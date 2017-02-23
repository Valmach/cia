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
package com.hack23.cia.service.component.agent.impl.worldbank.workgenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.jms.Destination;
import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hack23.cia.model.external.worldbank.countries.impl.CountryElement;
import com.hack23.cia.model.external.worldbank.indicators.impl.IndicatorElement;
import com.hack23.cia.model.internal.application.data.impl.WorldBankDataSources;
import com.hack23.cia.service.external.worldbank.api.DataFailureException;
import com.hack23.cia.service.external.worldbank.api.WorldBankCountryApi;

/**
 * The Class WorldBankDataWorkGeneratorImpl.
 */
@Service
final class WorldBankDataWorkGeneratorImpl extends AbstractWorldBankDataSourcesWorkGenerator {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(WorldBankDataWorkGeneratorImpl.class);

	/** The data workdestination. */
	@Autowired
	@Qualifier("com.hack23.cia.model.external.worldbank.data.impl.Data")
	private Destination dataWorkdestination;

	/** The worldbank country api. */
	@Autowired
	private WorldBankCountryApi worldbankCountryApi;

	/**
	 * Instantiates a new world bank data work generator impl.
	 */
	public WorldBankDataWorkGeneratorImpl() {
		super(WorldBankDataSources.DATA);
	}

	@Override
	public void generateWorkOrders() {
		try {
			final List<IndicatorElement> indicatorlist = getImportService().getAllIndicators();
			final List<CountryElement> countryList = worldbankCountryApi.getCountries();

			final Map<String, String> currentSaved = getImportService().getWorldBankDataMap();

			for (final IndicatorElement indicator : indicatorlist) {
				for (final CountryElement country : countryList) {
					sendCountryIndicatorWorkOrder(currentSaved, indicator, country);
				}
			}
		} catch (final JMSException | DataFailureException exception) {
			LOGGER.warn("jms", exception);
		}
	}

	/**
	 * Send country indicator work order.
	 *
	 * @param currentSaved
	 *            the current saved
	 * @param indicator
	 *            the indicator
	 * @param country
	 *            the country
	 * @throws JMSException
	 *             the exception
	 */
	private void sendCountryIndicatorWorkOrder(final Map<String, String> currentSaved, final IndicatorElement indicator,
			final CountryElement country) throws JMSException {
		if (country.getIso2Code() != null && country.getIso2Code().length() > 0
				&& !currentSaved.containsKey(country.getIso2Code() + '.' + indicator.getId())) {
			final List<String> load = new ArrayList<>();
			load.add(country.getIso2Code());
			load.add(indicator.getId());
			getJmsSender().send(dataWorkdestination, (Serializable) load);
		}
	}

}
