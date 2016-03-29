/**
 * Copyright 2010-2016 Boxfuse GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 *
 */
package org.flywaydb.core.internal.dbsupport.sybase.asa;

import java.sql.SQLException;

import org.flywaydb.core.internal.dbsupport.DbSupport;
import org.flywaydb.core.internal.dbsupport.JdbcTemplate;
import org.flywaydb.core.internal.dbsupport.Schema;
import org.flywaydb.core.internal.dbsupport.sybase.ase.SybaseASETable;

/**
 * Sybase SQL Anywhere table for flyway
 *
 */
public class SybaseASATable extends SybaseASETable {

	/**
	 * Creates a new Sybase SQL Anywhere table.
	 *
	 * @param jdbcTemplate
	 *            The Jdbc Template for communicating with the DB.
	 * @param dbSupport
	 *            The database-specific support.
	 * @param schema
	 *            The schema this table lives in.
	 * @param name
	 *            The name of the table.
	 */
	public SybaseASATable(JdbcTemplate jdbcTemplate, DbSupport dbSupport,
			Schema schema, String name) {
		super(jdbcTemplate, dbSupport, schema, name);
	}


	@Override
	protected void doLock() throws SQLException {
		jdbcTemplate.execute("LOCK TABLE " + this + " IN EXCLUSIVE MODE");

	}

}