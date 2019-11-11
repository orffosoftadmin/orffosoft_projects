package co.orffosoft.core.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class TrackIdGenerationService {

	/*
	 * This Class will create track id of format IP:SESSIONID:TRACKID
	 * 
	 */

	private String ipAddress;

	public String generateTackId(String sessionId) {

		StringBuilder trackId = new StringBuilder();

		try {

			UUID uuid = UUID.randomUUID();

			if (ipAddress == null) {
				setIPAddress();
			}

			if (sessionId == null) {
				sessionId = "";
			}

			trackId.append(ipAddress + ":" + sessionId + ":" + uuid.toString().replaceAll("-", ""));
		} catch (Exception e) {
			log.error("Exception while generating trackId==>" + e);
		}
		return trackId.toString();

	}

	private void setIPAddress() {
		try {
			InetAddress ipAddr = InetAddress.getLocalHost();
			ipAddress = ipAddr.getHostAddress();
		} catch (UnknownHostException ex) {
			log.error("Exception while getting IP address" + ex);
			ipAddress = "";
		}

	}
}
