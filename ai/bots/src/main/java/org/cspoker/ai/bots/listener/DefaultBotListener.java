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
package org.cspoker.ai.bots.listener;

import net.jcip.annotations.NotThreadSafe;

import org.cspoker.common.api.lobby.holdemtable.event.SitOutEvent;

@NotThreadSafe
public class DefaultBotListener implements BotListener {

	/**
	 * <code>no op</code>
	 * 
	 * @see org.cspoker.ai.bots.listener.BotListener#onNewDeal()
	 */
	public void onNewDeal() {
		// no op
	}

	/**
	 * <code>no op</code>
	 * 
	 * @see org.cspoker.ai.bots.listener.BotListener#onSitOut()
	 */
	@Override
	public void onSitOut(SitOutEvent sitOutEvent) {
		// no op
	}
	
	@Override
	public void onActionPerformed() {
		//no op
	}

}
