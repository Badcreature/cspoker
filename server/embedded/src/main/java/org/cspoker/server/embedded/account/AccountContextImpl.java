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
 package org.cspoker.server.embedded.account;

import javax.security.auth.login.LoginException;

import org.cspoker.common.elements.player.MutablePlayer;
import org.cspoker.common.elements.player.PlayerId;
import org.cspoker.server.embedded.player.PlayerFactory;

public class AccountContextImpl implements ExtendedAccountContext{
		
	private MutablePlayer player;
	
	public AccountContextImpl(String username, String password) throws LoginException {
		//TODO make login system plugable
		if(username==null || password == null || username.length()==0 || !password.equals("test")){
			throw new LoginException();
		}
		player = PlayerFactory.global_Player_Factory.createNewPlayer(username);
		
	}

	public void changePassword(String passwordHash) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	public void createAccount(String username, String passwordHash)throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	public byte[] getAvatar(PlayerId playerId) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	public void setAvatar(byte[] avatar) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	public MutablePlayer getPlayer(){
		return player;
	}

	public boolean hasPassword(String passwordHash) {
		return passwordHash!=null && passwordHash.equals("test");
	}
	
	public PlayerId getPlayerID() {
		return player.getId();
	}

}
