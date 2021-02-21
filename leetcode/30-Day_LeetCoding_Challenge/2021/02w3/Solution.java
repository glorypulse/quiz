class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> processMap = new HashMap<>();
        Iterator<Integer> pidIt = pid.iterator();
        Iterator<Integer> ppidIt = ppid.iterator();
        while (pidIt.hasNext()) {
            int curPid = pidIt.next();
            processMap.putIfAbsent(curPid, new ArrayList<>());

            int curPpid = ppidIt.next();
            processMap.putIfAbsent(curPpid, new ArrayList<>());
            processMap.get(curPpid).add(curPid);
        }

        // kill
        List<Integer> killList = new ArrayList<>();
        setKillList(kill, processMap, killList);
        return killList;
    }

    void setKillList(int kill, Map<Integer, List<Integer>> processMap, List<Integer> killList) {
        killList.add(kill);
        for (int child: processMap.get(kill)) {
            setKillList(child, processMap, killList);
        }
    }
}
