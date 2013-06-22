package com.sirma.itt.javacourse.netAndGui.task2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JProgressBar;

public class Download extends DownloaderWindow implements ActionListener {
	public Download() {
		download.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Download")) {
			errorField.setText("");
			String url = source.getText();

			URL onlineFile = null;
			URLConnection connection = null;
			BufferedInputStream in = null;
			try {
				onlineFile = new URL(url);
				connection = onlineFile.openConnection();
				in = new BufferedInputStream(connection.getInputStream());
			} catch (IOException e1) {
				errorField.setText("Wrong source url or could not open connection!");
				return;
			}
			int fileSize = connection.getContentLength();
			File dest = new File(destination.getText());
			BufferedOutputStream out = null;

			try {
				out = new BufferedOutputStream(new FileOutputStream(dest));
			} catch (FileNotFoundException e1) {
				errorField.setText("File system error!");
			}
			TransferObject transfer = new TransferObject(in, out);

			int lastRead = 0;
			boolean flag = true;
			// in.skip(offset);

			int readed = 0;

			byte[] buf = new byte[1024];
			int len;
			try {
				len = in.read(buf);
				progress = new JProgressBar(0, fileSize);
				mainPanel.add(progress, BorderLayout.SOUTH);
				progress.setValue(0);
				while (len > 0 && progress.getValue() < fileSize) {
					out.write(buf, 0, len);
					progress.setValue(progress.getValue() + len);
					len = in.read(buf);
				}

				in.close();
				out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}
}
