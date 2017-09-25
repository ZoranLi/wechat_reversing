package com.tencent.mm.plugin.a;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;

public class a {
    public static final int ikA = c.mE("moov");
    public static final int ikB = c.mE("mvhd");
    public static final int ikC = c.mE("trak");
    public static final int ikD = c.mE("mdia");
    public static final int ikE = c.mE("minf");
    public static final int ikF = c.mE("stbl");
    public static final int ikG = c.mE("avcC");
    public static final int ikH = c.mE("hvcC");
    public static final int ikI = c.mE("esds");
    public static final int ikJ = c.mE("moof");
    public static final int ikK = c.mE("traf");
    public static final int ikL = c.mE("mvex");
    public static final int ikM = c.mE("tkhd");
    public static final int ikN = c.mE("edts");
    public static final int ikO = c.mE("elst");
    public static final int ikP = c.mE("mdhd");
    public static final int ikQ = c.mE("hdlr");
    public static final int ikR = c.mE("stsd");
    public static final int ikS = c.mE("pssh");
    public static final int ikT = c.mE("sinf");
    public static final int ikU = c.mE("schm");
    public static final int ikV = c.mE("schi");
    public static final int ikW = c.mE("tenc");
    public static final int ikX = c.mE("encv");
    public static final int ikY = c.mE("enca");
    public static final int ikZ = c.mE("frma");
    public static final int ikc = c.mE("ftyp");
    public static final int ikd = c.mE("avc1");
    public static final int ike = c.mE("avc3");
    public static final int ikf = c.mE("hvc1");
    public static final int ikg = c.mE("hev1");
    public static final int ikh = c.mE("s263");
    public static final int iki = c.mE("d263");
    public static final int ikj = c.mE("mdat");
    public static final int ikk = c.mE("mp4a");
    public static final int ikl = c.mE("wave");
    public static final int ikm = c.mE("ac-3");
    public static final int ikn = c.mE("dac3");
    public static final int iko = c.mE("ec-3");
    public static final int ikp = c.mE("dec3");
    public static final int ikq = c.mE("dtsc");
    public static final int ikr = c.mE("dtsh");
    public static final int iks = c.mE("dtsl");
    public static final int ikt = c.mE("dtse");
    public static final int iku = c.mE("ddts");
    public static final int ikv = c.mE("tfdt");
    public static final int ikw = c.mE("tfhd");
    public static final int ikx = c.mE("trex");
    public static final int iky = c.mE("trun");
    public static final int ikz = c.mE("sidx");
    public static final int ilA = c.mE("----");
    public static final int ila = c.mE("saiz");
    public static final int ilb = c.mE("saio");
    public static final int ilc = c.mE("uuid");
    public static final int ild = c.mE("senc");
    public static final int ile = c.mE("pasp");
    public static final int ilf = c.mE("TTML");
    public static final int ilg = c.mE("vmhd");
    public static final int ilh = c.mE("mp4v");
    public static final int ili = c.mE("stts");
    public static final int ilj = c.mE("stss");
    public static final int ilk = c.mE("ctts");
    public static final int ill = c.mE("stsc");
    public static final int ilm = c.mE("stsz");
    public static final int iln = c.mE("stco");
    public static final int ilo = c.mE("co64");
    public static final int ilp = c.mE("tx3g");
    public static final int ilq = c.mE("wvtt");
    public static final int ilr = c.mE("stpp");
    public static final int ils = c.mE("samr");
    public static final int ilt = c.mE("sawb");
    public static final int ilu = c.mE("udta");
    public static final int ilv = c.mE("meta");
    public static final int ilw = c.mE("ilst");
    public static final int ilx = c.mE("mean");
    public static final int ily = c.mE("name");
    public static final int ilz = c.mE(SlookAirButtonFrequentContactAdapter.DATA);
    private int ilB;
    private long ilC;
    public long ilD;
    private int type;

    public a(int i, long j, int i2, long j2) {
        this.ilB = i;
        this.ilD = j;
        this.type = i2;
        this.ilC = j2;
    }

    public final boolean ND() {
        return this.type == ikA;
    }

    public final boolean NE() {
        return this.ilB == 0;
    }

    public final long NF() {
        return this.ilD + getSize();
    }

    public final long getSize() {
        if (this.ilC > 0) {
            return this.ilC;
        }
        return (long) this.ilB;
    }

    public String toString() {
        StringBuilder append = new StringBuilder("Atom{atomSize=").append(this.ilB).append(", atomLargeSize=").append(this.ilC).append(", type=");
        int i = this.type;
        return append.append(new String(new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)})).append(", beginPos=").append(this.ilD).append('}').toString();
    }
}
