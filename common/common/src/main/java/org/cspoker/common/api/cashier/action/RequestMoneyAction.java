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
package org.cspoker.common.api.cashier.action;

import javax.xml.bind.annotation.XmlRootElement;

import net.jcip.annotations.Immutable;

import org.cspoker.common.api.cashier.context.CashierContext;
import org.cspoker.common.api.shared.event.EventId;

@XmlRootElement
@Immutable
public class RequestMoneyAction extends CashierAction<Void> {

	private static final long serialVersionUID = 567436868321801958L;

	public RequestMoneyAction(EventId id) {
		super(id);
	}

	protected RequestMoneyAction() {
		// no op
	}
	
	@Override
	public Void perform(CashierContext cashierContext) {
		cashierContext.requestMoney();
		return null;
	}

}
