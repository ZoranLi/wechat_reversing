package com.tencent.mm.modelcdntran;

public final class i extends h {
    public String fOu;
    public int fOw;
    public long fTQ = 0;
    public String filename;
    public String fvn = "";
    public String host;
    public long hzq;
    public String hzr;
    public int hzs;
    public int hzt;
    public String hzu;
    public int hzv;
    public int hzw = 0;
    public long hzx = 0;
    public int hzy = 0;
    public a hzz;
    public String[] iplist;
    public boolean isColdSnsData = false;
    public String referer;
    public String signalQuality = "";
    public String snsScene = "";
    public String url;

    public interface a {
        void f(String str, int i, int i2);

        void onDataAvailable(String str, int i, int i2);

        void onMoovReady(String str, int i, int i2);

        void w(String str, int i);
    }

    public final boolean Ep() {
        return this.hzo == 3;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("isPlayMode: ").append(this.hzt);
        stringBuffer.append(" videoFormat: ").append(this.field_requestVideoFormat);
        stringBuffer.append(" initialDownloadLength : ").append(this.initialDownloadLength);
        stringBuffer.append(" initialDownloadOffset : ").append(this.initialDownloadOffset);
        stringBuffer.append(" videoXmlTotalLen : ").append(this.hzs);
        stringBuffer.append(" videoTaskType : ").append(this.hzo);
        stringBuffer.append(" filename : ").append(this.filename);
        if (En()) {
            stringBuffer.append(" url : ").append(this.url);
            stringBuffer.append(" host : ").append(this.host);
            stringBuffer.append(" referer : ").append(this.referer);
            stringBuffer.append(" ip size : ").append(this.iplist != null ? this.iplist.length : 0);
            stringBuffer.append(" isColdSnsData : ").append(this.isColdSnsData);
            stringBuffer.append(" signalQuality : ").append(this.signalQuality);
            stringBuffer.append(" snsScene : ").append(this.snsScene);
        } else {
            stringBuffer.append(" field_mediaId : ").append(this.field_mediaId);
        }
        stringBuffer.append("fileid : ").append(this.field_fileId);
        stringBuffer.append("fileaeskey: ").append(this.field_aesKey);
        stringBuffer.append("field_preloadRatio:").append(this.field_preloadRatio);
        stringBuffer.append("newmd5: ").append(this.fvn);
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
