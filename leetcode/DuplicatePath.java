class Solution {

    public List<List<String>> findDuplicate(String[] paths) {

        List<List<String>> duplicates = new ArrayList<>();

        Map<String, List<String>> indexPath = new HashMap<>();

        if (paths.length == 0) {
            return duplicates;
        }

        for (int i = 0; i < paths.length; i++) {

            String path = paths[i];

            String[] patharr = path.split("\\s+");

            String root = patharr[0];

            for (int j = 1; j < patharr.length; j++) {

                int firstpos = patharr[j].indexOf("(");

                int lastpos = patharr[j].indexOf(")");

                String content = patharr[j].substring(firstpos + 1, lastpos);

                String fullpath = root + "/" + patharr[j].substring(0, firstpos);

                if (indexPath.containsKey(content)) {

                    List<String> temp = indexPath.get(content);

                    temp.add(fullpath);

                    indexPath.put(content, temp);

                } else {
                    List<String> temp = new ArrayList<>();

                    temp.add(fullpath);

                    indexPath.put(content, temp);
                }

            }

        }

        for (Map.Entry<String, List<String>> entry : indexPath.entrySet()) {

            List<String> value = entry.getValue();

            if (value.size() > 1) {
                duplicates.add(value);
            }


        }


        return duplicates;


    }
}
