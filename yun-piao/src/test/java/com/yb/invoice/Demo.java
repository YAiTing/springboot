package com.yb.invoice;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.Base64;

/**
 * @Author: yangb
 * @Description:
 */
public class Demo {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String b = sendHtpps();
		System.out.println("result:" + new String(Base64.getDecoder().decode(b), "utf-8"));
	}
	private final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
		@Override
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	};
	private static void trustAllHosts() {
		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
			@Override
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return new java.security.cert.X509Certificate[]{};
			}
			@Override
			public void checkClientTrusted(X509Certificate[] chain, String authType) {
			}
			@Override
			public void checkServerTrusted(X509Certificate[] chain, String authType) {
			}
		}};
		// Install the all-trusting trust manager
		try {
			SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String sendHtpps() throws UnsupportedEncodingException {
		String a="<?xml version='1.0' encoding='utf-8' ?><business id=\"GETTOKEN\"><body><input><appId>500102010001448,499000115575</appId><appSecret>01b92641dc5d48e9ba8b003eda027168</appSecret></input></body></business>";//请求参数
		a = Base64.getEncoder().encodeToString(a.getBytes("UTF-8"));
		String result = "";
		PrintWriter out = null;
		BufferedReader in = null;
		try {
//			trustAllHosts();
			URL realUrl = new URL("http://60.12.220.74:10001/dzfpkp/NByunpiao/token.htm");
			HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
//			conn.setHostnameVerifier(DO_NOT_VERIFY);
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Content-Type", "text/plain;charset=utf-8");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(a);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 使用finally块来关闭输出流、输入流
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
}

