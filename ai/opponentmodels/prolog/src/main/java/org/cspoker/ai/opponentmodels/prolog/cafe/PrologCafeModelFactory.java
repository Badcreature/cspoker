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
package org.cspoker.ai.opponentmodels.prolog.cafe;

import jp.ac.kobe_u.cs.prolog.lang.PrologControl;
import net.jcip.annotations.ThreadSafe;

import org.cspoker.ai.opponentmodels.OpponentModel;
import org.cspoker.common.elements.player.PlayerId;

@ThreadSafe
public class PrologCafeModelFactory implements OpponentModel.Factory {

	@Override
	public OpponentModel create(PlayerId actor) {
		PrologControl prolog = new PrologControl();
		return new PrologCafeModel(prolog);
	}
	
	@Override
	public String toString() {
		return "PrologCafeModel";
	}
}
