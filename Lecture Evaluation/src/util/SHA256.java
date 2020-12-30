package util;

import java.security.MessageDigest;

public class SHA256 {

	public static String getSHA256(String input) {

		StringBuffer result = new StringBuffer();
		
		try {
			
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] salt = "Solt".getBytes();
			digest.reset();
			digest.update(salt);
			byte[] chars = digest.digest(input.getBytes("UTF-8"));
			for (int inx = 0; inx < chars.length; inx++) {
				String hex = Integer.toHexString(0xff & chars[inx]);
				if (hex.length() == 1)
					result.append('0');
				result.append(hex);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result.toString();

	}
}
