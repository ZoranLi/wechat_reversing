package com.tencent.mm.plugin.music.a.e;

public final class g {
    public static int BD(String str) {
        if ("audio/3gpp".equalsIgnoreCase(str)) {
            return 1;
        }
        if ("audio/amr-wb".equalsIgnoreCase(str)) {
            return 2;
        }
        if ("audio/mpeg".equalsIgnoreCase(str) || "audio/mp3".equalsIgnoreCase(str)) {
            return 3;
        }
        if ("audio/mp4a-latm".equalsIgnoreCase(str) || str.startsWith("audio/mp4")) {
            return 4;
        }
        if ("audio/qcelp".equalsIgnoreCase(str)) {
            return 5;
        }
        if ("audio/vorbis".equalsIgnoreCase(str)) {
            return 6;
        }
        if ("audio/opus".equalsIgnoreCase(str)) {
            return 7;
        }
        if ("audio/g711-alaw".equalsIgnoreCase(str)) {
            return 8;
        }
        if ("audio/g711-mlaw".equalsIgnoreCase(str)) {
            return 9;
        }
        if ("audio/raw".equalsIgnoreCase(str)) {
            return 10;
        }
        if ("audio/flac".equalsIgnoreCase(str)) {
            return 11;
        }
        if ("audio/gsm".equalsIgnoreCase(str)) {
            return 12;
        }
        if ("audio/ac3".equalsIgnoreCase(str)) {
            return 13;
        }
        if ("audio/eac3".equalsIgnoreCase(str)) {
            return 14;
        }
        if ("audio/x-ms-wma".equalsIgnoreCase(str)) {
            return 15;
        }
        if ("audio/x-wav".equalsIgnoreCase(str)) {
            return 16;
        }
        if ("audio/x-ape".equalsIgnoreCase(str) || "application/x-ape".equalsIgnoreCase(str)) {
            return 17;
        }
        return 0;
    }
}
