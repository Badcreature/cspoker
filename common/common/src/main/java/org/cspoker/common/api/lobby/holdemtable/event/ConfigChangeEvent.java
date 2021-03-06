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

package org.cspoker.common.api.lobby.holdemtable.event;

import net.jcip.annotations.Immutable;

import org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener;
import org.cspoker.common.elements.table.TableConfiguration;

/**
 * A class to represent big blind events.
 * 
 */
@Immutable
public class ConfigChangeEvent extends HoldemTableEvent {

	private static final long serialVersionUID = -7615744787729191158L;
	
	private final TableConfiguration tableConfig;

	public ConfigChangeEvent(TableConfiguration tableConfig) {
		this.tableConfig = tableConfig;
	}

	protected ConfigChangeEvent() {
		tableConfig = null;
	}

	@Override
	public String toString() {
		return "The table configuration changed to "+tableConfig;
	}

	public TableConfiguration getTableConfig() {
		return tableConfig;
	}
	
	@Override
	public void dispatch(HoldemTableListener holdemTableListener) {
		holdemTableListener.onConfigChange(this);
	}
}
