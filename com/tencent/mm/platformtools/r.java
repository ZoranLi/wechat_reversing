package com.tencent.mm.platformtools;

import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class r {
    public static boolean iiA = false;
    public static int iiB = 0;
    public static boolean iiC = false;
    public static boolean iiD = false;
    public static boolean iiE = false;
    public static String iiF = "";
    public static String iiG = "";
    public static boolean iiH = false;
    public static boolean iiI = false;
    public static boolean iiJ = false;
    public static boolean iiK = false;
    public static boolean iiL = false;
    public static boolean iiM = false;
    public static boolean iiN = false;
    public static int iiO = 0;
    public static int iiP = 0;
    public static boolean iiQ = false;
    public static String iiR = null;
    public static String iiS = null;
    public static boolean iiT = false;
    public static boolean iiU = false;
    public static int iiV = 0;
    public static int iiW = 0;
    public static int iiX = 0;
    public static String iiY = "";
    public static String iiZ = "";
    public static boolean iik = false;
    public static boolean iil = false;
    public static boolean iim = false;
    public static boolean iin = false;
    public static boolean iio = false;
    public static boolean iip = false;
    public static boolean iiq = false;
    public static boolean iir = false;
    public static boolean iis = false;
    public static boolean iit = false;
    public static boolean iiu = false;
    public static boolean iiv = false;
    public static String iiw = "";
    public static boolean iix = false;
    public static boolean iiy = false;
    public static boolean iiz = false;
    public static boolean ijA = false;
    public static boolean ijB = false;
    public static int ijC = -1;
    public static boolean ijD = false;
    public static String ijE = "";
    public static boolean ijF = false;
    public static boolean ijG = false;
    public static int ijH = 5;
    public static int ijI = 0;
    public static boolean ijJ = false;
    public static String ijK = "";
    public static String ijL = "";
    public static boolean ijM = false;
    public static boolean ijN = false;
    public static String ijO = "";
    public static String ijP = "";
    public static boolean ijQ = false;
    public static boolean ijR = false;
    public static boolean ijS = false;
    public static boolean ijT = false;
    private static HashMap<Integer, ConcurrentLinkedQueue<Integer>> ijU = new HashMap();
    public static boolean ijV = false;
    public static boolean ijW = false;
    public static boolean ijX = false;
    public static String ija = null;
    public static String ijb = null;
    public static boolean ijc = false;
    public static boolean ijd = false;
    public static boolean ije = false;
    public static boolean ijf = false;
    public static String ijg = "";
    public static String ijh = "";
    public static String iji = "";
    public static String ijj = "";
    public static String ijk = "";
    public static boolean ijl = false;
    public static boolean ijm = false;
    public static boolean ijn = false;
    public static int ijo = 0;
    public static boolean ijp = false;
    public static boolean ijq = false;
    public static boolean ijr = false;
    public static boolean ijs = false;
    public static boolean ijt = false;
    public static boolean iju = false;
    public static boolean ijv = true;
    public static boolean ijw = false;
    public static boolean ijx = false;
    public static String ijy = "";
    public static int ijz = 0;
    public static double lat = 0.0d;
    public static double lng = 0.0d;

    public static void bf(int i, int i2) {
        synchronized (ijU) {
            ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) ijU.get(Integer.valueOf(i));
            if (concurrentLinkedQueue == null) {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                ijU.put(Integer.valueOf(i), concurrentLinkedQueue);
            }
            concurrentLinkedQueue.add(Integer.valueOf(i2));
        }
    }
}
