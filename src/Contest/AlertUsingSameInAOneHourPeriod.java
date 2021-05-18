package Contest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AlertUsingSameInAOneHourPeriod {
    public List<String> alertNames(String[] N, String[] T) {
        Set<String> alert = new HashSet();
        List<String> l = new ArrayList<>();
        Map<Integer,Integer> m1 = new HashMap<>();
        Map<String,List<String>> m2 = new HashMap<>();

        for(int i=0;i<T.length;i++){
            String time = T[i];
            String name = N[i];
            List<String> list = new ArrayList<>();
            list.add(time);

            if(m2.containsKey(name)){
                m2.get(name).add(time);
            }else{
                m2.put(name,list);
            }
        }

        for(Map.Entry<String,List<String>> entry: m2.entrySet()){
            List<String> tmpl = entry.getValue();
            Collections.sort(tmpl);
            String name = entry.getKey();

            int prehour=-100;
            int curhour=-101;
            int preminute = -59;
            int curminute = -59;
            int al = 0;
            for(String s: tmpl){
                String [] tmp = s.split(":");
                curhour = Integer.parseInt(tmp[0]);
                curminute = Integer.parseInt(tmp[1]);
                if(prehour==curhour) {
                    al++;
                    prehour = curhour;
                    preminute = Math.min(curminute,preminute);
                }
                else{
                    if(curhour-prehour<=1){
                        if(preminute==0&&curminute==0){
                            al++;
                            prehour = curhour;
                            preminute = Math.min(curminute,preminute);
                        }
                        else{
                            al=0;
                        }

                    }
                    else{
                        al=0;
                        prehour = curhour;
                        preminute = curminute;
                    }
                }



                if(al>=2) {
                    l.add(name);
                    break;
                }
            }
        }

        Collections.sort(l);

        return l;
    }
    public static void main(String[] args) throws ParseException {
        String k[]={"10:00","10:40","11:00","09:00","11:00","13:00","15:00"};
        String n[]={"daniel","daniel","daniel","luis","luis","luis","luis"};
        AlertUsingSameInAOneHourPeriod aup = new AlertUsingSameInAOneHourPeriod();
        List<String> list = new ArrayList<>();
        list=aup.alertNames(n,k);
        for (String s: list
             ) {
            System.out.println(s);
        }
    }
}
