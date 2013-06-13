package com.sirma.itt.javacourse.netAndGui.task2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Download {
	public Download() throws IOException {
		String url = "http://middleages-bg.info/interests/other/User.jpg";
		URL onlineFile = new URL(url);
		URLConnection connection = onlineFile.openConnection();

		String fileType = url.substring(url.lastIndexOf("."));
		System.out.println(fileType);
		ReadableByteChannel rbc = Channels.newChannel(connection.getInputStream());
		FileOutputStream fos = new FileOutputStream("X:/myfile" + fileType);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

	}
}
