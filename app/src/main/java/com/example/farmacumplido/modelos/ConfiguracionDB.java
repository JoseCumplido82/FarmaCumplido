package com.example.farmacumplido.modelos;

public class ConfiguracionDB {
    public static final String HOSTDB = "10.0.2.2";
    //public static final String HOSTDB = "infsalinas.sytes.net";
    public static final String NOMBREDB = "medicamentosdb";
    public static final String USUARIODB = "root";
    //public static final String USUARIODB = "damserver1";
    public static final String CLAVEDB = "1234";
    //public static final String CLAVEDB = "dam1234";
   private static final String OPCIONES = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    //private static final String OPCIONES = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
    public static final String PUERTOMYSQL = "3306";
    //public static final String PUERTOMYSQL = "5306";
    public static final String URLMYSQL = "jdbc:mysql://"+ HOSTDB + ":" + PUERTOMYSQL+"/" + NOMBREDB + OPCIONES;

}
