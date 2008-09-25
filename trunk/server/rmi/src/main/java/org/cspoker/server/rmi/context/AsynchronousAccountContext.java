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
package org.cspoker.server.rmi.context;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

import org.cspoker.common.api.account.AccountContext;
import org.cspoker.common.api.account.DelegatingAccountContext;
import org.cspoker.common.api.account.event.RemoteAccountListener;
import org.cspoker.server.rmi.listener.AsynchronousAccountListener;

public class AsynchronousAccountContext extends DelegatingAccountContext {

	protected ConcurrentHashMap<RemoteAccountListener, AsynchronousAccountListener> wrappers = 
		new ConcurrentHashMap<RemoteAccountListener, AsynchronousAccountListener>();
	protected Executor executor;
	private AsynchronousServerContext asynchronousServerContext;
	
	public AsynchronousAccountContext(AsynchronousServerContext asynchronousServerContext, Executor executor, AccountContext accountContext) {
		super(accountContext);
		this.asynchronousServerContext = asynchronousServerContext;
		this.executor = executor;
	}
	
	@Override
	public void subscribe(RemoteAccountListener accountListener) {
		AsynchronousAccountListener wrapper = new AsynchronousAccountListener(asynchronousServerContext, executor, accountListener);
		if(wrappers.putIfAbsent(accountListener, wrapper)==null){
			super.subscribe(wrapper);
		}
		
	}
	
	@Override
	public void unSubscribe(RemoteAccountListener accountListener) {
		AsynchronousAccountListener wrapper = wrappers.remove(accountListener);
		if(wrapper!=null){
			super.unSubscribe(wrapper);
		}
	}
	
}
