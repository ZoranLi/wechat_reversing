package com.tencent.mm.pluginsdk;

import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;

public final class b {

    public static final class a {
        public static final HashMap<String, Long> sBh;

        public static Long LB(String str) {
            if (str == null) {
                return null;
            }
            return (Long) sBh.get(str.toLowerCase());
        }

        static {
            HashMap hashMap = new HashMap();
            sBh = hashMap;
            hashMap.put("doc", Long.valueOf(64));
            sBh.put("docx", Long.valueOf(128));
            sBh.put("ppt", Long.valueOf(256));
            sBh.put("pptx", Long.valueOf(512));
            sBh.put("xls", Long.valueOf(AppSupportContentFlag.MMAPP_SUPPORT_XLS));
            sBh.put("xlsx", Long.valueOf(AppSupportContentFlag.MMAPP_SUPPORT_XLSX));
            sBh.put("pdf", Long.valueOf(AppSupportContentFlag.MMAPP_SUPPORT_PDF));
            sBh.put("1", Long.valueOf(1));
            sBh.put(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, Long.valueOf(2));
            sBh.put("48", Long.valueOf(4));
            sBh.put("43", Long.valueOf(8));
            sBh.put("mp3", Long.valueOf(16));
            sBh.put("wav", Long.valueOf(16));
            sBh.put("wma", Long.valueOf(16));
            sBh.put("avi", Long.valueOf(8));
            sBh.put("rmvb", Long.valueOf(8));
            sBh.put("rm", Long.valueOf(8));
            sBh.put("mpg", Long.valueOf(8));
            sBh.put("mpeg", Long.valueOf(8));
            sBh.put("wmv", Long.valueOf(8));
            sBh.put("mp4", Long.valueOf(8));
            sBh.put("mkv", Long.valueOf(8));
        }
    }

    public static final class b {
        public static final HashMap<Integer, Integer> sBi;

        static {
            HashMap hashMap = new HashMap();
            sBi = hashMap;
            hashMap.put(Integer.valueOf(22), Integer.valueOf(64));
            sBi.put(Integer.valueOf(9), Integer.valueOf(64));
            sBi.put(Integer.valueOf(3), Integer.valueOf(64));
            sBi.put(Integer.valueOf(23), Integer.valueOf(64));
            sBi.put(Integer.valueOf(25), Integer.valueOf(64));
            sBi.put(Integer.valueOf(13), Integer.valueOf(64));
            sBi.put(Integer.valueOf(29), Integer.valueOf(256));
            sBi.put(Integer.valueOf(34), Integer.valueOf(512));
            sBi.put(Integer.valueOf(6), Integer.valueOf(512));
            sBi.put(Integer.valueOf(35), Integer.valueOf(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
            sBi.put(Integer.valueOf(36), Integer.valueOf(Downloads.RECV_BUFFER_SIZE));
            sBi.put(Integer.valueOf(37), Integer.valueOf(WXMediaMessage.THUMB_LENGTH_LIMIT));
            sBi.put(Integer.valueOf(38), Integer.valueOf(WXMediaMessage.THUMB_LENGTH_LIMIT));
            sBi.put(Integer.valueOf(42), Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
            sBi.put(Integer.valueOf(40), Integer.valueOf(65536));
            sBi.put(Integer.valueOf(41), Integer.valueOf(65536));
            sBi.put(Integer.valueOf(46), Integer.valueOf(262144));
        }
    }
}
