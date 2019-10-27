import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    class Folder {
        Map<String, Folder> children;
        boolean leaf = false;
        String slashName;

        Folder(String name) {
            this.children = new HashMap<>();
            this.slashName = "/" + name;
        }

        void setSubFolder(String[] folderArray, int index) {
            if (leaf) return;

            String subFolderName = folderArray[index];
            Folder subFolder = children.get(subFolderName);
            if (subFolder == null) {
                subFolder = new Folder(subFolderName);
                children.put(subFolderName, subFolder);
            }
            if (index + 1 < folderArray.length) {
                subFolder.setSubFolder(folderArray, index + 1);
            } else {
                subFolder.leaf = true;
            }
        }

        void setName(List<String> folderNameList, String parentName) {
            String nameStr = parentName + slashName;

            if (leaf) {
                folderNameList.add(nameStr);
            } else {
                for (Folder child: children.values()) {
                    child.setName(folderNameList, nameStr);
                }
            }
        }
    }

    public List<String> removeSubfolders(String[] folder) {
        Folder root = new Folder("root");

        for (String f: folder) {
            String[] folderArray = f.split("/");
            int index = 1;
            root.setSubFolder(folderArray, index);
        }

        List<String> folderNameList = new ArrayList<>();
        for (Folder f: root.children.values()) {
            f.setName(folderNameList, "");
        }

        return folderNameList;
    }
}
