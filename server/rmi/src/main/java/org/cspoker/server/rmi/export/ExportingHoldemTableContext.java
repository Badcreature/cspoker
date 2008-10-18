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
package org.cspoker.server.rmi.export;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.apache.log4j.Logger;
import org.cspoker.common.api.lobby.holdemtable.context.ForwardingRemoteHoldemTableContext;
import org.cspoker.common.api.lobby.holdemtable.context.RemoteHoldemTableContext;
import org.cspoker.common.api.lobby.holdemtable.holdemplayer.context.RemoteHoldemPlayerContext;
import org.cspoker.common.api.lobby.holdemtable.holdemplayer.listener.HoldemPlayerListener;
import org.cspoker.common.api.shared.exception.IllegalActionException;

public class ExportingHoldemTableContext extends ForwardingRemoteHoldemTableContext {

	private final static Logger logger = Logger.getLogger(ExportingHoldemTableContext.class);

	public ExportingHoldemTableContext(RemoteHoldemTableContext holdemTableContext) throws RemoteException {
		super(holdemTableContext);
	}

	@Override
	public RemoteHoldemPlayerContext sitIn(final long seatId, final int amount, final HoldemPlayerListener holdemPlayerListener)
	throws RemoteException, IllegalActionException {
		try {
			return (RemoteHoldemPlayerContext) UnicastRemoteObject.exportObject(ExportingHoldemTableContext.super.sitIn(seatId, amount, holdemPlayerListener), 0);
		} catch (RemoteException exception) {
			logger.error(exception.getMessage(), exception);
			throw exception;
		}
	}

}
