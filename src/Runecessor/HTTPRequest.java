package Runecessor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class HTTPRequest {

	private static final String USER_AGENT = "Mozilla/5.0";

	// HTTP GET request
	public static String sendGet(String url) throws Exception {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		Utility.print("\nSending 'GET' request to URL : " + url);
		Utility.print("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		return response.toString();
	}

	/*
	// Keep commented out so when i obfuscate the client, the class name is also obfuscated.
	public static void main(String[] args) {
		try {
			throw new NullPointerException("Example of exception.");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				sendPost("https://localhost:8081/client_error", encodeSignature(throwableToString(e)), "text/plain");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	*/

	private static String encodeSignature(String content) {
		StringBuilder encoded = new StringBuilder("valid").append("%-%");

		encoded.append(Client.savedUsername == null || Client.savedUsername.isEmpty() ? "no username available"
				: Client.savedUsername).append("%-%");

		encoded.append(Utility.findRemoteIpAddressOr("No internet protocol")).append("%-%");

		encoded.append(content);

		return encoded.toString();
	}

	static String throwableToString(Throwable throwable) {
		StringWriter stringWriter = new StringWriter();

		try(PrintWriter writer = new PrintWriter(stringWriter)) {
			throwable.printStackTrace(writer);

			return stringWriter.toString();
		}
	}

	public static String sendPost(String url, String urlParameters, String contentType) throws Exception {
		SSLContext sslContext = SSLContext.getInstance("SSL");

		sslContext.init(null, new TrustManager[] { trustAllCertificates }, new SecureRandom());

		SSLSocketFactory socketFactory = sslContext.getSocketFactory();

		HttpsURLConnection.setDefaultHostnameVerifier((s, sslSession) -> true);

		URL obj = new URL(url);

		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		con.setSSLSocketFactory(socketFactory);

		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type", contentType);
		con.setRequestProperty("Set-Cookie", UUID.randomUUID().toString());

		con.setDoOutput(true);

		try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
			wr.writeBytes(urlParameters);
			wr.flush();
		}

		StringBuilder response = new StringBuilder();

		try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
		}

		return response.toString();
	}

	private static final TrustManager trustAllCertificates = new X509TrustManager() {

		@Override
		public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

		}

		@Override
		public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[0];
		}
	};

}