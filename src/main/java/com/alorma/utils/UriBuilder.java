package com.alorma.utils;

import android.net.Uri;

public class UriBuilder {

	private static StringBuffer sb;

    public UriBuilder(String base) {
        sb = new StringBuffer(base);
    }

	public UriBuilder addParam(String param) {
		sb.append("/");
		sb.append(param);
		return this;
	}

	@Override
	public String toString() {
		return sb.toString();
	}

    public static Uri providerUri(String authority, String path) {

        return Uri.parse("content://" + authority + "/" + path);
    }

    public static Uri providerUriById(String authority, String path, long id) {

        return Uri.withAppendedPath(providerUri(authority, path), Long.toString(id));
    }
}
