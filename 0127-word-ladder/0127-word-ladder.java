class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) // if endWord is not in given wordList set.
        {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        Set<String> vis = new HashSet<>();
        int changes = 1;
        q.add(beginWord);
        while(!q.isEmpty())
        {
            int size = q.size();
            while(size-->0)
            {
                String word = q.remove();
                if(word.equals(endWord))
                {
                    return changes;
                }
                for(int i=0;i<word.length();i++)
                {
                    for(int j='a';j<='z';j++)
                    {
                        char arr[] = word.toCharArray();
                        arr[i]=(char)j;
                        String str = new String(arr);
                        if(set.contains(str)&&!vis.contains(str))
                        {
                            q.add(str);
                            vis.add(str);
                        }
                    }
                }
            }
            changes++;
        }
        return 0;
    }
}