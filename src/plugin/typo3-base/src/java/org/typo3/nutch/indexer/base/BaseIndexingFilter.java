/**
 * Copyright 2012 Ingo Renner <ingo.renner@dkd.de>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.typo3.nutch.indexer.base;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.nutch.crawl.CrawlDatum;
import org.apache.nutch.crawl.Inlinks;
import org.apache.nutch.indexer.IndexingException;
import org.apache.nutch.indexer.IndexingFilter;
import org.apache.nutch.indexer.NutchDocument;
import org.apache.nutch.parse.Parse;

public class BaseIndexingFilter implements IndexingFilter  {

	protected static final String INDEXING_FIELD_TYPE = "type";
	protected static final String INDEXING_FIELD_APPKEY = "appKey";

	protected Configuration configuration;

	@Override
	public Configuration getConf() {
		return configuration;
	}

	/**
	 * Sets configuration
	 */
	@Override
	public void setConf(Configuration configuration) {
		this.configuration = configuration;
	}

	@Override
	public NutchDocument filter(NutchDocument doc, Parse parse, Text url,
			CrawlDatum datum, Inlinks inlinks) throws IndexingException {

		doc.add(INDEXING_FIELD_TYPE, "tx_nutch_external");
		doc.add(INDEXING_FIELD_APPKEY, "ApacheNutchForTypo3");

		return doc;
	}

}
