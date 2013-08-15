package com.sirma.itt.javacourse.chat.serverfunctions;

import com.sirma.itt.javacourse.chat.controllers.ServerMessenger;
import com.sirma.itt.javacourse.chat.controllers.Wrapper;

public class ClientsLogoutListener implements Runnable {
	Wrapper wrap;
	ServerMessenger msg;

	ClientsLogoutListener(ServerMessenger msg, Wrapper wrap) {
		this.wrap = wrap;
		this.msg = msg;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String[] message = msg.receiveCommand();

				if (message[0].equals("disconnect")) {
					wrap.getMsg().setTextToBeUpdated("logout user", message[1]);
					wrap.getUsersList().remove(message[1]);
					wrap.getMsg().setTextToBeUpdated("Main area",
							wrap.getLang().getValue("userDisconnected") + message[1]);
				}
			} catch (Exception e) {

			}
		}
	}
}
