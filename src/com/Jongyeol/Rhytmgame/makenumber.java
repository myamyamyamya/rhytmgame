package com.Jongyeol.Rhytmgame;

public class makenumber {
    public static int makenumber(String string){
        String[] strings = string.split("");
        String st = "";
        for(int i1=0; i1<strings.length; i1++){
            for(int i2=0; i2<10; i2++){
                if(strings[i1].equals(i2 + "")){
                    st = st + i2;
                }
            }
            if(strings[i1].equals("-")){
                st = st + "-";
            }
        }
        return Integer.parseInt(st);
    }
    public static float makefloat(String string){
        String[] strings = string.split("");
        String st = "";
        for(int i1=0; i1<strings.length; i1++){
            for(int i2=0; i2<10; i2++){
                if(strings[i1].equals(i2 + "")){
                    st = st + i2;
                }
            }
            if(strings[i1].equals("-")){
                st = st + "-";
            }
            if(strings[i1].equals(".")){
                st = st + ".";
            }
        }
        return Float.parseFloat(st);
    }
    public static Double makedouble(String string){
        String[] strings = string.split("");
        String st = "";
        for(int i1=0; i1<strings.length; i1++){
            for(int i2=0; i2<10; i2++){
                if(strings[i1].equals(i2 + "")){
                    st = st + i2;
                }
            }
            if(strings[i1].equals("-")){
                st = st + "-";
            }
            if(strings[i1].equals(".")){
                st = st + ".";
            }
        }
        return Double.parseDouble(st);
    }
    public static String makestring6number(int i){
        String st;
        if(i < 10){
            st = "00000" + i;
        } else if(i < 100) {
            st = "0000" + i;
        } else if(i < 1000) {
            st = "000" + i;
        } else if(i < 10000) {
            st = "00" + i;
        } else if(i < 100000) {
            st = "0" + i;
        } else {
            st = i + "";
        }
        return st;
    }
}
