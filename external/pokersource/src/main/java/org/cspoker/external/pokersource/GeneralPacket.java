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
package org.cspoker.external.pokersource;

import org.cspoker.external.pokersource.eventlisteners.all.AllEventListener;
import org.cspoker.external.pokersource.eventlisteners.general.GeneralEventListener;
import org.cspoker.external.pokersource.eventlisteners.poker.PokerEventListener;

abstract public class GeneralPacket extends JSONPacket{

	public abstract void signal(GeneralEventListener listener);
	
	@Override
	public void signal(AllEventListener listener) {
		//why is this even needed???
		signal((GeneralEventListener)listener);
	}
	
	@Override
	public void signal(GeneralEventListener generalListener, PokerEventListener pokerListener) {
		signal(generalListener);
	}
	
	
}
