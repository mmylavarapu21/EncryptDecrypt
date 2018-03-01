package com.deloitte.localmemory;

public class EncryptDecrypt {

	public String encrypting(String nonEncryptedName) {
		String encryptedName = null;
		if (!(LocalCache.getInstance().isPresent(nonEncryptedName))) {
			if (lengthofString(nonEncryptedName).equalsIgnoreCase("even")) {
				String part1 = nonEncryptedName.substring(0, ((nonEncryptedName.length()) / 2));
				System.out.println("Part1: " + part1);
				String part2 = nonEncryptedName.replace(part1, "");
				System.out.println("Part2: " + part2);
				encryptedName = part2.trim() + part1.trim();
				LocalCache.getInstance().setLocalCache(nonEncryptedName, encryptedName);
				return encryptedName;
			}
			String part1 = nonEncryptedName.substring(0, ((nonEncryptedName.length()) / 2) + 1);
			String part2 = nonEncryptedName.replace(part1, "");
			encryptedName = part2.trim() + "#" + part1.trim();
			LocalCache.getInstance().setLocalCache(nonEncryptedName, encryptedName);
			return encryptedName;

		}
		return LocalCache.getInstance().getDecryptedName(nonEncryptedName);
	}

	public String decrypting(String encryptedName) {
		String decryptedName = null;
		if (!(LocalCache.getInstance().isPresent(encryptedName))) {
			String part1 = encryptedName.substring(0, ((encryptedName.length()) / 2));
			System.out.println("Part1: " + part1);
			String part2 = encryptedName.replace(part1, "");
			System.out.println("Part2: " + part2);
			decryptedName = part2.trim() + part1.trim();
			decryptedName = decryptedName.replace("#", "");
			LocalCache.getInstance().setLocalCache(decryptedName, encryptedName);
			return decryptedName;
		}
		return LocalCache.getInstance().getEncryptedName(encryptedName);
	}

	private String lengthofString(String nonEncryptedName) {
		int stringLength = nonEncryptedName.length();
		if ((stringLength % 2) == 0) {
			return "even";
		}
		return "odd";
	}

}
