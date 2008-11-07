/**
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package org.cspoker.server.common.exception;

public class TableDoesNotExistException extends Exception {

	private static final long serialVersionUID = -1970659252469932812L;

	private final long tableId;

	public TableDoesNotExistException(long tableId) {
		super("The table with id [" + Long.toString(tableId) + "] des not exist.");
		this.tableId = tableId;
	}

	public long getTableId() {
		return tableId;
	}

}