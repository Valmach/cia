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
package com.hack23.cia.web.impl.ui.application.views.common.menufactory.impl;

import org.springframework.stereotype.Service;

import com.hack23.cia.web.impl.ui.application.views.common.menufactory.api.PartyRankingMenuItemFactory;
import com.hack23.cia.web.impl.ui.application.views.common.pagelinks.PageModeMenuCommand;
import com.hack23.cia.web.impl.ui.application.views.common.viewnames.PageMode;
import com.hack23.cia.web.impl.ui.application.views.common.viewnames.UserViews;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;

/**
 * The Class PartyRankingMenuItemFactoryImpl.
 */
@Service
public final class PartyRankingMenuItemFactoryImpl extends AbstractMenuItemFactoryImpl implements PartyRankingMenuItemFactory {

	/** The Constant COMMAND21. */
	private static final PageModeMenuCommand COMMAND21 = new PageModeMenuCommand(UserViews.PARTY_RANKING_VIEW_NAME, PageMode.PAGEVISITHISTORY);

	/** The Constant COMMAND20. */
	private static final PageModeMenuCommand COMMAND20 = new PageModeMenuCommand(UserViews.PARTY_RANKING_VIEW_NAME, PageMode.CHARTS);

	/** The Constant COMMAND19. */
	private static final PageModeMenuCommand COMMAND19 = new PageModeMenuCommand(UserViews.PARTY_RANKING_VIEW_NAME, PageMode.DATAGRID);

	/** The Constant COMMAND18. */
	private static final PageModeMenuCommand COMMAND18 = new PageModeMenuCommand(UserViews.PARTY_RANKING_VIEW_NAME, PageMode.OVERVIEW);

	/** The Constant PARTY_RANKING. */
	private static final String PARTY_RANKING = "Party Ranking";

	/** The Constant ALL_PARTIES_TOTAL_DAYS_SERVED_IN_PARLIAMENT. */
	private static final String ALL_PARTIES_TOTAL_DAYS_SERVED_IN_PARLIAMENT = "All parties, total days served in parliament";

	/** The Constant ALL_PARTIES_HEAD_COUNT_IN_PARLIAMENT. */
	private static final String ALL_PARTIES_HEAD_COUNT_IN_PARLIAMENT = "All parties, head count in parliament";

	/** The Constant CURRENT_PARTIES_TOTAL_DAYS_SERVED_IN_PARLIAMENT. */
	private static final String CURRENT_PARTIES_TOTAL_DAYS_SERVED_IN_PARLIAMENT = "Current parties, total days served in parliament";

	/** The Constant CURRENT_PARTIES_ACTIVE_IN_PARLIAMENT_HEAD_COUNT. */
	private static final String CURRENT_PARTIES_ACTIVE_IN_PARLIAMENT_HEAD_COUNT = "Current parties active in parliament, head count";

	/** The Constant ALL_PARTIES_TOTAL_ASSIGNMENTS_IN_COMMITTEES. */
	private static final String ALL_PARTIES_TOTAL_ASSIGNMENTS_IN_COMMITTEES = "All parties, total assignments in committees";

	/** The Constant CURRENT_PARTIES_TOTAL_DAYS_SERVED_IN_MINISTRIES. */
	private static final String CURRENT_PARTIES_TOTAL_DAYS_SERVED_IN_MINISTRIES = "Current parties, total days served in ministries";

	/**
	 * The Constant
	 * PARTY_BY_TOTAL_MEMBERS_BASED_ON_ROLES_IN_DEPARTMENTS_COMMITTEES_AND_PARLIAMENT.
	 */
	private static final String PARTY_BY_TOTAL_MEMBERS_BASED_ON_ROLES_IN_DEPARTMENTS_COMMITTEES_AND_PARLIAMENT = "Party by total members, based on roles in departments, committees and parliament";

	/** The Constant TOTAL_MEMBERS. */
	private static final String TOTAL_MEMBERS = "Total members";

	/** The Constant ALL_PARTIES_TOTAL_DAYS_SERVED_IN_COMMITTEES. */
	private static final String ALL_PARTIES_TOTAL_DAYS_SERVED_IN_COMMITTEES = "All parties, total days served in committees";

	/**
	 * The Constant
	 * CURRENT_PARTIES_ACTIVE_IN_COMMITTEES_TOTAL_DAYS_SERVED_IN_COMMITTEES.
	 */
	private static final String CURRENT_PARTIES_ACTIVE_IN_COMMITTEES_TOTAL_DAYS_SERVED_IN_COMMITTEES = "Current parties active in committees, total days served in committees";

