package org.cspoker.server;

import org.cspoker.common.api.cashier.context.CashierContext;
import org.cspoker.server.account.ExtendedAccountContext;

public class CashierContextImpl implements CashierContext {

	public CashierContextImpl(ExtendedAccountContext accountContext) {
	}

	public int getMoneyAmount() {
		return 0;
	}

	public void requestMoney() {
	}

}
