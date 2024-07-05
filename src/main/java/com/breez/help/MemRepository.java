package com.breez.help;

import java.util.HashMap;
import java.util.Map;

public class MemRepository {

	private static MemRepository instance;
	private final Map<Integer, String> phrases = new HashMap<>();

	public static MemRepository getInstance() {
		if (instance == null) {
			instance = new MemRepository();
		}
		return instance;
	}

	private MemRepository() {
		phrases.put(1, "You will succeed");
		phrases.put(2, "You're on the right way");
		phrases.put(3, "Don't give up, everything will succeed");
		phrases.put(4, "Well done");
	}

	public String getPhrase() {
		return phrases.get((int) (Math.random() * phrases.size() + 1));
	}

	public boolean addPhrase(String newPhrase) {
		for (String phrase : phrases.values()) {
			if (newPhrase.equals(phrase)) {
				return true;
			}
		}
		phrases.put(phrases.size() + 1, newPhrase);
		return false;
	}

}
