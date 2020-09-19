package com.example.javabase.base.overide;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

public class Site {

    // 站点ID
    private int id;
    // 站点经度
    private double siteLat;
    // 站点纬度
    private double siteLon;

    private static final String UNDERLINE = "_";

    public Site() {
    }

    public Site(int id, double siteLat, double siteLon) {
        this.id = id;
        this.siteLat = siteLat;
        this.siteLon = siteLon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSiteLat() {
        return siteLat;
    }

    public void setSiteLat(double siteLat) {
        this.siteLat = siteLat;
    }

    public double getSiteLon() {
        return siteLon;
    }

    public void setSiteLon(double siteLon) {
        this.siteLon = siteLon;
    }


    public static void main(String[] args) throws JsonProcessingException {
        List<Site> sites = new ArrayList<>();
        List<Integer> indesxList = new ArrayList<>();
        Site site1 = new Site(1, 2.1, 3.3);
        Site site2 = new Site(2, 2.2, 3.3);
        Site site3 = new Site(3, 2.3, 3.3);
        Site site4 = new Site(3, 2.3, 3.3);

        sites.add(site1);
        sites.add(site2);
        sites.add(site3);
        sites.add(site4);

        Map<Integer, String> redunParam = new HashMap();
        Map<Integer, String> hasExistsParam = new HashMap();

        for (int i = 0; i < sites.size(); i++) {
            boolean ret = checkRedunParam(sites.get(i), redunParam, hasExistsParam);
            if (!ret) {
                indesxList.add(i);
            }
        }

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(hasExistsParam));
        System.out.println("---------------------------------------------------");
        System.out.println(objectMapper.writeValueAsString(redunParam));
        System.out.println("---------------------------------------------------");
        System.out.println(objectMapper.writeValueAsString(indesxList));
        System.out.println("---------------------------------------------------");
    }


    private static boolean checkRedunParam(Site site, Map redunParam, Map hasExistsParam) {
        String value = site.getId() + UNDERLINE + site.getSiteLat() + UNDERLINE + site.getSiteLon();
        if (!hasExistsParam.keySet().contains(site.getId())) {
            hasExistsParam.put(site.getId(), value);
        } else if (hasExistsParam.keySet().contains(site.getId()) && hasExistsParam.get(site.getId()).equals(value)) {
            redunParam.put(site.getId(), value);
            return false;
        }
        return true;
    }

//    private static List<Site> removeRedunParam(List<Site> sites, List<Integer> indesxList) {
//        if (CollectionUtils.isEmpty(indesxList)) {
//            return sites;
//        }
//        for (Integer integer : indesxList) {
//            sites.remove(integer);
//        }
//        return sites;
//    }

}