	/**
	 * The Constant CURRENT_PARTIES_ACTIVE_IN_COMMITTEES_CURRENT_ASSIGNMENTS.
	 */
	private static final String CURRENT_PARTIES_ACTIVE_IN_COMMITTEES_CURRENT_ASSIGNMENTS = "Current parties active in committees, current assignments";

	/** The Constant CURRENT_PARTIES_ACTIVE_IN_COMMITTEES_HEAD_COUNT. */
	private static final String CURRENT_PARTIES_ACTIVE_IN_COMMITTEES_HEAD_COUNT = "Current parties active in committees, head count";

	/** The Constant ALL_PARTIES_TOTAL_DAYS_SERVED_IN_MINISTRIES_TEXT. */
	private static final String ALL_PARTIES_TOTAL_DAYS_SERVED_IN_MINISTRIES_TEXT = "All parties, total days served in ministries";

	/** The Constant CURRENT_PARTIES_ACTIVE_IN_MINISTRIES_HEAD_COUNT_TEXT. */
	private static final String CURRENT_PARTIES_ACTIVE_IN_MINISTRIES_HEAD_COUNT_TEXT = "Current parties active in ministries, head count";

	/** The Constant RANKING_LIST_BY_TOPIC_TEXT. */
	private static final String RANKING_LIST_BY_TOPIC_TEXT = "Ranking list by topic";

	/** The Constant CHART_BY_TOPIC_TEXT. */
	private static final String CHART_BY_TOPIC_TEXT = "Chart by topic";

	/** The Constant OVERVIEW_TEXT. */
	private static final String OVERVIEW_TEXT = "Overview";

	/** The Constant PAGE_VISIT_HISTORY_TEXT. */
	private static final String PAGE_VISIT_HISTORY_TEXT = "Page Visit History";

	@Override
	public void createPartyRankingMenuBar(final MenuBar menuBar) {
		initApplicationMenuBar(menuBar);

		createPartyRankingTopics(menuBar.addItem(PARTY_RANKING, null,null));
	}


	@Override
	public void createPartyRankingTopics(final MenuItem partynMenuItem) {

		partynMenuItem.addItem(OVERVIEW_TEXT, null,
				COMMAND18);

		final MenuItem listByTopic = partynMenuItem.addItem(RANKING_LIST_BY_TOPIC_TEXT, null, null);

		final MenuItem listItem = listByTopic.addItem(TOTAL_MEMBERS,
				COMMAND19);
		listItem.setDescription(PARTY_BY_TOTAL_MEMBERS_BASED_ON_ROLES_IN_DEPARTMENTS_COMMITTEES_AND_PARLIAMENT);

		final MenuItem chartByTopic = partynMenuItem.addItem(CHART_BY_TOPIC_TEXT, null, null);

		chartByTopic.addItem(CURRENT_PARTIES_ACTIVE_IN_MINISTRIES_HEAD_COUNT_TEXT,
				COMMAND20);
		chartByTopic.addItem(CURRENT_PARTIES_TOTAL_DAYS_SERVED_IN_MINISTRIES,
				COMMAND20);

		chartByTopic.addItem(CURRENT_PARTIES_ACTIVE_IN_COMMITTEES_HEAD_COUNT,
				COMMAND20);
		chartByTopic.addItem(CURRENT_PARTIES_ACTIVE_IN_COMMITTEES_CURRENT_ASSIGNMENTS,
				COMMAND20);
		chartByTopic.addItem(CURRENT_PARTIES_ACTIVE_IN_COMMITTEES_TOTAL_DAYS_SERVED_IN_COMMITTEES,
				COMMAND20);

		chartByTopic.addItem(CURRENT_PARTIES_ACTIVE_IN_PARLIAMENT_HEAD_COUNT,
				COMMAND20);
		chartByTopic.addItem(CURRENT_PARTIES_TOTAL_DAYS_SERVED_IN_PARLIAMENT,
				COMMAND20);

		chartByTopic.addItem(ALL_PARTIES_HEAD_COUNT_IN_PARLIAMENT,
				COMMAND20);
		chartByTopic.addItem(ALL_PARTIES_TOTAL_DAYS_SERVED_IN_PARLIAMENT,
				COMMAND20);

		chartByTopic.addItem(ALL_PARTIES_TOTAL_DAYS_SERVED_IN_MINISTRIES_TEXT,
				COMMAND20);
		chartByTopic.addItem(ALL_PARTIES_TOTAL_DAYS_SERVED_IN_COMMITTEES,
				COMMAND20);
		chartByTopic.addItem(ALL_PARTIES_TOTAL_ASSIGNMENTS_IN_COMMITTEES,
				COMMAND20);

		partynMenuItem.addItem(PAGE_VISIT_HISTORY_TEXT, null,
				COMMAND21);
	}

}
