class Solution {
    public String simplifyPath(String path) {
        int length = path.length();
        if (length <= 1) return "/";

        int start = 1;
        int index = 1;
        LinkedList<String> pathList = new LinkedList<>();
        while (index < length) {
            if (path.charAt(index) == '/') {
                setPathList(path.substring(start, index), pathList);
                start = index + 1;
            }
            index ++;
        }
        setPathList(path.substring(start, index), pathList);
        if (pathList.size() == 0) {
            pathList.add("");
        }
        StringBuilder sb = new StringBuilder();
        for (String dir: pathList) {
            sb.append("/");
            sb.append(dir);
        }
        return sb.toString();
    }

    void setPathList(String dir, LinkedList<String> pathList) {
        if (dir.isEmpty() || dir.equals(".")) {
            return;
        } else if (dir.equals("..")) {
            if (pathList.size() > 0) pathList.removeLast();
        } else {
            pathList.add(dir);
        }
    }
}
