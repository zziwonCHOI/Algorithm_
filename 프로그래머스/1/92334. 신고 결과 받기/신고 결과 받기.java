import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> reports=new HashMap<String, Integer>();
        Map<String, List<String>> report_list=new HashMap<String, List<String>>();
        
        // 먼저 신고 받은 사람들 신고 횟수 각각 카운팅
        // 동시에 각 이름 별로 신고한 사람들 정리해서 저장 
        for(int i=0; i<report.length; i++){
            String[] cur=report[i].split(" ");
            report_list.putIfAbsent(cur[0],new ArrayList<>());

            if(report_list.get(cur[0]).contains(cur[1])) continue;
            reports.merge(cur[1],1,Integer::sum);
            report_list.get(cur[0]).add(cur[1]);
        }
        
        
        for(int i=0; i<id_list.length; i++){
            String cur=id_list[i];
            List<String> idReport=report_list.get(cur);
            if(idReport==null) continue;
            for(int j=0; j<idReport.size(); j++){
                String target=idReport.get(j);
                if(reports.get(target)>=k){
                    answer[i]+=1;
                }
            }
        }
        return answer;
    }
}